package SAE.module;

import SAE.module.GameElement;

public abstract class Movable extends GameElement {
    private boolean immutable;

    /**
     *
     * @param col Parameter "line" of the piece you want to move
     * @param lig Parameter "column" of the piece you want to move
     * @param immutable
     */
    public Movable(int col, int lig , boolean immutable){
        super(col, lig);
        this.immutable = immutable;

    }

    public  Movable(Point p){
        super(p);
    }

    public Movable(int col, int lig ){
        super(col, lig);

    }


    public abstract void moveTo(int col , int lig);


    public abstract void moveTo(Point p);


    public boolean getImmutable(){
        return immutable;
    }

    public void setImmutable(boolean immutable) {
        this.immutable = immutable;
    }
}




