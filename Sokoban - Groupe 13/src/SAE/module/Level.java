package SAE.module;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Collection;

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

    /**
     *
     * @param dir The direction of the movement
     * The method move the person towards the direction wanted
     */
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

        /**
         * Check if the move is legal
         */
        if (isValidMove(newCol, newRow)) {

            /**
             * Check if there's a box placed on the new position of the person, if this is the case, the box is moved
             */

            for (Crate crate : crates) {
                if (crate.getCol() == newCol && crate.getLig() == newRow) {
                    int crateNewCol = crate.getCol() + (newCol - player.getCol());
                    int crateNewRow = crate.getLig() + (newRow - player.getLig());
                    if (isValidMove(crateNewCol, crateNewRow) && field[crateNewRow][crateNewCol] != GameRepresentation.CRATE) {
                        crate.moveTo(crateNewCol, crateNewRow);
                        player.moveTo(newCol, newRow);
                    }
                    break; // Only a single box can be moved at once
                }
            }
        }
    }


    /**
     *
     * @param col The column where the person will be moved
     * @param row The row/line where the person will be moved
     * @return The method returns 'true' if the move is legal, 'false' if not
     */
    private boolean isValidMove(int col, int row) {
        return col >= 0 && col < nbColumns && row >= 0 && row < nbLines && field[row][col] != GameRepresentation.WALL ;
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
        return Collections.unmodifiableList(crates);
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
