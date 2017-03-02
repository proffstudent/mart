package main.common.utils;

import main.models.pojo.Lection;
import main.models.pojo.Student;
import main.services.StudentService;
import org.apache.log4j.Logger;

import java.util.List;


/**
 * Created by smoldyrev on 24.02.17.
 */
public class LectionNotificator {
    private static Logger logger = Logger.getLogger(LectionNotificator.class);

    public static void notifyByLection(Lection lection){
        List<Student> students =
            StudentService.getStudentsByGroupId(lection.getGroupid());
        logger.trace(students.size() + "founded");
        for (Student student:
             students) {
            Mailer.sendMail(student.getEmail(),"lection is neared", lection.getSubject());
        }
    }
}
