package enrolmentSystem;

import enrolmentSystem.entity.Course;
import enrolmentSystem.entity.Student;
import enrolmentSystem.entity.StudentEnrolment;
import enrolmentSystem.list.CourseList;
import enrolmentSystem.list.StudentEnrolmentList;
import enrolmentSystem.list.StudentList;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Menu {
    //Instance Variables
    static StudentList studentList = StudentList.getInstance();
    static CourseList courseList = CourseList.getInstance();
    static StudentEnrolmentList studentEnrolmentList = StudentEnrolmentList.getInstance();
    boolean exit;

    public void runMenu() {
        printHeader();
        while (!exit) {
            printMenu();
            int choice = getMenuChoice(0, 7);
            doAction(choice);
        }
    }

    private void printHeader() {
        System.out.println("Welcome to Student Enrolment System");
    }

    private void printMenu() {
        System.out.println("\n1) Add new enrolment");
        System.out.println("2) Edit an enrolment");
        System.out.println("3) View an enrolment");
        System.out.println("4) View all enrolments");
        System.out.println("5) Delete an enrolment");
        System.out.println("6) Update enrolments in a semester");
        System.out.println("7) View and generate enrolment report");
        System.out.println("0) Exit");
    }

    private static int getMenuChoice(int lowerBound, int upperBound) {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        do {
            System.out.print("\nEnter your choice: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Only number allowed.");
            }
            if (choice < lowerBound || choice > upperBound) {
                System.out.println("Input out of range.");
            }
        } while (choice < lowerBound || choice > upperBound);
        return choice;
    }

    private void doAction(int choice) {
        switch (choice) {
            case 0:
                System.out.println("Exiting...");
                System.exit(0);
                break;
            case 1: {
                if (studentEnrolmentList.add(new StudentEnrolment(studentList.getStudent(),
                        courseList.getCourse(), getSemester()))) {
                    System.out.println("Enrolment added successfully.");
                } else {
                    System.out.println("This enrolment already exists.");
                }
            }
            break;
            case 2:
                StudentEnrolment studentEnrolment = studentEnrolmentList.getOne();
                if (studentEnrolment == null){
                    break;
                }
                System.out.println("Please select the info you wish to edit");
                System.out.println("1) Change the student");
                System.out.println("2) Change the course");
                System.out.println("3) Change the semester");
                int option = getMenuChoice(1, 3);
                switch (option) {
                    case 1 -> {
                        Student student = studentList.getStudent();
                        StudentEnrolment newStudentEnrolment = new StudentEnrolment(student, studentEnrolment.getCourse(), studentEnrolment.getSemester());
                        studentEnrolmentList.update(studentEnrolment, newStudentEnrolment);
                    }
                    case 2 -> {
                        Course course = courseList.getCourse();
                        StudentEnrolment newStudentEnrolment = new StudentEnrolment(studentEnrolment.getStudent(), course, studentEnrolment.getSemester());
                        studentEnrolmentList.update(studentEnrolment, newStudentEnrolment);
                    }
                    case 3 -> {
                        String semester = getSemester();
                        StudentEnrolment newStudentEnrolment = new StudentEnrolment(studentEnrolment.getStudent(), studentEnrolment.getCourse(), semester);
                        studentEnrolmentList.update(studentEnrolment, newStudentEnrolment);
                    }
                }
                break;
            case 3:
                System.out.println(studentEnrolmentList.getOne());
                break;
            case 4:
                studentEnrolmentList.getAll();
                break;
            case 5:
                studentEnrolment = studentEnrolmentList.getOne();
                if(studentEnrolment != null){
                    studentEnrolmentList.delete(studentEnrolment);
                    System.out.println("Enrolment is successfully deleted.");
                }
                break;
            case 6:
                Student student = studentList.getStudent();
                String semester = getSemester();
                Course course;
                studentEnrolmentList.getCoursesOfStudentInSemester(student, semester);
                System.out.println("1) Add new course");
                System.out.println("2) Delete a course");
                option = getMenuChoice(1, 2);

                switch (option) {
                    case 1 -> {
                        course = courseList.getCourse();
                        if (studentEnrolmentList.add(new StudentEnrolment(student, course, semester))) {
                            System.out.println("Successfully added new course enrolment for student with id "
                                    + student.getStudentId() + " in semester " + semester + ".");
                        } else {
                            System.out.println("This enrolment already exists!");
                        }
                        studentEnrolmentList.getCoursesOfStudentInSemester(student, semester);
                    }
                    case 2 -> {
                        System.out.println("Please enter the course you want to delete");
                        course = courseList.getCourse();
                        StudentEnrolment studentEnrolment1 = studentEnrolmentList.get(student, course, semester);
                        if(studentEnrolment1 != null){
                            studentEnrolmentList.delete(studentEnrolment1);
                            System.out.println("Enrolment is successfully deleted.");
                        } else {
                            System.out.println("This enrolment does not exist");
                        }
                    }
                }
                break;
            case 7:
                System.out.println("1) View all courses for one student in a semester");
                System.out.println("2) View all students for one course in a semester");
                System.out.println("3) View all courses offered in a semester");
                option = getMenuChoice(1, 3);

                switch (option) {
                    case 1 -> {
                        student = studentList.getStudent();
                        semester = getSemester();
                        List<Course> courses = studentEnrolmentList.getCoursesOfStudentInSemester(student, semester);
                        switch (optionGenerateReport()) {
                            case 1:
                                CSVWriter csvWriter = new CSVWriter();
                                try {
                                    csvWriter.exportCourses(courses, csvWriter.init(getFileName()));
                                    System.out.println("File generated successfully.");
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            case 2:
                                break;
                        }
                    }
                    case 2 -> {
                        course = courseList.getCourse();
                        semester = getSemester();
                        List<Student> students = studentEnrolmentList.getStudentsOfCourseInSemester(course, semester);
                        switch (optionGenerateReport()) {
                            case 1:
                                CSVWriter csvWriter = new CSVWriter();
                                try {
                                    csvWriter.exportStudents(students, csvWriter.init(getFileName()));
                                    System.out.println("File generated successfully.");
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            case 2:
                                break;
                        }
                    }
                    case 3 -> {
                        List<Course> courses = studentEnrolmentList.getCoursesInSemester(getSemester());
                        switch (optionGenerateReport()) {
                            case 1:
                                CSVWriter csvWriter = new CSVWriter();
                                try {
                                    csvWriter.exportCourses(courses, csvWriter.init(getFileName()));
                                    System.out.println("File generated successfully.");
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            case 2:
                                break;
                        }
                    }
                }
                break;
            default:
                System.out.println("Unknown error has occurred.");
        }
    }

    public static String getSemester(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the semester: ");
        return scanner.nextLine().toUpperCase().trim();
    }

    public static int optionGenerateReport() {
        System.out.println("\nDo you want to generate report?");
        System.out.println("1) Yes");
        System.out.println("2) No");
        return getMenuChoice(1, 2);
    }

    public static String getFileName(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the name of your report");
        return scanner.nextLine();
    }
}
