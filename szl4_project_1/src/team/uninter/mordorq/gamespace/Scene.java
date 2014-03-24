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
	private Thread animator;
	private int round;
	
	
	protected Scene(){
		super();
		//TODO:
		System.out.println("Scene.Scene() called");
		this.grids = new java.util.LinkedList<TerrainGrid>();
		this.towers = new ArrayList<Controlable>();
		System.out.println("Scene.Scene() returned");
	}
	
	/**
	 * The only constructor provided by this class is protected,
	 * enforcing the usage of the public class Builder which
	 * constructs the initial <code>Scene</code>.
	 * */
	protected Scene(MordorFrame owner, List<TerrainGrid> grids){
		super();
		//TODO:
		System.out.println("Scene.Scene(MordorFrame, List) called");
		this.owner = owner;
		this.grids = grids;
		this.towers = new ArrayList<Controlable>();
		this.round = 0;
		System.out.println("Scene.Scene(MordorFrame, List) returned");
	}
	
	/**
	 * Applies all <code>StatusModifier</code>s of the casted <code>Magic</code> to all
	 * <code>EnemyTroop</code> still alive on the scene.
	 * 
	 * @param magic the magic instance casted to this scene object
	 * */
	public void cast(Magic magic){
		//TODO:
		System.out.println("Scene.cast(Magic): void called");
		for(Controlable enemy : enemies)
			((EnemyTroop)enemy).addAll(magic.getStatusModifiers());
		System.out.println("Scene.cast(Magic): void returned");
	}
	
	/**
	 * Places the given <code>Casted</code> to the given <code>TerrainGrid</code>.
	 * 
	 * @param casted the game object about to be casted on the grid.
	 * @param grid the TerrainGrid about to accept the <code>Casted</code> instance.
	 * */
	public void place(Casted casted, TerrainGrid grid){
		//TODO:
		System.out.println("Scene.place( Casted,TerrainGrid ): void called");
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
		System.out.println("Scene.place( Casted,TerrainGrid ): void returned");
	}
	
	/**
	 * Notifies the <code>Scene</code> about that another round has ended.
	 * */
	public void endRound(){
		//TODO: timer.stop();
		System.out.println("Scene.endRound(): void called");
		System.out.println("Scene.endRound(): void returned");
	}
	
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
		//TODO:
		System.out.println("Scene.endGame(boolean): void called");
		if(wasWinning) owner.win();
		else owner.gameOver();
		System.out.println("Scene.endGame(boolean): void returned");
	}
	
	
	/**
	 * Delegates the call to all of its game space elements.
	 * */
	@Override
	public void repaint(){
		super.repaint();
		//TODO:
		System.out.println("Scene.repaint(): void called");
		for(TerrainGrid grid : grids){
			grid.repaint();
		}
		System.out.println("Scene.repaint(): void returned");
	}
	
	/**
	 * Increases the amount of mana the user has.
	 * 
	 * @param reward the mana measured in units the user gets for killing an enemy unit.
	 * */
	public void rewardUser(int reward){
		//TODO:
		System.out.println("Scene.rewardUser(reward): void called");
		owner.setUserMana(owner.getUserMana() + reward);
		System.out.println("Scene.rewardUser(reward): void returned");
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
		//TODO:
		System.out.println("Scene.getUserMana(): int called");
		int userMana = owner.getUserMana();
		System.out.println("Scene.getUserMana(): int returned");
		return userMana;
	}
	
	/**
	 * Sets the mana the user is left with to spend in the owner <code>MordorFrame</code>
	 * instance by delegating the call to it.
	 * 
	 * @param mana an integer value representing the new quantity of mana the user has.
	 * */
	public void setUserMana(int mana){
		//TODO:
		System.out.println("Scene.setUserMana(int): void called");
		owner.setUserMana(mana);
		System.out.println("Scene.setUserMana(int): void returned");
	}
	
	/**
	 * Publishes the list of grids contained by the <code>Scene</code>.
	 * 
	 * @return the list of grids managed by the <code>Scene</code>.
	 * */
	public List<TerrainGrid> getGrids(){
		//TODO:
		System.out.println("Scene.getGrids(): List called");
		System.out.println("Scene.getGrids(): List returned");
		return grids;
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
			//TODO:
			System.out.println("Scene.Builder.Builder(MordorFrame) called");
			this.owner = owner;
			System.out.println("Scene.Builder.Builder(MordorFrame) returned");
		}
		
		/**
		 * Makes it optional for the filePath to be given, although it is
		 * highly recommended to be set properly.
		 * 
		 * @param	filePath the source of the construction
		 * @return the current <code>Builder</code> instance being configured
		 * */
		public Builder filePath(String filePath){
			//TODO:
			System.out.println("Scene.Builder.filePath(String): Builder called");
			this.filePath=filePath;
			System.out.println("Scene.Builder.filePath(String): Builder returned");
			return this;
		}
		
		/**
		 * Standard interface to construct a new <code>Scene</code>.
		 * 
		 * @throws IOException only if errors occure in accessing the given file
		 * @return a new instance of <code>Sceen</code>
		 * */
		public Scene build() throws IOException {
			//TODO:
			System.out.println("Scene.Builder.build(): Scene called");
            List<TerrainGrid> grids = buildScene();
            System.out.println("Scene.Builder.build(): Scene returned");
            //TODO:
			Scene scene = new Scene(owner, grids);
            return scene;
		}
		
		/**
		 * An inner mechanism responsible for the real construction of the <code>Scene</code>.
		 * It handles all the reading from file, the wiring/binding of grids that the <code>Scene</code>
		 * is going to .
		 * 
		 * @return a list of <>TerrainGrid</code>
		 * */
		private List<TerrainGrid> buildScene() throws IOException {
			//TODO:
			System.out.println("Scene.Builder.buildScene(): List<TerrainGrids> called");
			List<TerrainGrid> grids = new ArrayList<TerrainGrid>();
			Map<Integer, List<TerrainGrid>> bucketHash = new HashMap<Integer, List<TerrainGrid>>();
			int width = 0, height = 0;

			BufferedReader reader = null;
			try{
			  reader = new BufferedReader(new InputStreamReader(
					  							new FileInputStream(filePath)));
			  String line;
			  while((line=reader.readLine()) != null){
				  height++;
				  String[] parts = line.split(" ");
				  width += parts.length;
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
					  if(y > 0) {
						  enterGrid.set(Neighbour.NORTH, grids.get((y-1)*height + 0));
						  grids.get((y-1)*height + 0).set(Neighbour.SOUTH, enterGrid);
					  }
					  grids.add(enterGrid);
					  
					  for(String _util : parts){
						  TerrainGrid grid = bucketHash.get(Integer.valueOf(_util)).get(0);
						  if(x > 0){
							  grid.set(Neighbour.WEST, grids.get(y*height + (x-1)));
							  grid.get(Neighbour.WEST).set(Neighbour.EAST, grid);;
						  }
						  if(y > 0){
							  grid.set(Neighbour.NORTH, grids.get((y-1)*height + x));
							  grid.get(Neighbour.NORTH).set(Neighbour.SOUTH, grid);
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
			//TODO:
			System.out.println("Scene.Builder.buildScene(): List<TerrainGrids> returned");
			return grids;
		}
	}
}