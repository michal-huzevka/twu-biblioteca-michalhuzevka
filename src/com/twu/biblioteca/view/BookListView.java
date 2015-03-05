package com.twu.biblioteca.view;

import com.twu.biblioteca.model.LibraryItem;

import java.util.List;

/**
 * Created by michal on 2/23/15.
 */
public class BookListView implements View {
    List<LibraryItem> libraryItems;
    public BookListView(List<LibraryItem> libraryItems) {

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
