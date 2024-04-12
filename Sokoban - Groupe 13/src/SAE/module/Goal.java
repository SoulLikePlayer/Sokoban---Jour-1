package SAE.module;

import SAE.module.GameElement;

public class Goal extends GameElement {
    public Goal(int col, int lig) {
        super(col, lig);
    }

    public Goal(Point p) {
        super(p);
    }
}