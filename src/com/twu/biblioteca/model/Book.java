package com.twu.biblioteca.model;

/**
 * Created by michal on 2/23/15.
 */
public class Book {
    private String title;
    private BookStatus bookStatus;

    public Book(String title) {
        this.setTitle(title);
        setBookStatus(BookStatus.AVAILABLE);
    }

    public void checkout() {
        setBookStatus(BookStatus.CHECKED_OUT);
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
}
