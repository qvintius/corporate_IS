package mainpackage.lab5;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//класс валидации
public class InclElemValidator implements ConstraintValidator<IncludeElement, Integer> {
    private int value;
    // создаем список из массива
    List<Integer> numbers = new ArrayList<Integer>(Arrays.asList(0,18,99));
    @Override
    public void initialize(IncludeElement constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return numbers.contains(value);
    }
}
