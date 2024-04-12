import SAE.module.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class TestLevel {
    private Level level;

    @Before
    public void setUp() {
        // Création d'un niveau de test avec un joueur, des caisses, des objectifs et un terrain
        Player player = new Player(1, 1);
        Point playerOrigin = new Point(1, 1);
        Crate crate1 = new Crate(2, 2);
        Crate crate2 = new Crate(3, 3);
        Goal goal1 = new Goal(4, 4);
        Goal goal2 = new Goal(5, 5);
        GameRepresentation[][] field = {
                {GameRepresentation.WALL, GameRepresentation.WALL, GameRepresentation.WALL, GameRepresentation.WALL, GameRepresentation.WALL},
                {GameRepresentation.WALL, GameRepresentation.PLAYER, GameRepresentation.EMPTY, GameRepresentation.CRATE, GameRepresentation.WALL},
                {GameRepresentation.WALL, GameRepresentation.EMPTY, GameRepresentation.WALL, GameRepresentation.EMPTY, GameRepresentation.WALL},
                {GameRepresentation.WALL, GameRepresentation.CRATE, GameRepresentation.EMPTY, GameRepresentation.WALL, GameRepresentation.WALL},
                {GameRepresentation.WALL, GameRepresentation.WALL, GameRepresentation.WALL, GameRepresentation.WALL, GameRepresentation.WALL}
        };
        level = new Level();
    }

    @Test
    public void testMovePlayer() {
        // Vérifie que le joueur peut se déplacer vers une case vide
        level.move(Direction.RIGHT);
        assertEquals(2, player.getCol());
        assertEquals(1, player.getLig());
    }

    @Test
    public void testMoveCrate() {
        // Vérifie que le joueur peut pousser une caisse vers une case vide
        level.move(Direction.DOWN);
        assertEquals(1, level.getCrates().get(0).getCol());
        assertEquals(3, level.getCrates().get(0).getLig());
    }

    @Test
    public void testReset() {
        // Effectue un déplacement puis réinitialise le niveau
        level.move(Direction.RIGHT);
        level.reset();
        assertEquals(1, level.getPlayer().getCol());
        assertEquals(1, level.getPlayer().getLig());
        assertEquals(2, level.getCrates().get(0).getCol());
        assertEquals(2, level.getCrates().get(0).getLig());
    }

    @Test
    public void testChangeEmptyToOutside() {
        // Change les cases vides non accessibles en MAZE_OUTSIDE
        level.changeEmptyToOutside();
        assertEquals(GameRepresentation.MAZE_OUTSIDE, level.getRepr(2, 2));
    }

    @Test
    public void testOver() {
        // Vérifie que le jeu n'est pas terminé au début
        assertFalse(level.over());

        // Déplace les caisses sur les objectifs et vérifie que le jeu est terminé
        level.move(Direction.DOWN);
        level.move(Direction.DOWN);
        assertTrue(level.over());
    }
}
