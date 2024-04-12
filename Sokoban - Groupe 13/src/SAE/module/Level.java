package SAE.module;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Collection;

public class Level {

    private final GameRepresentation[][] field;
    private final Player player;
    private final List<Crate> crates;
    private final List<Goal> goals;
    private final int nbLines;
    private final int nbColumns;

    public Level(Player player, Collection<Crate> crates, Collection<Goal> goals, GameRepresentation[][] field) {
        this.player = player;
        this.crates = new ArrayList<>(crates);
        this.goals = new ArrayList<>(goals);
        this.field = field;
        this.nbLines = field.length;
        this.nbColumns = field[0].length;
    }

    public void move(Direction dir) {
        // implémentation de la logique de déplacement
    }

    public void reset() {
        // implémentation de la logique de réinitialisation
    }

    public void changeEmptyToOutside() {
        // implémentation de la logique de changement des cases EMPTY en MAZE_OUTSIDE
    }

    public boolean over() {
        // implémentation de la logique de vérification de fin de niveau
        return false; // à remplacer par la logique appropriée
    }

    public GameRepresentation getRepr(int row, int col) {
        return field[row][col];
    }

    public List<Crate> getCrates() {
        return Collections.unmodifiableList(crates);
    }

    public List<Goal> getGoals() {
        return Collections.unmodifiableList(goals);
    }
}
