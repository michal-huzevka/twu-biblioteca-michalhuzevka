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
        List<LibraryItem> initialList = THelper.listOfBooks();
        Library library = new Library();
        library.addBooks(initialList);

        List<LibraryItem> availableLibraryItems = library.getAvailableBooks();
        assert(availableLibraryItems.containsAll(initialList));

    }

    @Test
    public void Should_ListAvailableMovies_When_MoviesAreAdded() {
        List<Movie> initialList = THelper.listOfMovies();
        Library library = new Library();
        library.addMovies(initialList);

        List<Movie> availableMovies = library.getAvailableMovies();
        assertTrue(availableMovies.containsAll(initialList));
    }




    @Test
    public void Should_RemoveBook_When_BookIsCheckedOut() throws Exception {
        Library library = THelper.initLibrary();

        LibraryItem libraryItem = library.getBookByTitle("The Agile Samurai");
        library.checkoutBook(libraryItem);
        List<LibraryItem> availableLibraryItems = library.getAvailableBooks();
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

}
