package team.uninter.mordorq.gamespace;

public class WeakenTrapRune extends TrapRune{
	public WeakenTrapRune(int manaCost) {
		super(manaCost);
		// TODO Auto-generated constructor stub
	}

	float damagePerTick;
	
	public boolean canInjectOn(Trap trap){
		System.out.println("DOTTrapRune.canInjectOn(Trap) : boolean called");
		trap.getRunesRemained();
		if(trap.getRunesRemained()>0)
		{
			PoisonStatus poisonStatus=new PoisonStatus(damagePerTick);
			trap.addEffect(poisonStatus);
			System.out.println("DOTTrapRune.canInjectOn(Trap) : boolean returned");
			return true;
		}
		else
		{
			System.out.println("DOTTrapRune.canInjectOn(Trap) : boolean returned");
			return false;
		}
	}

	@Override
	public void castOn(GameObject object) {
		// TODO Auto-generated method stub
		
	}
}
