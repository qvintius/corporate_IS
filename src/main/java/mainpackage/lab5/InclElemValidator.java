package mainpackage.lab5;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InclElemValidator implements ConstraintValidator<IncludeElement, Integer> {

    Integer[] array = {0,18,99};
    // создаем список из массива
    List<Integer> numbers = new ArrayList<Integer>(Arrays.asList(array));
    @Override
    public void initialize(IncludeElement constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        //numbers.contains(constraintAnnotation.value());
        //numbers = (List<Integer>) constraintAnnotation.array();
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return numbers.contains(value);
    }
}
