package flashcards;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String importFileName = null;
        String exportFileName = null;
        for (int i = 0; i < args.length; i++) {
            if ("-import".equals(args[i]) && i+1 < args.length) {
                importFileName = args[i+1];
                i++;
            } else if ("-export".equals(args[i]) && i+1 < args.length) {
                exportFileName = args[i+1];
                i++;
            }
        }
        Game game = new Game(importFileName, exportFileName);
        while (game.isOn()) {
            game.processInput(reader.nextLine());
        }
    }
}
