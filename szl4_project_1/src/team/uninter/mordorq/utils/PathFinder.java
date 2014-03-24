package team.uninter.mordorq.utils;

import team.uninter.mordorq.gamespace.*;
import team.uninter.mordorq.gamespace.Neighbour;
import team.uninter.mordorq.gamespace.RoadGrid;
import team.uninter.mordorq.gamespace.TerrainGrid;
import team.uninter.mordorq.gamespace.Vulnerable;

public class PathFinder {
	public static RoadGrid findPathFrom(RoadGrid currentGrid){
		//TODO remove sysout
		System.out.println("PathFinder findPathFrom called");
		RoadGrid barricadeGrid = null;
		int currentUtility = currentGrid.getUtility();
		for(Neighbour direction : Neighbour.values()){
			TerrainGrid targetGrid = currentGrid.get(direction);
			if(targetGrid != null){
				int targetUtility = targetGrid.getUtility();	
				if(targetUtility >= currentUtility){
					RoadGrid targetRoad = (RoadGrid)targetGrid;
					Vulnerable vulnerable = targetRoad.getVulnerable();
					if(vulnerable == null){
						System.out.println("PathFinder findPathFrom(RoadGrid currentGrid) returned");
						return targetRoad;
					}
					else{
						if(targetUtility - currentUtility - 50 > 0) return targetRoad;
						if(!(vulnerable instanceof EnemyTroop)){
							barricadeGrid = targetRoad;
						}
					}
				}
			}
		}
		if(barricadeGrid != null){
			System.out.println("PathFinder findPathFrom(RoadGrid currentGrid) returned");
			return barricadeGrid;
		}
		System.out.println("PathFinder findPathFrom(RoadGrid currentGrid) returned");
		return currentGrid;
	}
}
