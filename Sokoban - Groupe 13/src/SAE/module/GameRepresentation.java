package SAE.module;

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
