package mainpackage.lab3.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Event;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import mainpackage.lab3.dto.Applicant;
import mainpackage.lab3.dto.Exam;
import mainpackage.lab3.qualifiers.RegSysEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class RegSysHandler {//обработчик событий
    @Inject @RegSysEvent(RegSysEvent.EventType.RESULT)
    Event<Applicant> eventResult;


    private final List<Applicant> applicants = new ArrayList<>();

    public List<Applicant> getApplicants(){
        return applicants;
    }

    public void isRegistered(@Observes @RegSysEvent(RegSysEvent.EventType.REGISTER) Applicant applicant){
        if (applicants.contains(applicant))
            return;
        applicants.add(applicant);
        applicant.setStatus(Applicant.Status.REGISTERED);

    }


    //подсчет среднего балла
    public double calculateAvgScore(@Observes @RegSysEvent(RegSysEvent.EventType.SETMARK) Applicant applicant){
        int sum = 0;
        int count = 0;
        for (Exam e:applicant.getExams())
            if (e.getMark() != 0){
                sum +=e.getMark();
                count++;
            }
        double score = 0;
        if (count !=0)
            score =  (double) sum/count;
        applicant.setScore(score);
        if (count==3)//сданы все экзамены - вывести статус зачисления
            eventResult.fire(applicant);

        return score;

    }

    //статус зачисления
    private void isEnrolled(@Observes @RegSysEvent(RegSysEvent.EventType.RESULT) Applicant applicant) {
        if (applicant.getScore() > 3.5)
            applicant.setStatus(Applicant.Status.ENROLLED);
        else
            applicant.setStatus(Applicant.Status.NOTENROLLED);
    }


    @Override
    public String toString() {
        return "RegSysHandler{" +
                "applicants=\n" + applicants.stream().map(Applicant::toString).collect(Collectors.joining("\n")) +
                "\n}\n";
    }
}