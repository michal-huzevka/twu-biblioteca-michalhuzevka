package com.twu.biblioteca.controller.console;

import com.twu.biblioteca.controller.general.MenuController;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.UserType;
import com.twu.biblioteca.view.GenericView;
import com.twu.biblioteca.view.MenuView;
import com.twu.biblioteca.view.UserDetailsView;
import com.twu.biblioteca.view.View;

import java.util.Dictionary;
import java.util.HashMap;

/**
 * Created by michalhuzevka on 4/03/15.
 */
public class MenuState extends BaseState {
    private Library library;
    private MenuController controller;
    private BaseState nextState;
    private boolean terminated;
    private HashMap<String, ICommand> commands;

    public MenuState(Library library) {
        terminated = false;
        this.library = library;
        nextState = this;
        commands = createCommands();
    }


    private HashMap<String, ICommand> createCommands() {
        HashMap<String, ICommand> hashMap = new HashMap<String, ICommand>();
        hashMap.put("l", new LCommand());
        hashMap.put("b", new BCommand());
        hashMap.put("q", new QCommand());
        hashMap.put("m", new MCommand());
        hashMap.put("c", new CCommand());
        hashMap.put("r", new RCommand());
        hashMap.put("u", new UCommand());
        hashMap.put("o", new OCommand());

        return hashMap;
    }



    public View action(String input) {
        this.controller = new MenuController(library);
        String toLower = input.toLowerCase();
        ICommand command = commands.get(toLower);
        View view = null;
        if (command != null) {
            view = command.run();
        }
        //default view
        if (view == null) {
            view = new GenericView("Select a valid option! Press O to view the menu options. \r\n");
        }
        return view;
    }

    public boolean isTerminated() {
        return terminated;
    }
    public BaseState nextState() {
        return nextState;
    }


    interface ICommand {
        View run();
    }

    private class LCommand implements ICommand {
        public View run() {
            View view;
            if (library.getActiveUser() == null) {
                view = new GenericView("Please enter your library ID to login.\r\n");
                nextState = new EnterLibraryIDState(library);
            } else {
                library.setActiveUserID(null);
                view = new GenericView("You are now logged out. Press O to view the menu options.");
            }
            return view;
        }
    }
    private class BCommand implements  ICommand {
        public View run() {
            View view;
            if (library.getActiveUser() != null && library.getActiveUser().getUserType() == UserType.LIBRARIAN) {
                view = controller.GetUnavailableBooks();
            } else {
                view = controller.GetAvailableBooks();
            }
            return view;
        }
    }

    private class OCommand implements  ICommand {
        public View run() {
            View view;
            view = new MenuView(library.getActiveUser());
            return view;
        }
    }

    private class UCommand implements ICommand {
        public View run() {
            View view = null;
            if (library.getActiveUser() != null && library.getActiveUser().getUserType() == UserType.CUSTOMER) {
                view = new UserDetailsView(library.getActiveUser());
            }
            return view;
        }
    }

    private class RCommand implements ICommand {
        public View run() {
            View view;
            if (library.getActiveUser() != null && library.getActiveUser().getUserType() == UserType.CUSTOMER) {
                view = new GenericView("Please type in the name of the item you wish to return.\r\n");
                nextState = new ReturnState(library);
            } else {
                view = new GenericView("Please login to use that command!\r\n");
            }
            return view;
        }
    }

    private class CCommand implements ICommand {
        public View run() {
            View view;
            if (library.getActiveUser() != null && library.getActiveUser().getUserType() == UserType.CUSTOMER) {
                view = new GenericView("Please type in the name of the item you wish to checkout.\r\n");
                nextState = new CheckoutState(library);
            } else {
                view = new GenericView("Please login to use that command!\r\n");
            }
            return view;
        }
    }

    private class MCommand implements ICommand {
        public View run() {
            View view;
            if (library.getActiveUser() != null && library.getActiveUser().getUserType() == UserType.LIBRARIAN) {
                view = controller.GetUnavailableMovies();
            } else {
                view = controller.GetAvailableMovies();
            }
            return view;
        }
    }

    private class QCommand implements ICommand {
        public View run() {
            View view = new GenericView("");
            terminated = true;
            return view;
        }
    }
}
