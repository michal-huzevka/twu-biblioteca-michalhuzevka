package com.twu.biblioteca.model;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by michalhuzevka on 5/03/15.
 */
public class AccountCollection {
    private List<UserAccount> users = new ArrayList<UserAccount>();

    public UserAccount getUser(String ID, String password) {
        for (UserAccount account : users) {
            if ((account.getID().equals(ID)) && (account.getPassword().equals(password))) {
                return account;
            }
        }
        throw new NoSuchElementException();
    }
    public UserAccount getUser(String ID) {
        for (UserAccount account : users) {
            if (account.getID().equals(ID)) {
                return account;
            }
        }
        throw new NoSuchElementException();
    }

    public void add(UserAccount account) {
        users.add(account);
    }

}
