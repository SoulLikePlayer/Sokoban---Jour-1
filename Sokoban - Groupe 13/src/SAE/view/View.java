package SAE.view;

import SAE.module.Level;

/**
 * Display the game
 */
public class View {
    public void levelToStr(Level l){
        for (int row = 0; row < l.getNbLines(); row++) {
            for (int col = 0; col < l.getNbColumns(); col++) {
                System.out.print(l.getRepr(row, col).character);
            }
            System.out.println();
        }
    }

    public void levelToGridStr(Level l) {
        for (int row = 0; row < l.getNbLines(); row++) {
            for (int col = 0; col < l.getNbColumns(); col++) {
                System.out.print(l.getRepr(row, col).character);

                // Ajouter un caractère de séparation entre les colonnes de la grille
                System.out.print(" ");
            }
            System.out.println();
            // Ajouter une ligne de séparation entre les lignes de la grille
            System.out.println("-".repeat(l.getNbColumns() * 2));
        }
    }
}
