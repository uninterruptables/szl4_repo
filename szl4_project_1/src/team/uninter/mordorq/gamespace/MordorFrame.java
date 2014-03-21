/**
 * MordorFrame.java
 */
package team.uninter.mordorq.gamespace;

import javax.swing.event.*;
import java.awt.*;
import javax.swing.*;
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
	
	/**
	 * Builds the <code>Scene</code> object from the source of the given
	 * file path, and the widgets displayed by the GUI.
	 * 
	 * @param 	filePath	where the construction descriptor of the scene is	
	 * @throws IOException	in case the file on the given filePath does not exist.
	 * */
	protected MordorFrame(String filePath) throws IOException {
		super("Mordor Quest");
		//TODO:
		System.out.println("MordorFrame.MordorFrame(String) called");
		scene = new Scene.Builder(this).filePath(filePath).build();
		initWidgets();
		System.out.println("MordorFrame.MordorFrame(String) returned");
	}
	
	/**
	 * Inner mechanism for building up the widgets displayed by this frame.
	 * 
	 * */
	private void initWidgets(){
		//TODO:
		System.out.println("MordorFrame.initWidgets(): void called");
		userManaField = new JTextField();
		userManaField.setEditable(false);
		userManaField.setText("1000");
		System.out.println("MordorFrame.initWidgets(): void returned");
	}
	
	/**
	 * Factory method publishing mechanism to instantiate a <code>MordorFrame</code>
	 * with default configuration.
	 * 
	 * @throws IOException if the file does not exist anymore on the default file path
	 * @return a new instance of the MordorFrame class
	 * */
	public static MordorFrame newInstance() throws IOException {
		//TODO:
		System.out.println("MordorFrame.newInstance(): MordorFrame called");
		MordorFrame frame = new MordorFrame(DEFAULT_FILE_PATH);
		System.out.println("MordorFrame.newInstance(): MordorFrame returned");
		return frame;
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
		System.out.println("MordorFrame.newInstance(String): MordorFrame called");
		MordorFrame frame = new MordorFrame(filePath);
		System.out.println("MordorFrame.newInstance(String): MordorFrame returned");
		return frame;
	}
	
	/**
	 * Returns the mana the user still owns to spend on casting objects.
	 * 
	 * @return the remaining mana being at the users disposal
	 * */
	public int getUserMana(){
		//TODO:
		System.out.println("MordorFrame.getUserMana(): int called");
		System.out.println("MordorFrame.getUserMana(): int returned");
		return Integer.parseInt(userManaField.getText());
	}
	
	/**
	 * Sets the mana the user still have to a new value;
	 * 
	 * @param mana the new amount of mana the user can spend. 
	 * */
	public void setUserMana(int mana){
		//TODO:
		System.out.println("MordorFrame.setUserMana(int): void called");
		userManaField.setText(Integer.toString(mana));
		System.out.println("MordorFrame.setUserMana(int): void returned");
	}
	
	
	private static final String DEFAULT_FILE_PATH = "resources/descriptors/scened.txt";
	private JTextField userManaField;
	private Scene scene;
}
