public abstract class Movable extends GameElement{
    protected boolean immutable;

    public abstract void Movable(int col, int lig , boolean immutable);

    public abstract void Movable(Point p);

    public abstract void Movable(int col , int lig);

    public abstract void moveTo(int col , int lig);

    public abstract void moveTo(Point p);
}
