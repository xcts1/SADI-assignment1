package enrolmentSystem.entity;

public class Course {

    private final String courseId;
    private final String courseName;
    private final int numOfCredits;

    // getters and setters
    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getNumOfCredits() {
        return numOfCredits;
    }

    // constructors
    public Course(String courseId, String courseName, int numOfCredits) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.numOfCredits = numOfCredits;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", numOfCredits=" + numOfCredits +
                '}';
    }
}
