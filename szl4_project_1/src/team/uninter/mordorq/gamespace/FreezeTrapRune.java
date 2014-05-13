package team.uninter.mordorq.gamespace;

import java.awt.Image;
import java.io.File;
import java.util.HashMap;

import team.uninter.mordorq.gamespace.Casted.ImageColor;
import team.uninter.mordorq.utils.GameConstants;

public class FreezeTrapRune extends TrapRune{
	//Class used to add an extra slowdown status modifier in the traps
	//effect list. On inject on, it calls the trap's
	//addEffect function, to add the extra effect
	
//	static {
//		avalImages = new HashMap<ImageColor, Image>();
//		Casted.tryLoad(avalImages, ImageColor.RED, new File("resources/images/slowtraprune_16p_red.png"));
//		Casted.tryLoad(avalImages, ImageColor.NORMAL, new File("resources/images/slowtraprune_16p.png"));
//	}
	
	public FreezeTrapRune() {
		super();
		avalImages = new HashMap<ImageColor, Image>();
		Casted.tryLoad(avalImages, ImageColor.RED, new File("resources/images/slowtraprune_16p_red.png"));
		Casted.tryLoad(avalImages, ImageColor.NORMAL, new File("resources/images/slowtraprune_16p.png"));
	}
	
	public FreezeTrapRune(int x, int y) {
		super(x, y);
		avalImages = new HashMap<ImageColor, Image>();
		Casted.tryLoad(avalImages, ImageColor.RED, new File("resources/images/slowtraprune_16p_red.png"));
		Casted.tryLoad(avalImages, ImageColor.NORMAL, new File("resources/images/slowtraprune_16p.png"));
	}
	
	public void injectOn(Trap trap){
//		trap.addEffect(new SlowStatus());
		int currentId = trap.getEffect().getId();
		trap.addEffect(new SlowStatus(GameConstants.SLOWER_TRAP_SLOW_AMOUNT + GameConstants.SLOWER_TRAP_RUNE_SLOW_AMOUNT, GameConstants.SLOWER_STATUS_DURATION, currentId));
	}
}
