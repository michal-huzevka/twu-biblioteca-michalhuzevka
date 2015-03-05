package com.twu.biblioteca.integration;

//import build.tools.javazic.Main;
import com.twu.biblioteca.THelper;
import com.twu.biblioteca.controller.console.*;
import com.twu.biblioteca.model.LibraryItem;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.UserAccount;
import org.junit.Test;

/**
 * Created by michal on 2/23/15.
 */
public class CheckoutAndReturnTest {
    @Test
    public void CheckOutAndReturn1() {
        Library library = THelper.initLibrary();
        UserAccount user = THelper.sampleUser();
        library.setActiveUserID(user.getID());

        assert(library.getAvailableBooks().size() == 3);

        CheckoutState checkoutState = new CheckoutState(library);
        String book1 = "Design Patterns";
        String book2 = "Software Refactoring";
        checkoutState.action(book1);
        assert (library.getAvailableBooks().size() == 2);

        checkoutState.action(book2);
        assert (library.getAvailableBooks().size() == 1);

        checkoutState.action("asdfga not a book");
        assert (library.getAvailableBooks().size() == 1);


        ReturnState returnState = new ReturnState(library);
        returnState.action(book1);
        assert (library.getAvailableBooks().size() == 2);

        returnState.action(book2);
        assert (library.getAvailableBooks().size() == 3);

        returnState.action("asdfga not a book");
        assert (library.getAvailableBooks().size() == 3);
    }

    @Test
    public void CheckOutAndReturn2() {
        Library library = THelper.initLibrary();
        ConsoleController controller = new ConsoleController(library);
        LibraryItem libraryItem = library.getBookByTitle("Design Patterns");
        assert (libraryItem.isAvailable());
        assert (library.getAvailableBooks().size() == 3);

        controller.action("l");
        controller.action("1234");
        controller.action("asd123");
        controller.action("c");
        controller.action("Design Patterns");
        controller.action("Not a command");

        assert (library.getAvailableBooks().size() == 2);
        assert (!libraryItem.isAvailable());
        controller.action("c");
        controller.action("r");
        controller.action("r");
        controller.action("Test book");
        controller.action("Design Patterns");
        assert (library.getAvailableBooks().size() == 3);
        assert (libraryItem.isAvailable());
        controller.action("r");
        controller.action("Design Patterns");
        assert (library.getAvailableBooks().size() == 3);
        assert (libraryItem.isAvailable());


    }
}
