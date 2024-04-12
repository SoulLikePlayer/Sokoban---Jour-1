import SAE.module.Player;
import SAE.module.Point;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;







public class PlayerTest {

    @Test
    public void Constructor(){
        Player p = new Player(1 , 2 );
        assertEquals(p.getCol() , 1);
        assertEquals(p.getLig(), 2);
        assertFalse(p.getLig()==7);


        Player p1 = new Player(1 , 2, false);
        assertEquals(p1.getCol() , 1);
        assertEquals(p1.getLig(), 2);
        assertFalse(p1.getLig()==7);
        assertEquals(p1.getImmutable(), false);


        Point pt = new Point(1,2);
        Player p2 = new Player(pt, false);
        assertEquals(p2.getCol() , 1);
        assertEquals(p2.getLig(), 2);
        assertFalse(p2.getLig()==7);
        assertEquals(p1.getImmutable(), false);

    }


}
