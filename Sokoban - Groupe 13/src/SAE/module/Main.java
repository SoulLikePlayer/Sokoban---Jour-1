package SAE.module;

import SAE.exception.FileFormatException;
import SAE.view.View;
import SAE.controller.*;

import java.io.*;

/**
 * Class that runs the game
 */
public class Main {
    public static void main(String[] args) throws FileFormatException, FileNotFoundException {
        Game jeu = new Game();
        jeu.run();
    }
}
