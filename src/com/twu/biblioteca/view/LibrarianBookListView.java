package com.twu.biblioteca.view;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.LibraryItem;
import com.twu.biblioteca.model.UserAccount;

import java.util.List;

/**
 * Created by michal on 2/23/15.
 */
public class LibrarianBookListView implements View {
    private List<Book> libraryItems;
    public LibrarianBookListView(List<Book> libraryItems) {
        this.libraryItems = libraryItems;
    }
    public String output() {
        StringBuilder builder = new StringBuilder();
        for (Book libraryItem : libraryItems) {
            UserAccount borrower = libraryItem.getBorrower();
            String s = libraryItem.getTitle() + " is borrowed by " + borrower.getFirstName() + " " + borrower.getLastName();
            builder.append(s + "\r\n");
        }
        return  builder.toString();
    }
}
