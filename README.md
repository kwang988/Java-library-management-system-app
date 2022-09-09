## Topics Covered:

- Creating and Instantiating Classes
- Controlling Class Visibility (public/private)
- Using common Data Types (String, boolean, int, Enum)
- Using common Standard Libraries (ArrayList)
- Performing simple Mathematical Operations
- Performing Loops using while, for, and for-each
- Accessing and storing sequential data (Arrays)
  
# Assignment

This assignment will assess if you can demonstrate the required skills to proceed to the _Advanced Java_ portion of the curriculum.

Only attempt this assignment if you feel comfortable with the topics listed above.

You will be building a Java application that represents the **Kenzie Book Library**.  

Build the classes represented in the following **Class Diagram**:

![Class Diagram](https://i.imgur.com/N2vFSCi.png)  

Your classes should match this diagram, including the arguments, return values, and class visibility.  This diagram only shows _public_ properties and methods.  All other properties and methods you create should be _private_. 

## Classes

### Genre (Enum)

This enum class should provide the possibles genres for books.  These should include: 
* FANTASY
* SCIENCE_FICTION
* MYSTERY
* ROMANCE
* CHILDRENS
* NONFICTION

### Book

A Book constructor should accept the following arguments: 
* `title` - String - The title of the book
* `author` - String - The author of the book
* `genre` - Genre - The genre of the book
* `pages` - String[] - An array of the text of every page in the book.

A book should keep track of the **current page** that is being viewed.

A book should have the following methods: 

* `getCurrentPageNumber()` - return the current page number 
* `nextPage()` - Go to the next page, return the text of that page.
* `prevPage()` - Go to the previous page, return the text of that page.
* `openPage(int pageNumber)` - Go to the chosen page, return the text of that page.
* `tearOutCurrentPage()` - This should remove the current page from the book, permanently removing the page.  The current page should now point to the next page (if there is one). This should return the text of the torn-out page.
* `getNumPages()` - Return the total number of pages in the book
* `getPercentageComplete()` - Return the percentage (0-100) of how far the current page is in the book.
* `getTitle()` - return the book's title
* `getAuthor()` - return the book's author
* `getGenre() ` - return the book's genre

### Library

A Library should have no arguments in its constructor.  

The library should contain a list of Books, as well as a list of the titles of books which are checked out.

Books should be stored in **Lexical Order** according to the book title. (No, you don't need to use the Dewey-Decimal System... 😃)

The Library should have the following methods: 
* `addBook(Book book)` - This should add the given book to the Library
* `listBooks()` - This should return an array of all book titles in the library.  This should include books which are checked out.
* `listBooks(Genre genre)` - This should return an array of all book titles in the library with the given genre
* `listAvailableBooks()` - This should return an array of all book titles in the library that are NOT checked out.
* `listAvailableBooks(Genre genre)` - This should return an array of all book titles in the library with the given genre that are NOT checked out.
* `hasBook(String bookTitle)` - This should return a boolean representing whether a book with the given title is contained in the library.  (This should include book which are and are not checked out)
* `checkoutBook(String bookTitle)` - If the library has the book and the book is not already checked out, then this should check out the given book and return it.  If the library has the book but it is already checked out then this should throw a **BookNotAvailableException**.  If the Library does not have the book then this should throw a **BookNotFoundException**.  
* `returnBook(Book book)` - This should return the given book to the library.  


### BookNotFoundException and BookNotAvailableException

Both of these Exception classes are already provided.  You should use them in your Library class in the `checkoutBook()` method.

### Main

There is already a `Main` class provided.  This class contains a main method that will perform some basic operations of the Library.  You can use this code to understand the intended usages of the classes as well as verify that your code is working correctly

You can use the provided `populateLibrary()` method to create books and add a set of books to the library.

Note that this code **does not exercise every feature of these classes**. 

## Unit Tests

Your code will be expected to fulfill the **Unit Tests** provided with the project.  To pass the assignment, all of the unit tests must succeed.   Make sure to test your own code to verify that it works as you would expect.  

You can use Gradle to run the unit tests.  While inside of the project directory, run:

```
./gradlew test
```

If you have failing tests, you cna use `./gradlew test --info` to see the full stacktraces.

## Code Quality

Try to write high quality, readable, code for this assignment.  You will be graded on code organization and readability.

# Submission
Submit the URL to your Github repository.

## Grading
This activity will be graded according to the following completion criteria and learning outcomes:

## Completion Criteria
* The Book class exists and functions as described above
* The Library class exists and functions as described above
* All unit tests are passing
* Your code is functional, well organized, and easy to read