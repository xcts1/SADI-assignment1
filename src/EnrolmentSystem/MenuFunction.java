package EnrolmentSystem;

import java.util.Arrays;
import java.util.Scanner;

public class MenuFunction {
    static StudentList studentList = StudentList.getInstance();
    static CourseList courseList = CourseList.getInstance();
    static StudentEnrolmentList studentEnrolmentList = StudentEnrolmentList.getInstance();

    private MenuFunction() {}
    public static MenuFunction instance = new MenuFunction();
    public static MenuFunction getInstance() {
        return instance;
    }

    public void function() {
        Menu mainMenu = new Menu();
        mainMenu.add(new MenuOption("1", "Add new enrolment") {
            @Override
            public void doAction() {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Please enter the student id");
                Student student = studentList.get(scanner.nextLine());
                System.out.println("Please enter the course id");
                Course course = courseList.get(scanner.nextLine());
                System.out.println("Please enter the semester");
                //String semester = scanner.nextLine();
                StudentEnrolment studentEnrolment = new StudentEnrolment(student,course,scanner.nextLine());
                studentEnrolmentList.add(studentEnrolment);
                System.out.println(studentEnrolmentList.toString());
            }
        });
        mainMenu.add(new MenuOption("2", "Update enrolment") {
            @Override
            public void doAction() {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Please enter the student id");
                Student student = studentList.get(scanner.nextLine());
                System.out.println("Please enter the semester");
                String semester = scanner.nextLine();
                studentEnrolmentList.getCourseInASemester(student, semester);
                System.out.println("1) Add new course");
                System.out.println("2) Delete a course");
                int option;
                do {
                    option = Option();
                } while (option < 1 || option > 2);

                switch (option) {
                    case 1:
                        System.out.println("Please enter the course you want to enroll");
                        Course course = courseList.get(scanner.nextLine());
                        StudentEnrolment studentEnrolment = new StudentEnrolment(student, course, semester);
                        studentEnrolmentList.add(studentEnrolment);
                        System.out.println("Successfully added new course enrolment");
                        studentEnrolmentList.getCourseInASemester(student, semester);
                        break;
                    case 2:
                        System.out.println("Please enter the course you want to delete");
                        course = courseList.get(scanner.nextLine());
                        studentEnrolmentList.delete(student, course, semester);
                        break;
                }
            }
        });
        mainMenu.add(new MenuOption("3", "Get all enrolments") {
            @Override
            public void doAction() {
                studentEnrolmentList.getAll();
            }
        });
        mainMenu.add(new MenuOption("4", "Get one enrolment") {
            @Override
            public void doAction() {
                studentEnrolmentList.getOne();
            }
        });
        mainMenu.add(new MenuOption("5", "Five time processes") {
            @Override
            public void doAction() {
            }
        });
        mainMenu.add(new MenuOption("6", "Rollback previous drawing result") {
            @Override
            public void doAction() {
            }
        });
        mainMenu.add(new MenuOption("7", "Exit") {
            @Override
            public void doAction() {
                mainMenu.loopUntilExit();
            }
        });
        mainMenu.loopUntilExit();
    }

    public static int Option() {
        int num = 0;
        boolean choice = false;
        do {
            System.out.print("Please enter your option: ");
            Scanner input = new Scanner(System.in);
            if (input.hasNextInt()) {
                num = input.nextInt();
                choice = true;
            } else {
                System.out.println("Please enter a valid option!");
            }
        } while (!choice);
        return num;
    }
}
