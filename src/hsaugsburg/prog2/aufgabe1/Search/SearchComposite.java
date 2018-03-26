package hsaugsburg.prog2.aufgabe1.Search;

import hsaugsburg.prog2.aufgabe1.Game.Coordinates;
import hsaugsburg.prog2.aufgabe1.Game.Score;

import java.util.*;

/**
 * Chooses  most efficient search strategies to find players new score
 * @author David
 * @author Markus
 */
public class SearchComposite {

    private final List<ISearchStrategy> _strategies = new LinkedList<ISearchStrategy>();

    /**
     * Creates composite with diagonal, horizontal and vertical search strategy
     */
    public SearchComposite() {
        _strategies.add(new DiagonalSearchStrategy());
        _strategies.add(new HorizontalSearchStrategy());
        _strategies.add(new VerticalSearchStrategy());
    }

    /**
     * Creates composite for custom search strategies
     * @param strategies
     */
    public SearchComposite(List<ISearchStrategy> strategies) {
        for (ISearchStrategy s : strategies) {
            _strategies.add(s);
        }
    }

    /**
     * Adds search strategy
     * @param strategy
     */
    public void add(ISearchStrategy strategy) {
        _strategies.add(strategy);
    }

    /**
     * Removes strategy from composite
     * @param strategy
     */
    public void remove(ISearchStrategy strategy) {
        //TODO implement remove
        throw new UnsupportedOperationException();
    }

    /**
     * Tries all applicable search strategies and will return highest score
     * @param world
     * @param coord
     * @param symbol
     * @return highest score
     */
    public int search(char[][] world, Coordinates coord, char symbol) {
        List<Integer> counts = new LinkedList<Integer>();
        for (ISearchStrategy strategy : _strategies) {
            if (strategy.appliesTo(world, coord, symbol))
                counts.add(strategy.search(world, coord, symbol));
        }
        if (counts.size() != 0)
            return Collections.max(counts);
        else
            return 0;
    }
}
