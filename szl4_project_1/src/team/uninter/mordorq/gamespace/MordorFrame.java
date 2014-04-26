/**
 * MordorFrame.java
 */
package team.uninter.mordorq.gamespace;

import javax.swing.event.*;

import java.awt.*;

import javax.swing.*;

import team.uninter.mordorq.utils.StringResources;

import java.awt.*;
import java.io.*;
/**
 * Represents the frame for the application, that contains and
 * manages the actual <code>Scene</code> for the game. Provides a GUI, handles and
 * dispatches events, registers user data, provides an interface
 * for the user to choose from actions, for that displays several
 * widgets.
 * <p>
 * Highly relies on the Factory Method pattern.
 * 
 * 
 * @author Imre Szekeres
 * @version "%I%, %G%"
 * @see javax.swing.JFrame
 * @see Scene
 * @see java.awt.ActionListener
 */
@SuppressWarnings({"unused", "serial"})
public class MordorFrame extends JFrame{
	
	private static final String DEFAULT_FILE_PATH = "resources/descriptors/scened.txt";
	private JLabel userManaField;
	private JLabel userManaFieldPrefix;
	private JLabel towerTitle;
	private JLabel trapTitle;
	private JLabel towerRuneTitle;
	private JLabel trapRuneTitle;
	private JLabel infoTitle;
//	private JLabel infoDescription;
	private JTextArea infoDescription;
	private Scene scene;
	
	private JPanel gamePanel;
	private JPanel actionPanel;
	private JPanel manaPanel;
	private JPanel towerPanel;
	private JPanel innerTowerPanel;
	private JPanel trapPanel;
	private JPanel innerTrapPanel;
	private JPanel towerRunePanel;
	private JPanel innerTowerRunePanel;
	private JPanel trapRunePanel;
	private JPanel innerTrapRunePanel;
	private JPanel upperLogicalPanel;
	private JPanel lowerLogicalPanel;
	private JPanel infoPanel;
	private JPanel infoSeparatorPanel;
	
	private JSplitPane splitHorizontal;
	private JSplitPane manaSplitter;
	private JSplitPane towerTrapSplitter;
	private JSplitPane runeSplitter;
	private JSplitPane logicalSplitter;
	private JSplitPane infoSplitter;
	
	private JMenuBar menubar;
	private JMenu gameMenu;
	private JMenuItem startMenuItem;
	private JMenuItem pauseMenuItem;
	private JMenuItem restartMenuItem;
	private JMenuItem exitMenuItem;
	
	private JButton basicTower;
	private JButton rangeTower;
	private JButton greatTower;
	private JButton fastTower;
	
	private JButton dmgDecreaseTrap;
	private JButton speedDecreaseTrap;
	private JButton poisonTrap;
	
	private JButton plusSpeedTowerRune;
	private JButton plusDmdTowerTune;
	private JButton plusRangeTowerRune;
	private JButton plusElfDmdTowerTune;
	private JButton plusDwarfDmdTowerTune;
	private JButton plusHobbitTowerTune;
	
	private JButton plusSpeedDecreaseTrapRune;
	private JButton plusDmgDecreaseTrapRune;
	private JButton plusPoisonTrapRune;
	
	
	
	/**
	 * Builds the <code>Scene</code> object from the source of the given
	 * file path, and the widgets displayed by the GUI.
	 * 
	 * @param 	filePath	where the construction descriptor of the scene is	
	 * @throws IOException	in case the file on the given filePath does not exist.
	 * */
	protected MordorFrame(String filePath) throws IOException {
		super("Mordor Quest");
		scene = new Scene.Builder(this).filePath(filePath).build();
		initWidgets();
		
		super.setVisible(true);
	}
	
	protected MordorFrame() {
		super("Mordor Quest");
		scene = new Scene.Builder(this).buildSimple();
		initWidgets();
		
		super.setVisible(true);
	}
	
	/**
	 * Inner mechanism for building up the widgets displayed by this frame.
	 * 
	 * */
	private void initWidgets(){
		Font font1 = new Font("SansSerif", Font.BOLD, 20);
		Font font2 = new Font("SansSerif", Font.BOLD, 12);
		userManaField = new JLabel("1000");
		userManaField.setFont(font1);
		
		userManaFieldPrefix = new JLabel("Mana: ");
		userManaFieldPrefix.setFont(font1);
		
		towerTitle  = new JLabel("Towers");
		trapTitle  = new JLabel("Traps");
		towerRuneTitle  = new JLabel("Tower Runes");
		trapRuneTitle  = new JLabel("Trap Runes");
		infoTitle = new JLabel("Info");
//		infoDescription = new JLabel();
		infoDescription = new JTextArea();
		infoDescription.setFont(font2);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(875, 600));
		setResizable( false );
		
