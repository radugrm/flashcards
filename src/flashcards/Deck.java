package flashcards;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Deck {

    private Map<String, String> termMap;
    private Map<String, String> definitionMap;
    private int noOfCards;

    public Deck(int noOfCards) {
        this.noOfCards = noOfCards;
        termMap = new LinkedHashMap<>();
        definitionMap = new LinkedHashMap<>();
    }

    public int deckSize() {
        return noOfCards;
    }

    public boolean termExists(String term){
        return termMap.containsKey(term);
    }

    public boolean definitionExists(String definition){
        return definitionMap.containsKey(definition);
    }

    public void addCard(String term, String definition){
        termMap.put(term, definition);
        definitionMap.put(definition, term);
    }

    public Map<String, String> getTermMap() {
        return termMap;
    }
    public Map<String, String> getDefinitionMap() {
        return definitionMap;
    }

}
