package spell;

import java.io.IOException;

public class SpellCorrector implements ISpellCorrector {
    @Override
    public void useDictionary(String dictionaryFileName) throws IOException {
        //Use Scanner class
        //Make map from dictionary, key is word and value is frequency counts
    }

    @Override
    public String suggestSimilarWord(String inputWord) {
        //Check map if word is in there (not misspelled)
        //Generate a set of possible spellings for the word, starting with the edit distance 1 words
        //Check if any of the edit distance 1 words are in the dictionary, if more than 1, than use value counts, the tiebreakers
        //Generate set of edit distance 2 words - rerun the distance 1 algorithm on distance 1 words and union them
        //Check if any of them are in the dictionary
        return null;
    }
}
