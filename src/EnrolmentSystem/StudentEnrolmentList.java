package EnrolmentSystem;

import java.util.ArrayList;
import java.util.List;

public class StudentEnrolmentList implements StudentEnrolmentManager {

    private StudentEnrolmentList() {
    }

    private List<StudentEnrolment> studentEnrolmentList = new ArrayList<>();
    private static StudentEnrolmentList instance = new StudentEnrolmentList();

    public static StudentEnrolmentList getInstance() {
        return instance;
    }

    public List<StudentEnrolment> getStudentEnrolmentList() {
        return studentEnrolmentList;
    }

    @Override
    public List<StudentEnrolment> getAll() {
        return null;
    }

    @Override
    public void add(StudentEnrolment studentEnrolment) {
        studentEnrolmentList.add(studentEnrolment);
        System.out.println("Enrolment added");
    }

    @Override
    public void update(StudentEnrolment studentEnrolment) {

    }

    @Override
    public void delete(StudentEnrolment studentEnrolment) {

    }

    @Override
    public StudentEnrolment getOne(String studentId, String semester) {
        return null;
    }

    @Override
    public String toString() {
        return "StudentEnrolmentList{" +
                "studentEnrolmentList=" + studentEnrolmentList +
                '}';
    }

    public void getCourseInASemester(Student student, String semester) {
        for (StudentEnrolment sc : studentEnrolmentList) {
            if (sc.getStudent().equals(student) && sc.getSemester().equals(semester)){
                System.out.println(sc.getCourse());
            }
        }
    }
}
