package hsaugsburg.prog2.aufgabe1.Game;

import hsaugsburg.prog2.aufgabe1.IO.Input;

/**
 * Manages state of {@link GameWorld} and {@link Score}
 * @author David
 * @author Markus
 */
public class GameState {

    private final GameWorld _world;

    private Score _score;

    /**
     * Create game state from {@link GameWorld} and {@link Score}
     * @param world
     * @param score
     */
    public GameState(GameWorld world, Score score) {
        if (world == null)
            throw new IllegalArgumentException(GameWorld.class.getName() + "is null");
        if (score == null)
            throw new IllegalArgumentException(Score.class.getName() + "is null");
        _world = world;
        _score = score;
    }

    /**
     * Returns game world.
     * @return GameWorld
     */
    public GameWorld getWorld() {
        return _world;
    }

    /**
     * Returns game score.
     * @return Score
     */
    public Score getScore() {
        return _score;
    }

    /**
     * Sets new score
     * @param score
     */
    public void setScore(Score score) {
        if (score == null)
            throw new IllegalArgumentException(Score.class.getName() + " is null");
        _score = score;
    }
}
