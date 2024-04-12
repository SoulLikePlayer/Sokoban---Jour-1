public class Point {
<<<<<<< HEAD
        final int col;
     final int lig;
=======
    final int col;
    final int lig;
>>>>>>> 3d54f92475470e46a6a5b2d84c37a5786da5da53

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
