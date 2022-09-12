package com.kenzie.library;

import java.util.ArrayList;
import java.util.Arrays;

public class Library {
    //declare properties
    private ArrayList<Book> booksList;
    private ArrayList<String> checkedOutBooksTitleList;

    //no arguments constructor
    public Library() {
        booksList = new ArrayList<Book>();
        checkedOutBooksTitleList = new ArrayList<String>();
    }

    //declare methods
    public void addBook(Book book) {
        booksList.add(book);
    }

    public String[] listBooks() {
        String[] allBookTitlesArr = new String[booksList.size()];
        for (int i = 0; i < booksList.size(); i++) {
            allBookTitlesArr[i] = booksList.get(i).getTitle();
        }
        Arrays.sort(allBookTitlesArr);
        return allBookTitlesArr;
    }

    public String[] listBooks(Genre genre) {
        int bookWithGivenGenreCount = 0;
        for (int i = 0; i < booksList.size(); i++) {
            if (booksList.get(i).getGenre() == genre) {
                bookWithGivenGenreCount++;
            }
        }
        String[] bookWithGivenGenreTitlesArr = new String[bookWithGivenGenreCount];
        for (int i = 0, j = 0; i < booksList.size(); i++) {
            if (booksList.get(i).getGenre() == genre) {
                bookWithGivenGenreTitlesArr[j] = booksList.get(i).getTitle();
                j++;
            }
        }
        Arrays.sort(bookWithGivenGenreTitlesArr);
        return bookWithGivenGenreTitlesArr;
    }

    public String[] listAvailableBooks() {
        int availableBooksCount = 0;
        for (int i = 0; i < booksList.size(); i++) {
            if (!checkedOutBooksTitleList.contains(booksList.get(i).getTitle())) {
                availableBooksCount++;
            }
        }
        String[] availableBookTitlesArr = new String[availableBooksCount];
        for (int i = 0, j = 0; i < booksList.size(); i++) {
            if (!checkedOutBooksTitleList.contains(booksList.get(i).getTitle())) {
                availableBookTitlesArr[j] = booksList.get(i).getTitle();
                j++;
            }
        }
        Arrays.sort(availableBookTitlesArr);
        return availableBookTitlesArr;
    }

    public String[] listAvailableBooks(Genre genre) {
        int availableBookWithGivenGenreCount = 0;
        String[] bookWithGivenGenreTitlesArr = listBooks();
        for (int i = 0; i < bookWithGivenGenreTitlesArr.length; i++) {
            if (!checkedOutBooksTitleList.contains(bookWithGivenGenreTitlesArr[i])) {
                availableBookWithGivenGenreCount++;
            }
        }
        String[] availableBookWithGivenGenreTitlesArr = new String[availableBookWithGivenGenreCount];
        for (int i = 0, j = 0; i < bookWithGivenGenreTitlesArr.length; i++) {
            if (!checkedOutBooksTitleList.contains(bookWithGivenGenreTitlesArr[i])) {
                availableBookWithGivenGenreTitlesArr[j] = bookWithGivenGenreTitlesArr[i];
                j++;
            }
        }
        Arrays.sort(availableBookWithGivenGenreTitlesArr);
        return availableBookWithGivenGenreTitlesArr;
    }

    public boolean hasBook(String bookTitle) {
        boolean result = false;
        String[] allBooks = listBooks();
        for (int i = 0; i < allBooks.length; i++) {
            if (allBooks[i].equals(bookTitle)) {
                result = true;
            }
        }
        return result;
    }

    public Book checkoutBook(String bookTitle) {
        Book book = null;
        if (hasBook(bookTitle) == false) {
            throw new BookNotFoundException(bookTitle);
        } else if (checkedOutBooksTitleList.contains(bookTitle)) {
            throw new BookNotAvailableException(bookTitle);
        }
        for (int i = 0; i < booksList.size(); i++) {
            if (booksList.get(i).getTitle().equals(bookTitle)) {
                book = booksList.get(i);
            }
        }
        checkedOutBooksTitleList.add(bookTitle);
        return book;
    }

    public void returnBook(Book book) {
        checkedOutBooksTitleList.remove(book.getTitle());
    }
}
