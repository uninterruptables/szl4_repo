/**
 * MordorFrame.java
 */
package team.uninter.mordorq.gamespace;

import javax.swing.event.*;

import java.awt.*;

import javax.swing.*;

import team.uninter.mordorq.utils.StringResources;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.TimerTask;
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
	private JLabel magicTitle;
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
	private JPanel magicSeparatorPanel;
	private JPanel magicPanel;
	private JPanel innerMagicPanel;
	
	private JSplitPane splitHorizontal;
	private JSplitPane manaSplitter;
	private JSplitPane towerTrapSplitter;
	private JSplitPane runeSplitter;
	private JSplitPane logicalSplitter;
	private JSplitPane infoSplitter;
	private JSplitPane magicSplitter;
	
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
	
	private JButton barricade;
	
	private JButton plusSpeedTowerRune;
	private JButton plusDmdTowerTune;
	private JButton plusRangeTowerRune;
	private JButton plusElfDmdTowerTune;
	private JButton plusDwarfDmdTowerTune;
	private JButton plusHobbitTowerTune;
	
	private JButton plusSpeedDecreaseTrapRune;
	private JButton plusDmgDecreaseTrapRune;
	private JButton plusPoisonTrapRune;
	
	private JButton nazgulMagic;
	private JButton iceWindMagic;
	private JButton poisonFogMagic;
	
	
	
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
		trapTitle  = new JLabel("Traps & Barricade");
		towerRuneTitle  = new JLabel("Tower Runes");
		trapRuneTitle  = new JLabel("Trap Runes");
		magicTitle = new JLabel("Magics");
		infoTitle = new JLabel("Info");
		infoDescription = new JTextArea();
		infoDescription.setFont(font2);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(900, 700));
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
		magicSeparatorPanel = new JPanel();
		magicPanel = new JPanel();
		innerMagicPanel = new JPanel();
		
		splitHorizontal = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		manaSplitter = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		towerTrapSplitter = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		runeSplitter = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		logicalSplitter = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		infoSplitter = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		magicSplitter = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		
		basicTower = new JButton("Basic");
		rangeTower = new JButton("Long Range");
		greatTower = new JButton("High Damage");
		fastTower = new JButton("Fast");
		
		dmgDecreaseTrap = new JButton("Weakening");
		speedDecreaseTrap = new JButton("Slower");
		poisonTrap = new JButton("Poisonous");
		
		barricade = new JButton("Barricade");
		
		plusSpeedTowerRune = new JButton("+Speed");
		plusDmdTowerTune = new JButton("+Damage");
		plusRangeTowerRune  = new JButton("+Range");
		plusElfDmdTowerTune  = new JButton("+Elf dmg");
		plusDwarfDmdTowerTune  = new JButton("+Dwarf dmg");
		plusHobbitTowerTune  = new JButton("+Hobbit dmg");
		
		plusSpeedDecreaseTrapRune = new JButton("+Slower");
		plusDmgDecreaseTrapRune = new JButton("+Weakening");
		plusPoisonTrapRune = new JButton("+Poisonous");
		
		nazgulMagic = new JButton("Nazgul");
		iceWindMagic = new JButton("Ice Wing");
		poisonFogMagic = new JButton("Poison Fog");
		
		
		this.setLayout(new BorderLayout());
		
		//window setup
		this.add(splitHorizontal, BorderLayout.CENTER);
		splitHorizontal.add(gamePanel);
		splitHorizontal.add(actionPanel);
		
		//actionPanel setup
		actionPanel.setLayout(new BorderLayout());
		actionPanel.add(manaSplitter, BorderLayout.CENTER);
		
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
		upperLogicalPanel.add(towerTrapSplitter, BorderLayout.CENTER);

		towerTrapSplitter.add(towerPanel);
		towerTrapSplitter.add(trapPanel);

		towerPanel.setLayout(new BorderLayout());
		towerPanel.add(towerTitle, BorderLayout.NORTH);
		towerPanel.add(innerTowerPanel, BorderLayout.CENTER);
		innerTowerPanel.setLayout(new GridLayout(2,2));
		
		trapPanel.setLayout(new BorderLayout());
		trapPanel.add(trapTitle, BorderLayout.NORTH);
		trapPanel.add(innerTrapPanel, BorderLayout.CENTER);
		innerTrapPanel.setLayout(new GridLayout(2,2));
		
		//lower logical separation (runes) setup
		lowerLogicalPanel.setLayout(new BorderLayout());
		lowerLogicalPanel.add(runeSplitter, BorderLayout.CENTER);
		
		runeSplitter.add(towerRunePanel);
		runeSplitter.add(infoSeparatorPanel);
		
		towerRunePanel.setLayout(new BorderLayout());
		towerRunePanel.add(towerRuneTitle, BorderLayout.NORTH);
		towerRunePanel.add(innerTowerRunePanel, BorderLayout.CENTER);
		innerTowerRunePanel.setLayout(new GridLayout(3,2));		
		
		infoSeparatorPanel.setLayout(new BorderLayout());
		infoSeparatorPanel.add(infoSplitter, BorderLayout.CENTER);
		
		infoSplitter.add(trapRunePanel);
		infoSplitter.add(magicSeparatorPanel);
		
		trapRunePanel.setLayout(new BorderLayout());
		trapRunePanel.add(trapRuneTitle, BorderLayout.NORTH);
		trapRunePanel.add(innerTrapRunePanel, BorderLayout.CENTER);
		innerTrapRunePanel.setLayout(new GridLayout(2,2));
		
		magicSeparatorPanel.setLayout(new BorderLayout());
		magicSeparatorPanel.add(magicSplitter);
		
		magicSplitter.add(magicPanel);
		magicSplitter.add(infoPanel);
		
		
		magicPanel.setLayout(new BorderLayout());
		magicPanel.add(magicTitle, BorderLayout.NORTH);
		magicPanel.add(innerMagicPanel, BorderLayout.CENTER);
		innerMagicPanel.setLayout(new GridLayout(2,2));
		
		
		infoPanel.setLayout(new BorderLayout());
		infoPanel.add(infoTitle, BorderLayout.NORTH);
		infoPanel.add(infoDescription, BorderLayout.CENTER);
		
		//add buttons to panels
		innerTowerPanel.add(basicTower);
		innerTowerPanel.add(rangeTower);
		innerTowerPanel.add(greatTower);
		innerTowerPanel.add(fastTower);
		
		innerTrapPanel.add(dmgDecreaseTrap);
		innerTrapPanel.add(speedDecreaseTrap);
		innerTrapPanel.add(poisonTrap);
		innerTrapPanel.add(barricade);
		
		innerTowerRunePanel.add(plusDmdTowerTune);
		innerTowerRunePanel.add(plusRangeTowerRune);
		innerTowerRunePanel.add(plusSpeedTowerRune);
		innerTowerRunePanel.add(plusElfDmdTowerTune);
		innerTowerRunePanel.add(plusDwarfDmdTowerTune);
		innerTowerRunePanel.add(plusHobbitTowerTune);
		
		innerTrapRunePanel.add(plusDmgDecreaseTrapRune);
		innerTrapRunePanel.add(plusSpeedDecreaseTrapRune);
		innerTrapRunePanel.add(plusPoisonTrapRune);
		
		innerMagicPanel.add(nazgulMagic);
		innerMagicPanel.add(iceWindMagic);
		innerMagicPanel.add(poisonFogMagic);
		
		//make dividers to unmoveable
		splitHorizontal.setDividerLocation(650);
		
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
		
		pauseMenuItem.setEnabled(false);
		restartMenuItem.setEnabled(false);
		
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
		
		barricade.addMouseListener(new java.awt.event.MouseAdapter() {
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
		
		//for magics
		nazgulMagic.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	infoDescription.setText(StringResources.NAZGUL_MAGIC_INFO);
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	infoDescription.setText("");
		    }
		});
		
		iceWindMagic.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	infoDescription.setText(StringResources.ICE_WIND_MAGIC_INFO);
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	infoDescription.setText("");
		    }
		});
		
		poisonFogMagic.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	infoDescription.setText(StringResources.POISON_FOG_MAGIC_INFO);
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	infoDescription.setText("");
		    }
		});
		
		
		//click event listeners
		
		//for towers
		basicTower.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					scene.setActiveObject("Basic Tower");
				} catch (InstantiationException | IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
        });
		
		fastTower.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					scene.setActiveObject("Fast Tower");
				} catch (InstantiationException | IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
        });
		
		greatTower.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					scene.setActiveObject("Great Tower");
				} catch (InstantiationException | IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
        });
		
		rangeTower.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					scene.setActiveObject("Long Distace Tower");
				} catch (InstantiationException | IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
        });
		
		//for traps & barricade
		
		barricade.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					scene.setActiveObject("Barricade");
				} catch (InstantiationException | IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
        });
		
		dmgDecreaseTrap.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					scene.setActiveObject("Decrease Damage Trap");
				} catch (InstantiationException | IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
        });
		
		poisonTrap.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					scene.setActiveObject("Poison Trap");
				} catch (InstantiationException | IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
        });
		
		speedDecreaseTrap.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					scene.setActiveObject("Slow Down Trap");
				} catch (InstantiationException | IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
        });
		
		//for tower runes
		plusDmdTowerTune.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					scene.setActiveObject("Damage Booster Tower Rune");
				} catch (InstantiationException | IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
        });
		
		plusDwarfDmdTowerTune.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					scene.setActiveObject("Damage Boost Dwarven Tower Rune");
				} catch (InstantiationException | IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
        });
		
		plusElfDmdTowerTune.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					scene.setActiveObject("Damage Boost Elven Tower Rune");
				} catch (InstantiationException | IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
        });
		
		plusHobbitTowerTune.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					scene.setActiveObject("Damage Boost Hobbit Tower Rune");
				} catch (InstantiationException | IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
        });
		
		plusRangeTowerRune.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					scene.setActiveObject("Radius Increasing Tower Rune");
				} catch (InstantiationException | IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
        });
		
		plusSpeedTowerRune.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					scene.setActiveObject("Speed Booster Tower Rune");
				} catch (InstantiationException | IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
        });
		
		//for trap runes
		plusDmgDecreaseTrapRune.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					scene.setActiveObject("Weaken Trap Rune");
				} catch (InstantiationException | IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
        });
		
		plusPoisonTrapRune.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					scene.setActiveObject("Poison Trap Rune");
				} catch (InstantiationException | IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
        });
		
		plusSpeedDecreaseTrapRune.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					scene.setActiveObject("Freeze Trap Rune");
				} catch (InstantiationException | IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
        });
		
		//for magics
		nazgulMagic.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					scene.setActiveObject("Nazgul");
				} catch (InstantiationException | IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
        });
		
		iceWindMagic.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					scene.setActiveObject("Ice Wind");
				} catch (InstantiationException | IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
        });
		
		poisonFogMagic.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					scene.setActiveObject("Poison Fog");
				} catch (InstantiationException | IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
        });
		
		
		//menu item listeners
		
		//start game
		startMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startMenuItem.setEnabled(false);
				pauseMenuItem.setEnabled(true);
				restartMenuItem.setEnabled(true);
				scene.start();
			}
        }); 
		
		//stop game
		pauseMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(scene.timer != null){
					pauseMenuItem.setText("Continue Game");
					startMenuItem.setEnabled(false);
					scene.pause();
				}
				else{
					pauseMenuItem.setText("Pause Game");
					scene.start();
				}
			}
        }); 
		
		//restart game
		restartMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pauseMenuItem.setText("Pause Game");
				startMenuItem.setEnabled(false);
				reset();
			}
        }); 
		
		//exit game
		exitMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(ABORT);
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
		return new MordorFrame(filePath);
	}
	
	/**
	 * Publishes the <code>Scene</code> constructed and managed by this instance of
	 * the <code>MordorFrame</code> class.
	 * 
	 * @return the <code>Scene</code> instance contained by this <code>MordorFrame</code> object.
	 * */
	public Scene getScene(){
		return scene;
	}
	
	/**
	 * Returns the mana the user still owns to spend on casting objects.
	 * 
	 * @return the remaining mana being at the users disposal.
	 * */
	public int getUserMana(){
		return Integer.parseInt(userManaField.getText());
	}
	
	/**
	 * Sets the mana the user still have to a new value;
	 * 
	 * @param mana the new amount of mana the user can spend. 
	 * */
	public void setUserMana(int mana){
		userManaField.setText(Integer.toString(mana));
	}
	
	/**
	 * Notifies the user about the positive output of the game!
	 * */
	public void win(){
		//TODO: JOptionPane.showMessageDialog(...);
	}
	
	/**
	 * Notifies the user about the negative output of the game!
	 * */
	public void gameOver(){
		//TODO: JOptionPane.showMessageDialog(...);
		JOptionPane.showMessageDialog(this, "Game Over");
		startMenuItem.setEnabled(false);
		pauseMenuItem.setEnabled(false);
	}
	
	/**
	 * Resets the game space for another game!
	 * */
	public void reset(){
		//TODO: scene = new Scene.Builder()...build()
		// contentPane .add(scene)
		int input = JOptionPane.showOptionDialog(this, "Are you sure?", "Restart Game", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

		if(input == JOptionPane.OK_OPTION)
		{
			//TODO: load default state
			if(scene.timer != null){
				scene.pause();
			}
			scene.start();
			
		    startMenuItem.setEnabled(false);
		    pauseMenuItem.setText("Pause Game");
		    pauseMenuItem.setEnabled(true);
		    restartMenuItem.setEnabled(true);
		}
	}
}