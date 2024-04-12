package SAE.module;

import SAE.module.GameElement;

public abstract class Movable extends GameElement {
    private boolean immutable;

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

    public void setImmutable(boolean imu){
        this.immutable = imu;
    }
}
