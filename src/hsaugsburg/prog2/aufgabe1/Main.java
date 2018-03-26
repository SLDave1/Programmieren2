package hsaugsburg.prog2.aufgabe1;

import hsaugsburg.prog2.aufgabe1.Game.Game;
import hsaugsburg.prog2.aufgabe1.Game.GameState;
import hsaugsburg.prog2.aufgabe1.Game.GameWorld2D;
import hsaugsburg.prog2.aufgabe1.Game.Score;
import hsaugsburg.prog2.aufgabe1.IO.Console;

public class Main {

    public static void main(String[] args) {
        new Game(new Console(), new GameState(new GameWorld2D(), new Score())).Run();
    }
}
