package SAE.module;

import SAE.exception.FileFormatException;

import java.io.*;

public abstract class LevelIO {

    @Override
    public Level readLevel(InputStream input) throws FileFormatException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
            int columns = Integer.parseInt(reader.readLine());
            int rows = Integer.parseInt(reader.readLine());
            char[][] layout = new char[rows][columns];

            for (int i = 0; i < rows; i++) {
                String line = reader.readLine();
                if (line == null || line.length() != columns) {
                    throw new FileFormatException("Invalid level format.");
                }
                layout[i] = line.toCharArray();
            }

            return new Level(columns, rows, layout);
        } catch (IOException | NumberFormatException e) {
            throw new FileFormatException("Error reading level file.", e);
        }
    }

    @Override
    public void saveLevel(Level level, File fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(String.valueOf(level.getColumns()));
            writer.newLine();
            writer.write(String.valueOf(level.getRows()));
            writer.newLine();

            for (char[] row : level.getLayout()) {
                writer.write(row);
                writer.newLine();
            }
        }
    }
}
