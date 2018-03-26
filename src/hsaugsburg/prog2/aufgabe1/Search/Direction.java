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
 * Specifies direction for scanning for symbols
 */
public class Direction {

    private final DirectionSetting _setting;

    /**
     * Creates direction with direction setting
     * @param setting
     */
    public Direction(DirectionSetting setting) {
        _setting = setting;
    }

    /**
     * scans for symbols in certain direction and returns count
     * @param world
     * @param coord
     * @param symbol
     * @return int symbol count
     */
    public int scan(GameWorld world, Coordinates coord, char symbol) {
        int count = 0;
        int i = 0;
        char c = symbol;
        while (c == symbol) {
            i++;
            if (_setting.equals(DirectionSetting.Right))
                c = world.getSymbol(new Coordinates(coord.getxPos() + i, coord.getyPos()));
            else if (_setting.equals(DirectionSetting.Left))
                c = world.getSymbol(new Coordinates(coord.getxPos() - i, coord.getyPos()));
            else if (_setting.equals(DirectionSetting.Up))
                c = world.getSymbol(new Coordinates(coord.getxPos(), coord.getyPos() + i));
            else if (_setting.equals(DirectionSetting.Down))
                c = world.getSymbol(new Coordinates(coord.getxPos(), coord.getyPos() - i));
            if (c == symbol)
                count++;
        }
        return count;
    }
}