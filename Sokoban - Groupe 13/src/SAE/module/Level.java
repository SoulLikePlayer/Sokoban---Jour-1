package SAE.module;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Collection;

public class Level {

    private final GameRepresentation[][] field;
    private final Player player;
    private final Point playerOrigin;
    private final List<Crate> crates;
    private final List<Point> crateOrigins;
    private final List<Goal> goals;
    private final int nbLines;
    private final int nbColumns;

    public Level(Player player, Point playerOrigin, Collection<Crate> crates, Collection<Point> crateOrigins, Collection<Goal> goals, GameRepresentation[][] field) {
        this.player = player;
        this.playerOrigin = playerOrigin;
        this.crates = new ArrayList<>(crates);
        this.crateOrigins = new ArrayList<>(crateOrigins);
        this.goals = new ArrayList<>(goals);
        this.field = field;
        this.nbLines = field.length;
        this.nbColumns = field[0].length;
    }

    // Méthode pour déplacer le joueur et éventuellement une caisse dans la direction donnée
    public void move(Direction dir) {
        int newCol = player.getCol();
        int newRow = player.getLig();

        switch (dir) {
            case UP:
                newRow--;
                break;
            case DOWN:
                newRow++;
                break;
            case LEFT:
                newCol--;
                break;
            case RIGHT:
                newCol++;
                break;
        }

        // Vérifie si le déplacement est valide
        if (isValidMove(newCol, newRow)) {
            player.moveTo(newCol, newRow);

            // Vérifie s'il y a une caisse à la nouvelle position et la déplace si nécessaire
            for (Crate crate : crates) {
                if (crate.getCol() == newCol && crate.getLig() == newRow) {
                    int crateNewCol = crate.getCol() + (newCol - player.getCol());
                    int crateNewRow = crate.getLig() + (newRow - player.getLig());
                    if (isValidMove(crateNewCol, crateNewRow)) {
                        crate.moveTo(crateNewCol, crateNewRow);
                    }
                    break; // On suppose qu'une seule caisse peut être poussée à la fois
                }
            }
        }
    }

    // Vérifie si un déplacement aux coordonnées spécifiées est valide
    private boolean isValidMove(int col, int row) {
        return col >= 0 && col < nbColumns && row >= 0 && row < nbLines && field[row][col] != GameRepresentation.WALL;
    }

    // Réinitialise la position du joueur et des caisses
    public void reset() {
        player.moveTo(playerOrigin); // Réinitialise la position du joueur à son origine

        // Réinitialise la position de chaque crate à son origine
        for (int i = 0; i < crates.size(); i++) {
            crates.get(i).moveTo(crateOrigins.get(i));
        }
    }

    // Transforme les cases EMPTY non accessibles en MAZE_OUTSIDE
    public void changeEmptyToOutside() {
        for (int row = 0; row < nbLines; row++) {
            for (int col = 0; col < nbColumns; col++) {
                if (field[row][col] == GameRepresentation.EMPTY && !isAccessible(col, row)) {
                    field[row][col] = GameRepresentation.MAZE_OUTSIDE;
                }
            }
        }
    }

    // Vérifie si toutes les caisses sont sur des objectifs
    public boolean over() {
        for (Crate crate : crates) {
            boolean crateOnGoal = false;
            for (Goal goal : goals) {
                if (goal.getCol() == crate.getCol() && goal.getLig() == crate.getLig()) {
                    crateOnGoal = true;
                    break;
                }
            }
            if (!crateOnGoal) {
                return false;
            }
        }
        return true;
    }

    // Renvoie la GameRepresentation aux coordonnées spécifiées
    public GameRepresentation getRepr(int row, int col) {
        return field[row][col];
    }

    // Renvoie une liste non modifiable des caisses
    public List<Crate> getCrates() {
        return Collections.unmodifiableList(crates);
    }

    // Renvoie une liste non modifiable des objectifs
    public List<Goal> getGoals() {
        return Collections.unmodifiableList(goals);
    }

    // Vérifie si une case aux coordonnées spécifiées est accessible par le joueur ou une caisse
    private boolean isAccessible(int col, int row) {
        return playerCanAccess(col, row) || crateCanAccess(col, row);
    }

    // Vérifie si une case aux coordonnées spécifiées est occupée par le joueur
    private boolean playerCanAccess(int col, int row) {
        return player.getCol() == col && player.getLig() == row;
    }

    // Vérifie si une case aux coordonnées spécifiées est occupée par une caisse
    private boolean crateCanAccess(int col, int row) {
        for (Crate crate : crates) {
            if (crate.getCol() == col && crate.getLig() == row) {
                return true;
            }
        }
        return false;
    }
}
