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

    GameRepresentation(char character){
        this.character = character;
    }
}
