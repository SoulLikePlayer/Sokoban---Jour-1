package SAE.module;

import SAE.exception.FileFormatException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class LevelIO {
    public static Level readLevel(InputStream input) throws FileFormatException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
            int nbColumns = Integer.parseInt(reader.readLine());
            int nbLines = Integer.parseInt(reader.readLine());

            GameRepresentation[][] field = new GameRepresentation[nbLines][nbColumns];

            List<Crate> crates = new ArrayList<>();
            List<Point> crateOrigins = new ArrayList<>();
            List<Goal> goals = new ArrayList<>();
            Player player = null;
            Point playerOrigin = null;

            for (int i = 0; i < nbLines; i++) {
                String line = reader.readLine();
                if (line == null) {
                    throw new FileFormatException("Unexpected end of file");
                }
                if (line.length() != nbColumns) {
                    throw new FileFormatException("Invalid number of characters in line " + (i + 3));
                }
                for (int j = 0; j < nbColumns; j++) {
                    char c = line.charAt(j);
                    GameRepresentation representation = GameRepresentation.fromCharachter(c);
                    field[i][j] = representation;
                    switch (representation) {
                        case PLAYER:
                            player = new Player(j, i);
                            playerOrigin = new Point(j, i);
                            break;
                        case CRATE:
                            crates.add(new Crate(j, i));
                            crateOrigins.add(new Point(j, i));
                            break;
                        case GOAL:
                            goals.add(new Goal(j, i));
                            break;
                    }
                }
            }

            if (player == null || playerOrigin == null) {
                throw new FileFormatException("Player not found in the level");
            }

            return new Level(player, crates, goals, field);
        } catch (IOException | NumberFormatException e) {
            throw new FileFormatException("Error reading level file: " + e.getMessage());
        }
    }

    public static void saveLevel(Level level, File fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(Integer.toString(level.getNbColumns()));
            writer.newLine();
            writer.write(Integer.toString(level.getNbLines()));
            writer.newLine();

            for (int i = 0; i < level.getNbLines(); i++) {
                for (int j = 0; j < level.getNbColumns(); j++) {
                    writer.write((level.getRepr(i, j)).character);
                }
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Error saving level to file: " + e.getMessage());
        }
    }
}
