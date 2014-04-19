package team.uninter.mordorq.utils;

import java.util.ArrayList;
import java.util.List;

import team.uninter.mordorq.gamespace.*;


/**
 * Utility class for geting the right
 * direction from a grid to another
 *
 */
public class PathFinder {
	public static RoadGrid findPathFrom(RoadGrid currentGrid){
		//possible target grids. If the randomness is turned on
		//this is the collection of the possible outputs.
		List<RoadGrid> possibleTargetGrids = new ArrayList<RoadGrid>();
		RoadGrid possibleTarget = currentGrid;
		int currentUtility = currentGrid.getUtility();
		
		//iterate through all neightbour grids
		for(Neighbour direction : Neighbour.values()){
			TerrainGrid targetGrid = currentGrid.get(direction);
			
			if(targetGrid != null){
				//if the neighbour's utility greater than the current
				//it is the trivial target grid
				if(targetGrid.getUtility() > currentUtility){
					if(((RoadGrid)targetGrid).getVulnerable() == null){
						return (RoadGrid)targetGrid;
					}
					else{
						possibleTarget = (RoadGrid)targetGrid;
					}
				}
				
				//If we can't decide which grid has the better utility,
				//collect them in a collection
				else if(currentUtility == targetGrid.getUtility()){
					possibleTargetGrids.add((RoadGrid)targetGrid);
				}
			}
		}
		
		//if a grid in the collection has something on it,
		//there is no reason to choice random
		boolean allAvailable = true;
		for(RoadGrid target : possibleTargetGrids){
			if(target.getVulnerable() != null){
				allAvailable = false;
			}
		}
		
		//if all grids available, choice a random one as target grid.
		if(allAvailable && GameConstants.RANDOMNESS && possibleTargetGrids.size() > 1){
			double randomValue = Math.random();
			if(randomValue > 0.5){
				return possibleTargetGrids.get(0);
			}
			else{
				return possibleTargetGrids.get(1);
			}
		}
		
		//else gives back the first available grid
		else{
			for(RoadGrid target : possibleTargetGrids){
				if(target.getVulnerable() == null){
					return target;
				}
			}
		}
		
		//if all neighbour are reserved, gives back the grid
		//with the greatest utility (and with something on it)
		return possibleTarget;
	}
}
