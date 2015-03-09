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
    public void should_ListAllAvailableBooks_When_BooksAreAdded() {
        List<Book> initialList = THelper.listOfBooks();
        Library library = new Library();
        library.addBooks(initialList);

        List<Book> availableLibraryItems = library.getAvailableBooks();
        assert(availableLibraryItems.containsAll(initialList));
    }

    @Test
    public void should_ListAllAvailableMovies_When_MoviesAreAdded() {
        List<Movie> initialList = THelper.listOfMovies();
        Library library = new Library();
        library.addMovies(initialList);

        List<Movie> availableMovies = library.getAvailableMovies();
        assertTrue(availableMovies.containsAll(initialList));
    }

    @Test
    public void should_ListAvailableBooks_When_ABookIsAdded() {
        Library library = new Library();

        Book book = new Book("Test", "Test Author", "2003");
        library.addBook(book);

        List<Book> availableLibraryItems = library.getAvailableBooks();
        assertTrue(availableLibraryItems.contains(book));

    }

    @Test
    public void should_ListAvailableMovies_When_AMovieIsAdded() {
        Library library = new Library();

        Movie movie = new Movie("TestMovie", "Test", "2003", "10");
        library.addMovie(movie);
        List<Movie> availableMovies = library.getAvailableMovies();
        assertTrue(availableMovies.contains(movie));
    }




    @Test
    public void should_RemoveBook_When_BookIsCheckedOut1() throws Exception {
        Library library = THelper.initLibrary();
        UserAccount user = THelper.sampleUser();
        LibraryItem libraryItem = library.getBookByTitle("The Agile Samurai");
        library.checkoutItem(libraryItem, user.getID());
        List<Book> availableLibraryItems = library.getAvailableBooks();
        for (LibraryItem tmpLibraryItem : availableLibraryItems) {
            assertFalse(tmpLibraryItem == libraryItem);
        }
    }

    @Test
    public void should_RemoveBook_When_BookIsCheckedOut2() throws Exception {
        Library library = THelper.initLibrary();
        UserAccount user = THelper.sampleUser();
        Book libraryItem = library.getBookByTitle("The Agile Samurai");
        library.checkoutItem(libraryItem, user.getID());
        List<Book> list = library.getUnavailableBooks();
        Book book = list.get(0);
        assertTrue(book == libraryItem);
    }

    @Test
    public void should_RemoveMovie_When_MovieIsCheckedOut() throws Exception {
        Library library = THelper.initLibrary();
        UserAccount user = THelper.sampleUser();
        Movie libraryItem = library.getMovieByTitle("Star Wars");
        library.checkoutItem(libraryItem, user.getID());
        List<Movie> list = library.getUnavailableMovies();
        Movie movie = list.get(0);
        assertTrue(movie == libraryItem);
    }

    @Test
    public void getBookByTitle_Should_ReturnCorrectBook() {
        Library library = THelper.initLibrary();
        LibraryItem libraryItem = library.getBookByTitle("The Agile Samurai");
        assertTrue(libraryItem.getTitle().equals("The Agile Samurai"));
    }

    @Test (expected = NoSuchElementException.class)
    public void getBookByTitle_Should_ThrowException_When_NoBooksExist() {
        Library library = THelper.initLibrary();
        LibraryItem libraryItem = library.getBookByTitle("Test book");
    }

    @Test
    public void getMovieByTitle_Should_ReturnMovie() {
        Library library = THelper.initLibrary();
        LibraryItem libraryItem = library.getMovieByTitle("The Shawshank Redemption");
        assertTrue (libraryItem.getTitle().equals("The Shawshank Redemption"));
    }

    @Test (expected = NoSuchElementException.class)
    public void getMovieByTitle_Should_ThrowException_When_NoBooksExist() {
        Library library = THelper.initLibrary();
        LibraryItem libraryItem = library.getMovieByTitle("Test movie");
    }

    @Test
    public void bookExists_Should_ReturnTrue_IfItExists() {
        Library library = THelper.initLibrary();
        assertFalse(library.bookExists("Test book"));
    }

    @Test
    public void bookExists_Should_ReturnFalse_IfItDoesntExist() {
        Library library = THelper.initLibrary();
        assertTrue(library.bookExists("The Agile Samurai"));
    }

    @Test
    public void movieExists_Should_ReturnTrue_IfItExists() {
        Library library = THelper.initLibrary();
        assertFalse(library.movieExists("Test movie"));
    }

    @Test
    public void movieExists_Should_ReturnFalse_IfItDoesntExist() {
        Library library = THelper.initLibrary();
        assertTrue(library.movieExists("The Shawshank Redemption"));
    }

}
