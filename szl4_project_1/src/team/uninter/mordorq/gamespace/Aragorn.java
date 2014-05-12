package team.uninter.mordorq.gamespace;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import team.uninter.mordorq.utils.GameConstants;

/**
 * @author Danyik D�vid Singleton class of the human race bosses, Aragorn. It
 *         have special health and damage value not like the extended class
 *         troops. There is only one of this troop.
 */
@SuppressWarnings("serial")
public class Aragorn extends Human {

	static {
		rewardMana = GameConstants.ARAGORN_REWARD;
	}

	private static Aragorn instance = null;

	private Aragorn(int health, int damage) {
		super();
		try {
			image = ImageIO.read(new File("/resources/images/aragorn_16p.jpg"));
		} catch (IOException e) {
		}
		this.health = health;
		this.damage = damage;
	}

	public static Aragorn getInstance() {
		if (instance == null) {
			instance = new Aragorn(GameConstants.ARAGORN_HEALTH, GameConstants.ARAGORN_DAMAGE);
		}
		return instance;
	}

}
