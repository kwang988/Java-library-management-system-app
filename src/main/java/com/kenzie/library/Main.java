package com.kenzie.library;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        populateLibrary(library);


        if (library.hasBook("A Brave New World")) {
            Book braveNewWorld = library.checkoutBook("A Brave New World");
            System.out.println(braveNewWorld.getTitle());
            System.out.println(braveNewWorld.getAuthor());
            System.out.println(braveNewWorld.getGenre().toString());
            System.out.println(braveNewWorld.getNumPages());
            System.out.println(braveNewWorld.getCurrentPageNumber());
            String currentPage = braveNewWorld.nextPage();
            System.out.println(currentPage);
            braveNewWorld.nextPage();
            braveNewWorld.nextPage();
            currentPage = braveNewWorld.prevPage();
            System.out.println(currentPage);
            System.out.println(braveNewWorld.getCurrentPageNumber());

            try {
                library.checkoutBook("A Brave New World");
            } catch (BookNotAvailableException e) {
                System.out.println(e.getMessage());
            }

            library.returnBook(braveNewWorld);

            String[] fantasyBooks = library.listBooks(Genre.FANTASY);
            for (String bookTitle : fantasyBooks) {
                System.out.println(bookTitle);
            }
        }

        if (!library.hasBook("Harry Potter")) {
            try {
                library.checkoutBook("Harry Potter");
            } catch (BookNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void populateLibrary(Library library) {
        library.addBook(new Book("A Brave New World", "Aldous Huxley", Genre.SCIENCE_FICTION, new String[]{"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."}));
        library.addBook(new Book("Alice in Wonderland", "Lewis Carroll", Genre.FANTASY, new String[]{"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."}));
        library.addBook(new Book("Lord of the Rings", "J.R.R. Tolkien", Genre.FANTASY, new String[]{"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."}));
    }
}

/*
Skills
* Looping x
* ArrayList (Ordered Data) x
* Logic
* math
* Enum x
* multiple constructors x
* Storing objects
* Class diagram
* String formatting and String Builder
* public / private




Library
* books
* findBook(title)
* listBooks()
* checkout(book)
* return(book)
*** max num books checked out at once?
***

Book
* info
* pages
* currentPage
** getPage(pageNum)
** nextPage()
** prevPage()


EBook
* info
* words
* numCharsPerPage
* pages
** increaseFontSize()
** decreaseFontSize()
** getPercentageComplete()


 */