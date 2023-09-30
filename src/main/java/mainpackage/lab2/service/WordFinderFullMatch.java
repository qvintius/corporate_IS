package mainpackage.lab2.service;
import jakarta.enterprise.inject.Default;

@Default
public class WordFinderFullMatch implements IWordFinder {//полное совпадение слова
    @Override
    public boolean find(String str, String word) {
        String delimiterSymbols = "[\\.\\?\\!\\,\\:\\;\\-]";
        String[] sentence = str.replaceAll(delimiterSymbols, " ").split(" ");
        boolean isFound = false;
        for (String w : sentence)
            if (w.equals(word))
                isFound = true;
        return isFound;
    }
}