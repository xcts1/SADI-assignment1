package EnrolmentSystem;

import java.util.ArrayList;
import java.util.List;

public class StudentList {

    private StudentList(){}
    private List<Student> studentList = new ArrayList<>();
    private static StudentList instance = new StudentList();
    public static StudentList  getInstance() {
        return instance;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public Student getStudent(String studentId){
        for (Student s: studentList){
            if (s.getStudentId().equals(studentId)) return s;
        }
        return null;
    }

    @Override
    public String toString() {
        return "StudentList{" +
                "studentList=" + studentList +
                '}';
    }

    public Student get(String studentId) {
        for (Student s: studentList){
            if (s.getStudentId().equals(studentId)) return s;
        }
        return null;
    }
}
