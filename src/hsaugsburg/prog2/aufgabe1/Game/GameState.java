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

import hsaugsburg.prog2.aufgabe1.IO.Input;

/**
 * Manages state of {@link GameWorld} and {@link Score}
 * @author David
 * @author Markus
 */
public class GameState {

    private final GameWorld _world;

    private Score _score;

    /**
     * Create game state from {@link GameWorld} and {@link Score}
     * @param world
     * @param score
     */
    public GameState(GameWorld world, Score score) {
        if (world == null)
            throw new IllegalArgumentException(GameWorld.class.getName() + " is null");
        if (score == null)
            throw new IllegalArgumentException(Score.class.getName() + " is null");
        _world = world;
        _score = score;
    }

    /**
     * Returns game world.
     * @return GameWorld
     */
    public GameWorld getWorld() {
        return _world;
    }

    /**
     * Returns game score.
     * @return Score
     */
    public Score getScore() {
        return _score;
    }

    /**
     * Sets new score
     * @param score
     */
    public void setScore(Score score) {
        if (score == null)
            throw new IllegalArgumentException(Score.class.getName() + " is null");
        _score = score;
    }
}
