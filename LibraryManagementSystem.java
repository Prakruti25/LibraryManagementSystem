import java.util.ArrayList;
import java.util.Scanner;

class Book {
    int id;
    String title;
    String author;
    boolean isAvailable;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }
}

public class LibraryManagementSystem {
    static ArrayList<Book> books = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        seedBooks();
        int choice;

        do {
            System.out.println("\nLibrary Management System");
            System.out.println("1. View Books");
            System.out.println("2. Add Book");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> viewBooks();
                case 2 -> addBook();
                case 3 -> issueBook();
                case 4 -> returnBook();
                case 5 -> System.out.println("Exiting the system...");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    private static void seedBooks() {
        books.add(new Book(1, "The Catcher in the Rye", "J.D. Salinger"));
        books.add(new Book(2, "To Kill a Mockingbird", "Harper Lee"));
        books.add(new Book(3, "1984", "George Orwell"));
    }

    private static void viewBooks() {
        System.out.println("\nBook List:");
        for (Book book : books) {
            System.out.println(book.id + ". " + book.title + " by " + book.author +
                    " - " + (book.isAvailable ? "Available" : "Issued"));
        }
    }

    private static void addBook() {
        System.out.print("\nEnter book title: ");
        scanner.nextLine(); // Consume the newline character
        String title = scanner.nextLine();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();
        int id = books.size() + 1;
        books.add(new Book(id, title, author));
        System.out.println("Book added successfully!");
    }

    private static void issueBook() {
        System.out.print("\nEnter book ID to issue: ");
        int id = scanner.nextInt();
        for (Book book : books) {
            if (book.id == id) {
                if (book.isAvailable) {
                    book.isAvailable = false;
                    System.out.println("Book issued successfully!");
                } else {
                    System.out.println("Book is already issued.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    private static void returnBook() {
        System.out.print("\nEnter book ID to return: ");
        int id = scanner.nextInt();
        for (Book book : books) {
            if (book.id == id) {
                if (!book.isAvailable) {
                    book.isAvailable = true;
                    System.out.println("Book returned successfully!");
                } else {
                    System.out.println("Book was not issued.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }
}
