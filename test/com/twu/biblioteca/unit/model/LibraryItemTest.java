package com.twu.biblioteca.unit.model;

import com.twu.biblioteca.THelper;
import com.twu.biblioteca.model.LibraryItem;
import com.twu.biblioteca.model.UserAccount;
import org.junit.Assert;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;
/**
 * Created by michal on 2/23/15.
 */
public class LibraryItemTest {
    @Test
    public void should_UpdateStatus_WhenItemIsCheckedOut() throws Exception{
        LibraryItem libraryItem = sampleLibraryItem();
        UserAccount user = THelper.sampleUser();

        libraryItem.checkout(user);
        assertEquals(user, libraryItem.getBorrower());
    }

    public void should_HaveCorrectBorrower_WhenItemIsCheckedOut() throws Exception{
        LibraryItem libraryItem = sampleLibraryItem();
        UserAccount user = THelper.sampleUser();

        libraryItem.checkout(user);
        assertEquals(user, libraryItem.getBorrower());
    }

    @Test  (expected = Exception.class)
    public void should_ThrowException_IfItemIsCheckedOutTwice() throws  Exception{
        LibraryItem libraryItem = sampleLibraryItem();
        UserAccount user = THelper.sampleUser();

        libraryItem.checkout(user);
        libraryItem.checkout(user);
    }

    @Test
    public void should_UpdateStatus_WhenItemIsReturned() throws Exception{
        LibraryItem libraryItem = sampleLibraryItem();
        UserAccount user = THelper.sampleUser();
        libraryItem.checkout(user);

        libraryItem.returnItem();
        assertTrue (libraryItem.isAvailable());

    }

    @Test (expected = Exception.class)
    public void should_ThrowException_IfItemIsIncorrectlyReturned() throws  Exception{
        LibraryItem libraryItem = sampleLibraryItem();
        UserAccount user = THelper.sampleUser();
        libraryItem.returnItem();
    }


    private LibraryItem sampleLibraryItem() {
        return new LibraryItem("Software Refactoring", "2003");
    }

}
