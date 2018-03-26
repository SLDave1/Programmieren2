/*
 * Copyright 2017-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package hsaugsburg.prog2.aufgabe1.Search;

import hsaugsburg.prog2.aufgabe1.Game.Coordinates;
import hsaugsburg.prog2.aufgabe1.Game.GameWorld;
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
    public int search(GameWorld world, Coordinates coord, char symbol) {
        if (world == null)
            throw new IllegalArgumentException(GameWorld.class.getName() + " is null");
        if (coord == null)
            throw new IllegalArgumentException(Coordinates.class.getName() + " is null");
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
