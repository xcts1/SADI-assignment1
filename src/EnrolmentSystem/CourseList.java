package EnrolmentSystem;

import java.util.ArrayList;
import java.util.List;

public class CourseList {

    private CourseList(){}
    private List<Course> courseList = new ArrayList<>();
    private static CourseList instance = new CourseList();
    public static CourseList  getInstance() {
        return instance;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    @Override
    public String toString() {
        return "CourseList{" +
                "courseList=" + courseList +
                '}';
    }

    public Course get(String courseId) {
        for (Course c: courseList){
            if (c.getCourseId().equals(courseId)) return c;
        }
        return null;
    }
}
