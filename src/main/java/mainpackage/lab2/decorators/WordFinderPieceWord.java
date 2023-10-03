package mainpackage.lab2.decorators;

import jakarta.annotation.Priority;
import jakarta.decorator.Decorator;
import jakarta.decorator.Delegate;
import jakarta.inject.Inject;
import mainpackage.lab2.service.IWordFinder;
@Decorator @Priority(1)
public class WordFinderPieceWord implements IWordFinder {//совпадение части слова
    @Delegate @Inject
    private IWordFinder iWordFinder;

    @Override
    public boolean find(String str, String word) {
        return iWordFinder.find(str, word) || str.contains(word);
    }
}