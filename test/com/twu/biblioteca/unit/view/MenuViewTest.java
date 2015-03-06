package com.twu.biblioteca.unit.view;

import com.twu.biblioteca.THelper;
import com.twu.biblioteca.view.MenuView;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
/**
 * Created by michalhuzevka on 5/03/15.
 */
public class MenuViewTest {
    @Test
    public void Should_DisplayCorrectly_If_UserIsLoggedInAsCustomer() {
        MenuView view = new MenuView(THelper.sampleUser());
        assertTrue(view.output().contains("C to Check out an item"));
        assertTrue(view.output().contains("R to Return an item"));
        assertFalse(view.output().contains("L to Login"));
    }

    @Test
    public void Should_DisplayCorrectly_If_UserIsNotLoggedin() {
        MenuView view = new MenuView(null);
        assertFalse(view.output().contains("C to Check out an item"));
        assertFalse(view.output().contains("R to Return an item"));
        assertTrue(view.output().contains("L to Login"));
    }

    @Test
    public void Should_DisplayCorrectly_If_UserIsLoggedInAsLibrarian() {
        MenuView view = new MenuView(THelper.sampleLibrarian());
        assertTrue(view.output().contains("B to list borrowed Books"));
        assertTrue(view.output().contains("M to list borrowed Movies"));
        assertFalse(view.output().contains("C to Check out an item"));
        assertFalse(view.output().contains("R to Return an item"));
        assertFalse(view.output().contains("L to Login"));
    }

}
