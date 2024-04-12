package SAE.module;

/**
 * An enumeration that implements every possible types of a case on the game
 */
public enum GameRepresentation {

    PLAYER('@'),
    WALL('#'),
    GOAL('.'),
    CRATE('$'),
    PLAYER_ON_GOAL('+'),
    CRATE_ON_GOAL('*'),
    EMPTY(' '),
    MAZE_OUTSIDE('X');

    private final char character;

    /**
     * @param character The symbol that represents the value of the enumeration
     * The function returns the value of the corresponding Sakoban character
     */
    GameRepresentation(char character){
        this.character = character;
    }
}
