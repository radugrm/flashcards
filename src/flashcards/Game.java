package flashcards;

import flashcards.enums.State;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

public class Game {
    private Deck deck;
    private State state;
    private boolean isOn = true;
    private String cardTermToAdd;
    private int numberOfQuestions;
    private Map.Entry<String, String> card;
    private Logger logger = new Logger();
    private String exportFileName = null;

    public Game(String importFileName, String exportFileName) {
        deck = new Deck();
        state = State.MAIN_MENU;
        numberOfQuestions = 0;
        this.exportFileName = exportFileName;
        if (importFileName != null) {
            processImportCards(importFileName);
        } else {
            logger.log(DisplayUtils.printMainMenuText());
        }
    }

    public void processInput(String input) {
        logger.log(input + "\n");
        state.moveOn(this, input);
    }

    public void processMainMenu(String input) {
        switch (input.toLowerCase()) {
            case "add":
                logger.log(DisplayUtils.printAskCardTermText());
                state = State.ADD_TERM;
                break;
            case "remove":
                logger.log(DisplayUtils.printAskCardTermText());
                state = State.REMOVE;
                break;
            case "import":
                logger.log(DisplayUtils.printAskFileName());
                state = State.IMPORT;
                break;
            case "export":
                logger.log(DisplayUtils.printAskFileName());
                state = State.EXPORT;
                break;
            case "ask":
                logger.log(DisplayUtils.printHowManyTimesToAsk());
                state = State.ASK;
                break;
            case "exit":
                logger.log(DisplayUtils.printAdiosMessage());
                if (exportFileName != null && exportFileName.trim().length() != 0) {
                    exportToFile(exportFileName);
                }
                isOn = false;
                break;
            case "hardest card":
                logger.log(DisplayUtils.printHardestCards(deck.getHardestCards(), deck.getMaxMistakes()));
                changeStateToMainMenu();
                break;
            case "reset stats":
                deck.resetStats();
                logger.log(DisplayUtils.printStatsReset());
                changeStateToMainMenu();
                break;
            case "log":
                logger.log(DisplayUtils.printAskFileName());
                state = State.LOG;
                break;
        }
    }

    public void processAddTerm(String input) {
        if (deck.termExists(input)) {
            logger.log(DisplayUtils.printCardAlreadyExistsText(input));
            changeStateToMainMenu();
        } else {
            cardTermToAdd = input;
            state = State.ADD_DEFINITION;
            logger.log(DisplayUtils.printDisplayAddCardDefinitionInputText());
        }
    }

    public void processAddDefinition(String input) {
        if (deck.definitionExists(input)) {
            logger.log(DisplayUtils.printDefinitionAlreadyExistsText(input));
            cardTermToAdd = null;
        } else {
            deck.addCard(cardTermToAdd, input);
            logger.log(DisplayUtils.printCardAddedText(cardTermToAdd, input));
        }
        changeStateToMainMenu();
    }

    public void processRemoveCard(String input) {
        if (!deck.termExists(input)) {
            logger.log(DisplayUtils.printRemoveCardError(input));
        } else {
            deck.removeCardByTerm(input);
            logger.log(DisplayUtils.printRemoveCardSuccess());
        }
        changeStateToMainMenu();
    }

    public void processImportCards(String input) {
        try {
            int cardsImported = deck.importDeckFromFile(input);
            logger.log(DisplayUtils.printCardsImported(cardsImported));
        } catch (FileNotFoundException e) {
            logger.log(DisplayUtils.printFileNotFoundText());
            e.printStackTrace();
        }
        changeStateToMainMenu();
    }

    public void processExportCards(String input) {
        exportToFile(input);
        changeStateToMainMenu();
    }

    private void exportToFile(String input) {
        try {
            int cardsExported = deck.exportDeckToFile(input);
            logger.log(DisplayUtils.printCardsExported(cardsExported));
        } catch (IOException e) {
            logger.log(DisplayUtils.printExportFailedText());
            e.printStackTrace();
        }
    }

    public void processAsk(String input) {
        if (numberOfQuestions != 0) {
            if (card.getValue().equalsIgnoreCase(input)) {
                logger.log(DisplayUtils.printCorrectAnswerText());
            } else {
                if (deck.definitionExists(input)) {
                    logger.log(DisplayUtils.printIncorrectAnswerDefinitionExistsText(
                            card.getValue(),
                            deck.getActualTermForDefinition(input)));
                } else {
                    logger.log(DisplayUtils.printIncorrectAnswerText(card.getValue()));
                }
                deck.increaseMistakesOfCard(card.getKey());
            }
            numberOfQuestions--;
            if (numberOfQuestions == 0) {
                changeStateToMainMenu();
            } else {
                card = deck.getCard();
                logger.log(DisplayUtils.printDisplayCardTermText(card.getKey()));
            }
        } else {
            numberOfQuestions = Integer.parseInt(input);
            card = deck.getCard();
            logger.log(DisplayUtils.printDisplayCardTermText(card.getKey()));
        }
    }

    public void processLog(String input) {
        try {
            logger.exportLog(input);
            logger.log(DisplayUtils.printExportedLog());
        } catch (IOException e) {
            logger.log(DisplayUtils.printExportFailedText());
            e.printStackTrace();
        }
        changeStateToMainMenu();
    }

    public boolean isOn() {
        return isOn;
    }

    private void changeStateToMainMenu() {
        state = State.MAIN_MENU;
        logger.log(DisplayUtils.printMainMenuText());
    }
}
