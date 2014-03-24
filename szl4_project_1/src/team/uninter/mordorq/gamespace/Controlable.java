/**
 * Controlable.java
 */
package team.uninter.mordorq.gamespace;

//small interface for GameObjects that are simulated over time.
public interface Controlable {
	void controlIt();
	boolean isActive();
}
