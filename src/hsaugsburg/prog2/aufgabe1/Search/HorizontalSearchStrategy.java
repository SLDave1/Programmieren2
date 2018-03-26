package hsaugsburg.prog2.aufgabe1.Search;

import hsaugsburg.prog2.aufgabe1.Game.Coordinates;
import hsaugsburg.prog2.aufgabe1.Game.GameState;

/**
 * Performs horizontal search
 * @author David
 * @author Markus
 */
public class HorizontalSearchStrategy implements ISearchStrategy {

    /**
     * Checks neighbor symbols
     *
     * @param world
     * @return
     */
    @Override
    public boolean appliesTo(char[][] world, Coordinates coord, char symbol) {
        if (world == null)
            throw new IllegalArgumentException("char array is null");
        if (world == null)
            throw new IllegalArgumentException(Coordinates.class.getName() + "is null");
        return (((coord.getxPos() + 1 <= world[0].length) ? (world[coord.getyPos()][coord.getxPos() + 1] == symbol) : false) ||
                ((coord.getxPos() - 1 >= 0) ? (world[coord.getyPos()][coord.getxPos() - 1] == symbol) : false));
    }

    /**
     * Returns symbol count
     *
     * @param world
     * @return
     */
    @Override
    public int search(char[][] world, Coordinates coord, char symbol) {
        if (world == null)
            throw new IllegalArgumentException("char array is null");
        if (coord == null)
            throw new IllegalArgumentException(Coordinates.class.getName() + "is null");
        int count = 1;
        count += countRight(world, coord, symbol);
        count += countLeft(world, coord, symbol);
        return count;
    }

    private int countRight(char[][] world, Coordinates coord, char symbol) {
        int count = 0;
        int i = 0;
        char c = symbol;
        while (c == symbol) {
            i++;
            c = (coord.getxPos() + 1 <= world[0].length) ? world[coord.getyPos()][coord.getxPos() + i] : '.';
            if (c == symbol)
                count++;
        }
        return count;
    }

    private int countLeft(char[][] world, Coordinates coord, char symbol) {
        int count = 0;
        int i = 0;
        char c = symbol;
        while (c == symbol) {
            i++;
            // TODO refactor checks into Gameworld class
            c = (coord.getxPos() - 1 >= 0) ? world[coord.getyPos()][coord.getxPos() - i] : '.';
            if (c == symbol)
                count++;
        }
        return count;
    }
}
