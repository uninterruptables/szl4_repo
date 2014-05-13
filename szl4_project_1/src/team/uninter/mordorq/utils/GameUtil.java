package team.uninter.mordorq.utils;

import java.util.List;

import team.uninter.mordorq.gamespace.TerrainGrid;

public class GameUtil {

	public static TerrainGrid getGridByXY(List<TerrainGrid> grids, int x, int y){
		for(TerrainGrid g : grids){
			int xInteger = (x - x % GameConstants.GRID_SIZE);
			int yInteger = (y - y % GameConstants.GRID_SIZE);
			if(g.getX() == xInteger && g.getY() == yInteger){
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
