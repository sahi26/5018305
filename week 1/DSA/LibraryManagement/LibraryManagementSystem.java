/*
Time Complexity:
Linear Search:
Best Case: O(1) (Target found at the beginning)
Average Case: O(n) (Target found at some position)
Worst Case: O(n) (Target not found or found at the end)
Binary Search:
Best Case: O(1) (Target found in the middle)
Average Case: O(log n) (Target found after dividing the array multiple times)
Worst Case: O(log n) (Target not found after multiple divisions)
Suitability:

Linear Search: Best used when the array is unsorted or the dataset is small. It does not require sorting but can be slow for large datasets.
Binary Search: Efficient for large, sorted datasets due to its logarithmic time complexity. Requires the array to be sorted but provides fast search performance.
 */
public class LibraryManagementSystem {
    public static class Book implements Comparable<Book> {
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

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        @Override
        public int compareTo(Book other) {
            return this.title.compareToIgnoreCase(other.title);
        }

        @Override
        public String toString() {
            return "Book ID: " + bookId + ", Title: " + title + ", Author: " + author;
        }
    }

    public static Book linearSearch(Book[] books, String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public static Book binarySearch(Book[] books, String title) {
        int l = 0, r = books.length - 1;
        while (l <= r) {
            int mid = (r + l) / 2;
            int comparison = books[mid].getTitle().compareToIgnoreCase(title);
            if (comparison == 0) {
                return books[mid];
            } else if (comparison < 0) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Book[] books = {
                new Book(1, "Haunting Adeline", "Collen Hover"),
                new Book(2, "Verinity", "Hover"),
                new Book(3, "Grandmother", "Sudha")
        };
        System.out.println("Linear Search:");
        Book foundBook = linearSearch(books, "Grandmother");
        if (foundBook != null) {
            System.out.println("Book found: " + foundBook);
        } else {
            System.out.println("Book not found.");
        }
        java.util.Arrays.sort(books);
        System.out.println("\nBinary Search:");
        foundBook = binarySearch(books, "Verinity");
        if (foundBook != null) {
            System.out.println("Book found: " + foundBook);
        } else {
            System.out.println("Book not found.");
        }
    }
}
