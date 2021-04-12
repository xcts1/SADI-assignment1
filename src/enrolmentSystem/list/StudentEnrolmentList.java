package enrolmentSystem.list;

import enrolmentSystem.Menu;
import enrolmentSystem.entity.Course;
import enrolmentSystem.entity.Student;
import enrolmentSystem.entity.StudentEnrolment;

import java.util.ArrayList;
import java.util.List;

public class StudentEnrolmentList implements StudentEnrolmentManager {

    static StudentList studentList = StudentList.getInstance();
    static CourseList courseList = CourseList.getInstance();

    private StudentEnrolmentList() {}

    private final List<StudentEnrolment> studentEnrolmentList = new ArrayList<>();
    private static final StudentEnrolmentList instance = new StudentEnrolmentList();
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
    public void update(StudentEnrolment oldStudentEnrolment, StudentEnrolment newStudentEnrolment) {
        if (this.add(newStudentEnrolment)){
            this.delete(oldStudentEnrolment);
            System.out.println("Enrolment information updated successfully");
        } else {
            System.out.println("Update fails. New enrolment information already exists.");
        }
    }

    @Override
    public void delete(StudentEnrolment studentEnrolment) {
        studentEnrolmentList.remove(studentEnrolment);
    }

    @Override
    public StudentEnrolment get(Student student, Course course, String semester) {
        for (StudentEnrolment se : studentEnrolmentList) {
            if (se.getStudent() == student
                    && se.getCourse() == course
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
            if (se.getStudent() == student
            && se.getCourse() == course
            && se.getSemester().equals(semester)) {
                return se;
            }
        }
        System.out.println("No such enrolment found.");
        return null;
    }

    @Override
    public String toString() {
        return "StudentEnrolmentList{" +
                "studentEnrolmentList=" + studentEnrolmentList +
                '}';
    }

    public List<Course> getCoursesOfStudentInSemester(Student student, String semester) {
        List<Course> courses = new ArrayList<>();
        for (StudentEnrolment se : studentEnrolmentList) {
            if (se.getStudent() == student && se.getSemester().equals(semester)){
                System.out.println(se.getCourse());
                courses.add(se.getCourse());
            }
        }
        return courses;
    }

    public List<Student> getStudentsOfCourseInSemester(Course course, String semester) {
        List<Student> students = new ArrayList<>();
        for (StudentEnrolment se : studentEnrolmentList) {
            if (se.getCourse() == course && se.getSemester().equals(semester)){
                System.out.println(se.getStudent());
                students.add(se.getStudent());
            }
        }
        return students;
    }

    public List<Course> getCoursesInSemester(String semester) {
        List<Course> courses = new ArrayList<>();
        for (StudentEnrolment se : studentEnrolmentList) {
            if (se.getSemester().equals(semester)){
                System.out.println(se.getCourse());
                courses.add(se.getCourse());
            }
        }
        return courses;
    }

    public boolean isEnrolled(StudentEnrolment studentEnrolment){
        for (StudentEnrolment se : studentEnrolmentList) {
            if (se.getStudent() == studentEnrolment.getStudent()
                    && se.getSemester().equals(studentEnrolment.getSemester())
                    && se.getCourse() == studentEnrolment.getCourse()){
                return true;
            }
        }
        return false;
    }
}
