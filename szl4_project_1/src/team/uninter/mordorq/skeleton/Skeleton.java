/**
 * Skeleton.java
 * */
package team.uninter.mordorq.skeleton;

import java.io.*;

import team.uninter.mordorq.skeleton.CastSimulator.CastAlias;
//TODO: finish the comment @see section!
/**
 * <code>Skeleton</code> is responsible for providing a CLI for the user,
 * interpreting the commands given by the user and managing output (simulations
 * or usage) accordingly.
 * 
 * @author Imre Szekeres
 * @version "%I%, %G%"
 * @see MordorFrameBuilds
 * @see TroopStepSimulator
 * */
public class Skeleton {
	
	private static final String USAGE_STRING;
	private Simulatable simulatable;
	private BufferedReader consoleIn;
	
	/**
	 * Publishes a no-arg constructor for the <code>Skeleton</code>.
	 * */
	public Skeleton() throws IOException {
		consoleIn = new BufferedReader(new InputStreamReader(System.in));
	}
	
	/**
	 * Provides the main mechanism behind the skeleton application, the CLI,
	 * interprets the input and manages the simulation accordingly.
	 * 
	 * @throws IOException 
	 * */
	public void run() throws IOException{	
			String command;
			printUsage();
			System.out.print(">> ");
			while(!(command = consoleIn.readLine()).trim().equals("exit")){
				try{
					switch(command){
					case "1":
						simulatable = MordorFrameBuilds.getInstance();
						runSimulation();
						break;
					case "2":
						simulatable = CastSimulator.getInstance();
						((CastSimulator)simulatable).configureFor(CastAlias.TRAPRUNE_TRAP);
						runSimulation();
						break;
					case "3":
						simulatable = CastSimulator.getInstance();
						((CastSimulator)simulatable).configureFor(CastAlias.TRAPRUNE_TOWER);
						runSimulation();
						break;
					case "4":
						simulatable = TroopStepSimulator.getInstance();
						((TroopStepSimulator)simulatable)
							.configureFor(TroopStepSimulator.TroopStepAlias.DEFAULT);
						runSimulation();
						break;
					case "5":
						simulatable = TroopStepSimulator.getInstance();
						((TroopStepSimulator)simulatable)
							.configureFor(TroopStepSimulator.TroopStepAlias.TRAP_AFFECTS);
						runSimulation();
						break;
					case "6":
						simulatable = MissileDamageSimulator.getInstance();
						runSimulation();
						break;
					case "7":
						simulatable = TroopStepSimulator.getInstance();
						((TroopStepSimulator)simulatable)
							.configureFor(TroopStepSimulator.TroopStepAlias.TOWER_FIRES);
						runSimulation();
						break;
					case "8":
						simulatable = CastSimulator.getInstance();
						((CastSimulator)simulatable).configureFor(CastAlias.TOWER_GROUND);
						runSimulation();
						break;
					case "9":
						simulatable = CastSimulator.getInstance();
						((CastSimulator)simulatable).configureFor(CastAlias.TRAP_ROAD);
						runSimulation();
						break;
					case "10":
						simulatable = CastSimulator.getInstance();
						((CastSimulator)simulatable).configureFor(CastAlias.MAGIC);
						runSimulation();
						break;
					case "11":
						simulatable = TroopStepSimulator.getInstance();
						((TroopStepSimulator)simulatable)
							.configureFor(TroopStepSimulator.TroopStepAlias.DAMAGES_MOUNTAIN);
						runSimulation();
						break;
					default: printUsage();
					}
				}catch(IOException e){
					System.out.println("io error: "+e.getClass().getName()+": "+e.getMessage());
				}catch(Exception ex){
					System.out.println("exception in main thread: "+ex.getClass()+": "+ex.getMessage());
				}finally{
					System.out.print(">> ");
				}
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

	/**
	 * Reads one line of input from the console, providing the opportunity for others
	 * to get decisions or data from the user.
	 * 
	 * @throws IOException only is the read from console fails.
	 * */
	public String getInput() throws IOException {
		System.out.print(">> ");
		return consoleIn.readLine();
	}
	
	/**
	 * Reads one line of input from the console prompting the given message, providing the opportunity for others
	 * to get decisions or data from the user.
	 * 
	 * @param message explicit declaration of the kind of input we want.
	 * @throws IOException only is the read from console fails.
	 * */
	public String getInput(String message) throws IOException {
		System.out.print(">> "+message+" ");
		return consoleIn.readLine();
	}
	
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
		 +"  Cast-trap-road\t\t   9\n"
		 +"  Cast-magic\t\t\t   10\n"
		 +"  Troop-damages-mountain\t   11\n"
		 +"  terminate skeleton\t\t  exit\n";
	}
}
