package enrolmentSystem.list;

import enrolmentSystem.entity.Student;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentListTest {
    private static final Student student1 = new Student("s1", "Jack", "10/13/2000" );
    private static final Student student2 = new Student("s2", "Harry", "02/26/1995" );
    private static final List<Student> students = new ArrayList<>();
    private static StudentList studentList = StudentList.getInstance();
    private static StudentList studentList2 = StudentList.getInstance();

    @Test
    void getInstance() {
        assertNotNull(StudentList.getInstance(), "this should be an empty list");
        assertEquals(studentList, studentList2, "both list should be the same");
    }

    @Test
    void getStudents() {
        studentList.getStudents().add(student1);
        students.add(student1);
        assertEquals(students, studentList.getStudents());
    }

    @Test
    void testToString() {
    }

    @Test
    void get() {
        assertEquals(null, studentList.get("s2"), "no student s2 found");
    }

    @Test
    void getStudent() {
//        System.out.println("Please enter the student id: ");
        ByteArrayInputStream in = new ByteArrayInputStream("s1".getBytes());
        System.setIn(in);
        assertEquals(studentList.get("s1"), studentList.getStudent());
//        ByteArrayInputStream in = new ByteArrayInputStream("s1".getBytes());
//        System.setIn(in);
    }
}