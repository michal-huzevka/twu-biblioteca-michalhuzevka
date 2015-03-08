package com.twu.biblioteca.unit.controller.console;

import com.twu.biblioteca.THelper;
import com.twu.biblioteca.controller.console.ConsoleController;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.StubReader;
import com.twu.biblioteca.model.StubWriter;
import com.twu.biblioteca.view.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by michal on 2/23/15.
 */
public class ConsoleControllerTest {

    private Library library;
    private StubReader reader;
    private StubWriter writer;
    private ConsoleController controller;

    @Before
    public void setUp() {
        library = THelper.initLibrary();
        reader = new StubReader();
        writer = new StubWriter();
        controller = new ConsoleController(library,reader, writer);
    }

    @Test
    public void should_NotBeTerminated_AfterBeingInitialized() {
        assert (!controller.isTerminated());
    }
    @Test
    public void should_Terminate_WhenQIsPressed() {
        reader.addFakeInput("Q");
        controller.nextAction();
        assert(controller.isTerminated());
    }

    @Test
    public void should_DisplayBookList_WhenBIsPressed() {
        reader.addFakeInput("B");
        controller.nextAction();
        assert (writer.getLastView() instanceof BookListView);
    }
}
