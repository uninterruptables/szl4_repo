package team.uninter.mordorq.utils;

public class StringResources {
	
	public static String BASIC_TOWER_INFO = "Cost: "+GameConstants.BASIC_TOWER_COST+" \nRange: "+GameConstants.BASIC_TOWER_RADIUS+"\nRate of fire: "+Math.floor(((double)GameConstants.FPS/(double)GameConstants.BASIC_TOWER_MAXCOOLDOWN) * 100) / 100+"/sec\nDamage: \n   -Dwarf: "+GameConstants.BASIC_MISSILE_DWARF_DAMAGE+"\n   -Elf: "+GameConstants.BASIC_MISSILE_ELF_DAMAGE+"\n   -Hobbit: "+GameConstants.BASIC_MISSILE_HOBBIT_DAMAGE+"\n   -Human: "+GameConstants.BASIC_MISSILE_HUMAN_DAMAGE+""; 
	public static String FAST_TOWER_INFO = "Cost: "+GameConstants.FAST_TOWER_COST+" \nRange: "+GameConstants.FAST_TOWER_RADIUS+"\nRate of fire: "+Math.floor(((double)GameConstants.FPS/(double)GameConstants.FAST_TOWER_MAXCOOLDOWN) * 100) / 100+"/sec\nDamage: \n   -Dwarf: "+GameConstants.FAST_MISSILE_DWARF_DAMAGE+"\n   -Elf: "+GameConstants.FAST_MISSILE_ELF_DAMAGE+"\n   -Hobbit: "+GameConstants.FAST_MISSILE_HOBBIT_DAMAGE+"\n   -Human: "+GameConstants.FAST_MISSILE_HUMAN_DAMAGE+"";
	public static String GREAT_TOWER_INFO = "Cost: "+GameConstants.GREAT_TOWER_COST+" \nRange: "+GameConstants.GREAT_TOWER_RADIUS+"\nRate of fire: "+Math.floor(((double)GameConstants.FPS/(double)GameConstants.GREAT_TOWER_MAXCOOLDOWN) * 100) / 100+"/sec\nDamage: \n   -Dwarf: "+GameConstants.GREAT_MISSILE_DWARF_DAMAGE+"\n   -Elf: "+GameConstants.GREAT_MISSILE_ELF_DAMAGE+"\n   -Hobbit: "+GameConstants.GREAT_MISSILE_HOBBIT_DAMAGE+"\n   -Human: "+GameConstants.GREAT_MISSILE_HUMAN_DAMAGE+""; 
	public static String LONG_RANGE_INFO = "Cost: "+GameConstants.LONG_DISTANCE_TOWER_COST+" \nRange: "+GameConstants.LONG_DISTANCE_TOWER_RADIUS+"\nRate of fire: "+Math.floor(((double)GameConstants.FPS/(double)GameConstants.LONG_DISTANCE_TOWER_MAXCOOLDOWN) * 100) / 100+"/sec\nDamage: \n   -Dwarf: "+GameConstants.LONG_DISTANCE_MISSILE_DWARF_DAMAGE+"\n   -Elf: "+GameConstants.LONG_DISTANCE_MISSILE_ELF_DAMAGE+"\n   -Hobbit: "+GameConstants.LONG_DISTANCE_MISSILE_HOBBIT_DAMAGE+"\n   -Human: "+GameConstants.LONG_DISTANCE_MISSILE_HUMAN_DAMAGE+"";
	
	public static String WEAKENING_TRAP_INFO = "Cost: "+GameConstants.DECREASE_DAMAGE_TRAP_COST+" \nDamage decrease: "+GameConstants.DECREASE_DAMAGE_TRAP_WEAKEN_AMOUNT; 
	public static String SLOWER_TRAP_INFO = "Cost: "+GameConstants.SLOWER_TRAP__COST+" \nSpeed reduce: "+Math.floor(((double)GameConstants.SLOWER_TRAP_SLOW_AMOUNT/(double)GameConstants.FPS) * 100) / 100+"/sec"; 
	public static String POISONOUS_TRAP_INFO = "Cost: "+GameConstants.POISONOUS_TRAP_COST+" \nPoison damage: "+GameConstants.POISONOUS_TRAP_POISON_AMOUNT; 
	
