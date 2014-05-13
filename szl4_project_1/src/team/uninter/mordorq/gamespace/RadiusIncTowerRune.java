package team.uninter.mordorq.gamespace;

import java.awt.Image;
import java.io.File;
import java.util.HashMap;

import team.uninter.mordorq.gamespace.Casted.ImageColor;
import team.uninter.mordorq.utils.GameConstants;

public class RadiusIncTowerRune extends TowerRune{
	
//	static {
//		avalImages = new HashMap<ImageColor, Image>();
//		Casted.tryLoad(avalImages, ImageColor.RED, new File("resources/images/RangeTowerRune_16p_red.png"));
//		Casted.tryLoad(avalImages, ImageColor.NORMAL, new File("resources/images/RangeTowerRune_16p.png"));
//	}
	
	//a class used to create runes that can increase a tower's radius.
//	int extraRadius;
	public RadiusIncTowerRune() {
		super();
		avalImages = new HashMap<ImageColor, Image>();
		Casted.tryLoad(avalImages, ImageColor.RED, new File("resources/images/RangeTowerRune_16p_red.png"));
		Casted.tryLoad(avalImages, ImageColor.NORMAL, new File("resources/images/RangeTowerRune_16p.png"));
//		System.out.println("RadiusIncRune() called");
//		System.out.println("RadiusIncRune() returned");
	}
	
	public RadiusIncTowerRune(int x, int y) {
		super(x, y);
		avalImages = new HashMap<ImageColor, Image>();
		Casted.tryLoad(avalImages, ImageColor.RED, new File("resources/images/RangeTowerRune_16p_red.png"));
		Casted.tryLoad(avalImages, ImageColor.NORMAL, new File("resources/images/RangeTowerRune_16p.png"));
//		System.out.println("RadiusIncRune(Int, Int) called");
//		System.out.println("RadiusIncRune(Int, Int) returned");
	}

	public void injectOn(Tower tower)
	{
//		System.out.println("RadiusIncRune.injectOn(Tower) called");
		tower.setRadius(tower.getRadius() + GameConstants.PLUS_RANGE_TOWER_RUNE_RANGE_AMOUNT);
//		System.out.println("RadiusIncRune.injectOn(Tower) returned");
	}
	
}
