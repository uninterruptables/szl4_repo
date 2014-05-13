package team.uninter.mordorq.gamespace;

import java.awt.Image;
import java.io.File;
import java.util.HashMap;

import team.uninter.mordorq.gamespace.Casted.ImageColor;

public class PoisonTrap extends Trap {
	//Class use to create a trap, that decreases the enemy troops health, by applying a
	//PoisonStatus statusmodifier
	
//	static {
//		avalImages = new HashMap<ImageColor, Image>();
//		Casted.tryLoad(avalImages, ImageColor.RED, new File("resources/images/poison_trap_grid_2_16_red.png"));
//		Casted.tryLoad(avalImages, ImageColor.NORMAL, new File("resources/images/poison_trap_grid_2_16p.png"));
//	}
	
	public PoisonTrap() {
		super();
		avalImages = new HashMap<ImageColor, Image>();
		tryLoad(avalImages, ImageColor.RED, new File("resources/images/poison_trap_grid_2_16_red.png"));
		tryLoad(avalImages, ImageColor.NORMAL, new File("resources/images/poison_trap_grid_2_16p.png"));
//		System.out.println("PoisonTrap() called");
		PoisonStatus statMod = new PoisonStatus();
		addEffect(statMod);
		
//		System.out.println("PoisonTrap() returned");
	}
	public PoisonTrap(int x, int y) {
		super(x, y);
		avalImages = new HashMap<ImageColor, Image>();
		tryLoad(avalImages, ImageColor.RED, new File("resources/images/poison_trap_grid_2_16_red.png"));
		tryLoad(avalImages, ImageColor.NORMAL, new File("resources/images/poison_trap_grid_2_16p.png"));
//		System.out.println("PoisonTrap(Int, Int) called");
		PoisonStatus statMod = new PoisonStatus();
		addEffect(statMod);
//		System.out.println("PoisonTrap(Int, Int) returned");
	}
}
