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
            throw new IllegalArgumentException(GameState.class.getName() + " is null");
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
