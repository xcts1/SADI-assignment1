package enrolmentSystem.entity;

import java.text.ParseException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Student {

    final static String DATE_FORMAT = "MM/dd/yyyy";
    private final String studentId;
    private final String studentName;
    private final Date birthdate;

    // getters and setters
    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getBirthdate() {
        DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        return dateFormat.format(birthdate);
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
