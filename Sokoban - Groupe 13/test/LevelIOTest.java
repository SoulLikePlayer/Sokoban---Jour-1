import SAE.exception.FileFormatException;
import SAE.module.*;

import static SAE.module.GameRepresentation.*;
import static org.junit.Assert.*;
import org.junit.Test;
import java.io.*;

public class LevelIOTest {

    @Test
    public void testReadLevel() {
        String filePath = "C:\\Users\\Louis\\Desktop\\SAE2.03\\sae-2-03-final\\Sokoban - Groupe 13\\levels\\levels\\niveau01.xsb";

        try (InputStream inputStream = new FileInputStream(filePath)) {
            Level level = LevelIO.readLevel(inputStream);

            // Vérification que le niveau est non nul
            assertNotNull("Level should not be null", level);

            // Vérification des caractéristiques du niveau
            assertEquals("Incorrect number of columns", 9, level.getNbColumns());
            assertEquals("Incorrect number of lines", 7, level.getNbLines());

            // Vérification de la représentation du niveau
            GameRepresentation[][] expectedField = {
                    {EMPTY, WALL, WALL, WALL, WALL, WALL, EMPTY, EMPTY, EMPTY},
                    {WALL,WALL,WALL,EMPTY,EMPTY,WALL,WALL,WALL,WALL},
                    {WALL,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,CRATE,EMPTY,WALL},
                    {WALL,EMPTY,WALL,EMPTY,EMPTY,WALL,CRATE,EMPTY,WALL},
                    {WALL, EMPTY, GOAL, EMPTY, GOAL, WALL, PLAYER, EMPTY,WALL},
                    {WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL},
                    {EMPTY, EMPTY, EMPTY, WALL,WALL, EMPTY,EMPTY,EMPTY,EMPTY}
            };
            assertEquals(true, expectedField[0][0] == EMPTY);
            assertEquals(true, expectedField[0][1] == WALL);
            assertEquals(true, expectedField[3][6] == CRATE);
            assertEquals(true, expectedField[4][6] == PLAYER);
        } catch (IOException e) {
            fail("Exception thrown while reading level file: " + e.getMessage());
        } catch (FileFormatException e) {
            throw new RuntimeException(e);
        }
    }
}
