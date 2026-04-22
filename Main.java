import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AttendanceManager manager = new AttendanceManager();

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. Mark Attendance");
            System.out.println("3. View Students");
            System.out.println("4. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    manager.addStudent(id, name);
                    break;

                case 2:
                    System.out.print("Enter ID: ");
                    int sid = sc.nextInt();
                    System.out.print("Present? (true/false): ");
                    boolean present = sc.nextBoolean();
                    manager.markAttendance(sid, present);
                    break;

                case 3:
                    manager.viewStudents();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    return;
            }
        }
    }
}