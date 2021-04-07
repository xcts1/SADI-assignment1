package EnrolmentSystem;

import java.util.ArrayList;
import java.util.List;

public class StudentEnrolmentList implements StudentEnrolmentManager {

    private StudentEnrolmentList() {}

    private List<StudentEnrolment> studentEnrolmentList = new ArrayList<>();
    private static StudentEnrolmentList instance = new StudentEnrolmentList();
    public static StudentEnrolmentList getInstance() {
        return instance;
    }

//    public List<StudentEnrolment> getStudentEnrolmentList() {
//        return studentEnrolmentList;
//    }

    @Override
    public void getAll() {
        if (studentEnrolmentList.size() == 0) {
            System.out.println("No enrolment recorded !!!");
        } else {
            for (StudentEnrolment se: studentEnrolmentList)
                System.out.println(se.toString());
        }
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
    public void delete(String studentId, String courseId, String semester) {

    }

    @Override
    public StudentEnrolment getOne(String studentId, String courseId, String semester) {
        for (StudentEnrolment se : studentEnrolmentList) {
            if (se.getStudent().getStudentId().equals(studentId)
            && se.getCourse().getCourseId().equals(courseId)
            && se.getSemester().equals(semester)) {
                return se;
            }
        }
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
