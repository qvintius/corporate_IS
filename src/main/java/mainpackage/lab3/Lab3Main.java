package mainpackage.lab3;

import mainpackage.lab3.dto.Applicant;
import mainpackage.lab3.dto.Exam;
import mainpackage.lab3.dto.Faculty;
import mainpackage.lab3.service.RegSysHandler;
import mainpackage.lab3.service.RegistrationSystem;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import java.util.Arrays;

/*6. Разработать систему «Вступительные экзамены». Абитуриент регистрируется на Факультет, сдает Экзамены. Преподаватель
 выставляет Оценку. Система подсчитывает средний бал и определяет Абитуриента, зачисленного в учебное заведение*/
public class Lab3Main {

    public static void main( String[] args ) {
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();
        try {
            RegistrationSystem regSys = container.instance().select(RegistrationSystem.class).get();
            RegSysHandler regSysHandler = container.instance().select(RegSysHandler.class).get();

            //экзамены на факультетах
            Faculty facultyMaths = new Faculty("Applied Maths", Arrays.asList(
                    new Exam("Informatics"), new Exam("Mathematics"), new Exam("Language")));
            Faculty facultyPhysics = new Faculty("Applied Physics", Arrays.asList(
                    new Exam("Physics"), new Exam("Mathematics"), new Exam("Language")));



            Applicant applicantKapustin = new Applicant("Kapustin");
            regSys.registerApplicant(applicantKapustin, facultyMaths);
            regSys.markExam(applicantKapustin, new Exam("Mathematics"), 3);
            regSys.markExam(applicantKapustin, new Exam("Language"), 4);

            Applicant applicantVasnetsov = new Applicant("Vasnetsov");//абитуриент
            regSys.registerApplicant(applicantVasnetsov, facultyMaths);//регитрация на факультет
            regSys.markExam(applicantVasnetsov, new Exam("Informatics"), 3);//выставление оценок за экзамен
            regSys.markExam(applicantVasnetsov, new Exam("Mathematics"), 3);
            regSys.markExam(applicantVasnetsov, new Exam("Language"), 4);

            Applicant applicantSharikov = new Applicant("Sharikov");
            regSys.registerApplicant(applicantSharikov, facultyPhysics);
            regSys.markExam(applicantSharikov, new Exam("Physics"), 5);
            regSys.markExam(applicantSharikov, new Exam("Mathematics"), 4);
            regSys.markExam(applicantSharikov, new Exam("Language"), 5);

            System.out.println("");
            System.out.println(regSysHandler);

        } finally {
            container.shutdown();
        }
    }
}