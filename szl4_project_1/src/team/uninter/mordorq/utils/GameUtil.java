package team.uninter.mordorq.utils;

import java.util.List;

import team.uninter.mordorq.gamespace.TerrainGrid;

public class GameUtil {

	public static TerrainGrid getGridByXY(List<TerrainGrid> grids, int x, int y){
		for(TerrainGrid g : grids){
			if(g.getX() == x && g.getY() == y){
				return g;
			}
		}
		return null;
	}
	
	public static TerrainGrid getGridById(List<TerrainGrid> grids, int id){
		for(TerrainGrid g : grids){
			if(g.getId() == id){
				return g;
			}
		}
		return null;
	}
}
