package EnrolmentSystem;

import java.util.ArrayList;
import java.util.List;

public class CourseList {

    private CourseList(){}
    private List<Course> courses = new ArrayList<>();
    private static CourseList instance = new CourseList();
    public static CourseList  getInstance() {
        return instance;
    }

    public List<Course> getCourses() {
        return courses;
    }

    @Override
    public String toString() {
        return "CourseList{" +
                "courses=" + courses +
                '}';
    }

    public Course get(String courseId) {
        for (Course c: courses){
            if (c.getCourseId().equals(courseId)) return c;
        }
        return null;
    }
}
