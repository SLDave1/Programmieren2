package hsaugsburg.prog2.aufgabe1.Search;

import hsaugsburg.prog2.aufgabe1.Game.Coordinates;

/**
 * Performs diagonal search
 * @author David
 * @author Markus
 */
public class DiagonalSearchStrategy implements ISearchStrategy {

    /**
     * Checks neighbor symbols to decide if search is useful
     *
     * @param world
     * @param coord
     * @param symbol
     * @return
     */
    @Override
    public boolean appliesTo(char[][] world, Coordinates coord, char symbol) {
        return false;
    }

    /**
     * Returns symbol count
     *
     * @param world
     * @param coord
     * @param symbol
     * @return
     */
    @Override
    public int search(char[][] world, Coordinates coord, char symbol) {
        return 0;
    }
}
