package hsaugsburg.prog2.aufgabe1.Search;

import hsaugsburg.prog2.aufgabe1.Game.Coordinates;

/**
 * Searches vertically for highest score
 * @author David
 * @author Markus
 */
public class VerticalSearchStrategy implements ISearchStrategy {

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
        if (coord == null)
            throw new IllegalArgumentException(Coordinates.class.getName() + "is null");
        return ((world[coord.getyPos() + 1][coord.getxPos()] == symbol) ||
                (world[coord.getyPos() - 1][coord.getxPos()] == symbol));
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
        count += countUp(world, coord, symbol);
        count += countDown(world, coord, symbol);
        return count;
    }

    private int countUp(char[][] world, Coordinates coord, char symbol) {
        int count = 0;
        int i = 0;
        char c = symbol;
        while (c == symbol) {
            i++;
            c = world[coord.getyPos() + i][coord.getxPos()];
            if (c == symbol)
                count++;
        }
        return count;
    }

    private int countDown(char[][] world, Coordinates coord, char symbol) {
        int count = 0;
        int i = 0;
        char c = symbol;
        while (c == symbol) {
            i++;
            c = world[coord.getyPos() - i][coord.getxPos()];
            if (c == symbol)
                count++;
        }
        return count;
    }
}
