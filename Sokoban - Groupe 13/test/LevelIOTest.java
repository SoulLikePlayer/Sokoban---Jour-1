import SAE.exception.FileFormatException;
import SAE.module.*;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LevelIOTest {

    @Test
    public void testReadWriteMinimalLevel() {
        // Création d'un niveau minimal
        GameRepresentation[][] field = {{GameRepresentation.EMPTY}};
        Level level = new Level(new Player(0, 0), new ArrayList<>(), new ArrayList<>(), field);

        assertLevelReadWrite(level);
    }

    @Test
    public void testReadEmptyFile() {
        File emptyFile = createTempFile("");
        assertThrows(FileFormatException.class, () -> LevelIO.readLevel(new FileInputStream(emptyFile)));
    }

    @Test
    public void testReadNonExistentFile() {
        assertThrows(FileNotFoundException.class, () -> LevelIO.readLevel(new FileInputStream("nonexistent.txt")));
    }


    @Test
    public void testReadCorruptedFile() {
        File corruptedFile = createTempFile("123\n456\n789");
        assertThrows(FileFormatException.class, () -> LevelIO.readLevel(new FileInputStream(corruptedFile)));
    }


    @Test
    public void testWriteReadOnlyFile() {
        // Création d'un niveau de test
        GameRepresentation[][] field = {{GameRepresentation.EMPTY}};
        Level level = new Level(new Player(0, 0), new ArrayList<>(), new ArrayList<>(), field);

        // Création d'un fichier temporaire en lecture seule
        File readOnlyFile = createTempFile("");
        readOnlyFile.setReadOnly();

        // On s'attend à ce qu'une exception de type RuntimeException soit levée
        assertThrows(RuntimeException.class, () -> LevelIO.saveLevel(level, readOnlyFile));
    }


    // Méthode utilitaire pour lire et écrire un niveau et valider les résultats
    private void assertLevelReadWrite(Level level) {
        // Fichier temporaire pour le test
        File tempFile = createTempFile("");

        try {
            // Écriture du niveau dans le fichier temporaire
            LevelIO.saveLevel(level, tempFile);

            // Lecture du niveau à partir du fichier temporaire
            Level loadedLevel = LevelIO.readLevel(new FileInputStream(tempFile));

            // Vérification des données chargées
            assertEquals(level.getNbLines(), loadedLevel.getNbLines());
            assertEquals(level.getNbColumns(), loadedLevel.getNbColumns());
            for (int row = 0; row < level.getNbLines(); row++) {
                for (int col = 0; col < level.getNbColumns(); col++) {
                    assertEquals(level.getRepr(row, col), loadedLevel.getRepr(row, col));
                }
            }
        } catch (IOException | FileFormatException e) {
            e.printStackTrace();
            fail("Exception occurred during test: " + e.getMessage());
        } finally {
            // Suppression du fichier temporaire
            if (!tempFile.delete()) {
                System.err.println("Failed to delete temporary file: " + tempFile);
            }
        }
    }

    // Méthode utilitaire pour créer un fichier temporaire avec un contenu spécifié
    private File createTempFile(String content) {
        try {
            File tempFile = File.createTempFile("testLevel", ".txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            writer.write(content);
            writer.close();
            return tempFile;
        } catch (IOException e) {
            e.printStackTrace();
            fail("Failed to create temporary file: " + e.getMessage());
            return null;
        }
    }

    @Test
    public void testSaveLevel() {
        // Création d'un niveau de test
        GameRepresentation[][] field = {
                {GameRepresentation.EMPTY, GameRepresentation.WALL, GameRepresentation.GOAL},
                {GameRepresentation.CRATE, GameRepresentation.PLAYER, GameRepresentation.GOAL},
                {GameRepresentation.EMPTY, GameRepresentation.WALL, GameRepresentation.GOAL}
        };
        Level level = new Level(new Player(1, 1), new ArrayList<>(), new ArrayList<>(), field);

        // Fichier temporaire pour le test
        File tempFile = createTempFile("");

        try {
            // Sauvegarde du niveau dans le fichier temporaire
            LevelIO.saveLevel(level, tempFile);

            // Lecture du contenu du fichier temporaire
            BufferedReader reader = new BufferedReader(new FileReader(tempFile));
            List<String> lines = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            reader.close();

            // Vérification du contenu
            assertEquals("3", lines.get(0)); // Nombre de colonnes
            assertEquals("3", lines.get(1)); // Nombre de lignes
            assertEquals(" #.", lines.get(2)); // Première ligne du champ de jeu
            assertEquals("$@.", lines.get(3)); // Deuxième ligne du champ de jeu
            assertEquals(" #.", lines.get(4)); // Troisième ligne du champ de jeu
        } catch (IOException e) {
            e.printStackTrace();
            fail("Exception occurred during test: " + e.getMessage());
        } finally {
            // Suppression du fichier temporaire
            if (!tempFile.delete()) {
                System.err.println("Failed to delete temporary file: " + tempFile);
            }
        }
    }

}
