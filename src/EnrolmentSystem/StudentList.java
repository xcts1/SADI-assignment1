package EnrolmentSystem;

import java.util.ArrayList;
import java.util.List;

public class StudentList {
    private StudentList(){}
    private static StudentList instance = new StudentList();
    private List<Student> studentList = new ArrayList<>();

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
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
}
