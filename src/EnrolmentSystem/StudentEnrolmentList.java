package EnrolmentSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentEnrolmentList implements StudentEnrolmentManager {

    static StudentList studentList = StudentList.getInstance();
    static CourseList courseList = CourseList.getInstance();

    private StudentEnrolmentList() {}

    private List<StudentEnrolment> studentEnrolmentList = new ArrayList<>();
    private static StudentEnrolmentList instance = new StudentEnrolmentList();
    public static StudentEnrolmentList getInstance() {
        return instance;
    }

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
    public boolean add(StudentEnrolment studentEnrolment) {
        if (!isEnrolled(studentEnrolment)){
            studentEnrolmentList.add(studentEnrolment);
            return true;
        }
        return false;
    }

    @Override
    public void update(StudentEnrolment studentEnrolment) {

    }

    @Override
    public void delete(Student student, Course course, String semester) {
        System.out.println("Enrolment is successfully deleted");
        studentEnrolmentList.remove(get(student, course, semester));
    }

    @Override
    public StudentEnrolment get(Student student, Course course, String semester) {
        for (StudentEnrolment se : studentEnrolmentList) {
            if (se.getStudent().getStudentId().equals(student.getStudentId())
                    && se.getCourse().getCourseId().equals(course.getCourseId())
                    && se.getSemester().equals(semester)) {
                return se;
            }
        }
        return null;
    }

    @Override
    public StudentEnrolment getOne() {
        Student student = studentList.getStudent();
        Course course = courseList.getCourse();
        String semester = Menu.getSemester();
        for (StudentEnrolment se : studentEnrolmentList) {
            if (se.getStudent().getStudentId().equals(student.getStudentId())
            && se.getCourse().getCourseId().equals(course.getCourseId())
            && se.getSemester().equals(semester)) {
                System.out.println(se);
                return se;
            }
        }
        System.out.println("No such enrolment found");
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

    public void getStudentInACourse(Course course, String semester) {
        for (StudentEnrolment se : studentEnrolmentList) {
            if (se.getCourse().equals(course) && se.getSemester().equals(semester)){
                System.out.println(se.getStudent());
            }
        }
    }

    public boolean isEnrolled(StudentEnrolment studentEnrolment){
        for (StudentEnrolment se : studentEnrolmentList) {
            if (se.getStudent().equals(studentEnrolment.getStudent())
                    && se.getSemester().equals(studentEnrolment.getSemester())
                    && se.getCourse().equals(studentEnrolment.getCourse())){
                return true;
            }
        }
        return false;
    }
}
