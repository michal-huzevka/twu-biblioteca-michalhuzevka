package com.twu.biblioteca.unit.model;

import com.twu.biblioteca.model.*;
import org.junit.Assert;
import org.junit.Test;


public class MovieTest {
    @Test
    public void Should_UpdateStatus_WhenMovieIsCheckedOut() throws Exception{
        Movie movie = new Movie("Star Wars");
        assert(movie.isAvailable());

        movie.checkout();
        assert(!movie.isAvailable());

    }

    @Test
    public void Should_ThrowException_IfMovieIsCheckedOutTwice() throws  Exception{
        Movie movie = new Movie("Star Wars");

        movie.checkout();
        try {
            movie.checkout();
            Assert.fail();
        } catch (Exception ex) {

        }
    }

    @Test
    public void Should_UpdateStatus_WhenMovieIsReturned() throws Exception{
        Movie movie = new Movie("Star Wars");
        assert(movie.isAvailable());

        movie.checkout();
        assert(!movie.isAvailable());

        movie.returnBook();
        assert (movie.isAvailable());

    }

    @Test
    public void Should_ThrowException_IfMovieIsIncorrectlyReturned() throws  Exception{
        Movie movie = new Movie("Star Wars");

        try {
            movie.returnBook();
            Assert.fail();
        } catch (Exception ex) {

        }
    }
}
