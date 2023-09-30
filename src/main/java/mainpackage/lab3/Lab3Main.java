package mainpackage.lab3;

import mainpackage.lab3.dto.Applicant;
import mainpackage.lab3.dto.Exam;
import mainpackage.lab3.dto.Faculty;
import mainpackage.lab3.dto.Teacher;
import mainpackage.lab3.exampleEvents.Logger;
import mainpackage.lab3.service.RegistrationSystem;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import java.util.ArrayList;
import java.util.Arrays;

/*6. Разработать систему «Вступительные экзамены». Абитуриент регистрируется на Факультет, сдает Экзамены. Преподаватель
 выставляет Оценку. Система подсчитывает средний бал и определяет Абитуриента, зачисленного в учебное заведение*/
public class Lab3Main {
    private static Weld weld;
    private static WeldContainer container;

    public static void main( String[] args ) {
        weld = new Weld();
        container = weld.initialize();
        try {
            RegistrationSystem regSys = container.instance().select(RegistrationSystem.class).get();
            Teacher teacherIvanov = new Teacher("Ivanov");
            Teacher teacherPetrov = new Teacher("Petrov");
            Teacher teacherSidorov = new Teacher("Sidorov");
            Teacher teacherZhukov = new Teacher("Zhukov");

            Exam informatics = new Exam("Informatics", teacherIvanov);
            Exam mathematics = new Exam("Mathematics", teacherPetrov);
            Exam physics = new Exam("Physics", teacherSidorov);
            Exam language = new Exam("Language", teacherZhukov);

            Applicant applicantVasnetsov = new Applicant("Vasnetsov");
            Applicant applicantSharikov = new Applicant("Sharikov");
            Applicant applicantKrasnov = new Applicant("Krasnov");
            Applicant applicantPopov = new Applicant("Popov");

            Faculty facultyMaths = new Faculty("Applied Maths", Arrays.asList(informatics, mathematics, language));
            Faculty facultyProgramming = new Faculty("Programming", Arrays.asList(informatics, mathematics, language));
            Faculty facultyPhysics = new Faculty("Applied Physics", Arrays.asList(physics, mathematics, language));


            System.out.println("");



        } finally {
            container.shutdown();
        }
    }
}
