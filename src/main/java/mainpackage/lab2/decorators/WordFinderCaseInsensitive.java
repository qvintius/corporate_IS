package mainpackage.lab2.decorators;

import jakarta.annotation.Priority;
import jakarta.decorator.Decorator;
import jakarta.decorator.Delegate;
import jakarta.inject.Inject;
import mainpackage.lab2.service.IWordFinder;

@Decorator @Priority(2)
public class WordFinderCaseInsensitive implements IWordFinder {//совпадение без учета регистра

    @Delegate @Inject
    private IWordFinder iWordFinder;

    public boolean find(String str, String word) {
        return iWordFinder.find(str.toLowerCase(), word.toLowerCase());
    }
}