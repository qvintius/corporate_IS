package mainpackage.lab3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Exam {
    private String name;
    private Teacher teacher;
    private int mark;

    public Exam(String name, Teacher teacher) {
        this.name = name;
        this.teacher = teacher;
        this.mark = 0;//default
    }
}
