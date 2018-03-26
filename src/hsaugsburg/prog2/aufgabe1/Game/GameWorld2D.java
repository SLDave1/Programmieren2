package hsaugsburg.prog2.aufgabe1.Game;

/**
 * 2D world implementation of {@link GameWorld}
 * @author David
 * @author Markus
 */
public class GameWorld2D implements GameWorld {

    private final char[][] _world;

    /**
     * Creates custom game world
     * @param xLength
     * @param yLength
     */
    public GameWorld2D(int xLength, int yLength) {
        if (xLength < 0 || yLength < 0)
            throw new IllegalArgumentException();
        _world = new char[xLength][yLength];
        //TODO create world with right format
    }

    /**
     * Creates default 8 x 10 world
     */
    public GameWorld2D() {
        _world = new char[][] {
                { '1', '2', '3', '4', '5', '6', '7', '8' },
                { '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.' },
                { '1', '2', '3', '4', '5', '6', '7', '8' },
        };
    }

    /**
     * Returns current world state.
     * @return state
     */
    public char[][] getState() {
        return _world;
    }

    /**
     * Inserts X for specific {@link Coordinates}.
     * @param coord
     */
    public void setX(Coordinates coord) {
        if (coord == null)
            throw new IllegalArgumentException(Coordinates.class.getName() + "is null");
        Validate(coord.getxPos(), coord.getyPos());
        _world[coord.getxPos()][coord.getyPos()] = 'X';
    }

    /**
     * Inserts 0 for specific {@link Coordinates}.
     * @param coord
     */
    public void setO(Coordinates coord) {
        if (coord == null)
            throw new IllegalArgumentException(Coordinates.class.getName() + "is null");
        Validate(coord.getxPos(), coord.getyPos());
        _world[coord.getxPos()][coord.getyPos()] = 'O';
    }

    private void Validate(int xPos, int yPos) {
        boolean xPosInRange = (0 < xPos && xPos < _world[0].length);
        boolean yPosInRange = (0 < yPos && yPos < _world.length);
        boolean freeSpace = (_world[xPos][yPos] == '.');
        if (!xPosInRange || !yPosInRange)
            throw new IllegalArgumentException(String.format("Coordinates out of range. xPos: %s, yPos; %s", xPos, yPos));

        if (!freeSpace)
            throw new IllegalArgumentException(String.format("Space is already taken by the other player. xPos: %s, yPos; %s", xPos, yPos));
    }
}
