import java.io.*;
import java.util.*;

public class AttendanceManager {
    private List<Student> students = new ArrayList<>();
    private final String FILE_NAME = "data.txt";

    public AttendanceManager() {
        loadData();
    }

    public void addStudent(int id, String name) {
        students.add(new Student(id, name));
        saveData();
    }

    public void markAttendance(int id, boolean present) {
        for (Student s : students) {
            if (s.getId() == id) {
                s.markAttendance(present);
                break;
            }
        }
        saveData();
    }

    public void viewStudents() {
        for (Student s : students) {
            System.out.println(
                "ID: " + s.getId() +
                ", Name: " + s.getName() +
                ", Attendance: " + s.getAttendancePercentage() + "%"
            );
        }
    }

    private void saveData() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Student s : students) {
                writer.write(s.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving data");
        }
    }

    private void loadData() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                students.add(Student.fromString(line));
            }
        } catch (IOException e) {
            System.out.println("No previous data found.");
        }
    }
}