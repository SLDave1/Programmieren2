package hsaugsburg.prog2.aufgabe1.IO;

import hsaugsburg.prog2.aufgabe1.Game.GameState;
import hsaugsburg.prog2.aufgabe1.Game.Player;

import java.io.IOException;
import java.util.Scanner;

/**
 * Default implementation for {@link IOUnit} that uses Console as IO Device
 * @author David
 * @author Markus
 */
public class Console implements IOUnit {

    /**
     * Prints the current game state out.
     * @param state the current game state
     */
    public void print(GameState state) {
        if (state == null)
            throw new IllegalArgumentException(GameState.class.getName() + "is null");
        char[][] world = state.getWorld().getState();
        for (int row = 0; row < world.length; row++) {
            for (int column = 0; column < world[0].length; column++) {
                System.out.print(world[row][column]);
            }
            System.out.println();
        }
        System.out.println();
        if (state.getScore().getWinner() != Player.None)
            System.out.println("The winner is " + state.getScore().getWinner());
    }

    /**
     * Returns the user input.
     * @param player
     * @return Input
     */
    public Input read(Player player) throws IOException {
        System.out.println(player.name() + " choose column between 1-8");
        Scanner reader = new Scanner(System.in);
        String c = reader.next();
        return new Input(player, Integer.parseInt(c));
    }
}
