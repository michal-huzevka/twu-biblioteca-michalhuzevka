package com.twu.biblioteca.unit;

import com.twu.biblioteca.THelper;
import com.twu.biblioteca.controller.MainController;
import com.twu.biblioteca.view.*;
import org.junit.Test;

/**
 * Created by michal on 2/23/15.
 */
public class MainControllerTest {

    @Test
    public void Should_Terminate_WhenQIsPressed() {
        MainController controller = new MainController(THelper.initLibrary());
        assert(!controller.isTerminated());
        controller.action("Q");
        assert(controller.isTerminated());
    }

    @Test
    public void Should_DisplayBookList_WhenLIsPressed() {
        MainController controller = new MainController(THelper.initLibrary());
        View view = controller.action("L");
        assert (view instanceof BookListView);
    }
}
