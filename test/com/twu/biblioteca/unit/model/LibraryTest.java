package com.twu.biblioteca.unit.model;
import com.twu.biblioteca.THelper;
import com.twu.biblioteca.model.*;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

/**
 * Created by michal on 2/23/15.
 */
public class LibraryTest {

    @Test
    public void Should_ListAvailableBooks_When_BooksAreAdded() {
        List<Book> initialList = THelper.listOfBooks();
        Library library = new Library();
        library.addBooks(initialList);

        List<Book> availableLibraryItems = library.getAvailableBooks();
        assert(availableLibraryItems.containsAll(initialList));

        Book book = new Book("Test", "Test Author", "2003");
        library.addBook(book);

        availableLibraryItems = library.getAvailableBooks();
        assertTrue(availableLibraryItems.contains(book));

    }

    @Test
    public void Should_ListAvailableMovies_When_MoviesAreAdded() {
        List<Movie> initialList = THelper.listOfMovies();
        Library library = new Library();
        library.addMovies(initialList);

        List<Movie> availableMovies = library.getAvailableMovies();
        assertTrue(availableMovies.containsAll(initialList));

        Movie movie = new Movie("TestMovie", "Test", "2003", "10");
        library.addMovie(movie);
        availableMovies = library.getAvailableMovies();
        assertTrue(availableMovies.contains(movie));
    }




    @Test
    public void Should_RemoveBook_When_BookIsCheckedOut() throws Exception {
        Library library = THelper.initLibrary();

        LibraryItem libraryItem = library.getBookByTitle("The Agile Samurai");
        library.checkoutItem(libraryItem);
        List<Book> availableLibraryItems = library.getAvailableBooks();
        for (LibraryItem tmpLibraryItem : availableLibraryItems) {
            assert(tmpLibraryItem != libraryItem);
        }
    }

    @Test
    public void GetBookByTitle_Should_ReturnBook() {
        Library library = THelper.initLibrary();
        LibraryItem libraryItem = library.getBookByTitle("The Agile Samurai");
        assert (libraryItem.getTitle().equals("The Agile Samurai"));
    }

    @Test
    public void GetBookByTitle_Should_ThrowException_When_NoBooksExist() {
        Library library = THelper.initLibrary();
        try {
            LibraryItem libraryItem = library.getBookByTitle("Test book");
            Assert.fail("Exception not thrown");

        }
        catch (NoSuchElementException e) {

        }
    }

    @Test
    public void GetMovieByTitle_Should_ReturnMovie() {
        Library library = THelper.initLibrary();
        LibraryItem libraryItem = library.getMovieByTitle("The Shawshank Redemption");
        assert (libraryItem.getTitle().equals("The Shawshank Redemption"));
    }

    @Test
    public void GetMovieByTitle_Should_ThrowException_When_NoBooksExist() {
        Library library = THelper.initLibrary();
        try {
            LibraryItem libraryItem = library.getMovieByTitle("Test movie");
            Assert.fail("Exception not thrown");

        }
        catch (NoSuchElementException e) {

        }
    }

    @Test
    public void BookExists_Should_ReturnTrue_IfItExists() {
        Library library = THelper.initLibrary();
        assertFalse(library.bookExists("Test book"));
    }

    @Test
    public void BookExists_Should_ReturnFalse_IfItDoesntExist() {
        Library library = THelper.initLibrary();
        assertTrue(library.bookExists("The Agile Samurai"));
    }

    @Test
    public void MovieExists_Should_ReturnTrue_IfItExists() {
        Library library = THelper.initLibrary();
        assertFalse(library.movieExists("Test movie"));
    }

    @Test
    public void MovieExists_Should_ReturnFalse_IfItDoesntExist() {
        Library library = THelper.initLibrary();
        assertTrue(library.movieExists("The Shawshank Redemption"));
    }

}
