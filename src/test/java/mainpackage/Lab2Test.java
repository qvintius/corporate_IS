package mainpackage;

import static org.junit.Assert.assertTrue;
import mainpackage.lab2.WordFinder;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.Test;

public class Lab2Test {
    private static Weld weld;
    private static WeldContainer container;

    String str = "Декоратор перехватывает вызовы только для определенного интерфейса Java и, " +
            "следовательно, знает всю семантику, связанную с этим интерфейсом.";
    private int decoratorsOn = 12;
    /* 0 - декораторы выключены
    1 - только caseInsensitive (без учета регистра)
    2 - только pieceWord (часть слова)
    12 - caseInsensitive, pieceWord приоритетность
    21 - pieceWord, caseInsensitive  приоритетность
    */
    @Test
    public void FindFullWord() {//точный ввод слова
        String word = "интерфейсом";
        try {
            weld = new Weld();
            container = weld.initialize();
            WordFinder wordFinder = container.instance().select(WordFinder.class).get();
            boolean foundedWords = wordFinder.strFind(str, word);
            System.out.println(foundedWords);

            assertTrue(foundedWords);

        } finally {
            container.shutdown();
        }
    }

    @Test
    public void FindFullWordCaseInsensitive() {//полное слово без учета регистра
        String word = "иНтЕрФеЙсОм";

        try {
            weld = new Weld();
            container = weld.initialize();
            WordFinder wordFinder = container.instance().select(WordFinder.class).get();
            boolean foundedWords = wordFinder.strFind(str, word);
            System.out.println(foundedWords);

            switch (decoratorsOn) {
                case 0:
                    assertTrue(!foundedWords);
                    break;
                case 1:
                    assertTrue(foundedWords);
                    break;
                case 2:
                    assertTrue(!foundedWords);
                    break;
                case 12:
                    assertTrue(foundedWords);
                    break;
                case 21:
                    assertTrue(foundedWords);
                    break;
                default:
                    assertTrue(false);
            }
        } finally {
            container.shutdown();
        }
    }

    @Test
    public void FindPartWord() {//часть слова
        String word = "интерфейс";
        try {
            weld = new Weld();
            container = weld.initialize();
            WordFinder wordFinder = container.instance().select(WordFinder.class).get();
            boolean foundedWords = wordFinder.strFind(str, word);
            System.out.println(foundedWords);
            switch (decoratorsOn) {
                case 0:
                    assertTrue(!foundedWords);
                    break;
                case 1:
                    assertTrue(!foundedWords);
                    break;
                case 2:
                    assertTrue(foundedWords);
                    break;
                case 12:
                    assertTrue(foundedWords);
                    break;
                case 21:
                    assertTrue(foundedWords);
                    break;
                default:
                    assertTrue(false);
            }
        } finally {
            container.shutdown();
        }
    }

    @Test
    public void FindPartWordCaseInsensitive() {//часть слова без учета регистра
        String word = "иНтЕрФеЙс";
        try {
            weld = new Weld();
            container = weld.initialize();
            WordFinder wordFinder = container.instance().select(WordFinder.class).get();
            boolean foundedWords = wordFinder.strFind(str, word);
            System.out.println(foundedWords);
            switch (decoratorsOn) {
                case 0:
                    assertTrue(!foundedWords);
                    break;
                case 1:
                    assertTrue(!foundedWords);
                    break;
                case 2:
                    assertTrue(!foundedWords);
                    break;
                case 12:
                    assertTrue(foundedWords);
                    break;
                case 21:
                    assertTrue(!foundedWords);
                    break;
                default:
                    assertTrue(false);
            }
        } finally {
            container.shutdown();
        }
    }

}
