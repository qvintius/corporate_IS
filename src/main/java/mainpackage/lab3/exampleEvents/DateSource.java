package mainpackage.lab3.exampleEvents;

import jakarta.enterprise.inject.Alternative;
import java.util.Date;

public class DateSource {
    public String getDate() {
        return new Date().toString();//событие
    }
}
