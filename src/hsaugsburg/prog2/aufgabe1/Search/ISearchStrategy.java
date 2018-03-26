package hsaugsburg.prog2.aufgabe1.Search;

import hsaugsburg.prog2.aufgabe1.Game.Coordinates;

/**
 * Interface for different search strategies
 * @author David
 * @author Markus
 */
public interface ISearchStrategy {

    /**
     * Checks neighbor symbols to decide if search is useful
     * @param world
     * @param coord
     * @return
     */
    boolean appliesTo(char[][] world, Coordinates coord, char symbol);

    /**
     * Returns symbol count
     * @param world
     * @return
     */
    int search(char[][] world, Coordinates coord, char symbol);
}
