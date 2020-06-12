package flashcards;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int noOfCards = 0;
        List<FlashCard> flashCards = new ArrayList<>();
        DisplayUtils.noOfCardsText();
        noOfCards = reader.nextInt();
        reader.nextLine();
        for (int i = 0; i < noOfCards; i++) {
            DisplayUtils.displayCardTermInputText(i + 1);
            String term = reader.nextLine();
            DisplayUtils.displayCardDefinitionInputText(i + 1);
            String definition = reader.nextLine();
            flashCards.add(new FlashCard(term, definition));
        }
        for (int i = 0; i < noOfCards; i++) {
            FlashCard flashCard = flashCards.get(i);
            DisplayUtils.displayCardDefinitionText(flashCard);
            String definition = reader.nextLine();
            if (flashCard.checkDefinition(definition)) {
                DisplayUtils.correctAnswerText();
            } else {
                DisplayUtils.incorrectAnswerText(flashCard);
            }
        }
    }
}
