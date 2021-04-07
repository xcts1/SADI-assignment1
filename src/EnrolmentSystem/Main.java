package EnrolmentSystem;

public class Main {

    public static void main(String[] args) {
	// write your code here
        StudentList studentList = new StudentList();
        StudentEnrolmentManager studentEnrolmentManager = new StudentEnrolmentList();
        Student s1 = new Student("s1", "Minh", "16/08/1993");
        Student s2 = new Student("s2", "Linh", "16/08/1993");
        Student s3 = new Student("s3", "Trinh", "16/08/1993");
        studentList.getStudentList().add(s1);
        studentList.getStudentList().add(s2);
        studentList.getStudentList().add(s3);
        System.out.println(studentList);

        Course c1 = new Course("c1", "Programming1", 12);
        Course c2 = new Course("c2", "Programming2", 12);
        Course c3 = new Course("c3", "Programming2", 12);
        System.out.println(s1.toString());
        studentEnrolmentManager.add();

    }
}
