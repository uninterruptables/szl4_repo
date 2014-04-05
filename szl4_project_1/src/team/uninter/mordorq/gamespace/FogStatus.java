/**
 * FogStatusModifier.java
 */
package team.uninter.mordorq.gamespace;

/**
 * 
 * @author Imre Szekeres
 * @version "%I%, %G%"
 */
@SuppressWarnings("all")
public class FogStatus extends StatusModifier{

	private int radiusDecrement;
	
	public FogStatus(){
		super();
		radiusDecrement = 10;
		super.duration = 21;
	}
	
	/** 
	 * Decreases the radius of the target tower.
	 * 
	 * @param tower that is about to have the effects on of this <code>StatusModifier</code>
	 * @see team.uninter.mordorq.gamespace.StatusModifier#affect(team.uninter.mordorq.gamespace.EnemyTroop)
	 */
	public void affect(Tower tower) {
		tower.setRadius(tower.getRadius() - radiusDecrement);
	}

	/** 
	 * Resets the changes to the goven tower caused by this modifier.
	 *
	 * @param tower that had the effects on of this <code>StatusModifier</code>
	 * @see team.uninter.mordorq.gamespace.StatusModifier#reverseAffect(team.uninter.mordorq.gamespace.EnemyTroop)
	 */
	public void reverseAffect(Tower tower) {
		tower.setRadius(tower.getRadius() + radiusDecrement);
	}

	/**
	 * Sets the given <code>Tower</code> under its effects.
	 * 
	 * @param tower that is about to have the effects on of this <code>StatusModifier</code>
	 * @see team.uninter.mordorq.gamespace.StatusModifier#apply(team.uninter.mordorq.gamespace.EnemyTroop)
	 */
	public void apply(Tower tower) {
		tower.setFogStatus(this);		
	}
	
	/** 
	 * Instantly returns.
	 * 
	 * @param enemy which is not gonna be affected at all
	 * @see team.uninter.mordorq.gamespace.StatusModifier#affect(team.uninter.mordorq.gamespace.EnemyTroop)
	 */
	@Override
	public void affect(EnemyTroop enemy) {	}

	/** 
	 * Instantly returns.
	 *
	 * @param enemy which is not gonna be affected at all
	 * @see team.uninter.mordorq.gamespace.StatusModifier#reverseAffect(team.uninter.mordorq.gamespace.EnemyTroop)
	 */
	@Override
	public void reverseAffect(EnemyTroop enemy) {}

	/**
	 * Instantly returns.
	 * 
	 * @param enemy which is not gonna be affected at all 
	 * @see team.uninter.mordorq.gamespace.StatusModifier#apply(team.uninter.mordorq.gamespace.EnemyTroop)
	 */
	@Override
	public void apply(EnemyTroop enemy) {	}
}
