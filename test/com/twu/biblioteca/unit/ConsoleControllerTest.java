package com.twu.biblioteca.unit;

import com.twu.biblioteca.THelper;
import com.twu.biblioteca.controller.MainController;
import com.twu.biblioteca.controller.console.ConsoleController;
import com.twu.biblioteca.view.*;
import org.junit.Test;

/**
 * Created by michal on 2/23/15.
 */
public class ConsoleControllerTest {

    @Test
    public void Should_Terminate_WhenQIsPressed() {
        ConsoleController controller = new ConsoleController(THelper.initLibrary());
        assert(!controller.isTerminated());
        controller.action("Q");
        assert(controller.isTerminated());
    }

    @Test
    public void Should_DisplayBookList_WhenLIsPressed() {
        ConsoleController controller = new ConsoleController(THelper.initLibrary());
        View view = controller.action("L");
        assert (view instanceof BookListView);
    }
}
