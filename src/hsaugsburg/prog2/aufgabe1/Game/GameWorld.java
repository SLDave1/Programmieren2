package hsaugsburg.prog2.aufgabe1.Game;

import hsaugsburg.prog2.aufgabe1.Game.Game;

/**
 * Manages game world state.
 * @author David
 * @author Markus
 */
public interface GameWorld {

    /**
     * Inserts X for specific {@link Coordinates}.
     * @param coord
     */
    void setX(Coordinates coord);

    /**
     * Inserts 0 for specific {@link Coordinates}.
     * @param coord
     */
    void setO(Coordinates coord);

    /**
     * Returns current world state.
     * @return state
     */
    char[][] getState();
}
