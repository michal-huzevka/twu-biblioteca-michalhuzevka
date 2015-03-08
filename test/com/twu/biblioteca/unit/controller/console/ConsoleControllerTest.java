package com.twu.biblioteca.unit.controller.console;

import com.twu.biblioteca.THelper;
import com.twu.biblioteca.controller.console.ConsoleController;
import com.twu.biblioteca.view.*;
import org.junit.Test;

/**
 * Created by michal on 2/23/15.
 */
public class ConsoleControllerTest {

    @Test
    public void should_Terminate_WhenQIsPressed() {
        ConsoleController controller = new ConsoleController(THelper.initLibrary());
        assert(!controller.isTerminated());
        controller.action("Q");
        assert(controller.isTerminated());
    }

    @Test
    public void should_DisplayBookList_WhenBIsPressed() {
        ConsoleController controller = new ConsoleController(THelper.initLibrary());
        View view = controller.action("B");
        assert (view instanceof BookListView);
    }
}
