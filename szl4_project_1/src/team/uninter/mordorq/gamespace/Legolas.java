package team.uninter.mordorq.gamespace;

@SuppressWarnings("serial")
public class Legolas extends Elf{

	   private static Legolas instance = null;
	   protected Legolas() {}
	   final public int getReward(){
		int x=100;
		return x;}
	   public static Legolas getInstance()
	   {
	      if(instance == null) {
	         instance = new Legolas();
	      }
	      return instance;
	   }
	}