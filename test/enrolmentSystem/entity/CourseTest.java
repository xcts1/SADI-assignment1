package enrolmentSystem.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {

    public static Course course = new Course("c1", "Introduction to IT", 4 );


    @Test
    void getCourseId() {
        assertEquals("c1", course.getCourseId());
    }

    @Test
    void getCourseName() {
        assertEquals("Introduction to IT", course.getCourseName());
    }

    @Test
    void getNumOfCredits() {
        assertEquals(4, course.getNumOfCredits());

    }
}