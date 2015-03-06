package com.twu.biblioteca.unit.view;

import com.twu.biblioteca.THelper;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.UserAccount;
import com.twu.biblioteca.view.BookListView;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
/**
 * Created by michal on 2/23/15.
 */
public class BookListViewTest {
    @Test
    public void Output_ShouldDisplayListOfBooks() {

        BookListView view = new BookListView(THelper.listOfBooks());
        String output = view.output();
        assertTrue(output.contains("The Agile Samurai"));
        assertTrue(output.contains("Software Refactoring"));
        assertTrue(output.contains("Design Patterns"));

    }

}
