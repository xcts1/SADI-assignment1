package EnrolmentSystem;

public interface StudentEnrolmentManager {
    void getAll();
    boolean add(StudentEnrolment studentEnrolment);
    void update(StudentEnrolment studentEnrolment);
    void delete(Student student, Course course, String semester);
    StudentEnrolment get(Student student, Course course, String semester);

    StudentEnrolment getOne();

    String toString();

}
