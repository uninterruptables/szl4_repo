package team.uninter.mordorq.gamespace;

import java.awt.Image;
import java.io.File;
import java.util.HashMap;

import team.uninter.mordorq.gamespace.Casted.ImageColor;
import team.uninter.mordorq.utils.GameConstants;

public class SlowDownTrap extends Trap {
	
	//Class use to create a trap, that decreases the enemy troops speed, by applying a
	//SlowStatus statusmodifier
	
//	static {
//		avalImages = new HashMap<ImageColor, Image>();
//		Casted.tryLoad(avalImages, ImageColor.RED, new File("resources/images/slow_trap_grid_16_red.png"));
//		Casted.tryLoad(avalImages, ImageColor.NORMAL, new File("resources/images/slow_trap_grid_16p.png"));
//	}
	
	public SlowDownTrap() {
		super();
		avalImages = new HashMap<ImageColor, Image>();
		tryLoad(avalImages, ImageColor.RED, new File("resources/images/slow_trap_grid_16_red.png"));
		tryLoad(avalImages, ImageColor.NORMAL, new File("resources/images/slow_trap_grid_16p.png"));
		this.manaCost = GameConstants.SLOWER_TRAP__COST;
//		System.out.println("SlowDownTrap() called");
		SlowStatus statMod = new SlowStatus();
		addEffect(statMod);
//		System.out.println("SlowDownTrap() returned");
	}
	public SlowDownTrap(int x, int y) {
		super(x, y);
		avalImages = new HashMap<ImageColor, Image>();
		tryLoad(avalImages, ImageColor.RED, new File("resources/images/slow_trap_grid_16_red.png"));
		tryLoad(avalImages, ImageColor.NORMAL, new File("resources/images/slow_trap_grid_16p.png"));
		this.manaCost = GameConstants.SLOWER_TRAP__COST;
//		System.out.println("SlowDownTrap(Int, Int) called");
		SlowStatus statMod = new SlowStatus();
		addEffect(statMod);
//		System.out.println("SlowDownTrap(Int, Int) returned");
	}
}
