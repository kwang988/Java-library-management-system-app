package com.kenzie.library;

import java.util.Arrays;

public class Book {
    //declare properties
    private String title;
    private String author;
    private Genre genre;
    private String[] pages;
    private int currentPageNum = 0;

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
    public int getCurrentPageNumber() {
        return currentPageNum;
    }

    public String nextPage() {
        if (currentPageNum == pages.length - 1) {
            return null;
        } else {
            currentPageNum++;
            return pages[currentPageNum];
        }
    }

    public String prevPage() {
        if (currentPageNum == 0) {
            return null;
        } else {
            currentPageNum--;
            return pages[currentPageNum];
        }
    }

    public String openPage(int pageNumber) {
        currentPageNum = pageNumber;
        return pages[currentPageNum];
    }

    public String tearOutCurrentPage() {
        String tearOutPage = pages[currentPageNum];
        String newPointToStr = "";
        if (currentPageNum != pages.length - 1) {
            newPointToStr = pages[currentPageNum + 1];
        } else {
            currentPageNum--;
        }
        String[] newPages = new String[pages.length - 1];
        for (int i = 0, j = 0; i < pages.length; i++) {
            if (i != currentPageNum) {
                newPages[j++] = pages[i];
            }
        }
        newPages[currentPageNum] = newPointToStr;
        pages = newPages;
        return tearOutPage;
    }

    public int getNumPages() {
        return pages.length;
    }

    public int getPercentComplete() {
        return getCurrentPageNumber() * 100 / (getNumPages() - 1);
    }
}
