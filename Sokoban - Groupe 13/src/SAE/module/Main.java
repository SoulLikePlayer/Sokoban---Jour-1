package SAE.module;

import SAE.exception.FileFormatException;

import java.io.*;

public class Main {
    public static void main(String[] args) throws FileFormatException, FileNotFoundException {
        // Chemin du fichier contenant le niveau
        String filePath = "ENTREZ CHEMIN";

        // Lecture du niveau depuis le fichier
        try (InputStream inputStream = new FileInputStream(filePath)) {
            Level level = LevelIO.readLevel(inputStream);

            // Affichage du niveau
            System.out.println("Level read from file:");
            for (int row = 0; row < level.getNbLines(); row++) {
                for (int col = 0; col < level.getNbColumns(); col++) {
                    System.out.print(level.getRepr(row, col).character);
                }
                System.out.println();
            }

            // Sauvegarde du niveau dans un nouveau fichier
            LevelIO.saveLevel(level, new File("new_level.txt"));
            System.out.println("Level saved to new file: new_level.txt");
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filePath);

        } catch (IOException e) {
            System.err.println("Error closing file: " + e.getMessage());
        }
    }
}
