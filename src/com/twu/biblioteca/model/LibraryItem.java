package com.twu.biblioteca.model;

/**
 * Created by michal on 2/23/15.
 */
public class LibraryItem {
    private String title;
    private String yearCreated;
    private ItemStatus itemStatus;

    public LibraryItem(String title, String yearCreated) {
        this.title = title;
        this.yearCreated = yearCreated;
        setItemStatus(ItemStatus.AVAILABLE);
    }

    public void checkout() throws Exception {
        if (getItemStatus() != ItemStatus.AVAILABLE) {
            throw new Exception("Item is not available for checkout");
        }
        setItemStatus(ItemStatus.CHECKED_OUT);
    }

    public  void returnItem() throws  Exception {
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


    public String getYearCreated() {
        return yearCreated;
    }

    public void setYearCreated(String yearCreated) {
        this.yearCreated = yearCreated;
    }
}
