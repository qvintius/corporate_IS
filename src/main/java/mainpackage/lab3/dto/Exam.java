package mainpackage.lab3.dto;

import lombok.Data;

@Data
public class Exam {//экзамен
    private String name;
    private int mark;

    public Exam(String name) {
        this.name = name;
        this.mark = 0;//default
    }

    public Exam(String name, int mark){
        this.name = name;
        this.mark = mark;
    }

}