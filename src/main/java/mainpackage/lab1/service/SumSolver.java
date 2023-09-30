package mainpackage.lab1.service;

import mainpackage.lab1.qualifiers.MethodType;
import mainpackage.lab1.qualifiers.SolvingMethod;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

@SolvingMethod(MethodType.ADDITION)
public class SumSolver implements ISolver{//сложение
    @Override
    public Pair<Double, Double> solve(double kx1, double ky1, double a, double kx2, double ky2, double b) {
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
        double y = a/ky1;
        double x = (b-ky2*y)/kx2;

        return new ImmutablePair<>(x,y);
    }
}
