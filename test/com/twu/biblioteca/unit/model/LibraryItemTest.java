package com.twu.biblioteca.unit.model;

import com.twu.biblioteca.THelper;
import com.twu.biblioteca.model.LibraryItem;
import com.twu.biblioteca.model.UserAccount;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by michal on 2/23/15.
 */
public class LibraryItemTest {
    @Test
    public void should_UpdateStatus_WhenBookIsCheckedOut() throws Exception{
        LibraryItem libraryItem = sampleLibraryItem();
        UserAccount user = THelper.sampleUser();

        assertTrue(libraryItem.isAvailable());
        assertTrue(libraryItem.getBorrower() == null);
        libraryItem.checkout(user);
        assertTrue(!libraryItem.isAvailable());
        assertEquals(user, libraryItem.getBorrower());


    }

    @Test
    public void should_ThrowException_IfBookIsCheckedOutTwice() throws  Exception{
        LibraryItem libraryItem = sampleLibraryItem();
        UserAccount user = THelper.sampleUser();

        libraryItem.checkout(user);
        try {
            libraryItem.checkout(user);
            Assert.fail();
        } catch (Exception ex) {

        }
    }

    @Test
    public void should_UpdateStatus_WhenBookIsReturned() throws Exception{
        LibraryItem libraryItem = sampleLibraryItem();
        UserAccount user = THelper.sampleUser();

        assert(libraryItem.isAvailable());

        libraryItem.checkout(user);
        assert(!libraryItem.isAvailable());

        libraryItem.returnItem();
        assert (libraryItem.isAvailable());

    }

    @Test
    public void should_ThrowException_IfBookIsIncorrectlyReturned() throws  Exception{
        LibraryItem libraryItem = sampleLibraryItem();
        UserAccount user = THelper.sampleUser();
        try {
            libraryItem.returnItem();
            Assert.fail();
        } catch (Exception ex) {

        }
    }


    private LibraryItem sampleLibraryItem() {
        return new LibraryItem("Software Refactoring", "2003");
    }

}
