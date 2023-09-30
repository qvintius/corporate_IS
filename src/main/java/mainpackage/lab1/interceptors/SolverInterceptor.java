package mainpackage.lab1.interceptors;

import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.InvocationContext;

public class SolverInterceptor {
    @AroundInvoke
    public Object myInterceptor(InvocationContext ic) throws Exception {
        long initTime = System.currentTimeMillis();
        try {
            return ic.proceed();//выполнение целевого метода
        } finally {
            long diffTime = System.currentTimeMillis() - initTime;
            System.out.println(ic.getMethod() + " took " + diffTime + " millis");//заняло времени
        }
    }
}
