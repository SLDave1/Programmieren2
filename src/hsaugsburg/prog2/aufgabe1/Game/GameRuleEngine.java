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
import hsaugsburg.prog2.aufgabe1.Search.SearchComposite;

/**
 * Applies Game rules on {@link GameState}.
 * @author David
 * @author Markus
 */
public class GameRuleEngine {

    private final GameState _state;

    private final SearchComposite _composite;

    /**
     * Creates Rule Engine with default search composite
     * @param state
     */
    public GameRuleEngine(GameState state) {
        this(state, new SearchComposite());
    }
    /**
     * Creates engine with {@link GameState}.
     * @param state
     */
    public GameRuleEngine(GameState state, SearchComposite composite) {
        if (state == null)
            throw new IllegalArgumentException(GameState.class.getName() + " is null");
        if (composite == null)
            throw new IllegalArgumentException(SearchComposite.class.getName() + " is null");
        _state = state;
        _composite = composite;
    }

    /**
     * Applies game rules to game state for user input.
     * @param input
     */
    public void apply(Input input) {
        if (input == null)
            throw new IllegalArgumentException(Input.class.getName() + " is null");
        char[][] state = _state.getWorld().getState();
        if (state == null)
            throw new IllegalArgumentException("World state is null");
        char symbol = (input.getPlayer() == Player.Player1) ? 'X' : 'O';
        Coordinates coord = calculateWorld(input, state, symbol);
        int highestScore = _composite.search(_state.getWorld(), coord, symbol);
        if (highestScore == 4)
            _state.setScore(new Score(input.getPlayer(), highestScore));
    }

    /**
     * Calc new world state
     * @param input
     * @param state
     * @param symbol
     * @return Coordinates returns coordinate of new symbol
     */
    private Coordinates calculateWorld(Input input, char[][] state, char symbol) {
        int i = 1;
        while (i < state.length - 1) {
            if (i == 1 && state[i][input.getColumn()] != '.')
                break;
            else if (state[i][input.getColumn()] != '.') {
                state[--i][input.getColumn()] = symbol;
                break;
            }
            else if (i == state.length - 2) {
                state[i][input.getColumn()] = symbol;
                break;
            }
            else
                i++;
        }
        return new Coordinates(input.getColumn(), i);
    }
}
