package EnrolmentSystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        StudentList studentList = StudentList.getInstance();
        CourseList courseList = CourseList.getInstance();
        StudentEnrolmentList studentEnrolmentList = StudentEnrolmentList.getInstance();
//        Student s1 = new Student("s1", "Minh", "16/08/1993");
//        Student s2 = new Student("s2", "Linh", "16/08/1993");
//        Student s3 = new Student("s3", "Trinh", "16/08/1993");
//        studentList.getStudents().add(s1);
//        studentList.getStudents().add(s2);
//        studentList.getStudents().add(s3);

//        Course c1 = new Course("c1", "Programming1", 12);
//        Course c2 = new Course("c2", "Programming2", 12);
//        Course c3 = new Course("c3", "Programming2", 12);
//        courseList.getCourses().add(c1);
//        courseList.getCourses().add(c2);
//        courseList.getCourses().add(c3);
//        //studentEnrolmentManager.add();

        //parsing a CSV file into Scanner class constructor
        Scanner sc = null;
        try {
            sc = new Scanner(new File("./src/data/default.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Do you want to load an external file instead?");
        }
        //sc.useDelimiter(",");   //sets the delimiter pattern
        while (sc.hasNext())  //returns a boolean value
        {
            String line = sc.nextLine();
            System.out.println(line);
            String[] fields = line.split(",");
            studentList.getStudents().add(new Student(fields[0], fields[1], fields[2]));
            courseList.getCourses().add(new Course(fields[3], fields[4], Integer.parseInt(fields[5])));
            studentEnrolmentList.add(new StudentEnrolment(studentList.getStudent(fields[0]), courseList.get(fields[3]), fields[6]));
        }
        sc.close();  //closes the scanner
        System.out.println(studentList);
        System.out.println(courseList);

        Menu menu = Menu.getInstance();
        System.out.println("Welcome to Enrolment System");
        menu.function();
    }
}
