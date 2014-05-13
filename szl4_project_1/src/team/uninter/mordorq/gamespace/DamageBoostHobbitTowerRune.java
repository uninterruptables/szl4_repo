package team.uninter.mordorq.gamespace;

import java.awt.Image;
import java.io.File;
import java.util.HashMap;

import team.uninter.mordorq.gamespace.Casted.ImageColor;
import team.uninter.mordorq.utils.GameConstants;

public class DamageBoostHobbitTowerRune extends TowerRune{
	
	
	//Class used to increase damage versus hobbits. On inject on, it calls the tower-s
	//setSpecies function, to increase it's damage
//	float extraDamage;
	
//	static {
//		avalImages = new HashMap<ImageColor, Image>();
//		Casted.tryLoad(avalImages, ImageColor.RED, new File("resources/images/hobbit_tower_rune_16p_red.png"));
//		Casted.tryLoad(avalImages, ImageColor.NORMAL, new File("resources/images/hobbit_tower_rune_16p.png"));
//	}
	
	public DamageBoostHobbitTowerRune() {
		super();
		avalImages = new HashMap<ImageColor, Image>();
		tryLoad(avalImages, ImageColor.RED, new File("resources/images/hobbit_tower_rune_16p_red.png"));
		tryLoad(avalImages, ImageColor.NORMAL, new File("resources/images/hobbit_tower_rune_16p.png"));
//		System.out.println("DamageBoostHobbitTowerRune() called");
//		System.out.println("DamageBoostHobbitTowerRune() returned");
	}
	
	public DamageBoostHobbitTowerRune(int x, int y) {
		super(x, y);
		avalImages = new HashMap<ImageColor, Image>();
		tryLoad(avalImages, ImageColor.RED, new File("resources/images/hobbit_tower_rune_16p_red.png"));
		tryLoad(avalImages, ImageColor.NORMAL, new File("resources/images/hobbit_tower_rune_16p.png"));
//		System.out.println("DamageBoostHobbitTowerRune(Int, Int) called");
//		System.out.println("DamageBoostHobbitTowerRune(Int, Int) returned");
	}
	
	public void injectOn(Tower tower)
	{
//		System.out.println("DamageBoostHobbitTowerRune.injectOn(Tower) called");
		tower.setSpeciesDamage("hobbit", tower.getSpeciesDamage("hobbit") + GameConstants.PLUS_HOBBIT_DAMAGE_TOWER_RUNE_DAMAGE_AMOUNT);
//		System.out.println("DamageBoostHobbitTowerRune.injectOn(Tower) returned");
	}
}
