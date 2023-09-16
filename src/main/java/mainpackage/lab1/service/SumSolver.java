package mainpackage.lab1.service;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;
import mainpackage.lab1.qualifiers.Sum;

import java.text.DecimalFormat;

//@Default
@Sum
//@Interceptors(SolverInterceptor.class)
public class SumSolver implements ISolver{
    @Override
    public Pair<Double, Double> solve(double kx1, double ky1, double a, double kx2, double ky2, double b) {
        System.out.println("sum");

        //коэффициент перед x уравнять со вторым уравнением, домножив первое уравнение на коэффициент c противоположным знаком(если они одинакового знака)
        ky1 = ky1/kx1 * kx2;
        a= a/kx1 * kx2;
        //kx1 = kx1/kx1 * kx2;//можно не считать, так как при сумме уравнений коэффициент будет 0 и x уйдёт
        if (kx1>0 && kx2>0 || kx1<0 && kx2<0){
            //kx1 = kx1 * (-1);
            ky1 = ky1 * (-1);
            a = a * (-1);
        }

        //сложение уравнений
        //kx1 = kx1 + kx2;
        ky1 = ky1 + ky2;
        a = a + b;

        //результат
        /*float x,y;
        y = (float) (a/ky1);
        x=(float) ((b-ky2*y)/kx2);*/


        double y = a/ky1;
        double x = (b-ky2*y)/kx2;
        //System.out.println("x=" + dF.format(x) + "; y=" + dF.format(y));
        //Pair<Double, Double> pair = new ImmutablePair<>(x,y);

        return new ImmutablePair<>(x,y);
    }
}
