package team.uninter.mordorq.gamespace;

import java.awt.Image;
import java.io.File;
import java.util.HashMap;

import team.uninter.mordorq.gamespace.Casted.ImageColor;
import team.uninter.mordorq.utils.GameConstants;

public class DamageBoostDwarvenTowerRune extends TowerRune{
	
	//Class used to increase damage versus dwarves. On inject on, it calls the tower-s
	//setSpecies function, to increase it's damage
//	int extraDamage;
	
//	static {
//		avalImages = new HashMap<ImageColor, Image>();
//		Casted.tryLoad(avalImages, ImageColor.RED, new File("resources/images/dwarf_tower_rune_16p_red.png"));
//		Casted.tryLoad(avalImages, ImageColor.NORMAL, new File("resources/images/dwarf_tower_rune_16p.png"));
//	}
	
	public DamageBoostDwarvenTowerRune() {
		super();
		avalImages = new HashMap<ImageColor, Image>();
		Casted.tryLoad(avalImages, ImageColor.RED, new File("resources/images/dwarf_tower_rune_16p_red.png"));
		Casted.tryLoad(avalImages, ImageColor.NORMAL, new File("resources/images/dwarf_tower_rune_16p.png"));
	}
	
	public DamageBoostDwarvenTowerRune(int x, int y) {
		super(x, y);
		avalImages = new HashMap<ImageColor, Image>();
		Casted.tryLoad(avalImages, ImageColor.RED, new File("resources/images/dwarf_tower_rune_16p_red.png"));
		Casted.tryLoad(avalImages, ImageColor.NORMAL, new File("resources/images/dwarf_tower_rune_16p.png"));
	}
	
	public void injectOn(Tower tower)	{
		tower.setSpeciesDamage("dwarf", tower.getSpeciesDamage("dwarf") + GameConstants.PLUS_DWARF_DAMAGE_TOWER_RUNE_DAMAGE_AMOUNT);
	}	
}
