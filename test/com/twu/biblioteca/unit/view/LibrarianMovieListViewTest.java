package com.twu.biblioteca.unit.view;

import com.twu.biblioteca.THelper;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.model.UserAccount;
import com.twu.biblioteca.view.LibrarianBookListView;
import com.twu.biblioteca.view.LibrarianMovieListView;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by michalhuzevka on 6/03/15.
 */
public class LibrarianMovieListViewTest {

    @Test
    public void output_ShouldDisplayListOfMovies() throws Exception {
        Library library = THelper.initLibrary();
        UserAccount sampleUser = THelper.sampleUser();
        List<Movie> movies = library.getAvailableMovies();
        for (Movie movie : movies) {
            library.checkoutItem(movie, sampleUser.getID());
        }

        LibrarianMovieListView view = new LibrarianMovieListView(movies);
        String output = view.output();
        assertTrue(output.contains(sampleUser.getFirstName()));
        assertTrue(output.contains(sampleUser.getLastName()));

    }
}
