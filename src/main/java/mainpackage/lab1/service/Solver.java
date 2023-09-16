package mainpackage.lab1.service;

import jakarta.inject.Inject;
import mainpackage.lab1.qualifiers.Subt;
import org.apache.commons.lang3.tuple.Pair;
import mainpackage.lab1.interceptors.Solved;
import mainpackage.lab1.qualifiers.Sum;

public class Solver {
    @Inject @Subt  //точка внедрения
    private ISolver iSolver;
    @Solved //перехватчик
    public Pair<Double, Double> solve(double kx1, double ky1, double a, double kx2, double ky2, double b){
        return iSolver.solve(kx1, ky1, a, kx2, ky2, b);
    }
}
