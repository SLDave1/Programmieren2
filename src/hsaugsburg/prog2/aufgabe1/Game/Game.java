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
            throw new IllegalArgumentException(IOUnit.class.getName() + "is null");
        if (state == null)
            throw new IllegalArgumentException(GameState.class.getName() +  "is null");
        _unit = unit;
        _state = state;
        _engine = new GameRuleEngine(state);
    }

    /**
     * Runs game
     */
    public void Run() {
        //Spieler 1 fängt immer zuerst an
        Player player = Player.Player1;
        while (true) {
            try {
                Input input = _unit.read(player);
                _engine.apply(input);
                _unit.print(_state);
                player = (player == Player.Player1 ? Player.Player2 : Player.Player1);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
