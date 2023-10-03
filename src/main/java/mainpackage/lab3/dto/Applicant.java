package mainpackage.lab3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Applicant {//абитуриент
    private String name;
    private Faculty faculty;


    private List<Exam> exams = new ArrayList<>();
    private double score;
    private Status status;

    public Applicant(String name) {
        this.name = name;
        status = Status.NOTREGISTERED;
        score=0;
    }


    @AllArgsConstructor
    public enum Status{
        NOTREGISTERED ("не зарегестрирован"),
        REGISTERED("зарегестрирован"),
        NOTENROLLED("не зачислен"),
        ENROLLED("зачислен");

        private String value;

        @Override
        public String toString() {
            return "Status{" +
                    "value='" + value + '\'' +
                    '}';
        }
    }

}
