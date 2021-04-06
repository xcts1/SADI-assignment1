package EnrolmentSystem;

import java.util.ArrayList;
import java.util.List;

public class StudentEnrolmentList implements StudentEnrolmentManager{

    List<StudentEnrolment> studentEnrolments = new ArrayList<>();
    @Override
    public List<StudentEnrolment> getAll() {
        return null;
    }

    @Override
    public void add(StudentEnrolment studentEnrolment) {

    }

    @Override
    public void update(StudentEnrolment studentEnrolment) {

    }

    @Override
    public void delete(StudentEnrolment studentEnrolment) {

    }

    @Override
    public StudentEnrolment getOne(String studentId, String semester) {
        return null;
    }
}
