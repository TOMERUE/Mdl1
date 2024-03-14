import java.util.*;


public class tgs1 {

    static ArrayList<Book> bookList = new ArrayList<>();
    static ArrayList<Student> userStudent = new ArrayList<>();

    public static void main(String[] args) {

        initializeData();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("===== Library System =====");
            System.out.println("1. Login as Student");
            System.out.println("2. Login as Admin");
            System.out.println("3. Exit");
            System.out.print("Choose option (1-3): ");
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    inputNim(scanner);
                    break;
                case "2":
                    admin_tgs admin = new admin_tgs(scanner);
                    admin.menuAdmin(scanner);
                    break;
                case "3":
                    System.out.println("Thank you. Exiting program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid option.");
            }
        }

    }

    public static void inputNim(Scanner scanner) {
        System.out.print("Enter your NIM (input 101 for back): ");
        String nim = scanner.nextLine();
        if (nim.equals("101")) {
            return;
        } else if (checkNim(nim)) {
            Student student = findStudentByNim(nim);
            if (student != null)
                student.menuStudent(scanner);
            else
                System.out.println("Student not found.");
        } else {
            System.out.println("Invalid NIM. Please try again.");
            inputNim(scanner);
        }
    }

    public static boolean checkNim(String nim) {
        for (Student student : userStudent) {
            if (student.getNim().equals(nim)) {
                return true;
            }
        }
        return false;
    }

    public static Student findStudentByNim(String nim) {
        for (Student student : userStudent) {
            if (student.getNim().equals(nim)) {
                return student;
            }
        }
        return null;
    }

    public static void initializeData() {
        bookList.add(new Book("388c-e681-9152", "title1", "author1", "Sejarah", 8));
        bookList.add(new Book("ed90-be30-5cdb", "title2", "author2", "Sejarah", 11));
        bookList.add(new Book("d95e-0c4a-9523", "title3", "author3", "Sejarah", 3));

        userStudent.add(new Student("M.Taufiq ", "202210370310123", "Teknik", "Industri"));
        userStudent.add(new Student("Why", "200510370319321", "Teknik", "Mesin"));

    }
}

class Book {
    private String id;
    private String title;
    private String author;
    private String category;
    private int stock;

    public Book(String id, String title, String author, String category, int stock) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.stock = stock;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public int getStock() {
        return stock;
    }

}

