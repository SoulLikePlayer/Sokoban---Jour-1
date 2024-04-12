package SAE.module;

import SAE.exception.FileFormatException;
import SAE.view.View;

import java.io.*;

public class Main {
    public static void main(String[] args) throws FileFormatException, FileNotFoundException {
        // Path of the file containing the level
        String filePath = "C:\\Users\\Louis\\Desktop\\SAE2.03\\sae-2-03-final\\Sokoban - Groupe 13\\levels\\levels\\niveau01.xsb";

        // Read of the level from the file
        try (InputStream inputStream = new FileInputStream(filePath)) {
            Level level = LevelIO.readLevel(inputStream);
            View view = new View();

            // Display of the level
            System.out.println("Level read from file:");
            view.levelToGridStr(level);

            // Save of the level in a new file
            LevelIO.saveLevel(level, new File("new_level.txt"));
            System.out.println("Level saved to new file: new_level.txt");
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filePath);

        } catch (IOException e) {
            System.err.println("Error closing file: " + e.getMessage());
        }
    }
}
