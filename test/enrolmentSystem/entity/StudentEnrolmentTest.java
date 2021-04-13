package enrolmentSystem.entity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

class StudentEnrolmentTest {

    public static Student student = new Student("s1", "Jack", "10/13/2000" );
    public static Course course = new Course("c1", "Introduction to IT", 4 );
    StudentEnrolment studentEnrolment = new StudentEnrolment(student, course, "2020A");

    @Test
    void getStudent() {
        assertEquals(student, studentEnrolment.getStudent());
    }

    @Test
    void getCourse() {
        assertEquals(course, studentEnrolment.getCourse());
    }

    @Test
    void getSemester() {
        assertEquals("2020A", studentEnrolment.getSemester());
    }

    @Test
    void testToString() {
    }
}