package team.uninter.mordorq.gamespace;

import java.awt.Image;
import java.io.File;
import java.util.HashMap;

import team.uninter.mordorq.gamespace.Casted.ImageColor;
import team.uninter.mordorq.utils.GameConstants;

public class DamageBoostElvenTowerRune extends TowerRune{
	
	//Class used to increase damage versus elves. On inject on, it calls the tower-s
	//setSpecies function, to increase it's damage
//	float extraDamage;
	
//	static {
//		avalImages = new HashMap<ImageColor, Image>();
//		Casted.tryLoad(avalImages, ImageColor.RED, new File("resources/images/elf_tower_rune_16p_red.png"));
//		Casted.tryLoad(avalImages, ImageColor.NORMAL, new File("resources/images/elf_tower_rune_16p.png"));
//	}
	
	public DamageBoostElvenTowerRune() {
		super();
		avalImages = new HashMap<ImageColor, Image>();
		tryLoad(avalImages, ImageColor.RED, new File("resources/images/elf_tower_rune_16p_red.png"));
		tryLoad(avalImages, ImageColor.NORMAL, new File("resources/images/elf_tower_rune_16p.png"));
//		System.out.println("DamageBoostElvenTowerRune() called");
//		System.out.println("DamageBoostElvenTowerRune() returned");
	}

	public DamageBoostElvenTowerRune(int x, int y) {
		super(x, y);
		avalImages = new HashMap<ImageColor, Image>();
		tryLoad(avalImages, ImageColor.RED, new File("resources/images/elf_tower_rune_16p_red.png"));
		tryLoad(avalImages, ImageColor.NORMAL, new File("resources/images/elf_tower_rune_16p.png"));
//		System.out.println("DamageBoostElvenTowerRune(Int, Int) called");
//		System.out.println("DamageBoostElvenTowerRune(Int, Int) returned");
	}
	
	public void injectOn(Tower tower)
	{
//		System.out.println("DamageBoostElvenTowerRune.injectOn(Tower) called");
		tower.setSpeciesDamage("elf", tower.getSpeciesDamage("elf") + GameConstants.PLUS_ELF_DAMAGE_TOWER_RUNE_DAMAGE_AMOUNT);
//		System.out.println("DamageBoostElvenTowerRune.injectOn(Tower) returned");
	}
	
}
