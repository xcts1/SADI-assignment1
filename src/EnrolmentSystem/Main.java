package EnrolmentSystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        StudentList studentList = StudentList.getInstance();
        CourseList courseList = CourseList.getInstance();
        StudentEnrolmentList studentEnrolmentList = StudentEnrolmentList.getInstance();

        //parsing a CSV file into Scanner class constructor
        Scanner sc = null;

        try {
            sc = new Scanner(new File("./src/data/default.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Do you want to load an external file instead?");
        }

        while (sc.hasNext())  //returns a boolean value
        {
            String line = sc.nextLine();
            String[] fields = line.split(",");
            studentList.getStudents().add(new Student(fields[0].replace("\uFEFF", "").toUpperCase().trim(), fields[1], fields[2]));

            try {
                courseList.getCourses().add(new Course(fields[3].toUpperCase().trim(), fields[4], Integer.parseInt(fields[5])));
            } catch (NumberFormatException e){
                e.printStackTrace();
                System.out.println("'" + line + "'"+ " is skipped. Reason: invalid number of credits.\n");
                continue;
            }

            studentEnrolmentList.add(new StudentEnrolment(studentList.get(fields[0].replace("\uFEFF", "").toUpperCase().trim()), courseList.get(fields[3].toUpperCase().trim()), fields[6].toUpperCase().trim()));
        }
        sc.close();  //closes the scanner
//        System.out.println(studentList);
//        System.out.println(courseList);

//        Menu menu = Menu.getInstance();
//        System.out.println("Welcome to Enrolment System");
//        menu.function();
        Menu menu = new Menu();
        menu.runMenu();
    }
}
