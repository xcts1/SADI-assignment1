package EnrolmentSystem;

import java.util.List;

public interface StudentEnrolmentManager {
    List<StudentEnrolment> getAll();
    void add(StudentEnrolment studentEnrolment);
    void update(StudentEnrolment studentEnrolment);
    void delete(StudentEnrolment studentEnrolment);
    StudentEnrolment getOne(String studentId, String semester);
}
