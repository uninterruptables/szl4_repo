/**
 * Scene.java
 */
package team.uninter.mordorq.gamespace;

import javax.swing.*;
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
	private List<Tower> towers;
	private List<EnemyTroop> enemies;
	private MordorFrame owner;
	private Casted activeObject;
	private Thread animator;
	
	/**
	 * The only constructor provided by this class is protected,
	 * enforcing the usage of the public class Builder which
	 * constructs the initial <code>Scene</code>.
	 * */
	protected Scene(MordorFrame owner, List<TerrainGrid> grids){
		super();
		this.owner = owner;
		this.grids = grids;
		this.towers = new ArrayList<Tower>();
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
		 * An inner mechanism responsible for the real construction of the <code>Scene</code>.
		 * It handles all the reading from file, the wiring/binding of grids that the <code>Scene</code>
		 * is going to .
		 * 
		 * @return a list of <>TerrainGrid</code>
		 * */
		private List<TerrainGrid> buildScene() throws IOException {
			List<TerrainGrid> grids = new ArrayList<TerrainGrids>();
			Map<Integer, List<TerrainGrid>> bucketHash = new HashMap<Integer, List<TerrainGrid>>();
			int width, height;

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
						  _grids.add( util > 0 ? new RoadGrid(util) : new GroundGrid(util) );
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
				  int x, y;
				  while((line=reader.readLine()) != null){
					  String[] parts = line.split(" ");
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