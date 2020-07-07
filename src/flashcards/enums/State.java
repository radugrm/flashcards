package flashcards.enums;

import flashcards.Game;

public enum State {
    MAIN_MENU {
        @Override
        public void moveOn(Game game, String input) {
            game.processMainMenu(input);
        }
    },
    ADD_TERM {
        @Override
        public void moveOn(Game game, String input) {
            game.processAddTerm(input);
        }
    },
    ADD_DEFINITION {
        @Override
        public void moveOn(Game game, String input) {
            game.processAddDefinition(input);
        }
    },
    REMOVE {
        @Override
        public void moveOn(Game game, String input) {
            game.processRemoveCard(input);
        }
    },
    IMPORT {
        @Override
        public void moveOn(Game game, String input) {
            game.processImportCards(input);
        }
    },
    EXPORT {
        @Override
        public void moveOn(Game game, String input) {
            game.processExportCards(input, false);
        }
    },
    ASK {
        @Override
        public void moveOn(Game game, String input) {
            game.processAsk(input);
        }
    },
    LOG {
        @Override
        public void moveOn(Game game, String input) {
            game.processLog(input);
        }
    };

    public abstract void moveOn(Game game, String input);
}
