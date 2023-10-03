package mainpackage.lab4;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.ConstraintViolation;
import java.util.Set;
/*Описать класс СтанционныйПуть. С помощью стандартного API валидации с использованием стандартных аннотаций
произвести валидацию класса СтанционныйПуть. Валидацию провести с использованием аннотаций при описании
класса и с указанием ограничений в XML*/

public class Lab4Main {

    public static void main(String[] args) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();


        try {
            StationWay stWay = new StationWay();

            stWay.setId(1);
            stWay.setIdStation(-1);
            stWay.setNameStation("d");
            stWay.setNomWay(11);
            stWay.setConstructionDate("12-12-1999");
            stWay.setLength(0);
            stWay.setPurpose(null);
            Set<ConstraintViolation<StationWay>> violations1 = validator.validate(stWay);//отловить ошибки валидации
            System.out.println("");

            if (!violations1.isEmpty()) {
                for (ConstraintViolation<StationWay> violation : violations1) {
                    System.out.println(violation.getPropertyPath() + " " + violation.getMessage());
                }
            } else {
                System.out.println("Объект stationWay валиден");
            }
            System.out.println("");

            PureStationWay pureStWay = new PureStationWay();

            pureStWay.setId(2);
            pureStWay.setIdStation(-1);
            pureStWay.setNameStation("d");
            pureStWay.setNomWay(11);
            pureStWay.setConstructionDate("12-12-1999");
            pureStWay.setLength(0);
            pureStWay.setPurpose(null);
            Set<ConstraintViolation<PureStationWay>> violations2 = validator.validate(pureStWay);//отловить ошибки валидации

            if (!violations2.isEmpty()) {
                for (ConstraintViolation<PureStationWay> violation : violations2) {
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
