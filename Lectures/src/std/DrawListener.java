/******************************************************************************
 *  Compilation:  javac DrawListener.java
 *  Execution:    none
 *  Dependencies: none
 *
 *  Interface that accompanies Draw.java.
 ******************************************************************************/
package std;

/**
 *  The <code>DrawListener</code> interface provides a basic capability for
 *  responding to keyboard in mouse events from {@link Draw} via callbacks.
 *  You can see some examples in
 *  <a href="https://introcs.cs.princeton.edu/java/36inheritance">Section 3.6</a>.
 *
 *  <p>
 *  For additional documentation, see
 *  <a href="https://introcs.cs.princeton.edu/31datatype">Section 3.1</a> of
 *  <i>Computer Science: An Interdisciplinary Approach</i>
 *  by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */

public interface DrawListener {

    /**
     * Invoked when the mouse has been pressed.
     *
     * @param x the x-coordinate of the mouse
     * @param y the y-coordinate of the mouse
     */
    default void mousePressed(double x, double y) {
        // does nothing by default
    }

    /**
     * Invoked when the mouse has been dragged.
     *
     * @param x the x-coordinate of the mouse
     * @param y the y-coordinate of the mouse
     */
    default void mouseDragged(double x, double y) {
        // does nothing by default
    }

    /**
     * Invoked when the mouse has been released.
     *
     * @param x the x-coordinate of the mouse
     * @param y the y-coordinate of the mouse
     */
    default void mouseReleased(double x, double y) {
        // does nothing by default
    }

    /**
     * Invoked when the mouse has been clicked (pressed and released).
     * A mouse click is triggered only if the user presses a mouse button
     * and then releases it quickly, without moving the mouse.
     * It does not work with touch events.
     * The {@link mousePressed} method is generally preferred for
     * detecting mouse clicks.
     *
     * @param x the x-coordinate of the mouse
     * @param y the y-coordinate of the mouse
     */
    default void mouseClicked(double x, double y) {
        // does nothing by default
    }

    /**
     * Invoked when a key has been typed.
     *
     * @param c the character typed
     */
    default void keyTyped(char c) {
        // does nothing by default
    }

    /**
     * Invoked when a key has been pressed.
     *
     * @param keycode the key combination pressed
     */
    default void keyPressed(int keycode) {
        // does nothing by default
    }

    /**
     * Invoked when a key has been released.
     *
     * @param keycode the key combination released
     */
    default void keyReleased(int keycode) {
        // does nothing by default
    }

    /**
     * Gets called at regular time intervals.
     */
    default void update() {
        // does nothing by default
    }

}
