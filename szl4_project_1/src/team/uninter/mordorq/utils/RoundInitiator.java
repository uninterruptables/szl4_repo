/**
 * RoundInitiator.java 
 */
package team.uninter.mordorq.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import team.uninter.mordorq.gamespace.Aragorn;
import team.uninter.mordorq.gamespace.Controlable;
import team.uninter.mordorq.gamespace.Dwarf;
import team.uninter.mordorq.gamespace.Elf;
import team.uninter.mordorq.gamespace.EnemyTroop;
import team.uninter.mordorq.gamespace.Gimli;
import team.uninter.mordorq.gamespace.Hobbit;
import team.uninter.mordorq.gamespace.Human;
import team.uninter.mordorq.gamespace.Legolas;
import team.uninter.mordorq.gamespace.Neighbour;
import team.uninter.mordorq.gamespace.RoadGrid;
import team.uninter.mordorq.gamespace.Scene;

/**
 * It is responsible for the creation/instantiation of each enemy in a given
 * round. Each round is described in an xml file from which the
 * <code>RoundInitiator</code> works and constructs the horde of enemies.
 * 
 * @author Imre Szekeres
 * @version "%I%, %G%"
 * @see Scene
 * @see EnemyTroop
 * @see Controlable
 * @see org.xml.sax
 */
@SuppressWarnings("rawtypes")
public class RoundInitiator {

	// private static final Logger logger =
	// Logger.getLogger(RoundInitiator.class);
	private static String filePath = "resources/descriptors/rounds.xml";

	/**
	 * Sets the file path from which ot parses the xml file.
	 * 
	 * @param filePath
	 *            describing the file.
	 * */
	public static void setFilePath(String filePath) {
		RoundInitiator.filePath = filePath;
	}

	/**
	 * Initiates the given round by providing the horde of enemies.
	 * 
	 * @param round
	 *            indicating for which number of round the enemies must be
	 *            constructed.
	 * @return a collection of enemies ready to swarm the game space.
	 * */
	public static List<Controlable> initRoundFor(Scene scene, int round) {
		List<Controlable> enemies = new ArrayList<Controlable>();
		XMLReader reader = null;
		try {
			reader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
			reader.setContentHandler(new RoundHandler(enemies, round));
			reader.parse(filePath);

			List<Controlable> temp = new ArrayList<Controlable>(enemies);

			new Thread(new PlaceWorker(temp, (RoadGrid) scene.getGrids().get(0))).start();

		} catch (SAXException e) {
			System.out.println("sax error: " + e.getMessage());
		} catch (ParserConfigurationException ex) {
			System.out.println("parses error: " + ex.getMessage());
		} catch (IOException exc) {
			System.out.println("io error: " + exc.getMessage());
		}
		return enemies;
	}

	private static class PlaceWorker implements Runnable {

		private static final long WORKER_TIMEOUT = 2000;

		private List<? extends Controlable> enemySource;
		private RoadGrid root;
		private long timeout;

		PlaceWorker(List<? extends Controlable> enemySource, RoadGrid root) {
			this.enemySource = enemySource;
			this.timeout = WORKER_TIMEOUT;
			this.root = root;
		}

		@Override
		public void run() {
			try {
				while (!enemySource.isEmpty()) {
					placeFrom(enemySource, root);
					Thread.sleep(this.timeout);
				}
			} catch (InterruptedException e) {
			}
		}

		/**
		 * Places all the elements from a list to a chain of grids recursively.
		 * 
		 * @param enemies
		 *            from to place the elements
		 * @param grid
		 *            from to which to place the elements onto
		 * */
		private static void placeFrom(List<? extends Controlable> enemies, RoadGrid grid) {
			if (enemies.isEmpty() || grid == null)
				return;
			if (grid.getVulnerable() == null) {
				EnemyTroop enemy = (EnemyTroop) enemies.remove(0);
				grid.setVulnerable(enemy);
			}
			placeFrom(enemies, (RoadGrid) grid.get(Neighbour.SOUTH));
		}
	}

	/**
	 * Helper module for the SAX parser's <code>XMLReader</code> to parse and
	 * construct the enemy horde.
	 * */
	private static class RoundHandler extends DefaultHandler {

		private List<Controlable> enemies;
		private String activeName;
		private boolean inRound;
		private int roundNumber;

		/**
		 * Public constructor for initiating the parsing.
		 * 
		 * @param enemies
		 *            the initial list we want to fill with enemies
		 * @param roundNumber
		 *            indicating in which round we are
		 * */
		public RoundHandler(List<Controlable> enemies, int roundNumber) {
			this.enemies = enemies;
			inRound = false;
			this.roundNumber = roundNumber;
		}

		/**
		 * Extends the <code>DefaultHandler</code> mechanism by instantiating
		 * those enemies we found indication in the xml file.
		 * 
		 * @param buffer
		 *            a character sequence
		 * @param offset
		 * @param length
		 * */
		@Override
		public void characters(char[] buffer, int offset, int length) {
			if (activeName != null) {
				if (activeName.equals("legolas"))
					enemies.add(Legolas.getInstance());
				else if (activeName.equals("aragorn"))
					enemies.add(Aragorn.getInstance());
				else if (activeName.equals("gimli"))
					enemies.add(Gimli.getInstance());
				else {
					Class activeClass = activeName.equals("human") ? Human.class :
							activeName.equals("hobbit") ? Hobbit.class :
									activeName.equals("elf") ? Elf.class : Dwarf.class;
					try {
						for (int i = 0, n = Integer.parseInt(new String(buffer, offset, length)); i < n; i++)
							enemies.add((EnemyTroop) activeClass.newInstance());

						activeName = null;
					} catch (NumberFormatException ex) {
					} catch (InstantiationException e) {
					} catch (IllegalAccessException e) {
					}
				}
			}
		}

		/**
		 * Extends the <code>DefaultHandler</code> mechanism by identifying
		 * which round we are interested in, or what enemies we should
		 * instantiate.
		 * 
		 * @param namespaceUri
		 * @param localName
		 * @param qName
		 * @param attrs
		 * */
		@Override
		public void startElement(String namespaceUri, String localName, String qName, Attributes attrs)
				throws SAXException {
			if (qName.equals("round")) {
				int index = -1;
				if ((index = attrs.getIndex("id")) >= 0 &&
						(Integer.parseInt(attrs.getValue(index)) == roundNumber))
					inRound = true;
			}
			else if (inRound) {
				activeName = qName;
			}
		}

		/**
		 * Extends the <code>DefaultHandler</code> mechanism by identifying
		 * which tag we left.
		 * 
		 * @param namespaceUri
		 * @param localName
		 * @param qName
		 * */
		@Override
		public void endElement(String namespaceUri, String localName, String qName) throws SAXException {
			if (inRound && qName.equals(activeName))
				activeName = null;
			if (inRound && qName.equals("round")) {
				inRound = false;
				activeName = null;
			}
		}
	}
}
