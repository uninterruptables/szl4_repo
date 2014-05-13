/**
 * Scene.java
 */
package team.uninter.mordorq.gamespace;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.JPanel;

import org.apache.log4j.Logger;

import team.uninter.mordorq.gamespace.Casted.ImageColor;
import team.uninter.mordorq.utils.GameUtil;
import team.uninter.mordorq.utils.RoundInitiator;

/**
 * Responsible for containing and managing, animating all the game objects
 * playing in the game. Also handles and interprets events delegated by its
 * owner MordorFrame.
 * <p>
 * It highly depends on the Builder pattern through which the whole
 * <code>Scene</code> is builded, constructed according to a given descriptor
 * file.
 * 
 * @author Imre Szekeres
 * @version "%I%, %G%"
 * @see javax.swing.JPanel
 * @see MordorFrame
 * @see TerrainGrid
 * @see RoadGrid
 * @see GroundGrid
 * @see Animator
 * @see java.lang.Thread
 * @see Casted
 * @see Tower
 * @see Scene.Builder
 */
@SuppressWarnings("serial")
public class Scene extends JPanel {

	private static final Map<String, Class<? extends Casted>> availableAOs;
	private static final Logger logger = Logger.getLogger(Scene.class);

	private List<TerrainGrid> grids;
	private List<Tower> towers;
	private List<Controlable> enemies;
	private MordorFrame owner;
	private Casted activeObject;
	private Animator animator;
	private int round;
	java.util.Timer timer;

	/**
	 * Constructs the available active objects cache from which the selection of
	 * the currently selected active object is performed.
	 * */
	static {
		availableAOs = new HashMap<String, Class<? extends Casted>>();
		// availableAOs.put("", XY.class);
		/* Barricade */
		availableAOs.put("Barricade", Barricade.class);

		/* Towers */
		availableAOs.put("Basic Tower", BasicTower.class);
		availableAOs.put("Fast Tower", FastTower.class);
		availableAOs.put("Great Tower", GreatTower.class);
		availableAOs.put("Long Distace Tower", LongDistanceTower.class);

		/* Traps */
		availableAOs.put("Decrease Damage Trap", DecreaseDamageTrap.class);
		availableAOs.put("Poison Trap", PoisonTrap.class);
		availableAOs.put("Slow Down Trap", SlowDownTrap.class);

		/* Runes */
		availableAOs.put("Damage Boost Dwarven Tower Rune", DamageBoostDwarvenTowerRune.class);
		availableAOs.put("Damage Boost Hobbit Tower Rune", DamageBoostHobbitTowerRune.class);
		availableAOs.put("Damage Boost Elven Tower Rune", DamageBoostElvenTowerRune.class);
		availableAOs.put("Damage Booster Tower Rune", DamageBoosterTowerRune.class);

		availableAOs.put("Radius Increasing Tower Rune", RadiusIncTowerRune.class);
		availableAOs.put("Speed Booster Tower Rune", SpeedBoosterTowerRune.class);

		availableAOs.put("Freeze Trap Rune", FreezeTrapRune.class);
		availableAOs.put("Poison Trap Rune", PoisonTrapRune.class);
		availableAOs.put("Weaken Trap Rune", WeakenTrapRune.class);

		/* Magic */
		availableAOs.put("Nazgul", Nazgul.class);
		availableAOs.put("Ice Wind", IceWindMagic.class);
		availableAOs.put("Poison Fog", PoisonFogMagic.class);
	}

	/**
	 * Constructor for building a simple/empty <code>Scene</code>.
	 * */
	protected Scene(MordorFrame owner) {
		this();
		this.owner = owner;
		this.grids = new java.util.LinkedList<TerrainGrid>();
	}

	/**
	 * The only constructor provided by this class is protected, enforcing the
	 * usage of the public class Builder which constructs the initial
	 * <code>Scene</code>.
	 * */
	protected Scene(MordorFrame owner, List<TerrainGrid> grids) {
		this();
		this.owner = owner;
		this.grids = grids;
		initPanel();
	}

