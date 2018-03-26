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
