/**
 * Scene.java
 */
package team.uninter.mordorq.gamespace;

import javax.swing.*;

import team.uninter.mordorq.utils.RoundInitiator;

import java.util.*;
import java.io.*;

/**
 * Responsible for containing and managing, animating all the game objects playing
 * in the game. Also handles and interprets events delegated by its owner MordorFrame.
 * <p>
 * It highly depends on the Builder pattern through which the whole <code>Scene</code> is
 * builded, constructed according to a given descriptor file.
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
@SuppressWarnings({"serial", "unused"})
public class Scene extends JPanel{

	private List<TerrainGrid> grids;
	private List<Controlable> towers;
	private List<Controlable> enemies;
	private MordorFrame owner;
	private Casted activeObject;
	private Animator animator;
	private int round;
	
	/**
	 * Constructor for building a simple/empty <code>Scene</code>.
	 * */
	protected Scene(MordorFrame owner){
		super();
		this.owner = owner;
		this.grids = new java.util.LinkedList<TerrainGrid>();
		this.towers = new ArrayList<Controlable>();
		animator = new Animator(this);
	}
	
	/**
	 * The only constructor provided by this class is protected,
	 * enforcing the usage of the public class Builder which
	 * constructs the initial <code>Scene</code>.
	 * */
	protected Scene(MordorFrame owner, List<TerrainGrid> grids){
		super();
		this.owner = owner;
		this.grids = grids;
		this.towers = new ArrayList<Controlable>();
		this.round = 0;
		animator = new Animator(this);
	}
	
	public void start(){
		animator.run();
	}
	
	public void start(int tick){
		animator.run(tick);
	}
	
	/**
	 * Applies all <code>StatusModifier</code>s of the casted <code>Magic</code> to all
	 * <code>EnemyTroop</code> still alive on the scene.
	 * 
	 * @param magic the magic instance casted to this scene object
	 * */
	public void cast(Magic magic){
		if(enemies != null) {
			for(Controlable enemy : enemies)
				((EnemyTroop)enemy).addAll(magic.getStatusModifiers());
		}
	}
	
	/**
	 * Places the given <code>Casted</code> to the given <code>TerrainGrid</code>.
	 * 
	 * @param casted the game object about to be casted on the grid.
	 * @param grid the TerrainGrid about to accept the <code>Casted</code> instance.
	 * */
	public void place(Casted casted, TerrainGrid grid){
		casted.castOn(grid);
		if(casted instanceof Tower){
			towers.add((Tower)casted);
			for(TerrainGrid _grid : grids) {
				if(_grid.isInRangeOf((Tower)casted)){
					((Tower)casted).attach((RoadGrid)_grid);
					((RoadGrid)_grid).attach((Tower)casted);
				}
			}
		}
	}
	
	/**
	 * Notifies the <code>Scene</code> about that another round has ended.
	 * */
	public void endRound(){}
	
	/**
	 * Initiates a new round according to the previous number of round. If the
	 * new round does not supply new enemies then the game has been won!
	 * */
	public void nextRound(){
		enemies = RoundInitiator.initRound(round++);
		if(enemies.isEmpty()) endGame(true);
	}
	
	/**
	 * Notifies the <code>Scene</code> about the end of the current game.
	 * 
	 * @param wasWinning indicates how the game has ended: by winning or loosing it
	 * */
	public void endGame(boolean wasWinning){
		if(wasWinning) owner.win();
		else owner.gameOver();
	}
	
	
	/**
	 * Delegates the call to all of its game space elements.
	 * */
	@Override
	public void repaint(){
		super.repaint();
		if(grids != null){
			for(TerrainGrid grid : grids){
				grid.repaint();
			}
		}
	}
	
	/**
	 * Increases the amount of mana the user has.
	 * 
	 * @param reward the mana measured in units the user gets for killing an enemy unit.
	 * */
	public void rewardUser(int reward){
		owner.setUserMana(owner.getUserMana() + reward);
	}
	
	/**
	 * Sets the active object which is about to be placed and casted.
	 * 
	 * @param objectName identifies the object class that is about to be instantiated.
	 * */
	public void setActiveObject(String objectName){
		//TODO:
		System.out.println("Scene.setActiveObject(String): void called");
		System.out.println("Scene.setActiveObject(String): void returned");
	}
	
	/**
	 * Delegates the call to the owner <code>MordorFrama</code> from
	 * which the current value can be requested.
	 * 
	 * @return the mana measured in units left for the user to spend.
	 * */
	public int getUserMana(){
		return owner.getUserMana();
	}
	
	/**
	 * Sets the mana the user is left with to spend in the owner <code>MordorFrame</code>
	 * instance by delegating the call to it.
	 * 
	 * @param mana an integer value representing the new quantity of mana the user has.
	 * */
	public void setUserMana(int mana){
		owner.setUserMana(mana);
	}
	
	/**
	 * Publishes the list of grids contained by the <code>Scene</code>.
	 * 
	 * @return the list of grids managed by the <code>Scene</code>.
	 * */
	public List<TerrainGrid> getGrids(){
		return grids;
	}
	
	/**
	 * Publishes the mechanism to set all grids contained by the <code>Scene</code>.
	 * 
	 * @param grids that are contained in the <code>Scene</code>.
	 * @return the instance of the <code>Scene</code>.
	 * */
	public Scene setGrids(List<TerrainGrid> grids){
		this.grids = grids;
		return this;
	}
	
	/**
	 * Getter method for accessing the towers already casted to the <code>Scene</code>
	 * 
	 * @return the list of towers the scene contains
	 * */
	public List<Controlable> getTowers(){
		return towers;
	}
	
	/**
	 * Getter method for accessing the enemies yet on the <code>Scene</code>
	 * 
	 * @return the list of enemies the scene contains
	 * */
	public List<Controlable> getEnemies(){
		return enemies;
	}
	
	/**
	 * Gets the number of the round the user is currently in.
	 * 
	 * @return the number of the round the user is in
	 * */
	public int getRoundNumber(){
		return round;
	}
	
	
	
	/**
	 * The public class responsible for the construction of (each) <code>Scene</code>
	 * instance. From a file stream as a source given by a filePath it builds each grid.
	 * */
	public static class Builder{
		
		private String filePath = "resources/descriptors/simuframed.txt";
		private MordorFrame owner;
		
		/**
		 * The public constructor enforces the users to supply the owner <code>MordorFrame</code>
		 * in which the <code>Scene</code> is going to take place.
		 * */
		public Builder(MordorFrame owner){
			this.owner = owner;
		}
		
		/**
		 * Makes it optional for the filePath to be given, although it is
		 * highly recommended to be set properly.
		 * 
		 * @param	filePath the source of the construction
		 * @return the current <code>Builder</code> instance being configured
		 * */
		public Builder filePath(String filePath){
			this.filePath=filePath;
			return this;
		}
		
		/**
		 * Standard interface to construct a new <code>Scene</code>.
		 * 
		 * @throws IOException only if errors occure in accessing the given file
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
		public Scene buildSimple(){
			return new Scene(owner);
		}
		
		/**
		 * An inner mechanism responsible for the real construction of the <code>Scene</code>.
		 * It handles all the reading from file, the wiring/binding of grids that the <code>Scene</code>
		 * is going to .
		 * 
		 * @return a list of <>TerrainGrid</code>
		 * */
		private List<TerrainGrid> buildScene() throws IOException {
			List<TerrainGrid> grids = new ArrayList<TerrainGrid>();
			Map<Integer, List<TerrainGrid>> bucketHash = new HashMap<Integer, List<TerrainGrid>>();
			int height = 0;

			BufferedReader reader = null;
			try{
			  reader = new BufferedReader(new InputStreamReader(
					  							new FileInputStream(filePath)));
			  String line;
			  while((line=reader.readLine()) != null){
				  String[] parts = line.split(" ");
				  for(String _util : parts){
					  try{
						  int util = Integer.parseInt(_util);
						  if(!bucketHash.containsKey(util)) bucketHash.put(util, new ArrayList<TerrainGrid>());
						  List<TerrainGrid> _grids = bucketHash.get(util);
						  _grids.add( util > 0 ? new RoadGrid(util) : new GroundGrid() );
						  bucketHash.put(util, _grids);
					  }catch(NumberFormatException e){}
				  }
			  }
			}catch(IOException e){
				throw e;
			}finally{
				if(reader != null){
					try{ 
						reader.close();
					}catch(IOException e){}
				}
			}
			try{
				  reader = new BufferedReader(new InputStreamReader(
						  							new FileInputStream(filePath)));
				  String line;
				  int x = 0, y = 0;
				  while((line=reader.readLine()) != null){
					  String[] parts = line.split(" ");
					  
					  /* adding the entering space for newly spawn enemies */
					  RoadGrid enterGrid = new RoadGrid(1);
					  x++;
					  if(y > 0) {
						  enterGrid.set(Neighbour.NORTH, grids.get((y-1)*height + 0));
						  grids.get((y-1)*height + 0).set(Neighbour.SOUTH, enterGrid);
					  }
					  grids.add(enterGrid);
					  
					  for(String _util : parts){
						  TerrainGrid grid = bucketHash.get(Integer.valueOf(_util)).get(0);
						  if(x < 0) {
							  grid.setX(0);
							  grid.setX(0);
						  }
						  else if(x > 0){
							  TerrainGrid west = grids.get(y*height + (x-1));
							  grid.setX(west.getX() + 10);
							  grid.set(Neighbour.WEST, west);
							  west.set(Neighbour.EAST, grid);;
						  }
						  if(y > 0){
							  TerrainGrid north = grids.get((y-1)*height + x);
							  grid.setY(north.getY() + 10);
							  grid.set(Neighbour.NORTH, north);
							  north.set(Neighbour.SOUTH, grid);
						  }
						  grids.add(grid);
					      x++;
					  }
					  x = 0;
					  y++;
				  }
				}catch(IOException e){
					throw e;
				}finally{
					if(reader != null){
						try{ 
							reader.close();
						}catch(IOException e){}
					}
				}
			return grids;
		}
	}
}