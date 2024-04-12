import java.util.Objects;

public abstract class GameElement {
    protected Point position;

    public GameElement(int col, int lig) {
        this.position = new Point(col, lig);
    }

    public GameElement(Point p) {
        this.position = p;
    }

    public int getCol() {
        return position.col;
    }

    public int getLig() {
        return position.lig;
    }

    @Override
    public String toString() {
        return "(" + position.col + ", " + position.lig + ")";
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        GameElement other = (GameElement) obj;

        return Objects.equals(position, other.position);
    }
}