		gamePanel = new JPanel();
		actionPanel = new JPanel();
		manaPanel = new JPanel();
		towerPanel = new JPanel();
		innerTowerPanel = new JPanel();
		trapPanel = new JPanel();
		innerTrapPanel = new JPanel();
		towerRunePanel = new JPanel();
		innerTowerRunePanel = new JPanel();
		trapRunePanel = new JPanel();
		innerTrapRunePanel = new JPanel();
		upperLogicalPanel = new JPanel();
		lowerLogicalPanel = new JPanel();
		infoSeparatorPanel = new JPanel();
		infoPanel = new JPanel();
		
		splitHorizontal = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		manaSplitter = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		towerTrapSplitter = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		runeSplitter = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		logicalSplitter = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		infoSplitter = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		
		basicTower = new JButton("Basic");
		rangeTower = new JButton("Long Range");
		greatTower = new JButton("High Damage");
		fastTower = new JButton("Fast");
		
		dmgDecreaseTrap = new JButton("Weakening");
		speedDecreaseTrap = new JButton("Slower");
		poisonTrap = new JButton("Poisonous");
		
		plusSpeedTowerRune = new JButton("+Speed");
		plusDmdTowerTune = new JButton("+Damage");
		plusRangeTowerRune  = new JButton("+Range");
		plusElfDmdTowerTune  = new JButton("+Elf dmg");
		plusDwarfDmdTowerTune  = new JButton("+Dwarf dmg");
		plusHobbitTowerTune  = new JButton("+Hobbit dmg");
		
		plusSpeedDecreaseTrapRune = new JButton("+Slower");
		plusDmgDecreaseTrapRune = new JButton("+Weakening");
		plusPoisonTrapRune = new JButton("+Poisonous");
		
		
		this.setLayout(new BorderLayout());
		
		//window setup
		this.add(splitHorizontal, new BorderLayout().CENTER);
		splitHorizontal.add(gamePanel);
		splitHorizontal.add(actionPanel);
		
		//actionPanel setup
		actionPanel.setLayout(new BorderLayout());
		actionPanel.add(manaSplitter, new BorderLayout().CENTER);
		
		manaSplitter.add(manaPanel);
		manaSplitter.add(logicalSplitter);
		
		//manaPanel setup
		manaPanel.setLayout(new FlowLayout());
		manaPanel.add(userManaFieldPrefix);
		manaPanel.add(userManaField);
		
		//logical separation setup
		logicalSplitter.add(upperLogicalPanel);
		logicalSplitter.add(lowerLogicalPanel);
	
		//upper logical separation (tower,trap) setup
		upperLogicalPanel.setLayout(new BorderLayout());
		upperLogicalPanel.add(towerTrapSplitter, new BorderLayout().CENTER);

		towerTrapSplitter.add(towerPanel);
		towerTrapSplitter.add(trapPanel);

		towerPanel.setLayout(new BorderLayout());
		towerPanel.add(towerTitle, new BorderLayout().NORTH);
		towerPanel.add(innerTowerPanel, new BorderLayout().CENTER);
		innerTowerPanel.setLayout(new GridLayout(2,2));
		
		trapPanel.setLayout(new BorderLayout());
		trapPanel.add(trapTitle, new BorderLayout().NORTH);
		trapPanel.add(innerTrapPanel, new BorderLayout().CENTER);
		innerTrapPanel.setLayout(new GridLayout(2,2));
		
		//lower logical separation (runes) setup
		lowerLogicalPanel.setLayout(new BorderLayout());
		lowerLogicalPanel.add(runeSplitter, new BorderLayout().CENTER);
		
		runeSplitter.add(towerRunePanel);
		runeSplitter.add(infoSeparatorPanel);
		
		towerRunePanel.setLayout(new BorderLayout());
		towerRunePanel.add(towerRuneTitle, new BorderLayout().NORTH);
		towerRunePanel.add(innerTowerRunePanel, new BorderLayout().CENTER);
		innerTowerRunePanel.setLayout(new GridLayout(3,2));		
		
		infoSeparatorPanel.setLayout(new BorderLayout());
		infoSeparatorPanel.add(infoSplitter, new BorderLayout().CENTER);
		
		infoSplitter.add(trapRunePanel);
		infoSplitter.add(infoPanel);
		
