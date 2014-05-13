package team.uninter.mordorq.gamespace;

import java.awt.Image;
import java.io.File;
import java.util.HashMap;

import team.uninter.mordorq.gamespace.Casted.ImageColor;
import team.uninter.mordorq.utils.GameConstants;

public class WeakenTrapRune extends TrapRune{
	//Class used to add an extra weaken status modifier in the traps
	//effect list. On inject on, it calls the trap's
	//addEffect function, to add the extra effect
//	int weakenAmount;
	
//	static {
//		avalImages = new HashMap<ImageColor, Image>();
//		Casted.tryLoad(avalImages, ImageColor.RED, new File("resources/images/weaktraprune_16p_red.png"));
//		Casted.tryLoad(avalImages, ImageColor.NORMAL, new File("resources/images/weaktraprune_16p.png"));
//	}
	
	public WeakenTrapRune() {
		super();
		avalImages = new HashMap<ImageColor, Image>();
		Casted.tryLoad(avalImages, ImageColor.RED, new File("resources/images/weaktraprune_16p_red.png"));
		Casted.tryLoad(avalImages, ImageColor.NORMAL, new File("resources/images/weaktraprune_16p.png"));
//		System.out.println("WeakenTrapRune() called");
//		weakenAmount = GameConstants.WEAKEN_TRAP_RUNE_WEAKEN_AMOUNT;
//		System.out.println("WeakenTrapRune() returned");
	}
	
	public WeakenTrapRune(int x, int y) {
		super(x, y);
		avalImages = new HashMap<ImageColor, Image>();
		Casted.tryLoad(avalImages, ImageColor.RED, new File("resources/images/weaktraprune_16p_red.png"));
		Casted.tryLoad(avalImages, ImageColor.NORMAL, new File("resources/images/weaktraprune_16p.png"));
//		System.out.println("WeakenTrapRune(Int, Int) called");
//		weakenAmount = GameConstants.WEAKEN_TRAP_RUNE_WEAKEN_AMOUNT;
//		System.out.println("WeakenTrapRune(Int, Int) returned");
	}
	
	public void injectOn(Trap trap){
//		System.out.println("WeakenTrapRune.injectOn(Trap) called");
//		WeakenStatus weakenStatus = new WeakenStatus(weakenAmount);
//		trap.addEffect(weakenStatus);
		int currentId = trap.getEffect().getId();
		trap.addEffect(new WeakenStatus(GameConstants.DECREASE_DAMAGE_TRAP_WEAKEN_AMOUNT + GameConstants.WEAKEN_TRAP_RUNE_WEAKEN_AMOUNT, GameConstants.WEAKEN_STATUS_DURATION, currentId));
//		System.out.println("WeakenTrapRune.injectOn(Trap) returned");
	}
}
