package EnrolmentSystem;

import java.util.Scanner;

public class Menu {
    static StudentList studentList = StudentList.getInstance();
    static CourseList courseList = CourseList.getInstance();
    static StudentEnrolmentList studentEnrolmentList = StudentEnrolmentList.getInstance();

    private Menu() {}
    public static Menu instance = new Menu();
    public static Menu getInstance() {
        return instance;
    }

    public void function() {

        // the main menu when program loads
        MenuOptionList mainMenuOptionList = new MenuOptionList();
        mainMenuOptionList.add(new MenuOption("1", "Add new enrolment") {
            @Override
            public void doAction() {
                StudentEnrolment studentEnrolment = getUserInput();
                studentEnrolmentList.add(studentEnrolment);
                System.out.println("Enrolment added.");
                System.out.println(studentEnrolment);
            }
        });
        mainMenuOptionList.add(new MenuOption("2", "Update enrolment") {
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
        mainMenuOptionList.add(new MenuOption("3", "Get all enrolments") {
            @Override
            public void doAction() {
                studentEnrolmentList.getAll();
            }
        });
        mainMenuOptionList.add(new MenuOption("4", "Get one enrolment") {
            @Override
            public void doAction() {
                studentEnrolmentList.getOne();
            }
        });
        mainMenuOptionList.add(new MenuOption("5", "Generate enrolment reports") {
            @Override
            public void doAction() {
                System.out.println("1) View all courses for one student in a semester");
                System.out.println("2) View all students for one course in a semester");
                System.out.println("3) View all courses offered in a semester");
                int option = 0;
                do {
                    option = Option();
                } while (option < 1 || option > 3);

                switch (option) {
                    case 1:
                        Scanner scanner = new Scanner(System.in);
                        System.out.println("Please enter the student id");
                        Student student = studentList.get(scanner.nextLine());
                        System.out.println("Please enter the semester");
                        String semester = scanner.nextLine();
                        studentEnrolmentList.getCourseInASemester(student, semester);
                        break;
                    case 2:
                        scanner = new Scanner(System.in);
                        System.out.println("Please enter the course id");
                        Course course = courseList.get(scanner.nextLine());
                        System.out.println("Please enter the semester");
                        semester = scanner.nextLine();
                        studentEnrolmentList.getStudentInACourse(course, semester);
                        break;
                    case 3:
                        //test
                        break;
                }
            }
        });
        mainMenuOptionList.add(new MenuOption("6", "Exit") {
            @Override
            public void doAction() {
                mainMenuOptionList.loopUntilExit();
            }
        });
        mainMenuOptionList.loopUntilExit();
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

    public static StudentEnrolment getUserInput(){
        Scanner scanner = new Scanner(System.in);
        Student student = studentList.get(getStudentId());
        System.out.print("Please enter the semester: ");
        String semester = scanner.nextLine();
        Course course = courseList.get(getCourseId());
        return new StudentEnrolment(student, course, semester);
    }

    public static String getStudentId(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the student id: ");
        String input = scanner.nextLine();
        while (studentList.get(input) == null){
            System.out.println("No such student exists!!!");
            System.out.print("Please enter the student id: ");
            input = scanner.nextLine();
        }
        return input;
    }

    public static String getCourseId(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the course id: ");
        String input = scanner.nextLine();
        while (courseList.get(input) == null){
            System.out.println("No such course exists!!!");
            System.out.print("Please enter the course id: ");
            input = scanner.nextLine();
        }
        return input;
    }
}
