import java.util.Arrays;
import java.util.Scanner;

class Book {
    private int bookId;
    private String title;
    private String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "bookId=" + bookId + ", title=" + title + ", author=" + author;
    }
}

public class LibraryManagement {
    private static Book[] books = new Book[0];

    public static int linearSearch(Book[] books, String targetTitle) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].getTitle().equalsIgnoreCase(targetTitle)) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(Book[] books, String targetTitle) {
        int left = 0;
        int right = books.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int compareResult = books[mid].getTitle().compareToIgnoreCase(targetTitle);
            if (compareResult == 0) {
                return mid;
            } else if (compareResult < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void addBook(Book book) {
        Book[] newBooks = Arrays.copyOf(books, books.length + 1);
        newBooks[books.length] = book;
        books = newBooks;
        Arrays.sort(books, (b1, b2) -> b1.getTitle().compareToIgnoreCase(b2.getTitle()));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Book");
            System.out.println("2. Linear Search by Title");
            System.out.println("3. Binary Search by Title");
            System.out.println("4. Traverse Books");
            System.out.println("5. Exit");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Enter Book ID:");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter Book Title:");
                    String title = scanner.nextLine();
                    System.out.println("Enter Book Author:");
                    String author = scanner.nextLine();
                    addBook(new Book(id, title, author));
                    break;
                case 2:
                    System.out.println("Enter Book Title to search:");
                    String linearSearchTitle = scanner.nextLine();
                    int linearResult = linearSearch(books, linearSearchTitle);
                    if (linearResult >= 0) {
                        System.out.println("Found at index " + linearResult + ", Book ID: " + books[linearResult].getBookId());
                    } else {
                        System.out.println("Not Found");
                    }
                    break;
                case 3:
                    System.out.println("Enter Book Title to search:");
                    String binarySearchTitle = scanner.nextLine();
                    int binaryResult = binarySearch(books, binarySearchTitle);
                    if (binaryResult >= 0) {
                        System.out.println("Found at index " + binaryResult + ", Book ID: " + books[binaryResult].getBookId());
                    } else {
                        System.out.println("Not Found");
                    }
                    break;
                case 4:
                    for (Book book : books) {
                        System.out.println(book);
                    }
                    break;
                case 5:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
