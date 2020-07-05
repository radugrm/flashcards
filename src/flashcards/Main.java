package flashcards;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Game game = new Game();
        while (game.isOn()) {
            game.processInput(reader.nextLine());
        }
    }
}
