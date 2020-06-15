package flashcards;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        DisplayUtils.noOfCardsText();
        Deck deck = new Deck(reader.nextInt());
        reader.nextLine();
        int counter = 0;
        while (counter < deck.deckSize()) {
            DisplayUtils.displayCardTermInputText(counter + 1);
            while (true) {
                String term = reader.nextLine();
                if (deck.termExists(term)) {
                    DisplayUtils.termAlreadyExistsText(term);
                } else {
                    DisplayUtils.displayCardDefinitionInputText(counter + 1);
                    while (true) {
                        String definition = reader.nextLine();
                        if (deck.definitionExists(definition)) {
                            DisplayUtils.definitionAlreadyExistsText(definition);
                        } else {
                            deck.addCard(term, definition);
                            counter++;
                            break;
                        }
                    }
                    break;
                }
            }
        }

        for (Map.Entry<String, String> entry : deck.getTermMap().entrySet()) {
            DisplayUtils.displayCardTermText(entry.getKey());
            String definition = reader.nextLine();
            if (entry.getValue().equalsIgnoreCase(definition)) {
                DisplayUtils.correctAnswerText();
            } else {
                DisplayUtils.incorrectAnswerText(entry.getValue());
                if (deck.definitionExists(definition)) {
                    DisplayUtils.incorrectAnswerDefinitionExistsText(
                            entry.getValue(),
                            deck.getDefinitionMap().get(definition));
                } else {
                    DisplayUtils.incorrectAnswerText(entry.getValue());

                }
            }
        }
    }
}
