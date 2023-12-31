package mainpackage.lab1;

import org.apache.commons.lang3.tuple.Pair;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

/*Создать компонент CDI, выполняющий решения систем уравнений с двумя неизвестными различными способами (подстановкой, сложением).
Выбор способа решения должен быть реализован через указание соответствующей аннотации или посредством указания класса в XML файле.
Посредством перехватчиков провести сравнение по времени эффективности различных методов
 */
public class Lab1Main {
    private static Weld weld;
    private static WeldContainer container;

    public static void main( String[] args ) {
        weld = new Weld();
        container = weld.initialize();
        try{
            Solver solver = container.select(Solver.class).get();
            double kx1, ky1, kx2, ky2, a, b;
            kx1=5; ky1=-1; a=7;
            kx2=2; ky2=3; b=-10;

            double determinant = kx1 * ky2 - kx2 * ky1;
            if (determinant == 0)//если определитель 0
                System.out.println("Система уравнений не имеет решения");
            else {
                Pair<Double, Double> xy = (solver.solve(kx1, ky1, a, kx2, ky2, b));
                System.out.printf("x=%.3f y=%.3f\n", xy.getKey(), xy.getValue());
            }
        }
        finally {
            container.shutdown();
        }

    }
}