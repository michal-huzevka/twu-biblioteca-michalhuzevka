package com.twu.biblioteca.unit.view;

import com.twu.biblioteca.THelper;
import com.twu.biblioteca.view.BookListView;
import com.twu.biblioteca.view.MovieListView;
import org.junit.Test;

/**
 * Created by michal on 2/23/15.
 */
public class MovieListViewTest {
    @Test
    public void output_ShouldDisplayListOfBooks() {

        MovieListView view = new MovieListView(THelper.listOfMovies());
        String output = view.output();
        assert(output.contains("Star Wars"));
        assert(output.contains("The Shawshank Redemption"));

    }
}
