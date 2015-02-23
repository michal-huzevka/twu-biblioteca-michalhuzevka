package com.twu.biblioteca.view;

import com.twu.biblioteca.model.Book;

import java.util.List;

/**
 * Created by michal on 2/23/15.
 */
public class BookListView implements View {
    List<Book> books;
    public BookListView(List<Book> books) {

        this.books = books;
    }
    public String output() {
        StringBuilder builder = new StringBuilder();
        for (Book book : books) {
            builder.append(book.toString() + "\r\n");
        }
        return  builder.toString();
    }
}
