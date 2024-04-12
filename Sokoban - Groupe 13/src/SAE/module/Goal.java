package SAE.module;

import SAE.module.GameElement;

/**
 * This class store the position of the goals
 */
public class Goal extends GameElement {
    /**
     *
     * @param col The goal column of the move
     * @param lig The goal line of the move
     */
    public Goal(int col, int lig) {
        super(col, lig);
    }

    public Goal(Point p) {
        super(p);
    }

    @Override
    public int getCol() {
        return super.getCol();
    }

    @Override
    public int getLig() {
        return super.getLig();
    }
}