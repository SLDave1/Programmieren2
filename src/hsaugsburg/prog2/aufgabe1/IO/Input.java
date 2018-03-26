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

package hsaugsburg.prog2.aufgabe1.IO;

import hsaugsburg.prog2.aufgabe1.Game.GameWorld;
import hsaugsburg.prog2.aufgabe1.Game.Player;

/**
 * Value object which contains player input from {@link IOUnit} for one round
 * @author David
 * @author Markus
 */
public class Input {

    private final Player _player;

    private final int _column;

    /**
     * Creates Input object with player chosen column
     * @param player
     * @param column
     */
    public Input(Player player, int column) {
        if (player.equals(Player.None))
            throw new IllegalArgumentException("Player cannot be none");
        if (!(1 <= column && column <= 9))
            throw new IllegalArgumentException("Column has to be in range 1 to 9");
        _player = player;
        _column = column - 1;
    }

    public Player getPlayer() {
        return _player;
    }

    /**
     * Returns column number
     * @return column
     */
    public int getColumn() {
        return _column;
    }
}
