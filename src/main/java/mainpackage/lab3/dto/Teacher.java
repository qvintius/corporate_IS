package mainpackage.lab3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
public class Teacher {//преподаватель
    private String name;
    private List<Exam> exams;

    public Teacher(String name) {
        this.name = name;
    }
}