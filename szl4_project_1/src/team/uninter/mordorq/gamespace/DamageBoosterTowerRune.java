package team.uninter.mordorq.gamespace;

import java.awt.Image;
import java.io.File;
import java.util.HashMap;

import team.uninter.mordorq.gamespace.Casted.ImageColor;
import team.uninter.mordorq.utils.GameConstants;

public class DamageBoosterTowerRune extends TowerRune{
	
	//Class used to increase damage versus everything. On inject on, it calls the tower-s
	//setAllDamage function, to increase it's damage
//	float extraDamage;
	
//	static {
//		avalImages = new HashMap<ImageColor, Image>();
//		Casted.tryLoad(avalImages, ImageColor.RED, new File("resources/images/DamageTowerRune_16p_red.png"));
//		Casted.tryLoad(avalImages, ImageColor.NORMAL, new File("resources/images/DamageTowerRune_16p.png"));
//	}
	
	public DamageBoosterTowerRune() {
		super();
		avalImages = new HashMap<ImageColor, Image>();
		tryLoad(avalImages, ImageColor.RED, new File("resources/images/DamageTowerRune_16p_red.png"));
		tryLoad(avalImages, ImageColor.NORMAL, new File("resources/images/DamageTowerRune_16p.png"));
//		System.out.println("DamageBoosterTowerRune() called");
//		System.out.println("DamageBoosterTowerRune() returned");
	}
	
	public DamageBoosterTowerRune(int x, int y) {
		super(x, y);
		avalImages = new HashMap<ImageColor, Image>();
		tryLoad(avalImages, ImageColor.RED, new File("resources/images/DamageTowerRune_16p_red.png"));
		tryLoad(avalImages, ImageColor.NORMAL, new File("resources/images/DamageTowerRune_16p.png"));
//		System.out.println("DamageBoosterTowerRune(Int, Int) called");
//		System.out.println("DamageBoosterTowerRune(Int, Int) returned");
	}
	
	public void injectOn(Tower tower)
	{
//		System.out.println("DamageBoosterTowerRune.injectOn(Tower) called");
		tower.addAllDamage(GameConstants.PLUS_DAMAGE_TOWER_RUNE_DAMAGE_AMOUNT);
//		System.out.println("DamageBoosterTowerRune.injectOn(Tower) returned");
	}

	
}
