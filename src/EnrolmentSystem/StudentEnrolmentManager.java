package EnrolmentSystem;

import java.util.List;

public interface StudentEnrolmentManager {
    void getAll();
    void add(StudentEnrolment studentEnrolment);
    void update(StudentEnrolment studentEnrolment);
    void delete(String studentId, String courseId, String semester);

    StudentEnrolment getOne(String studentId, String courseId, String semester);

    public String toString();

}
