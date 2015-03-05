package com.twu.biblioteca.model;

/**
 * Created by michal on 2/23/15.
 */
public class LibraryItem {
    private String title;
    private String author;
    private String yearPublished;
    private ItemStatus itemStatus;

    public LibraryItem(String title) {
        this.setTitle(title);
        setItemStatus(ItemStatus.AVAILABLE);
    }

    public LibraryItem(String title, String author, String yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        setItemStatus(ItemStatus.AVAILABLE);
    }

    public String toString() {
        return getTitle() + " by " + getAuthor() + " in " + getYearPublished();
    }

    public void checkout() throws Exception {
        if (getItemStatus() != ItemStatus.AVAILABLE) {
            throw new Exception("Item is not available for checkout");
        }
        setItemStatus(ItemStatus.CHECKED_OUT);
    }

    public  void returnBook() throws  Exception {
        if (getItemStatus() != ItemStatus.CHECKED_OUT) {
            throw new Exception("Item is already in the library");
        }
        setItemStatus(ItemStatus.AVAILABLE);
    }

    public String getTitle() {
        return title;
    }

    private void setTitle(String title) {
        this.title = title;
    }


    public boolean isAvailable() {
        return getItemStatus() == ItemStatus.AVAILABLE;
    }

    private ItemStatus getItemStatus() {
        return itemStatus;
    }

    private void setItemStatus(ItemStatus bookStatus) {
        this.itemStatus = bookStatus;
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
