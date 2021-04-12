package EnrolmentSystem;

import java.text.ParseException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Student {

    final static String DATE_FORMAT = "MM/dd/yyyy";
    private String studentId;
    private String studentName;
    private Date birthdate;

    // getters and setters
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

    public String getBirthdate() {
        DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        return dateFormat.format(birthdate);
    }

    public void setBirthdate(String dateString) {
        Date date = null;
        try {
            DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
            dateFormat.setLenient(false);
            date = dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("Date must be in the format MM/dd/yyyy.");
        }
        this.birthdate = date;
    }

    // constructor
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
            System.out.println("Date entered must be in the format MM/dd/yyyy.");
        }
        this.birthdate = date;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
}
