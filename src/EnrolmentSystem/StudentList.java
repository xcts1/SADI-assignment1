package EnrolmentSystem;

import java.util.ArrayList;
import java.util.List;

public class StudentList {

    private StudentList(){}
    private List<Student> students = new ArrayList<>();
    private static StudentList instance = new StudentList();
    public static StudentList  getInstance() {
        return instance;
    }

    public List<Student> getStudents() {
        return students;
    }

    public Student getStudent(String studentId){
        for (Student s: students){
            if (s.getStudentId().equals(studentId)) return s;
        }
        return null;
    }

    @Override
    public String toString() {
        return "StudentList{" +
                "studentList=" + students +
                '}';
    }

    public Student get(String studentId) {
        for (Student s: students){
            if (s.getStudentId().equals(studentId)) return s;
        }
        return null;
    }
}
