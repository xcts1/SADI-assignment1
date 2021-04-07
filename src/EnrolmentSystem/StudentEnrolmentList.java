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
    public void add(StudentEnrolment studentEnrolment) {
        studentEnrolmentList.add(studentEnrolment);
        System.out.println("Enrolment added");
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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the student id");
        Student student = studentList.get(scanner.nextLine());
        System.out.println("Please enter the course id");
        Course course = courseList.get(scanner.nextLine());
        System.out.println("Please enter the semester");
        String semester = scanner.nextLine();
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
}
