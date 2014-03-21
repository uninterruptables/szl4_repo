/**
 * UnsupportedConfigurationException.java
 */
package team.uninter.mordorq.skeleton.signaling;

/**
 * It was designed as a signaling mechanism in pair with the <code>ConfigurableSimulator</code>
 * abstract class.
 * <p>
 * It provides both the wrapping of another exception with an additional message and just
 * simply using a given message to display services its super class, <code>Exception</code>.
 * 
 * @author Imre Szekeres
 * @version "%I%, %G%"
 * @see Exception
 * @see ConfigurableSimulator
 */
@SuppressWarnings("serial")
public class UnsupportedConfigurationException extends Exception{

	/**
	 * Public constructor for setting a message.
	 * 
	 * @param message that will be shown when the getMessage() method is invoked
	 * */
	public UnsupportedConfigurationException(String message){
		super(message);
	}
	
	/**
	 * Public constructor for setting a message along with the wrapping of another
	 * exception.
	 * 
	 * @param message that will be shown when the getMessage() method is invoked
	 * @param e another exception that has been caught and wrapped, then rethrown
	 * */
	public UnsupportedConfigurationException(String message, Exception e){
		super(message, e);
	}
}
