package hsaugsburg.prog2.aufgabe1.Game;

/**
 * Value object which contains coordinates for inserting O or X to {@link GameWorld}.
 * @author David
 * @author Markus
 */
public class Coordinates {

    private final int _xPos;

    private final int _yPos;

    /**
     * Creates object from xPos and yPos
     * @param xPos
     * @param yPos
     */
    public Coordinates(int xPos, int yPos) {
        if (xPos < 0 || yPos < 0)
            throw new IllegalArgumentException();
        _xPos = xPos;
        _yPos = yPos;
    }

    /**
     * Returns symbol xPos
     * @return xPos
     */
    public int getxPos() {
        return _xPos;
    }

    /**
     * Returns symbol yPos
     * @return yPos
     */
    public int getyPos() {
        return _yPos;
    }
}
