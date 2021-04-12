package EnrolmentSystem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVWriter {

    public BufferedWriter init(String fileName) {
        BufferedWriter br = null;
        String path = System.getProperty("user.dir");
        {
            try {
                br = new BufferedWriter(new FileWriter(path + "/src/reports/" +fileName + ".csv"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return br;
    }

    public void exportCourses(List<Course> courses, BufferedWriter br ) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("courseID, courseName, credits\n");
        for (Course course : courses) {
            sb.append(course.getCourseId());
            sb.append(",");
            sb.append(course.getCourseName());
            sb.append(",");
            sb.append(course.getNumOfCredits());
            sb.append("\n");
        }
        br.write(sb.toString());
        br.close();
    }

    public void exportStudents(List<Student> students, BufferedWriter br ) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("studentId, studentName, birthdate(MM/dd/yyyy)\n");
        for (Student student : students) {
            sb.append(student.getStudentId());
            sb.append(",");
            sb.append(student.getStudentName());
            sb.append(",");
            sb.append(student.getBirthdate());
            sb.append("\n");
        }
        br.write(sb.toString());
        br.close();
    }
}
