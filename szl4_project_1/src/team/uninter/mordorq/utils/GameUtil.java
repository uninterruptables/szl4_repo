package team.uninter.mordorq.utils;

import java.util.List;

import team.uninter.mordorq.gamespace.TerrainGrid;

public class GameUtil {

	public static TerrainGrid getGridByXY(List<TerrainGrid> grids, int x, int y) {
		for (TerrainGrid g : grids) {
			int xInteger = (x - x % GameConstants.GRID_SIZE);
			int yInteger = (y - y % GameConstants.GRID_SIZE);
			if (g.getX() == xInteger && g.getY() == yInteger) {
				return g;
			}
		}
		return null;
	}

	public static TerrainGrid getGridById(List<TerrainGrid> grids, int id) {
		for (TerrainGrid g : grids) {
			if (g.getId() == id) {
				return g;
			}
		}
		return null;
	}

	/**
	 * Slices down the characters from before the first occurrence of the given
	 * 'from' indicator.
	 * 
	 * @param whole
	 *            the <code>String</code> to slice
	 * @param from
	 *            the substring
	 * 
	 * @return a sub<code>String</code> from 'from'
	 * */
	public static String fetchFrom(String whole, String from) {
		return whole.substring(whole.indexOf(from));
	}

	/***/
	public static String slicePackagesFrom(String classPath) {
		String[] array = classPath.split("\\.");
		return array[array.length - 1];
	}
}