		trapRunePanel.setLayout(new BorderLayout());
		trapRunePanel.add(trapRuneTitle, new BorderLayout().NORTH);
		trapRunePanel.add(innerTrapRunePanel, new BorderLayout().CENTER);
		innerTrapRunePanel.setLayout(new GridLayout(2,2));
		
		infoPanel.setLayout(new BorderLayout());
		infoPanel.add(infoTitle, new BorderLayout().NORTH);
		infoPanel.add(infoDescription, new BorderLayout().CENTER);
		
		//add buttons to panels
		innerTowerPanel.add(basicTower);
		innerTowerPanel.add(rangeTower);
		innerTowerPanel.add(greatTower);
		innerTowerPanel.add(fastTower);
		
		innerTrapPanel.add(dmgDecreaseTrap);
		innerTrapPanel.add(speedDecreaseTrap);
		innerTrapPanel.add(poisonTrap);
		
		innerTowerRunePanel.add(plusDmdTowerTune);
		innerTowerRunePanel.add(plusRangeTowerRune);
		innerTowerRunePanel.add(plusSpeedTowerRune);
		innerTowerRunePanel.add(plusElfDmdTowerTune);
		innerTowerRunePanel.add(plusDwarfDmdTowerTune);
		innerTowerRunePanel.add(plusHobbitTowerTune);
		
		innerTrapRunePanel.add(plusDmgDecreaseTrapRune);
		innerTrapRunePanel.add(plusSpeedDecreaseTrapRune);
		innerTrapRunePanel.add(plusPoisonTrapRune);
		
		//make dividers to unmoveable
		splitHorizontal.setDividerLocation(600);
		
		splitHorizontal.setEnabled( false );
		manaSplitter.setEnabled( false );
		logicalSplitter.setEnabled( false );
		towerTrapSplitter.setEnabled( false );
		runeSplitter.setEnabled( false );
		infoSplitter.setEnabled( false );
		
		gamePanel.setBackground(Color.WHITE);
		
		//menu setup
		menubar = new JMenuBar();
		gameMenu = new JMenu("Game");
		startMenuItem = new JMenuItem("Start Game");
		pauseMenuItem = new JMenuItem("Pause Game");
		restartMenuItem = new JMenuItem("Restart Game");
		exitMenuItem = new JMenuItem("Exit");
		
		menubar.add(gameMenu);
		gameMenu.add(startMenuItem);
		gameMenu.add(pauseMenuItem);
		gameMenu.add(restartMenuItem);
		gameMenu.addSeparator();
		gameMenu.add(exitMenuItem);
		
		super.setJMenuBar(menubar);
		
