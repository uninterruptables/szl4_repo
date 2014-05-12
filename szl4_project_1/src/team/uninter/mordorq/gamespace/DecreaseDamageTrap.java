package team.uninter.mordorq.gamespace;

import java.awt.Image;
import java.io.File;
import java.util.HashMap;

import team.uninter.mordorq.gamespace.Casted.ImageColor;
import team.uninter.mordorq.utils.GameConstants;

public class DecreaseDamageTrap extends Trap{
	
	//Class use to create a trap, that decreases the enemy troops damage, by applying a
	//WeakenStatus statusmodifier
	
	static {
		avalImages = new HashMap<ImageColor, Image>();
		Casted.tryLoad(avalImages, ImageColor.RED, new File("resources/images/weak_trap_grid_16_red.png"));
		Casted.tryLoad(avalImages, ImageColor.NORMAL, new File("resources/images/weak_trap_grid_16p.png"));
	}
	
	public DecreaseDamageTrap() {
		super();
//		System.out.println("DecreaseDamageTrap() called");
//		WeakenStatus statMod = new WeakenStatus(GameConstants.DECREASE_DAMAGE_TRAP_WEAKEN_AMOUNT, GameConstants.WEAKEN_STATUS_DURATION);
		WeakenStatus statMod = new WeakenStatus();
		addEffect(statMod);
//		System.out.println("DecreaseDamageTrap() returned");
	}
	public DecreaseDamageTrap(int x, int y) {
		super(x, y);
//		System.out.println("DecreaseDamageTrap(Int, Int) called");
//		WeakenStatus statMod = new WeakenStatus(GameConstants.DECREASE_DAMAGE_TRAP_WEAKEN_AMOUNT, GameConstants.WEAKEN_STATUS_DURATION);
		WeakenStatus statMod = new WeakenStatus();
		addEffect(statMod);
//		System.out.println("DecreaseDamageTrap(Int, Int) returned");
	}
}
