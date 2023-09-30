package mainpackage.lab2;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

/* 6. Создать интерфейс Поиск слова в тексте, описывающий метод поиска слова в тексте. Создать класс, выполняющий поиск
 по полному совпадению с учётом регистра. Создать декоратор, выполняющий поиск по части слова и декоратор, выполняющий
 поиск без учёта регистра. Продемонстрировать поиск с различным набором декораторов
 */
public class Lab2Main {
    private static Weld weld;
    private static WeldContainer container;

    public static void main( String[] args ) {
        weld = new Weld();
        container = weld.initialize();
        try {
            String str = "Декоратор перехватывает вызовы только для определенного интерфейса Java и, " +
                    "следовательно, знает всю семантику, связанную с этим интерфейсом.";
            String word = "интерфейС";
            WordFinder wordFinder = container.instance().select(WordFinder.class).get();
            boolean isFound = wordFinder.strFind(str, word);
            System.out.println(isFound);

        } finally {
            container.shutdown();
        }
    }
}