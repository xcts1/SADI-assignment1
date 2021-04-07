package EnrolmentSystem;

public class Main {

    public static void main(String[] args) {
	// write your code here
        StudentList studentList = StudentList.getInstance();
        CourseList courseList = CourseList.getInstance();
        StudentEnrolmentList studentEnrolmentList = StudentEnrolmentList.getInstance();
        Student s1 = new Student("s1", "Minh", "16/08/1993");
        Student s2 = new Student("s2", "Linh", "16/08/1993");
        Student s3 = new Student("s3", "Trinh", "16/08/1993");
        studentList.getStudentList().add(s1);
        studentList.getStudentList().add(s2);
        studentList.getStudentList().add(s3);

        Course c1 = new Course("c1", "Programming1", 12);
        Course c2 = new Course("c2", "Programming2", 12);
        Course c3 = new Course("c3", "Programming2", 12);
        courseList.getCourseList().add(c1);
        courseList.getCourseList().add(c2);
        courseList.getCourseList().add(c3);
        //studentEnrolmentManager.add();
        MenuFunction menuFunction = MenuFunction.getInstance();
        System.out.println("Welcome to Enrolment System");
        menuFunction.function();
    }
}
