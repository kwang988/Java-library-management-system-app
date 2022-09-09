package com.kenzie.library;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BookTest {
	public static final String TEST_TITLE = "Book Title";
	public static final String TEST_AUTHOR = "Author Name";
	public static final String PAGE_ZERO = "Page Zero...";	
	public static final String PAGE_ONE = "Page One...";	
	public static final String PAGE_TWO = "Page Two...";
	public static final String PAGE_THREE = "Page Three...";
	public static final String PAGE_FOUR = "Page Four...";
	

	public static Book getTestBook() {
		Genre genre = Genre.SCIENCE_FICTION;
		String[] pages = new String[]{PAGE_ZERO, PAGE_ONE, PAGE_TWO, PAGE_THREE, PAGE_FOUR};
		Book book = new Book(TEST_TITLE, TEST_AUTHOR, genre, pages);
		return book;
	}
	

    @Test
	void canCreateBook() {
        Book book = getTestBook();
		assertEquals(TEST_TITLE, book.getTitle(), "getTitle() returns the provided book title");
		assertEquals(TEST_AUTHOR, book.getAuthor(), "getAuthor() returns the provided author name");
		assertEquals(Genre.SCIENCE_FICTION, book.getGenre(), "getGenre() returns the provided genre");
		assertEquals(5, book.getNumPages(), "getNumPages() returns the provided number of pages");
	}

	@Test
	void canNavigateNextAndPrev() {
		Book book = getTestBook();
		assertEquals(0, book.getCurrentPageNumber(), "Book starts at page 0");
		String currentPage = book.nextPage();
		assertEquals(1, book.getCurrentPageNumber(), "after nextPage() the book is at page 1");
		assertEquals(currentPage, PAGE_ONE, "Page 1 matches the given page");
		currentPage = book.nextPage();
		assertEquals(2, book.getCurrentPageNumber(), "after nextPage() the book is at page 2");
		assertEquals(currentPage, PAGE_TWO, "Page 2 matches the given page");
		currentPage = book.prevPage();
		assertEquals(1, book.getCurrentPageNumber(), "after prevPage() the book is back at page 1");
		assertEquals(currentPage, PAGE_ONE, "Page 1 matches the given page");
		currentPage = book.prevPage();
		assertEquals(0, book.getCurrentPageNumber(), "after prevPage() the book is back at page 0");
		assertEquals(currentPage, PAGE_ZERO, "Page 0 matches the given page");
		currentPage = book.prevPage();
		assertEquals(currentPage, null, "prevPage returns null when there is no previous page.");
		assertEquals(0, book.getCurrentPageNumber(), "The page number stays at zero when you cannot go back");

		currentPage = book.nextPage();
		currentPage = book.nextPage();
		currentPage = book.nextPage();
		currentPage = book.nextPage();
		currentPage = book.nextPage();
		assertEquals(currentPage, null, "nextPage returns null when there is no next page.");
		assertEquals(4, book.getCurrentPageNumber(), "The page number stays at the last page when you cannot go next");
	}

	@Test
	void canOpenSpecificPages() {
		Book book = getTestBook();
		String currentPage = book.openPage(3);
		assertEquals(3, book.getCurrentPageNumber(), "The book can open to page 3");
		assertEquals(currentPage, PAGE_THREE, "Page 3 matches the given page");

		currentPage = book.openPage(4);
		assertEquals(4, book.getCurrentPageNumber(), "The book can open to the last page");
		assertEquals(currentPage, PAGE_FOUR, "Page 4 matches the given page");

		currentPage = book.openPage(0);
		assertEquals(0, book.getCurrentPageNumber(), "The book can open to the first page");
		assertEquals(currentPage, PAGE_ZERO, "Page 0 matches the given page");
	}

	@Test
	void canTearOutPage() {
		Book book = getTestBook();
		book.openPage(3);
		assertEquals(3, book.getCurrentPageNumber(), "Book opens to page 3");
		String currentPage = book.tearOutCurrentPage();
		assertEquals(4, book.getNumPages(), "The book is one page shorter after tearing out a page");
		assertEquals(currentPage, PAGE_THREE, "The torn out page is returned");

		currentPage = book.openPage(3);
		assertEquals(currentPage, PAGE_FOUR, "The page 3 now points to page 4");

		book.tearOutCurrentPage();
		assertEquals(3, book.getNumPages(), "The book is one page shorter after tearing out a page");
		assertEquals(2, book.getCurrentPageNumber(), "The current page decrements one when you tear out the last page.");
	}

	@Test 
	void canGetProgressPercentage() {
		Book book = getTestBook();
		assertEquals(0, book.getPercentComplete());
		book.nextPage();
		assertEquals(25, book.getPercentComplete());
		book.nextPage();
		assertEquals(50, book.getPercentComplete());
		book.nextPage();
		assertEquals(75, book.getPercentComplete());
		book.nextPage();
		assertEquals(100, book.getPercentComplete());
	}
}
