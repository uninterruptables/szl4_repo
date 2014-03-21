/**
 * Skeleton.java
 * */
package team.uninter.mordorq.skeleton;

import java.io.*;
//TODO: finish the comment @see section!
/**
 * <code>Skeleton</code> is responsible for providing a CLI for the user,
 * interpreting the commands given by the user and managing output (simulations
 * or usage) accordingly.
 * 
 * @author Imre Szekeres
 * @version "%I%, %G%"
 * @see MordorFrameBuilds
 * */
public class Skeleton {
	
	/**
	 * Publishes a no-arg constructor for the <code>Skeleton</code>.
	 * */
	public Skeleton(){}
	
	/**
	 * Provides the main mechanism behind the skeleton application, the CLI,
	 * interprets the input and manages the simulation accordingly.
	 * */
	public void run(){
		BufferedReader consoleIn = null;
		try{
			consoleIn = new BufferedReader(new InputStreamReader(System.in));
			String command;
			printUsage();
			System.out.print(">> ");
			while(!(command = consoleIn.readLine()).trim().equals("exit")){
				switch(command){
				case "1":
					simulatable = MordorFrameBuilds.getInstance();
					runSimulation();
					break;
				case "2":
					//TODO:
					runSimulation();
					break;
				case "3":
					//TODO:
					runSimulation();
					break;
				case "4":
					//TODO:
					runSimulation();
					break;
				case "5":
					//TODO:
					runSimulation();
					break;
				case "6":
					//TODO:
					runSimulation();
					break;
				case "7":
					//TODO:
					runSimulation();
					break;
				case "8":
					//TODO:
					runSimulation();
					break;
				case "9":
					//TODO:
					runSimulation();
					break;
				case "10":
					//TODO:
					runSimulation();
					break;
				case "11":
					//TODO:
					runSimulation();
					break;
				default: printUsage();
				}
			}
		}catch(IOException e){
			System.out.println("io error: "+e.getClass().getName()+": "+e.getMessage());
		}catch(Exception ex){
			System.out.println("exception in main thread: "+ex.getClass()+": "+ex.getMessage());
		}
	}
	
	/**
	 * Runs the previously configured simulation.
	 * 
	 * @throws Exception if something malicious occures in the process of simulation.
	 * */
	private void runSimulation() throws Exception{
		simulatable.simulate();
		printUsage();
	}
	
	/**
	 * Prints the usage of the skeleton to the console helping the user
	 * typing in the right commands.
	 * */
	private static void printUsage(){
		printLine(USAGE_STRING);
	}
	
	/**
	 * Prints one line of message to the console.
	 * 
	 * @param message	the string output meant to be printed to the console.
	 * */
	private static void printLine(String message){
		System.out.println(message);
	}
	
	private static final String USAGE_STRING;
	private Simulatable simulatable;
	
	/**
	 * Initializes the usage string in a manner that is is separated from
	 * other parts of the code.
	 * */
	static{
		USAGE_STRING = 
		  "   Simulation name\t\tCommand  \n"
		 +"-------------------------------------------\n"
	     +"  MordorFrame builds\t\t   1\n"
		 +"  Cast-rune-trap\t\t   2\n"
		 +"  Cast-rune-tower\t\t   3\n"
		 +"  Troop-steps\t\t\t   4\n"
		 +"  Troop-steps-trap\t\t   5\n"
		 +"  Missile-damages\t\t   6\n"
		 +"  Troop-steps-tower-fires\t   7\n"
		 +"  Cast-tower-ground\t\t   8\n"
		 +"  Cast-tower-road\t\t   9\n"
		 +"  Cast-magic\t\t\t   10\n"
		 +"  Troop-damages-mountain\t   11\n"
		 +"  terminate skeleton\t\t  exit\n";
	}
}
