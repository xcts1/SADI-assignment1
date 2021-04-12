package enrolmentSystem.list;

import enrolmentSystem.entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentList {

    private StudentList(){}
    private final List<Student> students = new ArrayList<>();
    private static final StudentList instance = new StudentList();
    public static StudentList  getInstance() {
        return instance;
    }

    public List<Student> getStudents() {
        return students;
    }

    @Override
    public String toString() {
        return "StudentList{" +
                "studentList=" + students +
                '}';
    }

    // return the student with the studentId input, null if not found
    public Student get(String studentId) {
        for (Student s: students){
            if (s.getStudentId().equals(studentId.toUpperCase().trim())) return s;
        }
        return null;
    }

    // ask user for input studentId, check if the student exists and return the student
    public Student getStudent(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the student id: ");
        String input = scanner.nextLine();
        while (this.get(input) == null){
            System.out.println("No such student exists!!!");
            System.out.print("Please enter the student id: ");
            input = scanner.nextLine();
        }
        return this.get(input);
    }
}
