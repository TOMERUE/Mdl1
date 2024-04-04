import java.util.*;

public class admin_tgs extends tgs1 {
    private String name;
    private String nim;
    private String faculty;
    private String program;
    static ArrayList<Student> userStudent = new ArrayList<>();
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin123";

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
        if (userStudent.equals(userStudent)) {
            for (Student student : userStudent) {
                System.out.println("Name: " + student.getName());
                System.out.println("Faculty: " + student.getFaculty());
                System.out.println("NIM: " + student.getNim());
                System.out.println("Program: " + student.getProgram());
                System.out.println();
            }
        } else {

            System.out.println("No students registered.");
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
        if (loginAdmin(scanner)) {
            while (true) {
                System.out.println("=== Admin Menu ===");
                System.out.println("1. Tambah Siswa");
                System.out.println("2. Lihat Daftar Siswa");
                System.out.println("3. Tambah Buku");
                System.out.println("4. Lihat Daftar Buku");
                System.out.println("5. Keluar");
                System.out.print("Choose option (1-5): ");
                String option = scanner.nextLine();
                switch (option) {
                    case "1":
                        addStudent(scanner);
                        break;
                    case "2":
                        displayStudent();
                        break;
                    case "3":
                        addBook(scanner);
                        break;
                    case "4":
                        displayBookList();
                        break;
                    case "5":
                        System.out.println("Logging out from admin account.");
                        return;
                    default:
                        System.out.println("Invalid option.");
                }
            }
        } else {
            System.out.println("Admin login failed. Exiting.");
        }
    }

    public static void initializeData() {
        bookList.add(new Book("388c-e681-9152", "title1", "author1", "Sejarah", 8));
        bookList.add(new Book("ed90-be30-5cdb", "title2", "author2", "Sejarah", 11));
        bookList.add(new Book("d95e-0c4a-9523", "title3", "author3", "Sejarah", 3));

        userStudent.add(new Student("M.Taufiq ", "202210370310123", "Teknik", "Industri"));
        userStudent.add(new Student("Why", "200510370319321", "Teknik", "Mesin"));

    }

    private boolean loginAdmin(Scanner scanner) {
        System.out.print("Enter admin username: ");
        String username = scanner.nextLine();
        System.out.print("Enter admin password: ");
        String password = scanner.nextLine();

        return username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD);
    }

    public void addBook(Scanner scanner) {
        System.out.println("Choose book category:");
        System.out.println("1. Story Book");
        System.out.println("2. History Book");
        System.out.println("3. Text Book");
        System.out.println("4. Keluar");
        System.out.print("Enter choice (1-4): ");
        String categoryChoice = scanner.nextLine();

        String category;
        switch (categoryChoice) {
            case "1":
                category = "Story Book";
                break;
            case "2":
                category = "History Book";
                break;
            case "3":
                category = "Text Book";
                break;
            case "4":
                System.out.println("System logout...");
                return;
            default:
                System.out.println("Invalid choice. Defaulting to Story Book.");
                category = "Story Book";
                break;
        }
        System.out.println("Enter book details:");
        System.out.print("Enter book ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();
        System.out.print("Enter book stock: ");
        int stock = Integer.parseInt(scanner.nextLine());

        tgs1.bookList.add(new Book(id, title, author, category, stock));
        System.out.println("Book successfully added to the library.");
    }

    public void displayBookList() {
        System.out.println("List of Books:");
        System.out.println("================================================================");
        System.out.println("|| No. || Id Buku || Nama Buku || Author || Category || Stock ||");
        int index = 1;
        for (Book book : tgs1.bookList) {
            System.out.println("|| " + index + "  || " + book.getId() + " || " + book.getTitle() + " || "
                    + book.getAuthor() + " || " + book.getCategory() + "  || " + book.getStock() + " ||");
            index++;
        }
    }

}
