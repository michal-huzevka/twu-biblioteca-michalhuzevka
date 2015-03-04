package com.twu.biblioteca.unit.view;

import com.twu.biblioteca.THelper;
import com.twu.biblioteca.view.BookListView;
import org.junit.Test;

/**
 * Created by michal on 2/23/15.
 */
public class BookListViewTest {
    @Test
    public void Output_ShouldDisplayListOfBooks() {

        BookListView view = new BookListView(THelper.listOfBooks());
        String output = view.output();
        assert(output.contains("The Agile Samurai"));
        assert(output.contains("Software Refactoring"));
        assert(output.contains("Design Patterns"));

    }
}
