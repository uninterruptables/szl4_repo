package team.uninter.mordorq.prototype;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;

import team.uninter.mordorq.gamespace.BasicTower;
import team.uninter.mordorq.gamespace.Controlable;
import team.uninter.mordorq.gamespace.DamageBoosterTowerRune;
import team.uninter.mordorq.gamespace.DecreaseDamageTrap;
import team.uninter.mordorq.gamespace.EnemyTroop;
import team.uninter.mordorq.gamespace.GroundGrid;
import team.uninter.mordorq.gamespace.Human;
import team.uninter.mordorq.gamespace.IceWindMagic;
import team.uninter.mordorq.gamespace.MordorFrame;
import team.uninter.mordorq.gamespace.Nazgul;
import team.uninter.mordorq.gamespace.Neighbour;
import team.uninter.mordorq.gamespace.PoisonFogMagic;
import team.uninter.mordorq.gamespace.RoadGrid;
import team.uninter.mordorq.gamespace.StatusModifier;
import team.uninter.mordorq.gamespace.TerrainGrid;
import team.uninter.mordorq.gamespace.WeakenTrapRune;
import team.uninter.mordorq.utils.GameConstants;
import team.uninter.mordorq.utils.GameUtil;

public class Prototype {

	private LineToFileWriter writer;
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
	
