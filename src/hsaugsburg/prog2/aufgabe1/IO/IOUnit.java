package hsaugsburg.prog2.aufgabe1.IO;

import hsaugsburg.prog2.aufgabe1.Game.GameState;
import hsaugsburg.prog2.aufgabe1.Game.Player;

import java.io.IOException;

/**
 * Responsible for applications IO handling
 * @author David
 * @author Markus
 */
public interface IOUnit {

    /**
     * Prints the current game state out.
     * @param state the current game state
     */
    void print(GameState state);

    /**
     * Returns the user input.
     * @param player
     * @return Input
     */
    Input read(Player player) throws IOException;
}
