package enrolmentSystem.entity;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    Student student = new Student("s1", "Jack", "10/13/2000" );

    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
        System.out.println("Before class");
    }

    @Test
    void getStudentId() {
        assertEquals("s1", student.getStudentId());
    }

    @Test
    void getStudentName() {
        assertEquals("Jack", student.getStudentName());
    }

    @Test
    void getBirthdate() {
        assertEquals("10/13/2000", student.getBirthdate());
    }

}