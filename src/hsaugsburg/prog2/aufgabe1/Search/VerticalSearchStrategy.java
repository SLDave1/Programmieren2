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
    public boolean appliesTo(GameWorld world, Coordinates coord, char symbol) {
        if (world == null)
            throw new IllegalArgumentException("char array is null");
        if (coord == null)
            throw new IllegalArgumentException(Coordinates.class.getName() + " is null");
        return ((world.getSymbol(new Coordinates(coord.getxPos(), coord.getyPos() + 1)) == symbol) ||
                (world.getSymbol(new Coordinates(coord.getxPos(), coord.getyPos() - 1)) == symbol));
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
        count += new Direction(DirectionSetting.Up).scan(world, coord, symbol);
        count += new Direction(DirectionSetting.Down).scan(world, coord, symbol);
        return count;
    }
}
