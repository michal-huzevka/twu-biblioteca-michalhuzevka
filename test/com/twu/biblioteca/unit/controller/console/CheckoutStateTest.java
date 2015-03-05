package com.twu.biblioteca.unit.controller.console;

import com.twu.biblioteca.THelper;
import com.twu.biblioteca.controller.console.CheckoutState;
import com.twu.biblioteca.controller.console.MenuState;
import com.twu.biblioteca.model.LibraryItem;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.UserAccount;
import junit.framework.Assert;
import org.junit.Test;

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
        UserAccount user = THelper.sampleUser();
        library.setActiveUserID(user.getID());
        CheckoutState checkoutState = new CheckoutState(library);
        checkoutState.action("Design Patterns");
        Assert.assertTrue(checkoutState.nextState() instanceof MenuState);
    }

    @Test
    public void Should_MakeItemUnavailable_When_ItemIsCheckedOut() {
        Library library = THelper.initLibrary();
        UserAccount user = THelper.sampleUser();
        library.setActiveUserID(user.getID());
        CheckoutState checkoutState = new CheckoutState(library);
        checkoutState.action("Design Patterns");
        LibraryItem libraryItem = library.getBookByTitle("Design Patterns");
        Assert.assertTrue(!libraryItem.isAvailable());

    }

}
