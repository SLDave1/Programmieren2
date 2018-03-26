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

package hsaugsburg.prog2.aufgabe1.Game;

import hsaugsburg.prog2.aufgabe1.Game.Game;

/**
 * Manages game world state.
 * @author David
 * @author Markus
 */
public interface GameWorld {

    /**
     * Inserts X for specific {@link Coordinates}.
     * @param coord
     */
    void setX(Coordinates coord);

    /**
     * Inserts 0 for specific {@link Coordinates}.
     * @param coord
     */
    void setO(Coordinates coord);

    /**
     * Will return symbol for coordinates
     * @param coord
     * @return char symbol
     */
    char getSymbol(Coordinates coord);
    /**
     * Returns current world state.
     * @return state
     */
    char[][] getState();
}
