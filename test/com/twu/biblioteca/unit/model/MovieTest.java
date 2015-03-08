package com.twu.biblioteca.unit.model;

import com.twu.biblioteca.model.*;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;


public class MovieTest {

    @Test
    public void should_InitializeMembers_AfterConstructorIsCalled() {
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
