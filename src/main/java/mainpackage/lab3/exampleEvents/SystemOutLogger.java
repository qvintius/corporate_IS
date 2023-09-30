package mainpackage.lab3.exampleEvents;

import jakarta.enterprise.inject.Alternative;
import jakarta.inject.Inject;
import mainpackage.lab3.exampleEvents.DateSource;
import mainpackage.lab3.exampleEvents.Logger;

@Alternative
public class SystemOutLogger implements Logger {
    @Inject
    private DateSource dateSource;


    @Override
    public void print(String message) {
        System.out.println(dateSource.getDate() + " : " + message);
    }
}
