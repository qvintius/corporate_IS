package mainpackage.lab4;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PureStationWay {
    private int id;//системный идентификатор пути
    private String idWay;//идентификатор пути
    private int idStation;//идентификатор станции
    private String nameStation = null;//наименование станции
    private int nomWay = 0;//номер пути на станции
    private String constructionDate;//дата постройки
    private double length;//протяженность
    private String purpose;//назначение: неопределено, главный, подъездной путь
}
