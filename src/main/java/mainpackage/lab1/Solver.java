package mainpackage.lab1;

import jakarta.inject.Inject;
import jakarta.interceptor.Interceptors;
import mainpackage.lab1.interceptors.SolverInterceptor;
import mainpackage.lab1.qualifiers.MethodType;
import mainpackage.lab1.qualifiers.SolvingMethod;
import mainpackage.lab1.service.ISolver;
import org.apache.commons.lang3.tuple.Pair;
@Interceptors(SolverInterceptor.class)
public class Solver {
    @Inject //точка внедрения
    @SolvingMethod(MethodType.SUBTITUTION)
    private ISolver iSolver;
    public Pair<Double, Double> solve(double kx1, double ky1, double a, double kx2, double ky2, double b){
        return iSolver.solve(kx1, ky1, a, kx2, ky2, b);
    }
}
