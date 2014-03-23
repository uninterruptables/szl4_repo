package team.uninter.mordorq.gamespace;

public class FreezeTrapRune extends TrapRune{
	public FreezeTrapRune(int manaCost) {
		super(manaCost);
		// TODO Auto-generated constructor stub
	}

	float slowAmount;
	
	public boolean canInjectOn(Trap trap){
		System.out.println("DamageBoostDwarvenTowerRune.canInjectOn(Trap) : boolean called");
		System.out.println("DamageBoostDwarvenTowerRune.canInjectOn(Trap) : boolean returned");
		if(trap.getRunesRemained()>0)
		{
			SlowStatus slowStatus=new SlowStatus(slowAmount);
			trap.addEffect(slowStatus);
			return true;
		}
		return false;
		
	}

	@Override
	public void castOn(GameObject object) {
		// TODO Auto-generated method stub
		
	}
}
