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
import hsaugsburg.prog2.aufgabe1.Game.GameState;
import hsaugsburg.prog2.aufgabe1.Game.GameWorld;

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
    public boolean appliesTo(GameWorld world, Coordinates coord, char symbol) {
        if (world == null)
            throw new IllegalArgumentException("char array is null");
        if (world == null)
            throw new IllegalArgumentException(Coordinates.class.getName() + " is null");
        int newX = 0;
        return (world.getSymbol(new Coordinates(coord.getxPos() + 1, coord.getyPos())) == symbol) ||
                (world.getSymbol(new Coordinates(newX, coord.getyPos())) == symbol);
    }

    /**
     * Returns symbol count
     *
     * @param world
     * @return
     */
    @Override
    public int search(GameWorld world, Coordinates coord, char symbol) {
        if (world == null)
            throw new IllegalArgumentException("char array is null");
        if (coord == null)
            throw new IllegalArgumentException(Coordinates.class.getName() + " is null");
        int count = 1;
        count += countRight(world, coord, symbol);
        count += countLeft(world, coord, symbol);
        return count;
    }

    private int countRight(GameWorld world, Coordinates coord, char symbol) {
        int count = 0;
        int i = 0;
        char c = symbol;
        while (c == symbol) {
            i++;
            c = world.getSymbol(new Coordinates(coord.getxPos() + i, coord.getyPos()));
            if (c == symbol)
                count++;
        }
        return count;
    }

    private int countLeft(GameWorld world, Coordinates coord, char symbol) {
        int count = 0;
        int i = 0;
        char c = symbol;
        while (c == symbol) {
            i++;
            c = world.getSymbol(new Coordinates(coord.getxPos() - i, coord.getyPos()));
            if (c == symbol)
                count++;
        }
        return count;
    }
}
