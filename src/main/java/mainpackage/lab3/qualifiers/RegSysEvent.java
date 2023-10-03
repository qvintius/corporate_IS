package mainpackage.lab3.qualifiers;

import jakarta.inject.Qualifier;
import lombok.AllArgsConstructor;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Qualifier
@Retention(RUNTIME)
@Target({FIELD, METHOD, TYPE, PARAMETER})
public @interface RegSysEvent {
    EventType value();
    @AllArgsConstructor
    public enum EventType{
        REGISTER ("регистрация на факультет"),
        SETMARK ("поставить оценку"),
        RESULT ("результат зачисления");
        private String value;

    }
}
