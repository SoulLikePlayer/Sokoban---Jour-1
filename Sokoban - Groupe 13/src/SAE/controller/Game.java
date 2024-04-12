package SAE.controller;

import SAE.exception.FileFormatException;
import SAE.module.*;
import SAE.view.*;
import java.io.*;
import java.util.Scanner;

/**
 * Start a new game from the prompt wrote by the user
 * Play the game until the win
 */
public class Game {
    public void run() {

        View view = new View();
        System.out.printf("rentrez le nom de votre fichier : ");
        Scanner scanner = new Scanner(System.in);
        String filePath = scanner.next();
        // Read of the level from the file
        try (InputStream inputStream = new FileInputStream("Sokoban - Groupe 13/resources/levels/"+filePath)) {
            Level level = LevelIO.readLevel(inputStream);
            while (!level.over()) {
                view.levelToGridStr(level);
                System.out.println("Entrez une direction (RIGHT, LEFT, UP, DOWN) ou une commande (RESET, RESTART):");

                // Attendre que l'utilisateur entre une direction
                String input = scanner.nextLine();
                Direction direction = null;
                boolean restart = false;
                boolean reset = false;
                switch (input.toUpperCase()) {
                    case "RIGHT":
                        direction = Direction.RIGHT;
                        break;
                    case "LEFT":
                        direction = Direction.LEFT;
                        break;
                    case "UP":
                        direction = Direction.UP;
                        break;
                    case "DOWN":
                        direction = Direction.DOWN;
                        break;
                    case "RESTART" :
                        direction = null;
                        restart = true;
                    case "RESET" :
                        direction = null;
                        reset = true;
                    default:
                        System.out.println("Direction invalide. Utilisez RIGHT, LEFT, UP ou DOWN.");
                }

                // Si une direction valide a été entrée, effectuer le mouvement
                if (direction != null) {
                    level.move(direction);
                }
                if (reset == true){
                    level.resetTurn();
                    reset = false;
                }
                if (restart == true){
                    level.reset();
                    restart = false;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (FileFormatException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
