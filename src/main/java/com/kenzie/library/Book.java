package com.kenzie.library;

import java.util.Arrays;

public class Book {
    //declare properties
    private String title;
    private String author;
    private Genre genre;
    private static String[] pages;
    //declare constructor

    public Book(String title, String author, Genre genre, String[] pages) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.pages = pages;
    }
    //declare getter


    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Genre getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre=" + genre +
                ", pages=" + Arrays.toString(pages) +
                '}';
    }

    //declare other methods
    public static int getCurrentPageNumber(){
        return 0;
    }
    public static String nextPage(){
        if (getCurrentPageNumber() < pages.length-1){
        return pages[getCurrentPageNumber()+1];
    }else {
            return "";
        }
    public static String prevPage() {
        if (getCurrentPageNumber() != 0) {
            return pages[getCurrentPageNumber() - 1];
        } else {
            return "";
        }
    }

    public static String openPage(int pageNumber){
        return "";
    }
    public static String tearOutCurrentPage(){
        return "";
    }
    public static int getNumPages(){
        return pages.length;
    }
    public static int getPercentComplete(){
        return 0;
    }
}
