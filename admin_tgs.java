import java.util.*;

public class admin_tgs {
    private String name;
    private String nim;
    private String faculty;
    private String program;
    static ArrayList<Student> userStudent = new ArrayList<>();

    public admin_tgs(Scanner scanner) {
        for (Student student : userStudent) {
            System.out.println("Name: " + student.getName());
            System.out.println("Faculty: " + student.getFaculty());
            System.out.println("NIM: " + student.getNim());
            System.out.println("Program: " + student.getProgram());
            System.out.println();
        }
    }

    public void displayStudent() {
        System.out.println("List of Registered Students:");
        if (userStudent.isEmpty()) {
            System.out.println("No students registered.");
        } else {
            for (Student student : userStudent) {
                System.out.println("Name: " + student.getName());
                System.out.println("Faculty: " + student.getFaculty());
                System.out.println("NIM: " + student.getNim());
                System.out.println("Program: " + student.getProgram());
                System.out.println();
            }
        }
    }

    public void addStudent(Scanner scanner) {
        System.out.println("Enter student details:");
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        String nim;
        do {
            System.out.print("Enter student NIM: ");
            nim = scanner.nextLine();
            if (nim.length() != 15) {
                System.out.println("NIM must be 15 digits.");
            }
        } while (nim.length() != 15);
        System.out.print("Enter student faculty: ");
        String faculty = scanner.nextLine();
        System.out.print("Enter student program: ");
        String program = scanner.nextLine();
        userStudent.add(new Student(name, nim, faculty, program));
        System.out.println("Student successfully registered.");
    }

    public void menuAdmin(Scanner scanner) {
        while (true) {
            System.out.println("=== Admin Menu ===");
            System.out.println("1. Add Student");
            System.out.println("2. Display Registered Students");
            System.out.println("3. Logout");
            System.out.print("Choose option (1-3): ");
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    addStudent(scanner);
                    break;
                case "2":
                    displayStudent();
                    break;
                case "3":
                    System.out.println("Logging out from admin account.");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

}
