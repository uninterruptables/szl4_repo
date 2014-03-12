/**
 * MordorFrame.java
 * */
package szl4.uninterruptables.gui;

import javax.swing.*;
import java.awt.*;

/**
 * 
 * 
 * @author Imre Szekeres
 * */
@SuppressWarnings("serial")
public class MordorFrame extends JFrame{

	public MordorFrame(){
		super("Mordor Quest");
		initWidgets();
	}
	
	private void initWidgets(){
		
		this.setLocation(77, 110);
		this.setPreferredSize(new Dimension(1100, 770));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
	}
	
	public static void main(String[] args) {
		new MordorFrame().setVisible(true);
	}

}
