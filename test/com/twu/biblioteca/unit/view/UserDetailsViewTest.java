package com.twu.biblioteca.unit.view;

import com.twu.biblioteca.THelper;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.model.UserAccount;
import com.twu.biblioteca.model.UserType;
import com.twu.biblioteca.view.LibrarianMovieListView;
import com.twu.biblioteca.view.UserDetailsView;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by michalhuzevka on 6/03/15.
 */
public class UserDetailsViewTest {

    @Test
    public void Output_ShouldDisplayListOfMovies() throws Exception {
        UserAccount sampleUser = new UserAccount("1234", "asd123", "John", "Smith", "john@hotmail.com", "44445555", UserType.CUSTOMER);
        UserDetailsView view = new UserDetailsView(sampleUser);
        String output = view.output();
        String[] lines = output.split("\r\n");
        assertTrue(lines[0].equals("Name: John Smith"));
        assertTrue(lines[1].equals("Phone Number: 44445555"));
        assertTrue(lines[2].equals("Email: john@hotmail.com"));

    }
}
