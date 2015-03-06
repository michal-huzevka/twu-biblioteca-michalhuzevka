package com.twu.biblioteca.view;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.LibraryItem;

import java.util.List;

/**
 * Created by michal on 2/23/15.
 */
public class BookListView implements View {
    private List<Book> libraryItems;
    public BookListView(List<Book> libraryItems) {
        this.libraryItems = libraryItems;
    }
    public String output() {
        StringBuilder builder = new StringBuilder();
        for (LibraryItem libraryItem : libraryItems) {
            builder.append(libraryItem.toString() + "\r\n");
        }
        return  builder.toString();
    }
}
