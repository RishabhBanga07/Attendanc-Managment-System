import java.io.Serializable;

public class Student implements Serializable {
    private int id;
    private String name;
    private int totalClasses;
    private int attendedClasses;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.totalClasses = 0;
        this.attendedClasses = 0;
    }

    public void markAttendance(boolean present) {
        totalClasses++;
        if (present) {
            attendedClasses++;
        }
    }

    public double getAttendancePercentage() {
        if (totalClasses == 0) return 0;
        return (attendedClasses * 100.0) / totalClasses;
    }

    public String toString() {
        return id + "," + name + "," + totalClasses + "," + attendedClasses;
    }

    public static Student fromString(String data) {
        String[] parts = data.split(",");
        Student s = new Student(Integer.parseInt(parts[0]), parts[1]);
        s.totalClasses = Integer.parseInt(parts[2]);
        s.attendedClasses = Integer.parseInt(parts[3]);
        return s;
    }

    public int getId() { return id; }
    public String getName() { return name; }
}