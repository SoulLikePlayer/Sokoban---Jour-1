package SAE.controller;

import SAE.exception.FileFormatException;
import SAE.module.*;
import SAE.view.*;
import java.io.*;
import java.util.Scanner;

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
                System.out.println("Entrez une direction (RIGHT, LEFT, UP, DOWN) :");

                // Attendre que l'utilisateur entre une direction
                String input = scanner.nextLine();
                Direction direction = null;
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
                    default:
                        System.out.println("Direction invalide. Utilisez RIGHT, LEFT, UP ou DOWN.");
                }

                // Si une direction valide a été entrée, effectuer le mouvement
                if (direction != null) {
                    level.move(direction);
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
