package com.twu.biblioteca.unit.model;

import com.twu.biblioteca.THelper;
import com.twu.biblioteca.model.*;
import junit.framework.Assert;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by michalhuzevka on 5/03/15.
 */
public class AccountCollectionTest {
    @Test
    public void GetUser_Should_ReturnUser_If_UserExists() {
        AccountCollection collection = THelper.accountCollection();
        UserAccount account = collection.getUser("1234", "asd123");
        assertTrue(account.getID().equals("1234"));
    }

    @Test
    public void GetUser_Should_ThrowException_If_UserDoesntExist() {
        AccountCollection collection = THelper.accountCollection();
        try {
            UserAccount account = collection.getUser("User doesnt exist", "ggg");
            Assert.fail();
        } catch (Exception ex) {

        }
    }
}
