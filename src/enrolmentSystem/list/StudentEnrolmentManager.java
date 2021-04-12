package enrolmentSystem.list;

import enrolmentSystem.entity.Course;
import enrolmentSystem.entity.Student;
import enrolmentSystem.entity.StudentEnrolment;

public interface StudentEnrolmentManager {
    void getAll();
    boolean add(StudentEnrolment studentEnrolment);
    void update(StudentEnrolment oldStudentEnrolment, StudentEnrolment newStudentEnrolment);
    void delete(StudentEnrolment studentEnrolment);
    StudentEnrolment get(Student student, Course course, String semester);

    StudentEnrolment getOne();

    String toString();

}
