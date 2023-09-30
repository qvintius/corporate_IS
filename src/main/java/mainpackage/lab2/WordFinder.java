package mainpackage.lab2;

import jakarta.inject.Inject;
import mainpackage.lab2.service.IWordFinder;

public class WordFinder {
    @Inject
    private IWordFinder iWordFinder;//точка внедрения
    public boolean strFind(String str, String word){
        return iWordFinder.find(str, word);
    }
}