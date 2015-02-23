package com.twu.biblioteca.model;

/**
 * Created by michal on 2/23/15.
 */
public class Book {
    private String title;
    private String author;
    private String yearPublished;
    private BookStatus bookStatus;

    public Book(String title) {
        this.setTitle(title);
        setBookStatus(BookStatus.AVAILABLE);
    }

    public Book(String title, String author, String yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        setBookStatus(BookStatus.AVAILABLE);
    }

    public String toString() {
        return getTitle() + " by " + getAuthor() + " in " + getYearPublished();
    }

    public void checkout() throws Exception {
        if (getBookStatus() != BookStatus.AVAILABLE) {
            throw new Exception("Book is not available for checkout");
        }
        setBookStatus(BookStatus.CHECKED_OUT);
    }

    public  void returnBook() throws  Exception {
        if (getBookStatus() != BookStatus.CHECKED_OUT) {
            throw new Exception("Book is already in the library");
        }
        setBookStatus(BookStatus.AVAILABLE);
    }

    public String getTitle() {
        return title;
    }

    private void setTitle(String title) {
        this.title = title;
    }


    public boolean isAvailable() {
        return getBookStatus() == BookStatus.AVAILABLE;
    }

    private BookStatus getBookStatus() {
        return bookStatus;
    }

    private void setBookStatus(BookStatus bookStatus) {
        this.bookStatus = bookStatus;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(String yearPublished) {
        this.yearPublished = yearPublished;
    }
}
