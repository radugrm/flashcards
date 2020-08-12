package flashcards;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.*;

public class Deck {

    private Map<String, String> termMap;
    private Map<String, String> definitionMap;
    private Map<String, Integer> mistakesMap;
    Iterator<Map.Entry<String, String>> termMapIterator;

    public Deck() {
        termMap = new LinkedHashMap<>();
        definitionMap = new LinkedHashMap<>();
        mistakesMap = new HashMap<>();
    }

    public boolean termExists(String term) {
        return termMap.containsKey(term);
    }

    public boolean definitionExists(String definition) {
        return definitionMap.containsKey(definition);
    }

    public void addCard(String term, String definition) {
        termMap.put(term, definition);
        definitionMap.put(definition, term);
        termMapIterator = null;
    }

    public void removeCardByTerm(String term) {
        String removedDefinition = termMap.remove(term);
        termMapIterator = null;
        definitionMap.remove(removedDefinition);
        mistakesMap.remove(term);
    }

    public int exportDeckToFile(String filename) throws IOException {
        FileWriter myWriter = new FileWriter(filename);
        try {
            Iterator<Map.Entry<String, String>> it = termMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, String> entry = it.next();
                Integer mistakes = mistakesMap.getOrDefault(entry.getKey(), 0);
                myWriter.write(String.format("%s:%s:%d", entry.getKey(), entry.getValue(), mistakes));
                if (it.hasNext()) {
                    myWriter.write("\n");
                }
            }
            return termMap.size();
        } finally {
            myWriter.close();
        }
    }

    public int importDeckFromFile(String filename) throws FileNotFoundException {
        Scanner myReader = new Scanner(new File(filename));
        int cardsImported = 0;
        while (myReader.hasNextLine()) {
            String[] line = myReader.nextLine().split(":");
            addCardFromImport(line[0], line[1], Integer.parseInt(line[2]));
            cardsImported++;
        }
        myReader.close();
        termMapIterator = null;
        return cardsImported;
    }

    public Map.Entry<String, String> getCard() {
        if (termMapIterator != null && termMapIterator.hasNext()) {
            return termMapIterator.next();
        }
        termMapIterator = termMap.entrySet().iterator();
        return termMapIterator.next();
    }

    public String getActualTermForDefinition(String definition) {
        return definitionMap.get(definition);
    }

    public void increaseMistakesOfCard(String term) {
        if (termMap.containsKey(term)) {
            mistakesMap.put(term, mistakesMap.getOrDefault(term, 0) + 1);
        }
    }

    public void resetStats() {
        mistakesMap = new HashMap<>();
    }

    public Integer getMaxMistakes() {
        return (mistakesMap == null || mistakesMap.isEmpty()) ? 0 : Collections.max(mistakesMap.values());
    }

    public List<String> getHardestCards() {
        Integer maxMistakes = getMaxMistakes();
        List<String> hardestCards = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : mistakesMap.entrySet()) {
            if (maxMistakes.equals(entry.getValue())) {
                hardestCards.add(entry.getKey());
            }
        }
        return hardestCards;
    }

    private void addCardFromImport(String term, String definition, Integer mistakes) {
        if (termMap.containsKey(term)) {
            String existingDefinition = termMap.get(term);
            definitionMap.remove(existingDefinition);
        }
        termMap.put(term, definition);
        definitionMap.put(definition, term);
        mistakesMap.put(term, mistakes);
    }
}
