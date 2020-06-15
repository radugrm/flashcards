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

    public static void displayCardTermText(String definition) {
        System.out.print(MessageFormat.format("Print the definition of \"{0}\": \n> ", definition));
    }

    public static void correctAnswerText() {
        System.out.println("Correct answer!");
    }

    public static void incorrectAnswerText(String definition) {
        System.out.println(MessageFormat.format("Wrong answer. The correct one is \"{0}\".",
                definition));
    }

    public static void termAlreadyExistsText(String term) {
        System.out.println(MessageFormat.format("The card \"{0}\" already exists. Try again: \n> ",
                term));
    }

    public static void definitionAlreadyExistsText(String definition) {
        System.out.println(MessageFormat.format("The definition \"{0}\" already exists. Try again: \n> ",
                definition));
    }

    public static void incorrectAnswerDefinitionExistsText(String correctDefinition, String guessedTerm) {
        System.out.println(MessageFormat.format("Wrong answer. The correct one is \"{0}\", you've just written the" +
                " definition of \"{1}}\".\n", correctDefinition, guessedTerm));
    }
}
