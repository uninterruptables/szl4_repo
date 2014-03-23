package team.uninter.mordorq.gamespace;

import team.uninter.mordorq.skeleton.TroopStepSimulator;

@SuppressWarnings("serial")
public class Aragorn extends Human{

	   private static Aragorn instance = null;
	   private static Object syncObject = new Object();
	   protected Aragorn() {}
	   final public int getReward(){
		int x=100;
		return x;}
	   EnemyTroop troop = new Human(30, 40);
	   public static Aragorn getInstance()
	   {
	      if(instance == null) {
	    	  synchronized(syncObject){
	         instance = new Aragorn();
	      }
	      }
	      return instance;
	   }
		
	   
	public static Object getSyncObject() {
		return syncObject;
	}
	public static void setSyncObject(Object syncObject) {
		Aragorn.syncObject = syncObject;
	}
	}