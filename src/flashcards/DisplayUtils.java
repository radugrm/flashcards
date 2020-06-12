package flashcards;

import java.text.MessageFormat;

public class DisplayUtils {

    public static void noOfCardsText() {
        System.out.print("Input the number of cards:\n" +
                "> ");
    }

    public static void displayCardTermInputText(int cardNo) {
        System.out.print(MessageFormat.format("The card #{0} \n> ", cardNo));
    }

    public static void displayCardDefinitionInputText(int cardNo) {
        System.out.print(MessageFormat.format("The definition of the card #{0}: \n> ", cardNo));
    }

    public static void displayCardDefinitionText(FlashCard flashCard) {
        System.out.print(MessageFormat.format("Print the definition of \"{0}\": \n> ", flashCard.getTerm()));
    }

    public static void correctAnswerText() {
        System.out.println("Correct answer!");
    }

    public static void incorrectAnswerText(FlashCard flashCard) {
        System.out.println(MessageFormat.format("Wrong answer. The correct one is \"{0}\".",
                flashCard.getDefinition()));
    }
}
