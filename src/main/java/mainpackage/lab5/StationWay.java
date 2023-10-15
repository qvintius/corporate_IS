package mainpackage.lab5;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mainpackage.lab5.testExample.NumericConstraint;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StationWay {
    @Positive(message = "Системный идентификатор должен быть больше 0")
    private int id;//системный идентификатор пути
    @NotBlank(message = "Идентификатор должен быть задан")
    private String idWay;//системный идентификатор пути
    @Positive(message="Идентификатор станции должен быть больше 0")
    private int idStation;//идентификатор станции
    @NotEmpty(message = "Наименование станции не должно быть пустым")
    @Size(min = 4, max = 255, message="Наименование станции должно быть в пределах от 4 до 255 символов")
    private String nameStation = null;//наименование станции

    @Range(min = 1, max = 10, message="Порядковый номер пути на станции должен быть не меньше 1 и не больше 10")
    private int nomWay = 0;//номер пути на станции

    @Pattern(regexp = "[0-9]{2}-[0-9]{2}-[0-9]{4}") //dd-MM-yyyy
    private String constructionDate;//дата постройки

    @Positive(message = "Длина для пути должна быть положительной")
    private double length = 0;//протяженность

    @IncludeElement
    private int purpose;//назначение: 0 - неопределено, 18 - главный, 99 - подъездной путь
}
