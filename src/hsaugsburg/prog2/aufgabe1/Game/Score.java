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
