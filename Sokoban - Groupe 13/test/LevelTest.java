
import org.junit.jupiter.api.Test;

import SAE.module.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import static SAE.module.GameRepresentation.*;
import static SAE.module.GameRepresentation.EMPTY;

/*
public class LevelTest {

    private Level l;

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

    @Test
    public void Constructor1(){
        Player p = new Player(1 , 3,false);

        ArrayList<Crate> crates = new ArrayList<Crate>();
        Crate c = new Crate( 3 , 4);
        crates.add(c);


        ArrayList<Goal> goals = new ArrayList<Goal>();
        goals.add(new Goal(new Point(0,3)));

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
        assertEquals(l.isValidMove(0,3),false);

    }
    @Test
    public void TestMove() {
        GameRepresentation[][] expectedField = {
                {WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL},
                {WALL, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, WALL},
                {WALL, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, CRATE, EMPTY, WALL},
                {WALL, EMPTY, EMPTY, EMPTY, PLAYER, EMPTY, EMPTY, EMPTY, WALL},
                {WALL, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, WALL},
                {WALL, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, WALL},
                {WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL}
        };

    }



        
    }

    }
    @Test
    public void Constructor2() throws IllegalAccessException {
        Player p = new Player(1 , 3,false);

        ArrayList<Crate> crates = new ArrayList<Crate>();
        Crate c = new Crate( 3 , 4);
        crates.add(c);


        ArrayList<Goal> goals = new ArrayList<Goal>();
        goals.add(new Goal(new Point(0,3)));

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
        assertEquals(l.isValidMove(0,3),false);
        for(int i = 0; i < GameRepresentation.l);

        l.move(Direction.RIGHT);

    }
}
*/