	/**
	 * Constructor for initializing common fields. *
	 * */
	protected Scene() {
		super();
		this.towers = new CopyOnWriteArrayList<Tower>();
		this.enemies = new ArrayList<Controlable>();
		this.round = 0;
		animator = new Animator(this);
		initListeners();
	}

	private void initPanel() {

		RoadGrid maxUtil = new RoadGrid(1);
		for (TerrainGrid g : grids) {
			if (g.getUtility() > maxUtil.getUtility())
				maxUtil = (RoadGrid) g;
		}
		maxUtil.setVulnerable(MountainOfDoom.getInstance(this));

		this.setPreferredSize(new Dimension(640, 640));
	}

	private void initListeners() {
		this.addMouseListener(new SceneMouseListener(this));
		this.addMouseMotionListener(new SceneMouseMotionListener(this));
	}

	public void start() {
		timer = new java.util.Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				System.out.println("timer runing");
				animator.run(1);
			}
		}, 1000, 33);
	}

	/**
	 * Starts the game play.
	 * */
	public void start(int tick) {
		animator.run(tick);
	}

	/**
	 * Pauses the game play.
	 * */
	public void pause() {
		timer.cancel();
		timer = null;
	}

	/**
	 * Casts the active object to the given point.
	 * 
	 * @param point
	 *            representing the ( x,y ) coordinates onto which the active
	 *            object is to be casted
	 * */
	public void castOn(java.awt.Point point) {
		logger.debug(" Scene.castOn( point ) ~ activeObject: " + activeObject.toString());
		logger.debug(" Scene.castOn( point ) ~ point: ( " + point.x + "," + point.y + " )");
		if (activeObject instanceof Magic)
			cast((Magic) activeObject);
		else
			place(activeObject, GameUtil.getGridByXY(grids, point.x, point.y));

		owner.setUserMana(owner.getUserMana() - activeObject.manaCost);
		activeObject = null;
	}

	/**
	 * Applies all <code>StatusModifier</code>s of the casted <code>Magic</code>
	 * to all <code>EnemyTroop</code> still alive on the scene.
	 * 
	 * @param magic
	 *            the magic instance casted to this scene object
	 * */
	public void cast(Magic magic) {
		if (enemies != null) {
			for (Controlable enemy : enemies)
				((EnemyTroop) enemy).addAll(magic.getStatusModifiers());
		}
	}

	/**
	 * Places the given <code>Casted</code> to the given
	 * <code>TerrainGrid</code>.
	 * 
	 * @param casted
	 *            the game object about to be casted on the grid.
	 * @param grid
	 *            the TerrainGrid about to accept the <code>Casted</code>
	 *            instance.
	 * */
	public void place(Casted casted, TerrainGrid grid) {
		casted.castOn(grid);
		if (casted instanceof Tower) {
			towers.add((Tower) casted);
			for (TerrainGrid _grid : grids) {
				if (_grid.isInRangeOf((Tower) casted)) {
					((Tower) casted).attach((RoadGrid) _grid);
					((RoadGrid) _grid).attach((Tower) casted);
				}
			}
		}
		repaint();
	}

	/**
	 * Notifies the <code>Scene</code> about that another round has ended.
	 * */
	public void endRound() {
		logger.debug(" round ended");
		this.owner.endRound(round);
	}

	/**
	 * Initiates a new round according to the previous number of round. If the
	 * new round does not supply new enemies then the game has been won!
	 * */
	public void nextRound() {
		logger.debug(" scene: in round " + round);
		enemies = RoundInitiator.initRoundFor(this, round++);
		if (enemies.isEmpty())
			endGame(true);
	}

	/**
	 * Notifies the <code>Scene</code> about the end of the current game.
	 * 
	 * @param wasWinning
	 *            indicates how the game has ended: by winning or loosing it
	 * */
	public void endGame(boolean wasWinning) {
		// TODO: check
		timer.cancel();
		if (wasWinning)
			owner.win();
		else {
			// clear collections
			grids.clear(); // grids = null; //new ArrayList<TerrainGrid>();
			towers.clear(); // towers = null; //new ArrayList<Tower>();
			enemies.clear(); // enemies = null; //new ArrayList<Controlable>();
			owner.gameOver();
		}
	}

	/**
	 * Paints this component and all the components referenced by it.
	 * 
	 * @param g
	 *            the <code>Graphics</code> instance responsible for drawings in
	 *            the Java Graphics FrameWork
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (grids != null) {
			for (TerrainGrid grid : grids) {
				grid.drawGrid(g);
			}
		}
		if (activeObject != null)
			activeObject.drawObject(g);
	}

	/**
	 * Increases the amount of mana the user has.
	 * 
	 * @param reward
	 *            the mana measured in units the user gets for killing an enemy
	 *            unit.
	 * */
	public void rewardUser(int reward) {
		owner.setUserMana(owner.getUserMana() + reward);
	}

	/**
	 * Sets the active object which is about to be placed and casted.
	 * 
	 * @param objectName
	 *            identifies the object class that is about to be instantiated.
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * */
	public void setActiveObject(String objectName)
			throws InstantiationException, IllegalAccessException {
		this.activeObject = availableAOs.get(objectName).newInstance();
	}

	/**
	 * Delegates the call to the owner <code>MordorFrama</code> from which the
	 * current value can be requested.
	 * 
	 * @return the mana measured in units left for the user to spend.
	 * */
	public int getUserMana() {
		return owner.getUserMana();
	}

	/**
	 * Sets the mana the user is left with to spend in the owner
	 * <code>MordorFrame</code> instance by delegating the call to it.
	 * 
	 * @param mana
	 *            an integer value representing the new quantity of mana the
	 *            user has.
	 * */
	public void setUserMana(int mana) {
		owner.setUserMana(mana);
	}

	/**
	 * Publishes the list of grids contained by the <code>Scene</code>.
	 * 
	 * @return the list of grids managed by the <code>Scene</code>.
	 * */
	public List<TerrainGrid> getGrids() {
		return grids;
	}

	/**
	 * Publishes the mechanism to set all grids contained by the
	 * <code>Scene</code>.
	 * 
	 * @param grids
	 *            that are contained in the <code>Scene</code>.
	 * @return the instance of the <code>Scene</code>.
	 * */
	public Scene setGrids(List<TerrainGrid> grids) {
		this.grids = grids;
		return this;
	}

	/**
	 * Getter method for accessing the towers already casted to the
	 * <code>Scene</code>
	 * 
	 * @return the list of towers the scene contains
	 * */
	public synchronized List<Tower> getTowers() {
		return towers;
	}

	/**
	 * Getter method for accessing the enemies yet on the <code>Scene</code>
	 * 
	 * @return the list of enemies the scene contains
	 * */
	public synchronized List<Controlable> getEnemies() {
		return enemies;
	}

	/**
	 * Gets the number of the round the user is currently in.
	 * 
	 * @return the number of the round the user is in
	 * */
	public int getRoundNumber() {
		return round;
	}

	/**
	 * Manages the relevant mouse events sent to the <code>Scene</code>.
	 * */
	private static class SceneMouseListener extends MouseAdapter {

		SceneMouseListener(Scene owner) {
			this.owner = owner;
		}

		@Override
		public void mouseExited(MouseEvent e) {
			owner.activeObject = null;
			owner.repaint();
		}

		/**
		 * Calls upon the cast mechanism defined in the owner <code>Scene</code>
		 * according to the state of the active object.
		 * 
		 * @param e
		 *            the mouse event that triggers the casting
		 * */
		@Override
		public void mouseClicked(MouseEvent e) {
			Point p = e.getPoint();
			TerrainGrid gridUnder = GameUtil.getGridByXY(owner.grids, p.x, p.y);
			if (owner.activeObject != null && owner.activeObject.canCastOn(gridUnder)) {
				owner.castOn(e.getPoint());
			}
		}

		private Scene owner;
	}

	private static class SceneMouseMotionListener extends MouseMotionAdapter {

		public SceneMouseMotionListener(Scene owner) {
			this.owner = owner;
		}

		/**
		 * Manages the image to use when drawing the active object according to
		 * the underlying grid, and of course the state of the active object.
		 * 
		 * @param e
		 *            the mouse event defining the current position of the mouse
		 *            thus the active object itself.
		 * */
		@Override
		public void mouseMoved(MouseEvent e) {
			if (owner.activeObject != null) {
				java.awt.Point p = e.getPoint();
				owner.activeObject.setX(p.x - 8);
				owner.activeObject.setY(p.y - 8);
				TerrainGrid gridBeneath = GameUtil.getGridByXY(owner.grids, p.x, p.y);
				if (!owner.activeObject.canCastOn(gridBeneath)) {
					owner.activeObject.setImage(ImageColor.RED);
				}
				else {
					owner.activeObject.setImage(ImageColor.NORMAL);
				}
			}
			owner.repaint();
		}

		private Scene owner;
	}

	/**
	 * The public class responsible for the construction of (each)
	 * <code>Scene</code> instance. From a file stream as a source given by a
	 * filePath it builds each grid.
	 * */
	public static class Builder {

		private String filePath = "resources/descriptors/simuframed.txt";
		private MordorFrame owner;

		/**
		 * The public constructor enforces the users to supply the owner
		 * <code>MordorFrame</code> in which the <code>Scene</code> is going to
		 * take place.
		 * */
		public Builder(MordorFrame owner) {
			this.owner = owner;
		}

		/**
		 * Makes it optional for the filePath to be given, although it is highly
		 * recommended to be set properly.
		 * 
		 * @param filePath
		 *            the source of the construction
		 * @return the current <code>Builder</code> instance being configured
		 * */
		public Builder filePath(String filePath) {
			this.filePath = filePath;
			return this;
		}

		/**
		 * Standard interface to construct a new <code>Scene</code>.
		 * 
		 * @throws IOException
		 *             only if errors occure in accessing the given file
		 * @return a new instance of <code>Sceen</code>
		 * */
		public Scene build() throws IOException {
			List<TerrainGrid> grids = buildScene();
			return new Scene(owner, grids);
		}

		/**
		 * Builds a simple <code>Scene</code> without the girds.
		 * 
		 * @return a simple/empty scene
		 * */
		public Scene buildSimple() {
			return new Scene(owner);
		}

		/**
		 * An inner mechanism responsible for the real construction of the
		 * <code>Scene</code>. It handles all the reading from file, the
		 * wiring/binding of grids that the <code>Scene</code> is going to .
		 * 
		 * @return a list of <code>TerrainGrid</code>
		 * */
		private List<TerrainGrid> buildScene() throws IOException {
			List<TerrainGrid> grids = new ArrayList<TerrainGrid>();
			Map<Integer, List<TerrainGrid>> bucketHash = new HashMap<Integer, List<TerrainGrid>>();
			Map<Integer, List<Boolean>> usageChecker = new HashMap<Integer, List<Boolean>>();
			int width = 0;

			BufferedReader reader = null;
			int lineNum = 0;
			try {
				reader = new BufferedReader(new InputStreamReader(
						new FileInputStream(filePath)));
				String line;
				while ((line = reader.readLine()) != null) {
					width = 0;
					++lineNum;
					String[] parts = line.split(" ");
					for (String _util : parts) {
						try {
							int util = Integer.parseInt(_util);
							++width;
							if (!bucketHash.containsKey(util))
								bucketHash.put(util, new ArrayList<TerrainGrid>());
							List<TerrainGrid> _grids = bucketHash.get(util);
							_grids.add(util > 0 ? new RoadGrid(util) : new GroundGrid());
							bucketHash.put(util, _grids);
						} catch (NumberFormatException e) {
						}
					}
				}

				for (Entry<Integer, List<TerrainGrid>> entry : bucketHash.entrySet()) {
					Integer key = entry.getKey();
					List<TerrainGrid> value = entry.getValue();

					List<Boolean> valueList = new ArrayList<Boolean>();
					for (int i = 0; i < value.size(); i++) {
						valueList.add(new Boolean(false));
					}
					usageChecker.put(key, valueList);
				}

			} catch (IOException e) {
				throw e;
			} finally {
				if (reader != null) {
					try {
						reader.close();
					} catch (IOException e) {
					}
				}
			}
			try {
				reader = new BufferedReader(new InputStreamReader(
						new FileInputStream(filePath)));
				List<Integer> spawnUtils = Scene.Builder.createSpawnUtilitiesFor(lineNum);
				String line;
				int x = 0, y = 0;
				while ((line = reader.readLine()) != null) {
					String[] parts = line.split(" ");

					RoadGrid enterGrid = new RoadGrid(spawnUtils.get(y));
					enterGrid.setX(-16);
					enterGrid.setY(0);
					grids.add(enterGrid);
					x++;
					if (y > 0) {
						int index = (y - 1) * (width + 1);
						TerrainGrid north = grids.get(index);
						enterGrid.set(Neighbour.NORTH, north);
						north.set(Neighbour.SOUTH, enterGrid);

						enterGrid.setY(y * 16);
					}

					for (String _util : parts) {
						if (!_util.isEmpty()) {
							TerrainGrid grid = null;
							boolean foundNotUsed = false;

							for (Entry<Integer, List<Boolean>> entry : usageChecker.entrySet()) {
								Integer key = entry.getKey();
								List<Boolean> value = entry.getValue();

								for (int i = 0; i < value.size(); i++) {
									if (Integer.valueOf(key).equals(Integer.valueOf(_util))) {
										if (value.get(i) == false) {
											value.set(i, true);
											grid = bucketHash.get(Integer.valueOf(_util)).get(i);
											foundNotUsed = true;
											break;
										}
									}
								}
								if (foundNotUsed) {
									break;
								}
							}

							grid.setY(y * 16);

							if (x <= 0)
								grid.setX(0);
							else if (x > 0) {
								TerrainGrid west = grids.get(grids.size() - 1);
								grid.setX(west.getX() + 16);
								grid.set(Neighbour.WEST, west);
								west.set(Neighbour.EAST, grid);
							}
							if (y > 0) {
								TerrainGrid north = grids.get((y - 1) * (width + 1) + x);
								grid.set(Neighbour.NORTH, north);
								north.set(Neighbour.SOUTH, grid);
							}
							grids.add(grid);
							x++;
						}
					}
					x = 0;
					y++;
				}
			} catch (IOException e) {
				throw e;
			} finally {
				if (reader != null) {
					try {
						reader.close();
					} catch (IOException e) {
					}
				}
			}
			return grids;
		}

		/**
		 * Creates a list of integers representing utilities for the spawn chain
		 * of <code>RoadGrid</code>s.
		 * 
		 * @param numberOfLines
		 *            that indicates how many rows of grids are expected to be
		 * @return a list of utilities
		 * */
		private static List<Integer> createSpawnUtilitiesFor(int numberOfLines) {
			List<Integer> utilities = new ArrayList<Integer>();
			for (int i = 1, n = numberOfLines - 2; i <= n; i++)
				utilities.add(i / 2 + i % 2);
			utilities.add(2);
			utilities.add(1);
			return utilities;
		}
	}
}