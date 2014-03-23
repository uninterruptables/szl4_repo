package team.uninter.mordorq.gamespace;

import team.uninter.mordorq.skeleton.TroopStepSimulator;
import java.util.*;
@SuppressWarnings("serial")
public class Legolas extends Elf{

	   private static Legolas instance = null;
	   private static Object syncObject = new Object();
	   protected Legolas() {}
	   final public int getReward(){
		int x=100;
		return x;}
	   EnemyTroop troop = new Elf(50, 50);
	   public static Legolas getInstance()
	   {
	      if(instance == null) {
	    	  synchronized(syncObject){
	         instance = new Legolas();
	      }
	      }
	      return instance;
	   }
		
	   
	public static Object getSyncObject() {
		return syncObject;
	}
	public static void setSyncObject(Object syncObject) {
		Legolas.syncObject = syncObject;
	}
	}