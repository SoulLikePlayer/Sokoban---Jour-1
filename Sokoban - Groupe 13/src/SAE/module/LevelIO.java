package SAE.module;

import SAE.exception.FileFormatException;
import java.io.*;

public abstract class LevelIO {
    public Level readLevel(InputStream input) throws FileFormatException {
        //TODO : A IMPLEMENTER
    }

    public void saveLevel(Level level, File fileName) throws IOException {
        //TODO : A IMPLEMENTER
    }
}
