package mainpackage.lab1.service;

import jakarta.enterprise.inject.Alternative;
import mainpackage.lab1.qualifiers.Subt;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

//@Alternative
@Subt
public class SubtSolver implements ISolver{
    @Override
    public Pair<Double, Double> solve(double kx1, double ky1, double a, double kx2, double ky2, double b) {
        System.out.println("subt");

        //y=(b-kx2*x)/ky2;//выражение y из 2 уравнения и подставить в первое
        double x = (a - ky1/ky2 *b)/(kx1-ky1/ky2*kx2);//выраженный x из первого уравнения
        double y=(b-kx2*x)/ky2;

        //System.out.println("x=" + x + "; y=" + y);

        return new ImmutablePair<>(x,y);
    }
}
