package team.uninter.mordorq.prototype;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import team.uninter.mordorq.gamespace.MordorFrame;
import team.uninter.mordorq.utils.GameConstants;

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
//			getMapinfo();
		}
		else if(stringArray[0].equals("getEnemyinfo")){
//			getEnemyinfo();
		}
		else if(stringArray[0].equals("build")){
//			build();
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
//				createTower();
			}
			else if(parameter.equals("trap")){
//				createTrap();
			}
			else if(parameter.equals("rune")){
//				createRune();
			}
		}
		catch(Exception e){
			System.out.println("Wrong parameter, try enemy, tower, trap, rune");
		}
	}
	
	private void createEnemy(){
		if(checkConjunction(2,"at")){
			
		}
	}
	
	private HashMap<String,Integer> getPosParameters(String[] stringArray){
		String xPosParameter, yPosParameter;
		try{
			xPosParameter = stringArray[3];
			yPosParameter = stringArray[4];
			String[] xPos = xPosParameter.split(":");
			String[] yPos = yPosParameter.split(":");
			HashMap<String,Integer> coords = new HashMap<String,Integer>();
			coords.put(xPos[0], Integer.parseInt(xPos[1]));
			coords.put(yPos[0], Integer.parseInt(yPos[1]));
			return coords;
		}
		catch(Exception e){
			System.out.println("Wrong position parameters, try x:number y:number");
		}
		return null;
	}
	
	private boolean checkConjunction(int paramNumber, String conj){
		try{
			if(stringArray[paramNumber].equals(conj)){
				return true;
			}
			else {
				System.out.println("Wrong "+paramNumber+". parameter, try "+conj);
				return false;
			}
		}
		catch(Exception e){
			System.out.println("Missing "+paramNumber+". parameter, try "+conj);
		}
		return false;
	}
	
}
