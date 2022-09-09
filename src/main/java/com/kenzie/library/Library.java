package com.kenzie.library;

import java.util.ArrayList;

public class Library {
    //declare properties
    private ArrayList<Book> bookList = new ArrayList<>();
    private ArrayList<String> checkedOutBookList = new ArrayList<>();
    //use default constructor

    public Library() {
    }

    //declare methods
    public static void addBook(Book book){

    }
    public static String[] listBooks(){
        return null;
    }
    public static String[] listBooks(Genre genre){
        return null;
    }
    public static String[] listAvailableBooks(){
        return null;
    }
    public static String[] listAvailableBooks(Genre genre){
        return null;
    }
    public static boolean hasBook(String bookTitle){
        return true;
    }
    public static Book checkoutBook(String bookTitle){
        return null;
    }
    public static void returnBook(Book book){

    }
}
