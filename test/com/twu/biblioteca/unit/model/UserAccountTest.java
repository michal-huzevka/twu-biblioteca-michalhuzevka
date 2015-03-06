package com.twu.biblioteca.unit.model;

import com.twu.biblioteca.model.*;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by michalhuzevka on 5/03/15.
 */
public class UserAccountTest {
    @Test
    public void Should_InitializeMembers_AfterConstructorIsCalled() {
        UserAccount account = new UserAccount("1234", "asd123", "John", "Smith", "a@hotmail.com", "44445555", UserType.CUSTOMER);
        assertTrue(account.getID().equals("1234"));
        assertTrue(account.getPassword().equals("asd123"));
        assertTrue(account.getFirstName().equals("John"));
        assertTrue(account.getLastName().equals("Smith"));
        assertTrue(account.getEmail().equals("a@hotmail.com"));
        assertTrue(account.getPhoneNumber().equals("44445555"));
        assertTrue(account.getUserType().equals(UserType.CUSTOMER));

    }
}
