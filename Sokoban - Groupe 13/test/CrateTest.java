
import SAE.module.Crate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CrateTest {

    @Test
    public void testCrate() {
        Crate c1 = new Crate(7, 5);
        assertEquals(c1.getLig(),5);
        assertEquals(c1.getCol(),7);

        Crate c2 = new Crate(7, 5, true);
        assertEquals(c2.getLig(),5);
        assertEquals(c2.getCol(),7);
        assertEquals(c2.getImmutable(), true);


        

    }



}
