package EnrolmentSystem;

public class Course {

    private String courseId;
    private String courseName;
    private int numOfCredits;

    // getters and setters
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getNumOfCredits() {
        return numOfCredits;
    }

    public void setNumOfCredits(int numOfCredits) {
        this.numOfCredits = numOfCredits;
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
