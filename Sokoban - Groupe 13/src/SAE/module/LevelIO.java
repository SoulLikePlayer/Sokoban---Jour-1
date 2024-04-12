package SAE.module;

import SAE.exception.FileFormatException;

import java.io.*;

public abstract class LevelIO {
    public Level readLevel(InputStream input) throws FileFormatException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
            // Lire le nombre de colonnes et de lignes du niveau depuis le fichier
            int columns = Integer.parseInt(reader.readLine());
            int rows = Integer.parseInt(reader.readLine());

            // Lire le dessin du niveau depuis le fichier et le stocker dans un tableau
            GameRepresentation[][] field = new GameRepresentation[rows][columns];
            for (int i = 0; i < rows; i++) {
                String line = reader.readLine();
                if (line == null || line.length() != columns) {
                    throw new FileFormatException("Invalid level format.");
                }
                for (int j = 0; j < columns; j++) {
                    field[i][j] = GameRepresentation.valueOf(String.valueOf(line.charAt(j)));
                }
            }

            // Retourner un nouvel objet Level avec les données lues depuis le fichier
            return new Level(field);
        } catch (IOException | IllegalArgumentException | NullPointerException e) {
            throw new FileFormatException("Error reading level file.", e);
        }
    }

    public void saveLevel(Level level, File fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            // Écrire le nombre de colonnes et de lignes du niveau dans le fichier
            writer.write(String.valueOf(level.getNbColumns()));
            writer.newLine();
            writer.write(String.valueOf(level.getNbLines()));
            writer.newLine();

            // Écrire le dessin du niveau dans le fichier
            for (int i = 0; i < level.getNbLines(); i++) {
                for (int j = 0; j < level.getNbColumns(); j++) {
                    writer.write(level.getRepr(i, j).toString());
                }
                writer.newLine();
            }
        }
    }
}
