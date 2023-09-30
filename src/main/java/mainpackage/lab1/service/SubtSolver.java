package mainpackage.lab1.service;

import mainpackage.lab1.qualifiers.MethodType;
import mainpackage.lab1.qualifiers.SolvingMethod;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;


@SolvingMethod(MethodType.SUBTITUTION)
public class SubtSolver implements ISolver{//подстановка
    @Override
    public Pair<Double, Double> solve(double kx1, double ky1, double a, double kx2, double ky2, double b) {

        //y=(b-kx2*x)/ky2;//выражение y из 2 уравнения и подставить в первое
        double x = (a - ky1/ky2 *b)/(kx1-ky1/ky2*kx2);//выраженный x из первого уравнения
        double y = (b-kx2*x)/ky2;

        return new ImmutablePair<>(x,y);
    }
}
