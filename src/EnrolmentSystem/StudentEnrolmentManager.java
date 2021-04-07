package EnrolmentSystem;

import java.util.List;

public interface StudentEnrolmentManager {
    void getAll();
    void add(StudentEnrolment studentEnrolment);
    void update(StudentEnrolment studentEnrolment);
    void delete(StudentEnrolment studentEnrolment);
    StudentEnrolment getOne(String studentId, String semester);
    public String toString();

}
