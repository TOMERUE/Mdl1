import java.util.ArrayList;
import java.util.Scanner;

public class Student extends tgs1 {
    private String name;
    private String nim;
    private String faculty;
    private String program;
    static ArrayList<Book> bookList = new ArrayList<>();
    static ArrayList<Student> userStudent = new ArrayList<>();
    private ArrayList<Book> borrowedBooks;
    private int loanDuration;



    public Student(String name, String nim, String faculty, String program) {
        this.name = name;
        this.nim = nim;
        this.faculty = faculty;
        this.program = program;
        this.borrowedBooks = new ArrayList<>();
    }

    public Student(String nim) {

        for (Student student : tgs1.userStudent) {
            if (student.getNim().equals(nim)) {
                this.name = student.getName();
                this.nim = student.getNim();
                this.faculty = student.getFaculty();
                this.program = student.getProgram();
                this.borrowedBooks = student.getBorrowedBooks();
                break;
            }
        }
    }
    
    public String getNim() {
        return nim;
    }
    
    public static void initializeData() {
        bookList.add(new Book("388c-e681-9152", "title1", "author1", "Sejarah", 8));
        bookList.add(new Book("ed90-be30-5cdb", "title2", "author2", "Sejarah", 11));
        bookList.add(new Book("d95e-0c4a-9523", "title3", "author3", "Sejarah", 3));

        userStudent.add(new Student("M.Taufiq ", "202210370310123", "Teknik", "Industri"));
        userStudent.add(new Student("Why", "200510370319321", "Teknik", "Mesin"));

    }

    public void menuStudent(Scanner scanner) {
        while (true) {
            System.out.println("=== Student Menu ===");
            System.out.println("1. Buku terpinjam");
            System.out.println("2. Pinjam buku");
            System.out.println("3. Kembalikan buku");
            System.out.println("4. Pinjam Buku atau Logout");
            System.out.print("Choose option (1-4): ");
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    System.out.println("Buku terpinjam:");
                    displayBorrowedBooks();
                    break;
                case "2":
                    displayBooks();
                    borrowBook(scanner);
                    break;
                case "3":
                    returnBook(scanner);
                    break;
                case "4":
                    System.out.println("System logout...");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
    
    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Scanner scanner) {
        if (borrowedBooks.isEmpty()) {
            System.out.println("No books currently borrowed.");
            return;
        }

        displayBorrowedBooks();
        System.out.print("Enter the number of the book you want to return: ");
        int bookIndex = Integer.parseInt(scanner.nextLine()) - 1;

        if (bookIndex < 0 || bookIndex >= borrowedBooks.size()) {
            System.out.println("Invalid book selection.");
            return;
        }

        Book returnedBook = borrowedBooks.remove(bookIndex);
        returnedBook.setStock(returnedBook.getStock() + 1);
        System.out.println("Book '" + returnedBook.getTitle() + "' returned successfully.");
    }

    public void displayBorrowedBooks() {
        if (borrowedBooks.isEmpty()) {
            System.out.println("No books currently borrowed.");
        } else {
            System.out.println("=================================================================================");
            System.out.println("|| No. || Id Buku        || Nama Buku    || Author       || Category   || Durasi ||");
            System.out.println("=================================================================================");
            int index = 1;
            for (Book book : borrowedBooks) {
                System.out.println("|| " + index + "  || " + book.getId() + " || " + book.getTitle() + " || "
                        + book.getAuthor() + " || " + book.getCategory() + " || " + book.getLoanDuration() + " ||");
                index++;
            }
            System.out.println("=================================================================================");
        }
    }

    public void displayBooks() {
        System.out.println("================================================================");
        System.out.println("|| No. || Id Buku || Nama Buku || Author || Category || Stock ||");
        int index = 1;
        for (Book book : tgs1.bookList) {
            System.out.println("|| " + index + "  || " + book.getId() + " || " + book.getTitle() + " || "
                    + book.getAuthor() + " || " + book.getCategory() + "  || " + book.getStock() + " ||");
            index++;
        }
        System.out.println("================================================================");
    }

    public void borrowBook(Scanner scanner) {
        System.out.print("Enter the number of the book you want to borrow: ");
        int bookIndex = Integer.parseInt(scanner.nextLine()) - 1;
        if (bookIndex < 0 || bookIndex >= tgs1.bookList.size()) {
            System.out.println("Invalid book selection.");
            return;
        }

        Book selectedBook = tgs1.bookList.get(bookIndex);
        System.out.print("Enter the duration of loan (in days): ");
        int loanDuration = Integer.parseInt(scanner.nextLine());

        if (selectedBook.getStock() > 0) {

            selectedBook.setStock(selectedBook.getStock() - 1);
            selectedBook.setLoanDuration(loanDuration);
            borrowBook(selectedBook);
            System.out.println(
                    "Book '" + selectedBook.getTitle() + "' borrowed successfully for " + loanDuration + " days.");
        } else {
            System.out.println("Sorry, the selected book is out of stock.");
        }
    }

    public void setLoanDuration(int loanDuration) {
        this.loanDuration = loanDuration;
    }

    public int getLoanDuration() {
        return loanDuration;
    }

    public String getName() {
        return name;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getProgram() {
        return program;
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

}


