package SAE.module;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Collection;

import static SAE.module.GameRepresentation.WALL;

/**
 * The class Level enables the game to run properly
 */
public class Level {

    private final GameRepresentation[][] field;
    private final Player player;
    private final Point playerOrigin;
    private final List<Crate> crates;
    private final List<Point> crateOrigins;
    private final List<Goal> goals;
    private final int nbLines;
    private final int nbColumns;

    public Level(Player player, Collection<Crate> crates, Collection<Goal> goals, GameRepresentation[][] field) {
        this.player = player;
        this.playerOrigin = player.position;
        this.crates = new ArrayList<>(crates);
        this.crateOrigins = new ArrayList<>();
        for (int i = 0 ; i < field.length - 1 ; i++) {
            for (int j = 0; j < field[0].length - 1; j++) {
                if (field[i][j] == GameRepresentation.CRATE) {
                    crateOrigins.add(new Point(i, j));
                }
            }
        }

        this.goals = new ArrayList<>(goals);
        this.field = field;
        this.nbLines = field.length;
        this.nbColumns = field[0].length;
        field[player.getLig()][player.getCol()] = GameRepresentation.PLAYER ;
        for(Crate crate : crates){
            field[crate.getLig()][crate.getCol()] = GameRepresentation.CRATE ;
        }
        for(Goal goal : goals){
            field[goal.getLig()][goal.getCol()] = GameRepresentation.GOAL;
        }
    }

    /**
     *
     * @param dir The direction of the movement
     * The method move the person towards the direction wanted
     */
    public void move(Direction dir) throws IllegalAccessException {
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

        // Vérifie si le mouvement est valide
        if (isValidMove(newCol, newRow)) {
            boolean bouge = true;

            // Parcourt toutes les caisses pour voir si elles doivent être déplacées
            for (Crate crate : crates) {
                // Vérifie si une caisse est à la position de destination
                if (crate.getCol() == newCol && crate.getLig() == newRow) {
                    bouge = false;
                    // Calcule les nouvelles positions pour la caisse
                    int crateNewCol = crate.getCol() + (newCol - player.getCol());
                    int crateNewRow = crate.getLig() + (newRow - player.getLig());
                    // Vérifie si la nouvelle position de la caisse est valide et libre
                    if (isValidMove(crateNewCol, crateNewRow) && field[crateNewRow][crateNewCol] != GameRepresentation.CRATE) {
                        // Déplace la caisse et le joueur
                        crate.moveTo(crateNewCol, crateNewRow);
                        if (field[crateNewRow][crateNewCol] == GameRepresentation.GOAL){
                            field[crateNewRow][crateNewCol] = GameRepresentation.CRATE_ON_GOAL;
                        }else{
                            field[crateNewRow][crateNewCol] = GameRepresentation.CRATE;
                        }
                        if (field[player.getLig()][player.getCol()] == GameRepresentation.CRATE_ON_GOAL){
                            field[player.getLig()][player.getCol()] = GameRepresentation.GOAL;
                        }else{
                            field[player.getLig()][player.getCol()] = GameRepresentation.EMPTY;
                        }
                        if (field[newRow][newCol] == GameRepresentation.CRATE_ON_GOAL) {
                            // Modifie le GameElement de la case GOAL en PLAYER_ON_GOAL
                            field[newRow][newCol] = GameRepresentation.PLAYER_ON_GOAL;
                        } else {
                            field[newRow][newCol] = GameRepresentation.PLAYER;
                            // Restaure la case GOAL à sa valeur d'origine si elle a été modifiée en PLAYER_ON_GOAL
                        }
                        player.moveTo(newCol, newRow);
                    }
                    break; // Seule une seule caisse peut être déplacée à la fois
                }
            }
            // Si le joueur peut bouger et il n'y a pas de caisse à déplacer
            if (bouge) {
                // Si la nouvelle position est une case GOAL
                if (field[newRow][newCol] == GameRepresentation.GOAL) {
                    // Modifie le GameElement de la case GOAL en PLAYER_ON_GOAL
                    field[newRow][newCol] = GameRepresentation.PLAYER_ON_GOAL;
                } else {
                    field[newRow][newCol] = GameRepresentation.PLAYER;
                    // Restaure la case GOAL à sa valeur d'origine si elle a été modifiée en PLAYER_ON_GOAL
                }
                // Déplace le joueur
                if (field[player.getLig()][player.getCol()] == GameRepresentation.PLAYER_ON_GOAL) {
                    field[player.getLig()][player.getCol()] = GameRepresentation.GOAL;
                }
                else{
                    field[player.getLig()][player.getCol()] = GameRepresentation.EMPTY;
                }
                player.moveTo(newCol, newRow);
            }
        }
    }








    /**
     *
     * @param col The column where the person will be moved
     * @param row The row/line where the person will be moved
     * @return The method returns 'true' if the move is legal, 'false' if not
     */
    public boolean isValidMove(int col, int row) {
        return col >= 0 && col < nbColumns && row >= 0 && row < nbLines && field[row][col] != WALL ;

    }

    /**
     * Clear the position of the person and the boxes
     */
    public void reset() {
        player.moveTo(playerOrigin); // Move the person at his original position

        // Move every crate at their original positions
        for (int i = 0; i < crates.size(); i++) {
            crates.get(i).moveTo(crateOrigins.get(i));
        }
    }

    // Tranform EMPTY non-accesible cases to MAZE_OUTSIDE cases
    public void changeEmptyToOutside() {
        for (int row = 0; row < nbLines; row++) {
            for (int col = 0; col < nbColumns; col++) {
                if (field[row][col] == GameRepresentation.EMPTY && !isAccessible(col, row)) {
                    field[row][col] = GameRepresentation.MAZE_OUTSIDE;
                }
            }
        }
    }

    // Check if all of the crates are on their final positions
    public boolean over() {
        int compt = 0;
        for (Crate crate : crates) {

            for (Goal goal : goals) {
                if (goal.getCol() == crate.getCol() && goal.getLig() == crate.getLig()) {
                    compt ++ ;
                }

            }

        }
        return compt == goals.size();
    }

    /**
     *
     * @param row The row that will be check
     * @param col The column that will be check
     * @return The method return the representation of the case
     */
    public GameRepresentation getRepr(int row, int col) {
        return field[row][col];
    }

    // Return the number of columns of the level
    public int getNbColumns() {
        return nbColumns;
    }

    // Return the number of lines of the level
    public int getNbLines() {
        return nbLines;
    }

    // Return a non-modifiable list of the crates
    public List<Crate> getCrates() {
        List list = Collections.unmodifiableList(crates);
        return list;
    }

    /**
     * Return a non-modifiable list of the goals
     */

    public List<Goal> getGoals() {
        return Collections.unmodifiableList(goals);
    }


    /**
     * @param col The number of the column that will be check
     * @param row The number of the line that will be check
     * @return Check if a case is accessible for a player or a crate on the specified coordinates
     */
    private boolean isAccessible(int col, int row) {
        return playerCanAccess(col, row) || crateCanAccess(col, row);
    }

    /**
     *
     * @param col
     * @param row
     * @return Return if the case specified is already taken by a player
     */
    private boolean playerCanAccess(int col, int row) {

        return player.getCol() == col && player.getLig() == row;
    }

    /**
     *
     * @param col
     * @param row
     * @return Return if the case specified is already taken by a player
     */
    private boolean crateCanAccess(int col, int row)

    {
        for (Crate crate : crates) {
            if (crate.getCol() == col && crate.getLig() == row) {
                return true;
            }
        }
        return false;
    }
}
