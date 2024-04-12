public class Point {
        final int col;
     final int lig;

    public Point(int col, int lig) {
        this.col = col;
        this.lig = lig;
    }

    @Override
    public boolean equals(Object obj) {
        // Vérifie si l'objet est une instance de Point
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        // Cast de l'objet en Point
        Point other = (Point) obj;

        // Compare les attributs col et lig
        return col == other.col && lig == other.lig;
    }

}
