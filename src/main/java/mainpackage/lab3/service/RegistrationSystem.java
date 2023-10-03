package mainpackage.lab3.service;

import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;
import mainpackage.lab3.dto.Applicant;
import mainpackage.lab3.dto.Exam;
import mainpackage.lab3.dto.Faculty;
import mainpackage.lab3.qualifiers.RegSysEvent;

import java.util.ArrayList;
import java.util.List;

public class RegistrationSystem { //регистрационная система
    List<Applicant> applicants = new ArrayList<>();
    @Inject @RegSysEvent(RegSysEvent.EventType.SETMARK)
    private Event<Applicant> eventMark;//добавление оценки
    @Inject @RegSysEvent(RegSysEvent.EventType.REGISTER)
    private Event<Applicant> eventApplicant;//регистрация абитуриента

    public void registerApplicant(Applicant applicant, Faculty faculty){
        applicant.setFaculty(faculty);//регистрация абитуриента на факультет
        eventApplicant.fire(applicant);
        applicants.add(applicant);
    }

    public void markExam(Applicant applicant, Exam exam, int mark){
        if (applicant.getFaculty() == null)//если выставление оценки незарегестрированному абитуриенту
            return;


        for (Exam e:applicant.getFaculty().getExams())
            if (e.getName().equals(exam.getName())) {
                exam.setMark(mark);
                applicant.getExams().add(exam);
                eventMark.fire(applicant);
            }
    }
}