	private void parseCommand() throws Exception {
		if(stringArray[0].equals("endFileWrite")){
			endFileWrite();
		}
		else{
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
				canCreate();
			}
			else if(stringArray[0].equals("cast")){
				cast();
			}
			else if(stringArray[0].equals("loadCommands")){
				loadCommands();
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
				set();
			}
			else if(stringArray[0].equals("handleMana")){
				handleMana();
			}
			else if(stringArray[0].equals("startFileWrite")){
				startFileWrite(stringArray[1]);
			}
			else if(stringArray[0].equals("restart")){
				restart();
			}
			else if(stringArray[0].equals("help")){
				help();
			}
			else{
				System.out.println("Incorrect Command!");
			}
		}
	}
	
	private void canCreate(){
		String parameter;
		try{
			parameter = stringArray[1];
			if(parameter.equals("enemy")){
				canCreateEnemy();
			}
			else if(parameter.equals("tower")){
				canCreateTower();
			}
			else if(parameter.equals("trap")){
				canCreateTrap();
			}
			else if(parameter.equals("rune")){
				canCreateRune();
			}
			else{
				System.out.println("Wrong parameter, try: enemy, tower, trap, rune");
			}
		}
		catch(Exception e){
			System.out.println("Wrong parameter, try: enemy, tower, trap, rune");
		}
	}
	
	private void canCreateEnemy(){
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
						if(((RoadGrid)targetGrid).getTarget() == null){
							System.out.println("Can create enemy at x:"+xPos+" y:"+yPos+" gridId: "+targetGrid.getId());
						}
						else{
							System.out.println("Can't create. There is already an enemy at x:"+xPos+" y:"+yPos+" gridId: "+targetGrid.getId());
						}
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
	
	private void canCreateTower(){
		if(checkConjunction(2,"at")){
			int xPos, yPos;
			try{
				xPos = getPosParameter(stringArray[3],":");
				yPos = getPosParameter(stringArray[4],":");
				TerrainGrid targetGrid = GameUtil.getGridByXY(frame.getScene().getGrids(), xPos, yPos);
				if(targetGrid != null){
					if(targetGrid instanceof GroundGrid){
						if(((GroundGrid) targetGrid).getTower() == null){
							System.out.println("Can create tower at x:"+xPos+" y:"+yPos+" gridId: "+targetGrid.getId());
						}
						else{
							System.out.println("Can't create. There is already a tower on the given grid");
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
	
	private void canCreateTrap(){
		if(checkConjunction(2,"at")){
			int xPos, yPos;
			try{
				xPos = getPosParameter(stringArray[3],":");
				yPos = getPosParameter(stringArray[4],":");
				TerrainGrid targetGrid = GameUtil.getGridByXY(frame.getScene().getGrids(), xPos, yPos);
				if(targetGrid != null){
					if(targetGrid instanceof RoadGrid){
						if(((RoadGrid) targetGrid).getTrap() == null){
							System.out.println("Can create trap at x:"+xPos+" y:"+yPos+" gridId: "+targetGrid.getId());
						}
						else{
							System.out.println("Can't create. There is already a trap on the given grid");
						}
					}
					else if(targetGrid instanceof RoadGrid){
						System.out.println("Can't create Trap on GroundGrid");		
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
	
	private void canCreateRune(){
		if(checkConjunction(2,"at")){
			int xPos, yPos;
			try{
				xPos = getPosParameter(stringArray[3],":");
				yPos = getPosParameter(stringArray[4],":");
				TerrainGrid targetGrid = GameUtil.getGridByXY(frame.getScene().getGrids(), xPos, yPos);
				if(targetGrid != null){
					if(targetGrid instanceof RoadGrid){
						if(((RoadGrid) targetGrid).getTrap() != null){
							System.out.println("Can create rune at x:"+xPos+" y:"+yPos+" gridId: "+targetGrid.getId());
						}
						else{
							System.out.println("Can't create. There is no Trap on this RoadGrid");
						}
					}
					else if(targetGrid instanceof GroundGrid){
						if(((GroundGrid) targetGrid).getTower() != null){
							System.out.println("Can create rune at x:"+xPos+" y:"+yPos+" gridId: "+targetGrid.getId());
						}
						else{
							System.out.println("Can't create. There is no Tower on this GroundGrid");
						}
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
	
	/**
	 * Starts a writing session of all the commands typed into the console
	 * gets printed out to the specified file.
	 * 
	 * @param filePath
	 * @throws IOException if the given file does not exist or a current writing session does
	 * */
	private void startFileWrite(String filePath) throws IOException {
		if(writer == null || !writer.isOpen()){
			writer = new LineToFileWriter(filePath);
			System.out.println("Write into file is started.");
		}
		else throw new IOException("Writing to file is already in action! End the current session of writing.");
	}
	
	/**
	 * Closes the current writing session if it is already in progress,
	 * signals the missing of it otherwise.
	 * 
	 * @throws IOException if there is no current writing session to close
	 * */
	private void endFileWrite() throws IOException {
		if(writer != null && writer.isOpen()){
			writer.close();
			System.out.println("Write into file is ended.");
		}
		else throw new IOException("No session of writing has been started yet! Start a writing session.");
	}
	
	private void loadCommands(){
		try{
			if(stringArray.length > 2){
				for(int i = 2; i < stringArray.length; i++){
					stringArray[1] += " "+stringArray[i];
				}
			}
			
			String filePath = stringArray[1];
			String fileName = "";

			int i = filePath.lastIndexOf('\\');
			if (i > 0) {
				fileName = filePath.substring(i+1);
			}
			
			InputStream fis;
			BufferedReader br;
			String line;

			fis = new FileInputStream(filePath);
			br = new BufferedReader(new InputStreamReader(fis));
			while ((line = br.readLine()) != null) {
				stringArray = line.split(" ");
				parseCommand();
			}
			
			System.out.println("Loaded "+fileName);

			br.close();
			br = null;
			fis = null;
		}
		catch(Exception e){
			System.out.println("Wrong parameter, try: filepath");
		}
	}
	
	private void handleMana(){
		String manaAmountText;
		int manaAmount;
		try{
			manaAmountText = stringArray[1];
			try{
				manaAmount = Integer.parseInt(manaAmountText);
				frame.getScene().setUserMana(manaAmount);
				System.out.println("New mana amount is: "+manaAmount);
			}
			catch(Exception e){
				System.out.println("Wrong parameter, try: number");
			}
		}
		catch(Exception e){
			manaAmount = frame.getUserMana();
			System.out.println("Mana amount is: "+manaAmount);
		}
	}
	
	private void restart(){
		frame = MordorFrame.newInstance();
		System.out.println("Restarted succesfully");
	}
	
	private void cast(){
		try{
			String param = stringArray[1];
			if(param.equals("nazgul")){
				frame.getScene().cast(new Nazgul());
				System.out.println("Nazgul casted");
			}
			else if(param.equals("icewind")){
				frame.getScene().cast(new IceWindMagic());
				System.out.println("IceWindMagic casted");
			}
			else if(param.equals("poisonfog")){
				frame.getScene().cast(new PoisonFogMagic());
				System.out.println("PoisonFogMagic casted");
			}
			else{
				System.out.println("Wrong parameter, try: nazgul, icewind, poisonfog");
			}
			
		}
		catch(Exception e){
			System.out.println("Wrong parameter, try: nazgul, icewind, poisonfog");
		}
	}
	
	private void set(){
		int currentId, targetId;
		String direction;
		try{
			currentId = Integer.parseInt(stringArray[1]);
			targetId = Integer.parseInt(stringArray[3]);
			direction = stringArray[2];
			if(direction.equals("north")){
				GameUtil.getGridById(frame.getScene().getGrids(), currentId).set(Neighbour.NORTH, GameUtil.getGridById(frame.getScene().getGrids(), targetId));
				System.out.println("Set gridId:"+currentId+" "+direction+" neighbour to gridId:"+targetId+" is done");
			}
			else if(direction.equals("east")){
				GameUtil.getGridById(frame.getScene().getGrids(), currentId).set(Neighbour.EAST, GameUtil.getGridById(frame.getScene().getGrids(), targetId));
				System.out.println("Set gridId:"+currentId+" "+direction+" neighbour to gridId:"+targetId+" is done");
			}
			else if(direction.equals("south")){
				GameUtil.getGridById(frame.getScene().getGrids(), currentId).set(Neighbour.SOUTH, GameUtil.getGridById(frame.getScene().getGrids(), targetId));
				System.out.println("Set gridId:"+currentId+" "+direction+" neighbour to gridId:"+targetId+" is done");
			}
			else if(direction.equals("west")){
				GameUtil.getGridById(frame.getScene().getGrids(), currentId).set(Neighbour.WEST, GameUtil.getGridById(frame.getScene().getGrids(), targetId));
				System.out.println("Set gridId:"+currentId+" "+direction+" neighbour to gridId:"+targetId+" is done");
			}
			else{
				System.out.println("Wrong direction parameter, try: north, east, south, west");
			}
		}
		catch(Exception e){
			System.out.println("Wrong parameters, try: idNumber direction idNumber");
		}
	}
	
	private void getMapinfo(){
		List<TerrainGrid> grids = frame.getScene().getGrids();
		if(grids.size() > 0){
			String output = "------Map info------\n";
			for(TerrainGrid g : grids){
				output += g.getClass().getSimpleName() + " at x:" + g.getX() + " y:" + g.getY()+" with id:"+g.getId();
				if(g instanceof GroundGrid){
					if(((GroundGrid) g).getTower() != null){
						output += " inside: "+((GroundGrid) g).getTower().getClass().getSimpleName()+",";
					}
				}
				else if(g instanceof RoadGrid){
					output += " Inside: ";
					if(g.getInjectionTarget() != null){
						output += ((RoadGrid) g).getInjectionTarget().getClass().getSimpleName()+",";
					}
					if(((RoadGrid) g).getTarget() != null){
						output += ((RoadGrid) g).getTarget().getClass().getSimpleName()+",";
					}
				}
				output += "\n";
			}
			output += "\n----------------------";
			System.out.println(output);
		}
		else{
			System.out.println("No existing grid");
		}
	}
	
	private void getEnemyinfo(){
		List<Controlable> enemies = frame.getScene().getEnemies();
		if(enemies.size() > 0){
			String output = "------Enemy info------\n";
			for(int i = 0; i < enemies.size(); i++){
				EnemyTroop troop = (EnemyTroop)enemies.get(i);
				output += troop.getClass().getSimpleName() + " Hp: "+troop.getHealth()+" Dmg: "+troop.getDamage()+" gridId: "+troop.getCurrentGrid().getId()+
						" Pos: x:"+troop.getX()+" y: "+troop.getY()+" StatusModifier: ";
				for(StatusModifier sm : troop.getModifiers()){
					output += sm.getClass().getSimpleName()+",";
				}
				output += "\n";
			}
			output += "----------------------";
			System.out.println(output);
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
					if(g.getId() == id || (g.getX() == xPos && g.getY() == yPos)){
						contains = true;
					}
				}
				
				if(!contains){
					frame.getScene().getGrids().add(new RoadGrid(xPos,yPos,utility,id));
					System.out.println("Road created at x:"+xPos+" y:"+yPos+" with id:"+id);
				}
				else{
					System.out.println("Grid already exist with the given id or coordinates");
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
					if(g.getId() == id || (g.getX() == xPos && g.getY() == yPos)){
						contains = true;
					}
				}
				
				if(!contains){
					frame.getScene().getGrids().add(new GroundGrid(xPos,yPos,utility,id));
					System.out.println("Ground created at x:"+xPos+" y:"+yPos+" with id:"+id);
				}
				else{
					System.out.println("Grid already exist with the given id or coordinates");
				}
			}
		}
		catch(Exception e){
			System.out.println("Wrong parameter list try: number number at x:number y:number");
		}
	}
	
	private void toggleRandomness(){
		GameConstants.RANDOMNESS =!GameConstants.RANDOMNESS;
		if(GameConstants.RANDOMNESS){
			System.out.println("Randomness on");
		}
		else{
			System.out.println("Randomness off");
		}
	}
	
	private void help(){
		//TODO szepen leirni h kell hasznalni
		System.out.println("Command and parameter list:");
		System.out.println("---------------------------");
		System.out.println("toggleRandomness  -  toggles the random functions");
		System.out.println("animate 'number'  -  animates as much time tick as the given number is | 'number' is an integer");
		System.out.println("create 'object' at x:'xPos' y:'yPos'  -  creates the given object at the given parameter | 'object' types: enemy,tower,trap,rune; 'xPos' and 'yPos' are integers");
		System.out.println("canCreate 'object' at x:'xPos' y:'yPos'  -  can the given object create at the given parameter? | 'object' types: enemy,tower,trap,rune; 'xPos' and 'yPos' are integers");
		System.out.println("cast 'magic'  -  cast the given magic | 'magic' types: nazgul,icewind,poisonfog");
		System.out.println("loadCommands 'filepath'  -  load the command from a file | 'filepath' is a full file path");
		System.out.println("getMapinfo  -  list informations about the map");
		System.out.println("getEnemyinfo  -  list informations about the enemies");
		System.out.println("build 'object' at x:'xPos' y:'yPos'  -  build the given object at the given parameter | 'object' types: roadgrid,groundgrid; 'xPos' and 'yPos' are integers");
		System.out.println("set 'currentId' 'direction' 'targetId'  -  set the neighbour of the 'currentId' grid to the 'targetId' grid | 'currentId' is a grid id; 'direction' types: north,east,south,west; 'targetId' is a grid id");
		System.out.println("handleMana 'number'  -  gives back, or set the user's mana amount | 'number' is an integer (optional)");
		System.out.println("startFileWrite 'filePath'  -  writes the feedbacks to the given file instead of the console | 'filePath' is a full file path");
		System.out.println("restart  -  creates a clear gamespace");
		System.out.println("help  -  show helps for commands");
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
				createTrap();
			}
			else if(parameter.equals("rune")){
				createRune();
			}
			else{
				System.out.println("Wrong parameter, try: enemy, tower, trap, rune");
			}
		}
		catch(Exception e){
			System.out.println("Wrong parameter, try: enemy, tower, trap, rune");
		}
	}
	
	private void createTrap(){
		if(checkConjunction(2,"at")){
			int xPos, yPos;
			try{
				xPos = getPosParameter(stringArray[3],":");
				yPos = getPosParameter(stringArray[4],":");
				TerrainGrid targetGrid = GameUtil.getGridByXY(frame.getScene().getGrids(), xPos, yPos);
				if(targetGrid != null){
					if(targetGrid instanceof RoadGrid){
						if(((RoadGrid) targetGrid).getTrap() == null){
							DecreaseDamageTrap trap = new DecreaseDamageTrap(xPos,yPos);
							((RoadGrid) targetGrid).setTrap(trap);
							System.out.println("Trap created at x:"+xPos+" y:"+yPos+" gridId: "+targetGrid.getId());
						}
						else{
							System.out.println("There is already a trap on the given grid");
						}
					}
					else if(targetGrid instanceof RoadGrid){
						System.out.println("Can't create Trap on GroundGrid");		
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
	
	private void createRune(){
		if(checkConjunction(2,"at")){
			int xPos, yPos;
			try{
				xPos = getPosParameter(stringArray[3],":");
				yPos = getPosParameter(stringArray[4],":");
				TerrainGrid targetGrid = GameUtil.getGridByXY(frame.getScene().getGrids(), xPos, yPos);
				if(targetGrid != null){
					if(targetGrid instanceof RoadGrid){
						if(((RoadGrid) targetGrid).getTrap() != null){
							WeakenTrapRune rune = new WeakenTrapRune(xPos,yPos);
							rune.castOn(targetGrid);
							System.out.println("Rune created at x:"+xPos+" y:"+yPos+" gridId: "+targetGrid.getId());
						}
						else{
							System.out.println("There is no Trap on this RoadGrid");
						}
					}
					else if(targetGrid instanceof GroundGrid){
						if(((GroundGrid) targetGrid).getTower() != null){
							DamageBoosterTowerRune rune = new DamageBoosterTowerRune(xPos,yPos);
							rune.castOn(targetGrid);
							System.out.println("Rune created at x:"+xPos+" y:"+yPos+" gridId: "+targetGrid.getId());
						}
						else{
							System.out.println("There is no Tower on this GroundGrid");
						}
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
							BasicTower tower = new BasicTower(xPos, yPos);
							tower.setMaxCooldown(GameConstants.BASIC_TOWER_MAXCOOLDOWN);
							frame.getScene().place(tower,targetGrid);
							System.out.println("Tower created at x:"+xPos+" y:"+yPos+" gridId: "+targetGrid.getId());
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
						((RoadGrid)targetGrid).notifyAllWith(enemy);
						System.out.println("Enemy created at x:"+xPos+" y:"+yPos+" gridId: "+targetGrid.getId());
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