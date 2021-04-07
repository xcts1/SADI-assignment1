package EnrolmentSystem;

import java.util.ArrayList;
import java.util.List;

public class CourseList {
    private List<Course> courseList = new ArrayList<>();

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public Course getCourse(String courseId){
        for (Course c: courseList){
            if (c.getCourseId().equals(courseId)) return c;
        }
        return null;
    }
}
