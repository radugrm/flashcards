package flashcards;

import java.io.FileWriter;
import java.io.IOException;

public class Logger {

    private static StringBuilder log;

    public Logger() {
        log = new StringBuilder();
    }

    public void log(String s) {
        log.append(s);
    }

    public void exportLog(String filename) throws IOException {
        FileWriter myWriter = new FileWriter(filename);
        myWriter.write(log.toString());
        myWriter.close();

    }
}
