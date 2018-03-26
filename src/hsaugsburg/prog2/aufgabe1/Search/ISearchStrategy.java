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
 * Interface for different search strategies
 * @author David
 * @author Markus
 */
public interface ISearchStrategy {

    /**
     * Checks neighbor symbols to decide if search is useful
     * @param world
     * @param coord
     * @return
     */
    boolean appliesTo(GameWorld world, Coordinates coord, char symbol);

    /**
     * Returns symbol count
     * @param world
     * @return
     */
    int search(GameWorld world, Coordinates coord, char symbol);
}
