/**
 * Scene.java
 */
package team.uninter.mordorq.gamespace;

import java.util.*;
import java.io.*;
/**
 * @author Imre Szekeres
 * @version "%I%, %G%"
 */
public class Scene {

	protected Scene(MordorFrame owner, List<TerrainGrid> grids){
		this.owner = owner;
		this.grids = grids;
		this.towers = new ArrayList<Tower>();
	}
	
	public static class Builder{
		
		public Builder(MordorFrame owner){
			
		}
		
		public Builder filePath(String filePath){
			this.filePath=filePath;
			return this;
		}
		
		public Scene build() throws IOException {
            List<TerrainGrid> grids = buildScene();
			return new Scene(owner, grids);
		}
		
		private List<TerrainGrid> buildScene() throws IOException {
			List<TerrainGrid> grids = new ArrayList<TerrainGrids>();
			Map<String, List<TerrainGrid>> bucketHash = new HashMap<>();
			int width, height, x, y;
			// read from filePath -> fill hashmap
						// construct grids -> read from file 
						// for-each char -> x++, for-each newLine -> y++
						// if y > 0 
						//          westGrid  = grids.get(height*y + (x-1))
						//          northGrid = grids.get(height*(y-1) + x);
						//          westGrid.set(EAST, grid);
						//          northGrid.set(SOUTH, grid);
						//     grids.add(westGrid, height*y + (x-1)), grids.add(nosrthGrid, height*(y-1) + x),
						//     grids.add(grid)
			BufferedReader reader = null;
			try{
			  reader = new BufferedReader(new InputStreamReader(
					  							new FileInputStream(filePath)));
			  String line;
			  while((line=reader.readLine()) != null){
				  width += line.length();
				  height++;
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
		
		private String filePath = "resources/";
	}
	
	private List<TerrainGrid> grids;
	private List<Tower> towers;
	private List<EnemyTroop> enemies;
	private MordorFrame owner;
	private Thread animator;
}