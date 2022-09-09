package com.kenzie.library;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class LibraryTest {
    public static Book[] getTestBooks() {
        return new Book[]{
            new Book("Lord of the Rings", "J.R.R. Tolkien", Genre.FANTASY, new String[]{"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."}),
            new Book("A Brave New World", "Aldous Huxley", Genre.SCIENCE_FICTION, new String[]{"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."}),
            new Book("Winnie the Pooh", "A. A. Milne", Genre.CHILDRENS, new String[]{"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."}),
            new Book("Alice in Wonderland", "Lewis Carroll", Genre.FANTASY, new String[]{"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."})
        };
    }

    public static Library getPopulatedLibrary() {
        Library library = new Library();
        Book[] books = getTestBooks();
        for (Book book : books) {
            library.addBook(book);
        }
        return library;
    }
    
    @Test
    void canCreateLibrary() {
        Library library = new Library();

        String[] books = library.listBooks();
        assertEquals(0, books.length, "There are no books in the library");
 
        String[] availableBooks = library.listAvailableBooks();
        assertEquals(0, availableBooks.length, "There are no available books in the library");
    }

    @Test
    void canAddBooks() {
        Library library = new Library();
        Book[] testBook = getTestBooks();

        String[] books = library.listBooks();
        assertEquals(0, books.length, "There are no books in the library");

        library.addBook(testBook[0]);
        books = library.listBooks();
        assertEquals(1, books.length, "There is one book in the library");
        library.addBook(testBook[1]);
        library.addBook(testBook[2]);
        library.addBook(testBook[3]);
        books = library.listBooks();
        assertEquals(4, books.length, "There are four books in the library");
    }

    @Test
    void booksGetAddedInOrder() {
        Library library = getPopulatedLibrary();
        String[] books = library.listBooks();
        assertEquals(4, books.length, "There are four books in the library");
        assertEquals("A Brave New World", books[0]);
        assertEquals("Alice in Wonderland", books[1]);
        assertEquals("Lord of the Rings", books[2]);
        assertEquals("Winnie the Pooh", books[3]);
    }

    @Test
    void canCheckoutBook() {
        String selectedBookTitle = "A Brave New World";
        Library library = getPopulatedLibrary();
        Book book = library.checkoutBook(selectedBookTitle);
        assertEquals(selectedBookTitle, book.getTitle(), "The returned book matches the title requested");

        String[] availableBooks = library.listAvailableBooks();
        boolean hasBookAvailable = false;
        for (String bookTitle : availableBooks) {
            if (bookTitle == selectedBookTitle) {
                hasBookAvailable = true;
            }
        }
        assertEquals(false, hasBookAvailable, "The checked out book should no longer be available");

        String[] allBooks = library.listBooks();
        boolean hasBook = false;
        for (String bookTitle : allBooks) {
            if (bookTitle == selectedBookTitle) {
                hasBook = true;
            }
        }
        assertEquals(true, hasBook, "The checked out book should should still be listed in all the books");

        assertEquals(true, library.hasBook(selectedBookTitle), "The library still has the book");

        boolean caughtException = false;
        try {
            library.checkoutBook(selectedBookTitle);
        } catch (BookNotAvailableException e) {
            caughtException = true;
        }
        assertEquals(true, caughtException, "The BookNotAvailableException should be thrown when attempting to checkout the book again");
    }

    @Test
    void exceptionHappensWhenCheckingOutMissingBook() {
        Library library = getPopulatedLibrary();
        boolean exceptionCaught = false;

        try {
            library.checkoutBook("missing book");
        } catch(BookNotFoundException e) {
            exceptionCaught = true;
        }
        assertEquals(true, exceptionCaught, "There should be a BookNotFoundException when checking out a book that doesn't exist");
    }

    @Test
    void canReturnBook() {
        String selectedBookTitle = "A Brave New World";
        Library library = getPopulatedLibrary();
        Book book = library.checkoutBook(selectedBookTitle);
        
        library.returnBook(book);
        String[] availableBooks = library.listAvailableBooks();
        boolean hasBookAvailable = false;
        for (String bookTitle : availableBooks) {
            if (bookTitle == selectedBookTitle) {
                hasBookAvailable = true;
            }
        }
        assertEquals(true, hasBookAvailable, "The checked out book should be available after it is returned");

        book = library.checkoutBook(selectedBookTitle);
        assertEquals(selectedBookTitle, book.getTitle(), "The book can be checked out again");
    }

}
