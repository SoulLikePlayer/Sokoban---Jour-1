public enum GameRepresentation {

    PLAYER('@'),
    WALL('#'),
    TARGET('.'),
    BOX('$'),
    PLAYER_ON_TARGET('+'),
    BOX_ON_TARGET('*'),
    EMPTY(' '),
    EMPTY_EXTERIOR('X');

    GameRepresentation(char character){
        this.character = character;
    }
}
