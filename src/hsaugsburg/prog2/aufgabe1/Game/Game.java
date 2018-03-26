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

import hsaugsburg.prog2.aufgabe1.IO.IOUnit;
import hsaugsburg.prog2.aufgabe1.IO.Input;

/**
 * Main module of application which has reference to all major components
 * {@link IOUnit}, {@link GameState} and {@link GameRuleEngine}.
 * @author David
 * @author Markus
 */
public class Game {

    private final IOUnit _unit;

    private final GameState _state;

    private final GameRuleEngine _engine;

    /**
     * Creates game from io unit and state and initalize rule engine from state
     * @param unit
     * @param state
     */
    public Game(IOUnit unit, GameState state) {
        if (unit == null)
            throw new IllegalArgumentException(IOUnit.class.getName() + " is null");
        if (state == null)
            throw new IllegalArgumentException(GameState.class.getName() +  " is null");
        _unit = unit;
        _state = state;
        _engine = new GameRuleEngine(state);
    }

    /**
     * Runs game
     */
    public void Run() {
        Player player = Player.Player1;
        while (_state.getScore().getWinner() == Player.None) {
            try {
                Input input = _unit.read(player);
                _engine.apply(input);
                _unit.print(_state);
                player = (player == Player.Player1 ? Player.Player2 : Player.Player1);
            } catch (Exception ex) {
                if (ex instanceof NumberFormatException)
                    System.out.println("Invalid input");
                else
                    System.out.println(ex.getMessage());
            }
        }
    }
}
