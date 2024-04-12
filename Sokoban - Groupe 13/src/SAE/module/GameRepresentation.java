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

    public final char character;

    /**
     * @param character The symbol that represents the value of the enumeration
     * The function returns the value of the corresponding Sakoban character
     */
    GameRepresentation(char character){

        this.character = character;
    }

    public static GameRepresentation fromCharachter(char c){
        if ( c == '@'){
            return PLAYER;
        }if( c == '#'){
            return WALL;
        }if (c == '.'){
            return GOAL;
        }if (c == '$'){
            return CRATE;
        }if (c == '+'){
            return PLAYER_ON_GOAL;
        }if (c == '*'){
            return CRATE_ON_GOAL;
        }if (c == 'X'){
            return MAZE_OUTSIDE;
        }
        return EMPTY;
    }
}
