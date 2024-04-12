import SAE.module.Point;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @Test
    public void constructorTest(){
        Point p = new Point( 4 , 5 );
        assertEquals(p.col,  4);
        assertEquals(p.lig ,  5);
        assertEquals(p , new Point(4 , 5));
    }
}