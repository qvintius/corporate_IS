package mainpackage.lab1.service;

import org.apache.commons.lang3.tuple.Pair;

public interface ISolver {
    public Pair<Double, Double> solve(double kx1, double ky1, double a, double kx2, double ky2, double b);
}
