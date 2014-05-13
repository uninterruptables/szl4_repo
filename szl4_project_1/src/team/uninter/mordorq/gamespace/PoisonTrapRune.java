package team.uninter.mordorq.gamespace;

import java.awt.Image;
import java.io.File;
import java.util.HashMap;

import team.uninter.mordorq.gamespace.Casted.ImageColor;
import team.uninter.mordorq.utils.GameConstants;

public class PoisonTrapRune extends TrapRune{
	
	//Class used to add an extra poisonus status modifier in the traps
	//effect list. On inject on, it calls the trap's
	//addEffect function, to add the extra effect
		
//	static {
//		avalImages = new HashMap<ImageColor, Image>();
//		Casted.tryLoad(avalImages, ImageColor.RED, new File("resources/images/poisontraprune_16p_red.png"));
//		Casted.tryLoad(avalImages, ImageColor.NORMAL, new File("resources/images/poisontraprune_16p.png"));
//	}
	
	public PoisonTrapRune() {
		super();
		avalImages = new HashMap<ImageColor, Image>();
		tryLoad(avalImages, ImageColor.RED, new File("resources/images/poisontraprune_16p_red.png"));
		tryLoad(avalImages, ImageColor.NORMAL, new File("resources/images/poisontraprune_16p.png"));
	}
	
	public PoisonTrapRune(int x, int y) {
		super(x, y);
	}
	
	public void injectOn(Trap trap){
//		PoisonStatus poisonStatus = new PoisonStatus();
//		trap.addEffect(poisonStatus);
		int currentId = trap.getEffect().getId();
		trap.addEffect(new PoisonStatus(GameConstants.POISONOUS_TRAP_POISON_AMOUNT + GameConstants.POISONOUS_TRAP_RUNE_POISON_AMOUNT, GameConstants.POISONOUS_STATUS_DURATION, currentId));
	}

}
