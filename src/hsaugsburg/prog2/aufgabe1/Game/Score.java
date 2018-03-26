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

/**
 * Manages users score.
 * @author David
 * @author Markus
 */
public class Score {

    private Player _winner;

    private int _player1Points;

    private int _player2Points;

    /**
     * Initializes player points and sets no winner
     */
    public Score() {
        _winner = Player.None;
        _player1Points = 0;
        _player2Points = 0;
    }

    public Score(Player player, int points) {
        _winner = (points == 4) ? player : Player.None;
        if (player == Player.Player1)
            _player1Points = points;
        else if (player == Player.Player2)
            _player2Points = points;

    }

    /**
     * Increases player 1 points by 1 and will set him Winner at 4 Points
     */
    public void increasePlayer1Points() {
        _player1Points++;
        if (_player1Points == 4)
            _winner = Player.Player1;
    }

    /**
     * Increases player 2 points by 1 and will set him Winner at 4 Points
     */
    public void increasePlayer2Points() {
        _player2Points++;
        if (_player2Points == 4)
            _winner = Player.Player2;
    }

    /**
     * Returns winning player.
     * @return Winner
     */
    public Player getWinner() {
        return _winner;
    }
}
