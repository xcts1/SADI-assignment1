package EnrolmentSystem;

import java.util.Scanner;

public class StudentEnrolment {

    private Student student;
    private Course course;
    private String semester;
    StudentList studentList;
    CourseList courseList;

    // getters and setters
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    // constructors
    public StudentEnrolment(Student student, Course course, String semester) {
        this.student = student;
        this.course = course;
        this.semester = semester;
    }

    @Override
    public String toString() {
        return "StudentEnrolment{" +
                "student=" + student +
                ", course=" + course +
                ", semester='" + semester + '\'' +
                '}';
    }

    public StudentEnrolment addNewEnrolment(){
        Scanner input = new Scanner(System.in);
        System.out.println("Start adding an enrolment...");
        StudentEnrolment studentEnrolment = null;
        System.out.print("Please enter the student id: ");
        studentEnrolment.setStudent(studentList.get(input.nextLine()));
        System.out.print("Please enter the semester: ");
        studentEnrolment.setSemester(input.nextLine());
        System.out.print("Please enter the course id: ");
        studentEnrolment.setCourse(courseList.get(input.nextLine()));
        return studentEnrolment;
    }
}
