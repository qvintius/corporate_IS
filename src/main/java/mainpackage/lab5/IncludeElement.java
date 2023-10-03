package mainpackage.lab5;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD, METHOD, TYPE, PARAMETER, ANNOTATION_TYPE, CONSTRUCTOR})
@Retention(RUNTIME)
@Constraint(validatedBy = {InclElemValidator.class})
public @interface IncludeElement {
    String message() default "{lab5.length.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    int value() default 5;

    @Target({METHOD, TYPE, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
    @Retention(RUNTIME)
    @interface List{
        int[] value();
    }
}