	public static String BARRICADE_INFO = "Cost: "+GameConstants.BARRICADE_COST+" \nHealth: "+GameConstants.BARRICADE_HEALTH; 
	
	public static String PLUS_DAMAGE_TOWER_RUNE_INFO = "Increase tower's damage \nCost: "+GameConstants.PLUS_DAMAGE_TOWER_RUNE_COST+"\n+Damage: "+GameConstants.PLUS_DAMAGE_TOWER_RUNE_DAMAGE_AMOUNT; 
	public static String PLUS_RANGE_TOWER_RUNE_INFO = "Increase tower's range \nCost: "+GameConstants.PLUS_RANGE_TOWER_RUNE_COST+"\n+Range: "+GameConstants.PLUS_RANGE_TOWER_RUNE_RANGE_AMOUNT; 
	public static String PLUS_SPEED_TOWER_RUNE_INFO = "Increase tower rate of fire \nCost: "+GameConstants.PLUS_SPEED_TOWER_RUNE_COST+"\n+Rate of fire: "+Math.floor(((double)GameConstants.PLUS_SPEED_TOWER_RUNE_SPEED_AMOUNT/(double)GameConstants.FPS) * 100) / 100+"/sec"; 
	public static String PLUS_ELF_DAMAGE_TOWER_RUNE_INFO = "Increase tower's elf damage \nCost: "+GameConstants.PLUS_ELF_DAMAGE_TOWER_RUNE_COST+"\n+Elf damage: "+GameConstants.PLUS_ELF_DAMAGE_TOWER_RUNE_DAMAGE_AMOUNT; 
	public static String PLUS_DWARF_DAMAGE_TOWER_RUNE_INFO = "Increase tower's dwarf damage \nCost: "+GameConstants.PLUS_DWARF_DAMAGE_TOWER_RUNE_COST+"\n+Dwarf damage: "+GameConstants.PLUS_DWARF_DAMAGE_TOWER_RUNE_DAMAGE_AMOUNT; 
	public static String PLUS_HOBBIT_DAMAGE_TOWER_RUNE_INFO = "Increase tower's hobbit damage \nCost: "+GameConstants.PLUS_HOBBIT_DAMAGE_TOWER_RUNE_COST+"\n+Hobbit damage: "+GameConstants.PLUS_HOBBIT_DAMAGE_TOWER_RUNE_DAMAGE_AMOUNT; 
	
	public static String PLUS_SLOWER_TRAP_RUNE_INFO = "Increase trap's speed reduce \nCost: "+GameConstants.SLOWER_TRAP_RUNE_COST+"\n+Speed reduce: "+Math.floor(((double)GameConstants.SLOWER_TRAP_RUNE_SLOW_AMOUNT/(double)GameConstants.FPS) * 100) / 100+"/sec"; 
	public static String PLUS_WEAKENING_TRAP_RUNE_INFO = "Increase trap's damage decrease \nCost: "+GameConstants.WEAKEN_TRAP_RUNE_COST+"\n+Damae decrease: "+GameConstants.WEAKEN_TRAP_RUNE_WEAKEN_AMOUNT; 
	public static String PLUS_POISONOUS_TRAP_RUNE_INFO = "Increase trap's poison damage \nCost: "+GameConstants.POISONOUS_TRAP_RUNE_COST+"\n+Poison damage: "+GameConstants.POISONOUS_TRAP_RUNE_POISON_AMOUNT; 
	
	public static String NAZGUL_MAGIC_INFO = "Cost: "+GameConstants.NAZGUL_MAGIC_COST+"\nFreeze every enemy for "+Math.floor((double)GameConstants.NAZGUL_MAGIC_FREEZE_DURATION/(double)GameConstants.FPS)+" sec";
	public static String ICE_WIND_MAGIC_INFO = "Cost: "+GameConstants.ICE_WIND_MAGIC_COST+"\nDo something for "+Math.floor((double)GameConstants.ICE_WIND_MAGIC_DURATION/(double)GameConstants.FPS)+" sec";
	public static String POISON_FOG_MAGIC_INFO = "Cost: "+GameConstants.POISON_FOG_MAGIC_COST+"\nPoison all enemies for "+Math.floor((double)GameConstants.POISON_FOG_MAGIC_DURATION/(double)GameConstants.FPS)+" sec";
}
