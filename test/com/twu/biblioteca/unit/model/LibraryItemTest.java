package com.twu.biblioteca.unit.model;

import com.twu.biblioteca.model.LibraryItem;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by michal on 2/23/15.
 */
public class LibraryItemTest {
    @Test
    public void Should_UpdateStatus_WhenBookIsCheckedOut() throws Exception{
        LibraryItem libraryItem = sampleLibraryItem();
        assert(libraryItem.isAvailable());

        libraryItem.checkout();
        assert(!libraryItem.isAvailable());

    }

    @Test
    public void Should_ThrowException_IfBookIsCheckedOutTwice() throws  Exception{
        LibraryItem libraryItem = sampleLibraryItem();

        libraryItem.checkout();
        try {
            libraryItem.checkout();
            Assert.fail();
        } catch (Exception ex) {

        }
    }

    @Test
    public void Should_UpdateStatus_WhenBookIsReturned() throws Exception{
        LibraryItem libraryItem = sampleLibraryItem();
        assert(libraryItem.isAvailable());

        libraryItem.checkout();
        assert(!libraryItem.isAvailable());

        libraryItem.returnItem();
        assert (libraryItem.isAvailable());

    }

    @Test
    public void Should_ThrowException_IfBookIsIncorrectlyReturned() throws  Exception{
        LibraryItem libraryItem = sampleLibraryItem();

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
