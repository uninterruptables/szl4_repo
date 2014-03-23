package team.uninter.mordorq.gamespace;

import team.uninter.mordorq.skeleton.TroopStepSimulator;

@SuppressWarnings("serial")
public class Gimli extends Dwarf{

	   private static Gimli instance = null;
	   private static Object syncObject = new Object();
	   protected Gimli() {}
	   final public int getReward(){
		int x=100;
		return x;}
	   EnemyTroop troop = new Dwarf(60, 50);
	   public static Gimli getInstance()
	   {
	      if(instance == null) {
	    	  synchronized(syncObject){
	         instance = new Gimli();
	      }
	      }
	      return instance;
	   }
		
	   
	public static Object getSyncObject() {
		return syncObject;
	}
	public static void setSyncObject(Object syncObject) {
		Gimli.syncObject = syncObject;
	}
	}