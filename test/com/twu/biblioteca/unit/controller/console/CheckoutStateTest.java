package com.twu.biblioteca.unit.controller.console;

import com.twu.biblioteca.THelper;
import com.twu.biblioteca.controller.console.CheckoutState;
import com.twu.biblioteca.controller.console.ConsoleController;
import com.twu.biblioteca.controller.console.MenuState;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.view.BookListView;
import com.twu.biblioteca.view.View;
import junit.framework.Assert;
import org.junit.Test;

import java.awt.*;

/**
 * Created by michal on 2/23/15.
 */
public class CheckoutStateTest {

    @Test
    public void Should_ReturnToMenu_WhenRIsPressed() {
        Library library = THelper.initLibrary();
        CheckoutState checkoutState = new CheckoutState(library);
        checkoutState.action("r");
        Assert.assertTrue(checkoutState.nextState() instanceof MenuState);
    }

    @Test
    public void Should_ReturnToMenu_When_ItemIsCheckedOut() {
        Library library = THelper.initLibrary();
        CheckoutState checkoutState = new CheckoutState(library);
        checkoutState.action("Design Patterns");
        Assert.assertTrue(checkoutState.nextState() instanceof MenuState);
    }

    @Test
    public void Should_MakeItemUnavailable_When_ItemIsCheckedOut() {
        Library library = THelper.initLibrary();
        CheckoutState checkoutState = new CheckoutState(library);
        checkoutState.action("Design Patterns");
        Book book = library.getBookByTitle("Design Patterns");
        Assert.assertTrue(!book.isAvailable());

    }

}
