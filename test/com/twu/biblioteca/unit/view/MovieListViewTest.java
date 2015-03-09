package com.twu.biblioteca.unit.view;

import com.twu.biblioteca.THelper;
import com.twu.biblioteca.view.BookListView;
import com.twu.biblioteca.view.MovieListView;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
/**
 * Created by michal on 2/23/15.
 */
public class MovieListViewTest {
    @Test
    public void output_ShouldDisplayListOfBooks() {

        MovieListView view = new MovieListView(THelper.listOfMovies());
        String output = view.output();
        assertTrue(output.contains("Star Wars"));
        assertTrue(output.contains("The Shawshank Redemption"));

    }
}
