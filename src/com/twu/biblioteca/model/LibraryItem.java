package com.twu.biblioteca.model;

/**
 * Created by michal on 2/23/15.
 */
public class LibraryItem {
    private String title;
    private String author;
    private String yearPublished;
    private ItemStatus bookStatus;

    public LibraryItem(String title) {
        this.setTitle(title);
        setBookStatus(ItemStatus.AVAILABLE);
    }

    public LibraryItem(String title, String author, String yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        setBookStatus(ItemStatus.AVAILABLE);
    }

    public String toString() {
        return getTitle() + " by " + getAuthor() + " in " + getYearPublished();
    }

    public void checkout() throws Exception {
        if (getBookStatus() != ItemStatus.AVAILABLE) {
            throw new Exception("Book is not available for checkout");
        }
        setBookStatus(ItemStatus.CHECKED_OUT);
    }

    public  void returnBook() throws  Exception {
        if (getBookStatus() != ItemStatus.CHECKED_OUT) {
            throw new Exception("Book is already in the library");
        }
        setBookStatus(ItemStatus.AVAILABLE);
    }

    public String getTitle() {
        return title;
    }

    private void setTitle(String title) {
        this.title = title;
    }


    public boolean isAvailable() {
        return getBookStatus() == ItemStatus.AVAILABLE;
    }

    private ItemStatus getBookStatus() {
        return bookStatus;
    }

    private void setBookStatus(ItemStatus bookStatus) {
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
