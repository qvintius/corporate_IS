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
           StationWay stWay = new StationWay();

            stWay.setId(1);
            stWay.setIdWay("someId");
            stWay.setIdStation(111);
            stWay.setNameStation("dddd");
            stWay.setNomWay(10);
            stWay.setConstructionDate("12-12-1999");
            stWay.setLength(0.8);
            stWay.setPurpose(18);

            Set<ConstraintViolation<StationWay>> violations1 = validator.validate(stWay);//отловить ошибки валидации
            System.out.println("");

            if (!violations1.isEmpty()) {
                for (ConstraintViolation<StationWay> violation : violations1) {
                    System.out.println(violation.getPropertyPath() + " " + violation.getMessage());
                }
            } else {
                System.out.println("Объект stationWay валиден");
            }
        } finally {
            factory.close();
        }
    }
}