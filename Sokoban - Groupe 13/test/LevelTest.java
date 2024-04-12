import SAE.module.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import static SAE.module.GameRepresentation.*;
import static SAE.module.GameRepresentation.EMPTY;

public class LevelTest {

    @Test
    public void Constructor(){
        Player p = new Player(2 , 2,false);

        ArrayList<Crate> crates = new ArrayList<Crate>();
        Crate c = new Crate( 3 , 3);
        crates.add(c);


        ArrayList<Goal> goals = new ArrayList<Goal>();
        goals.add(new Goal(new Point(6,6)));

        GameRepresentation[][] expectedField = {
                {EMPTY, WALL, WALL, WALL, WALL, WALL, EMPTY, EMPTY, EMPTY},
                {WALL,WALL,WALL,EMPTY,EMPTY,WALL,WALL,WALL,WALL},
                {WALL,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,CRATE,EMPTY,WALL},
                {WALL,EMPTY,WALL,EMPTY,EMPTY,WALL,CRATE,EMPTY,WALL},
                {WALL, EMPTY, GOAL, EMPTY, GOAL, WALL, PLAYER, EMPTY,WALL},
                {WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL},
                {EMPTY, EMPTY, EMPTY, WALL,WALL, EMPTY,EMPTY,EMPTY,EMPTY}
        };

        Level l = new Level(p,crates,goals,expectedField);

        assertEquals(l.getNbColumns(), 9);
        assertEquals(l.getNbLines(),7);
        assertEquals(l.getRepr(4,6), PLAYER);
        assertEquals(l.getRepr(2,6), CRATE);


    }
}
