package mainpackage.lab3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class Applicant {//абитуриент
    private String name;
    private Faculty faculty;

    public Applicant(String name) {
        this.name = name;
    }

    private List<Exam> getExams(){
        return faculty.getExams();
    }

    public void addExam(Exam exam) {
        this.getExams().add(exam);
    }

    public float calculateAverageMark() {
        if (this.getExams().isEmpty()) {
            return 0;
        }

        int sum = 0;
        for (Exam exam : this.getExams()) {
            sum += exam.getMark();
        }

        return (float) sum / this.getExams().size();
    }

}
