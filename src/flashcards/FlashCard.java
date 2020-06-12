package flashcards;

public class FlashCard {

    private String term;
    private String definition;


    public FlashCard(String term, String definition) {
        this.term = term;
        this.definition = definition;
    }

    public boolean checkDefinition(String definition) {
        return this.definition.equalsIgnoreCase(definition);
    }

    public String getTerm() {
        return term;
    }

    public String getDefinition() {
        return definition;
    }
}
