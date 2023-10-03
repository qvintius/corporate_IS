package mainpackage.lab5;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/*Вариант 6. Описать класс СтанционныйПуть. Поле Специализация класса СтанционныйПуть должно принимать одно из трёх
значений: 0 - неопределенно, 18 - главный путь, 99 - подъездной путь. Описать ограничение @IncludeElement, проверяющее
наличие значение в заданном множестве. Валидировать поле Специализация. Продемонстрировать работу с ограничением.
 */
public class Lab5Main {
    public static void main(String[] args) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        try {
            StationWay stationWay = new StationWay();
            //Set<ConstraintViolation<StationWay>> violations = validator.validate(stationWay);

        } finally {
            factory.close();
        }
    }
}
