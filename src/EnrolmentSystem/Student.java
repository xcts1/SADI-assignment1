package EnrolmentSystem;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Student {
    final static String DATE_FORMAT = "dd/MM/yyyy";
    private String studentId;
    private String studentName;
    private Date birthdate;
    private List<Course> courses =  new ArrayList<>();

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public boolean setBirthdate(String dateString) {
        Date date;
        try {
            DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
            dateFormat.setLenient(false);
            date = dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("Date entered must be in the format dd/MM/yyyy !!!");
            return false;
        }
        this.birthdate = date;
        return true;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Student(String studentId, String studentName, String birthdate) {
        this.studentId = studentId;
        this.studentName = studentName;
        Date date = null;
        try {
            DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
            dateFormat.setLenient(false);
            date = dateFormat.parse(birthdate);
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("Date entered must be in the format dd/MM/yyyy !!!");
        }
        this.birthdate = date;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", birthdate=" + birthdate +
                ", courses=" + courses +
                '}';
    }

}
