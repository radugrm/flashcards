package flashcards;

import java.util.List;

public class DisplayUtils {

    public static String printAskCardTermText() {
        String s = "The card \n" +
                "> ";
        System.out.print(s);
        return s;
    }

    public static String printDisplayAddCardDefinitionInputText() {
        String s = "The definition of the card: \n" +
                "> ";
        System.out.print(s);
        return s;
    }

    public static String printDisplayCardTermText(String definition) {
        String s = String.format("Print the definition of \"%s\": %n> ", definition);
        System.out.print(s);
        return s;
    }

    public static String printCorrectAnswerText() {
        String s = "Correct answer!";
        System.out.print(s);
        return s;
    }

    public static String printIncorrectAnswerText(String definition) {
        String s = String.format("Wrong answer. The correct one is \"%s\".%n",
                definition);
        System.out.print(s);
        return s;
    }

    public static String printCardAlreadyExistsText(String term) {
       String s = String.format("The card \"%s\" already exists. Try again: %n> ",
                term);
       System.out.print(s);
       return s;
    }

    public static String printDefinitionAlreadyExistsText(String definition) {
        String s = String.format("The definition \"%s\" already exists. Try again: %n> ",
                definition);
        System.out.print(s);
        return s;
    }

    public static String printIncorrectAnswerDefinitionExistsText(String correctDefinition, String guessedTerm) {
        String s = String.format("Wrong answer. The correct one is \"%s\", you've just written the" +
                " definition of \"%s\".%n", correctDefinition, guessedTerm);
        System.out.print(s);
        return s;
    }

    public static String printMainMenuText() {
        String s = "Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats) \n" +
                "> ";
        System.out.print(s);
        return s;
    }

    public static String printCardAddedText(String term, String definition) {
        String s = String.format("The pair (\"%s\": \"%s\") has been added.%n", term, definition);
        System.out.print(s);
        return s;
    }


    public static String printRemoveCardSuccess() {
        String s = "The card has been removed\n";
        System.out.print(s);
        return s;
    }

    public static String printRemoveCardError(String term) {
        String s = String.format("Can't remove \"%s\": there is no such card", term);
        System.out.print(s);
        return s;
    }

    public static String printAskFileName() {
        String s = "Filename: \n> ";
        System.out.print(s);
        return s;
    }

    public static String printFileNotFoundText() {
        String  s = "File not found.";
        System.out.print(s);
        return s;
    }

    public static String printExportFailedText() {
        String s = "Export failed.\n ";
        System.out.print(s);
        return s;
    }

    public static String printHowManyTimesToAsk() {
        String s = "How many times to ask?\n" +
                "> ";
        System.out.print(s);
        return s;
    }

    public static String printCardsExported(int numberOfCards) {
        String s = String.format("%d cards have been saved.%n", numberOfCards);
        System.out.print(s);
        return s;
    }

    public static String printCardsImported(int numberOfCards) {
        String s = String.format("%d cards have been loaded.%n", numberOfCards);
        System.out.print(s);
        return s;
    }

    public static String printHardestCards(List<String> hardestCards, Integer maxMistakes) {
        String s;
        if (hardestCards == null || hardestCards.size() == 0) {
            s = String.format("There are no cards with errors.%n");
        } else if (hardestCards.size() == 1) {
            s = String.format("The hardest card is \"%s\". You have %d errors answering it.%n",
                    hardestCards.get(0), maxMistakes);
        } else {
            s = String.format("The hardest card is \"%s\". You have %d errors answering them.%n",
                    String.join("\", \"", hardestCards), maxMistakes);
        }
        System.out.print(s);
        return s;
    }

    public static String printAdiosMessage() {
        String s = "Bye bye!";
        System.out.println(s);
        return s;
    }

    public static String printExportedLog() {
        String s = "The log has been saved\n";
        System.out.print(s);
        return s;
    }

    public static String printStatsReset() {
        String s = "The stats have been reset.\n";
        System.out.print(s);
        return s;
    }
}
