
import SAE.module.Crate;

import SAE.module.Goal;
import SAE.module.Point;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class GoalTest {

    @Test
    public void GoalTest_1(){
        Goal goal1 = new Goal(8,9);
        assertEquals(goal1.getCol(), 8);
        assertEquals(goal1.getLig(), 9);

        Point p = new Point( 4 , 5 );
        Goal goal2 = new Goal(p);
        assertEquals(goal2.getCol(),4);
        assertEquals(goal2.getLig(),5);

    }

}
