package team.uninter.mordorq.prototype;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;

import team.uninter.mordorq.gamespace.BasicTower;
import team.uninter.mordorq.gamespace.Controlable;
import team.uninter.mordorq.gamespace.EnemyTroop;
import team.uninter.mordorq.gamespace.GroundGrid;
import team.uninter.mordorq.gamespace.Human;
import team.uninter.mordorq.gamespace.MordorFrame;
import team.uninter.mordorq.gamespace.RoadGrid;
import team.uninter.mordorq.gamespace.StatusModifier;
import team.uninter.mordorq.gamespace.TerrainGrid;
import team.uninter.mordorq.utils.GameConstants;
import team.uninter.mordorq.utils.GameUtil;

public class Prototype {

	private BufferedReader consoleIn;
	private String[] stringArray;
	MordorFrame frame = MordorFrame.newInstance();
	
	public Prototype(){
		consoleIn = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public void run() throws IOException{
		String command;
		while(!(command = consoleIn.readLine()).trim().equals("exit")){
			try{	
				stringArray = command.split(" ");
				parseCommand();
			}catch(Exception ex){
				System.out.println("exception in main thread: "+ex.getClass()+": "+ex.getMessage());
			}
		}
		
	}
	
	private void parseCommand(){
		if(stringArray[0].equals("toggleRandomness")){
			toggleRandomness();
		}
		else if(stringArray[0].equals("animate")){
			animate();
		}
		else if(stringArray[0].equals("create")){
			create();
		}
		else if(stringArray[0].equals("canCreate")){
//			canCreate();
		}
		else if(stringArray[0].equals("cast")){
//			cast();
		}
		else if(stringArray[0].equals("loadCommands")){
//			loadCommands();
		}
		else if(stringArray[0].equals("getMapinfo")){
			getMapinfo();
		}
		else if(stringArray[0].equals("getEnemyinfo")){
			getEnemyinfo();
		}
		else if(stringArray[0].equals("build")){
			build();
		}
		else if(stringArray[0].equals("set")){
//			set();
		}
		else if(stringArray[0].equals("handleMana")){
//			handleMana();
		}
		else if(stringArray[0].equals("startFileWrite")){
//			startFileWrite();
		}
		else if(stringArray[0].equals("endFileWrite")){
//			endFileWrite();
		}
		else if(stringArray[0].equals("restart")){
//			restart();
		}
		else if(stringArray[0].equals("help")){
			help();
		}
		else if(stringArray[0].equals("toggleRandomness")){
//			exit();
		}
		else{
			System.out.println("Incorrect Command!");
		}
	}
	
	private void getMapinfo(){
		List<TerrainGrid> grids = frame.getScene().getGrids();
		if(grids.size() > 0){
			for(TerrainGrid g : grids){
				String output = g.getClass().getSimpleName() + " at x:" + g.getX() + " y:" + g.getY()+" with id:"+g.getId();
				if(g instanceof GroundGrid){
					if(((GroundGrid) g).getTower() != null){
						output += " inside: "+((GroundGrid) g).getTower().getClass().getSimpleName()+",";
					}
				}
				else if(g instanceof RoadGrid){
					if(g.getInjectionTarget() != null){
						output += " inside: "+((RoadGrid) g).getInjectionTarget().getClass().getSimpleName()+",";
					}
					if(((RoadGrid) g).getTarget() != null){
						output += " inside: "+((RoadGrid) g).getTarget().getClass().getSimpleName()+",";
					}
				}
				System.out.println(output);
			}
		}
		else{
			System.out.println("No existing grid");
		}
	}
	
	private void getEnemyinfo(){
		List<Controlable> enemies = frame.getScene().getEnemies();
		if(enemies.size() > 0){
			for(int i = 0; i < enemies.size(); i++){
				EnemyTroop troop = (EnemyTroop)enemies.get(i);
				String output = troop.getClass().getSimpleName() + " Hp: "+troop.getHealth()+" Dmg: "+troop.getDamage()+" gridId: "+troop.getCurrentGrid().getId()+
						" Pos: x:"+troop.getX()+" y: "+troop.getY()+" StatusModifier: ";
				for(StatusModifier sm : troop.getModifiers()){
					output += sm.getClass().getSimpleName()+",";
				}
				System.out.println(output);
			}
		}
		else{
			System.out.println("No existing enemy");
		}
	}
	
	private void build(){
		String parameter;
		try{
			parameter = stringArray[1];
			if(parameter.equals("roadgrid")){
				buildRoad();
			}
			else if(parameter.equals("groundgrid")){
				buildGround();
			}
			else{
				System.out.println("Wrong parameter, try: roadgrid, groundgrid");
			}
		}
		catch(Exception e){
			System.out.println("Wrong parameter, try: roadgrid, groundgrid");
		}
	}
	
	private void buildRoad(){
		int utility, id, xPos, yPos;
		try{
			utility = Integer.parseInt(stringArray[2]);
			id = Integer.parseInt(stringArray[3]);
			if(checkConjunction(4,"at")){
				xPos = getPosParameter(stringArray[5],":");
				yPos = getPosParameter(stringArray[6],":");
				
				boolean contains = false;
				for(TerrainGrid g : frame.getScene().getGrids()){
					if(g.getId() == id){
						contains = true;
					}
				}
				
				if(!contains){
					frame.getScene().getGrids().add(new RoadGrid(xPos,yPos,utility,id));
					System.out.println("Road created at x:"+xPos+" y:"+yPos+" with id:"+id);
				}
				else{
					System.out.println("Grid already exist with id:"+id);
				}
			}
		}
		catch(Exception e){
			System.out.println("Wrong paramteres list try: number at x:number y:number");
		}
	}
	
	private void buildGround(){
		int utility, id, xPos, yPos;
		try{
			utility = Integer.parseInt(stringArray[2]);
			id = Integer.parseInt(stringArray[3]);
			if(checkConjunction(4,"at")){
				xPos = getPosParameter(stringArray[5],":");
				yPos = getPosParameter(stringArray[6],":");
				
				boolean contains = false;
				for(TerrainGrid g : frame.getScene().getGrids()){
					if(g.getId() == id){
						contains = true;
					}
				}
				
				if(!contains){
					frame.getScene().getGrids().add(new GroundGrid(xPos,yPos,utility,id));
					System.out.println("Ground created at x:"+xPos+" y:"+yPos+" with id:"+id);
				}
				else{
					System.out.println("Grid already exist with id:"+id);
				}
			}
		}
		catch(Exception e){
			System.out.println("Wrong paramteres list try: number at x:number y:number");
		}
	}
	
	private void toggleRandomness(){
		GameConstants.RANDOMNESS =!GameConstants.RANDOMNESS;
	}
	
	private void help(){
		//TODO szepen leirni h kell hasznalni
		System.out.println("command and parameter lsit");
	}
	
	private void animate(){
		int tick;
		try{
			tick = Integer.parseInt(stringArray[1]);
			frame.getScene().start(tick);
			System.out.println("Animated "+tick+" time segment(s)");
		}
		catch(Exception e){
			System.out.println("Wrong argument, enter a number!");
		}
	}
	
	private void create(){
		String parameter;
		try{
			parameter = stringArray[1];
			if(parameter.equals("enemy")){
				createEnemy();
			}
			else if(parameter.equals("tower")){
				createTower();
			}
			else if(parameter.equals("trap")){
//				createTrap();
			}
			else if(parameter.equals("rune")){
//				createRune();
			}
			else{
				System.out.println("Wrong parameter, try: enemy, tower, trap, rune");
			}
		}
		catch(Exception e){
			System.out.println("Wrong parameter, try: enemy, tower, trap, rune");
		}
	}
	
	private void createTower(){
		if(checkConjunction(2,"at")){
			int xPos, yPos;
			try{
				xPos = getPosParameter(stringArray[3],":");
				yPos = getPosParameter(stringArray[4],":");
				TerrainGrid targetGrid = GameUtil.getGridByXY(frame.getScene().getGrids(), xPos, yPos);
				if(targetGrid != null){
					if(targetGrid instanceof GroundGrid){
						if(((GroundGrid) targetGrid).getTower() == null){
							frame.getScene().place(new BasicTower(xPos, yPos),targetGrid);
							System.out.println("Created tower on x:"+xPos+" y:"+yPos+" gridId: "+targetGrid.getId());
						}
						else{
							System.out.println("There is already a tower on the given grid");
						}
					}
					else if(targetGrid instanceof RoadGrid){
						System.out.println("Can't create tower on RoadGrid");		
					}
				}
				else{
					System.out.println("No grid exist on the given coordinates");
				}
				
			}
			catch(Exception e){
				System.out.println("Wrong position parameter try: x:number y:number");
			}
		}
	}
	
	private void createEnemy(){
		if(checkConjunction(2,"at")){
			int xPos, yPos;
			try{
				xPos = getPosParameter(stringArray[3],":");
				yPos = getPosParameter(stringArray[4],":");
				TerrainGrid targetGrid = GameUtil.getGridByXY(frame.getScene().getGrids(), xPos, yPos);
				if(targetGrid != null){
					if(targetGrid instanceof GroundGrid){
						System.out.println("Can't create enemy on GroundGrid");
					}
					else if(targetGrid instanceof RoadGrid){
						List<Controlable> enemies = frame.getScene().getEnemies();
						Human enemy = new Human(xPos,yPos);
						enemies.add(enemy);
						((RoadGrid)targetGrid).setVulnerable(enemy);
						System.out.println("Created enemy on x:"+xPos+" y:"+yPos+" gridId: "+targetGrid.getId());
					}
				}
				else{
					System.out.println("No grid exist on the given coordinates");
				}
				
			}
			catch(Exception e){
				System.out.println("Wrong position parameter try: x:number y:number");
			}
		}
	}
	
	private int getPosParameter(String text, String separation){
		String[] splittedText = text.split(separation);
		return Integer.parseInt(splittedText[1]);
	}
	
	private boolean checkConjunction(int paramNumber, String conj){
		try{
			if(stringArray[paramNumber].equals(conj)){
				return true;
			}
			else {
				System.out.println("Wrong "+paramNumber+". parameter, try: "+conj);
				return false;
			}
		}
		catch(Exception e){
			System.out.println("Missing "+paramNumber+". parameter, try: "+conj);
		}
		return false;
	}
	
}