		//set textarea background color
		//and upper border
		infoDescription.setBackground(infoPanel.getBackground());
		infoDescription.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, Color.BLACK));
		
		
		initEventListeners();
		
		
	}
	
	private void initEventListeners(){
		//hover event on buttons for info show
		
		//for towers
		basicTower.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	infoDescription.setText(StringResources.BASIC_TOWER_INFO);
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	infoDescription.setText("");
		    }
		});
		
		greatTower.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	infoDescription.setText(StringResources.GREAT_TOWER_INFO);
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	infoDescription.setText("");
		    }
		});
		
		fastTower.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	infoDescription.setText(StringResources.FAST_TOWER_INFO);
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	infoDescription.setText("");
		    }
		});
		
		rangeTower.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	infoDescription.setText(StringResources.LONG_RANGE_INFO);
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	infoDescription.setText("");
		    }
		});
		
		//for traps
		dmgDecreaseTrap.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	infoDescription.setText(StringResources.WEAKENING_TRAP_INFO);
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	infoDescription.setText("");
		    }
		});
		
		speedDecreaseTrap.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	infoDescription.setText(StringResources.SLOWER_TRAP_INFO);
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	infoDescription.setText("");
		    }
		});
		
		poisonTrap.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	infoDescription.setText(StringResources.POISONOUS_TRAP_INFO);
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	infoDescription.setText("");
		    }
		});
		
		//for tower runes
		plusDmdTowerTune.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	infoDescription.setText(StringResources.PLUS_DAMAGE_TOWER_RUNE_INFO);
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	infoDescription.setText("");
		    }
		});
		
		plusDwarfDmdTowerTune.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	infoDescription.setText(StringResources.PLUS_DWARF_DAMAGE_TOWER_RUNE_INFO);
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	infoDescription.setText("");
		    }
		});
		
		plusElfDmdTowerTune.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	infoDescription.setText(StringResources.PLUS_ELF_DAMAGE_TOWER_RUNE_INFO);
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	infoDescription.setText("");
		    }
		});
		
		plusHobbitTowerTune.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	infoDescription.setText(StringResources.PLUS_HOBBIT_DAMAGE_TOWER_RUNE_INFO);
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	infoDescription.setText("");
		    }
		});
		
		plusRangeTowerRune.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	infoDescription.setText(StringResources.PLUS_RANGE_TOWER_RUNE_INFO);
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	infoDescription.setText("");
		    }
		});
		
		plusSpeedTowerRune.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	infoDescription.setText(StringResources.PLUS_SPEED_TOWER_RUNE_INFO);
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	infoDescription.setText("");
		    }
		});
		
		//for trap runes
		plusDmgDecreaseTrapRune.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	infoDescription.setText(StringResources.PLUS_WEAKENING_TRAP_RUNE_INFO);
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	infoDescription.setText("");
		    }
		});
		
		plusSpeedDecreaseTrapRune.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	infoDescription.setText(StringResources.PLUS_SLOWER_TRAP_RUNE_INFO);
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	infoDescription.setText("");
		    }
		});
		
		plusPoisonTrapRune.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	infoDescription.setText(StringResources.PLUS_POISONOUS_TRAP_RUNE_INFO);
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	infoDescription.setText("");
		    }
		});
	}
	
	/**
	 * Factory method publishing mechanism to instantiate a <code>MordorFrame</code>
	 * with default configuration.
	 * 
	 * @throws IOException if the file does not exist anymore on the default file path
	 * @return a new instance of the MordorFrame class
	 * */
	public static MordorFrame newInstance() {
		return new MordorFrame();
	}
	
	/**
	 * Factory method for instantiating a <code>MordorFrame</code> from an arbitrary descriptor file.
	 * 
	 * @param  filePath 	a string representing the file path on which the descriptor is available
	 * @throws IOException	in case the given file path does not describe a file
	 * @return a new instance of the MordorFrame class
	 * */
	public static MordorFrame newInstance(String filePath) throws IOException{
		//TODO:
//		System.out.println("MordorFrame.newInstance(String): MordorFrame called");
		MordorFrame frame = new MordorFrame(filePath);
//		System.out.println("MordorFrame.newInstance(String): MordorFrame returned");
		return frame;
	}
	
	/**
	 * Publishes the <code>Scene</code> constructed and managed by this instance of
	 * the <code>MordorFrame</code> class.
	 * 
	 * @return the <code>Scene</code> instance contained by this <code>MordorFrame</code> object.
	 * */
	public Scene getScene(){
		//TODO:
//		System.out.println("MordorFrame.getScene(): Scene called");
//		System.out.println("MordorFrame.getScene(): Scene returned");
		return scene;
	}
	
	/**
	 * Returns the mana the user still owns to spend on casting objects.
	 * 
	 * @return the remaining mana being at the users disposal.
	 * */
	public int getUserMana(){
		//TODO:
//		System.out.println("MordorFrame.getUserMana(): int called");
//		System.out.println("MordorFrame.getUserMana(): int returned");
		return Integer.parseInt(userManaField.getText());
	}
	
	/**
	 * Sets the mana the user still have to a new value;
	 * 
	 * @param mana the new amount of mana the user can spend. 
	 * */
	public void setUserMana(int mana){
		//TODO:
//		System.out.println("MordorFrame.setUserMana(int): void called");
		userManaField.setText(Integer.toString(mana));
//		System.out.println("MordorFrame.setUserMana(int): void returned");
	}
	
	/**
	 * Notifies the user about the positive output of the game!
	 * */
	public void win(){
		//TODO: JOptionPane.showMessageDialog(...);
//		System.out.println("MordorFrame.win(): void called");
//		System.out.println("MordorFrame.win(): void returned");
	}
	
	/**
	 * Notifies the user about the negative output of the game!
	 * */
	public void gameOver(){
		//TODO: JOptionPane.showMessageDialog(...);
//		System.out.println("MordorFrame.gameOver(): void called");
//		System.out.println("MordorFrame.gameOver(): void returned");
//		System.out.println("Game Over");
	}
	
	/**
	 * Resets the game space for another game!
	 * */
	public void reset(){
		//TODO: scene = new Scene.Builder()...build()
		// contentPane .add(scene)
//		System.out.println("MordorFrame.reset(): void called");
//		System.out.println("MordorFrame.reset(): void returned");
	}
}
