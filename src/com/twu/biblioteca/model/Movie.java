package com.twu.biblioteca.model;

/**
 * Created by michalhuzevka on 5/03/15.
 */
public class Movie extends LibraryItem {
    private String director;
    private String rating;

    public Movie(String title, String director, String year, String rating) {
        super(title, year);
        setDirector(director);
        setRating(rating);
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String toString() {
        return getTitle() + " by " + getDirector() + " in " + getYearCreated();
    }
}
