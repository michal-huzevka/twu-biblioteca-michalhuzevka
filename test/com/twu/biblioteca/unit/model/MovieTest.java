package com.twu.biblioteca.unit.model;

import com.twu.biblioteca.model.*;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;


public class MovieTest {
    @Test
    public void Should_UpdateStatus_WhenMovieIsCheckedOut() throws Exception{
        Movie movie = sampleMovie();
        assert(movie.isAvailable());

        movie.checkout();
        assert(!movie.isAvailable());

    }

    @Test
    public void Should_ThrowException_IfMovieIsCheckedOutTwice() throws  Exception{
        Movie movie = sampleMovie();

        movie.checkout();
        try {
            movie.checkout();
            Assert.fail();
        } catch (Exception ex) {

        }
    }

    @Test
    public void Should_UpdateStatus_WhenMovieIsReturned() throws Exception{
        Movie movie = sampleMovie();
        assert(movie.isAvailable());

        movie.checkout();
        assert(!movie.isAvailable());

        movie.returnItem();
        assert (movie.isAvailable());

    }

    @Test
    public void Should_ThrowException_IfMovieIsIncorrectlyReturned() throws  Exception{
        Movie movie = sampleMovie();

        try {
            movie.returnItem();
            Assert.fail();
        } catch (Exception ex) {

        }
    }

    @Test
    public void Should_InitializeMembers_AfterConstructorIsCalled() {
        Movie movie = sampleMovie();
        assertTrue(movie.getTitle().equals("Star Wars"));
        assertTrue(movie.getDirector().equals("Steven Spielberg"));
        assertTrue(movie.getYearCreated().equals("1979"));
        assertTrue(movie.getRating().equals("10"));
    }

    private Movie sampleMovie() {
        return new Movie("Star Wars", "Steven Spielberg", "1979", "10");
    }

}
