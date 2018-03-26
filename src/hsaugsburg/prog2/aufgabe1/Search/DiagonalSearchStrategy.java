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
    public boolean appliesTo(GameWorld world, Coordinates coord, char symbol) {
        if (world == null)
            throw new IllegalArgumentException("char array is null");
        if (world == null)
            throw new IllegalArgumentException(Coordinates.class.getName() + " is null");
        return (world.getSymbol(new Coordinates(coord.getxPos() + 1, coord.getyPos() + 1)) == symbol) ||
                (world.getSymbol(new Coordinates(coord.getxPos() - 1, coord.getyPos() + 1)) == symbol) ||
                (world.getSymbol(new Coordinates(coord.getxPos() + 1, coord.getyPos() - 1)) == symbol) ||
                (world.getSymbol(new Coordinates(coord.getxPos() - 1, coord.getyPos() - 1)) == symbol);
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
    public int search(GameWorld world, Coordinates coord, char symbol) {
        if (world == null)
            throw new IllegalArgumentException("char array is null");
        if (coord == null)
            throw new IllegalArgumentException(Coordinates.class.getName() + " is null");
        int count = 1;
        count += upDiagonal(world, coord, symbol);
        int result = downDiagonal(world, coord, symbol) + 1;
        if (result > count)
            count = result;
        return count;
    }

    //TODO refactor to Direction class
    private int upDiagonal(GameWorld world, Coordinates coord, char symbol) {
        int count = 0;
        int i = 0;
        char c = symbol;
        while (c == symbol) {
            i++;
            c = world.getSymbol(new Coordinates(coord.getxPos() + i, coord.getyPos() + i));
            if (c == symbol)
                count++;
        }
        i = 0;
        c = symbol;
        while (c == symbol) {
            i++;
            c = world.getSymbol(new Coordinates(coord.getxPos() - i, coord.getyPos() - i));
            if (c == symbol)
                count++;
        }
        return count;
    }

    //TODO refactor to Direction class
    private int downDiagonal(GameWorld world, Coordinates coord, char symbol) {
        int count = 0;
        int i = 0;
        char c = symbol;
        while (c == symbol) {
            i++;
            c = world.getSymbol(new Coordinates(coord.getxPos() - i, coord.getyPos() + i));
            if (c == symbol)
                count++;
        }
        i = 0;
        c = symbol;
        while (c == symbol) {
            i++;
            c = world.getSymbol(new Coordinates(coord.getxPos() + i, coord.getyPos() - i));
            if (c == symbol)
                count++;
        }
        return count;
    }
}
