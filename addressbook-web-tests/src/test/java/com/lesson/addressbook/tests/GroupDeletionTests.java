package com.lesson.addressbook.tests;

import com.lesson.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class GroupDeletionTests extends TestBase {

    @BeforeMethod
    public void checkCreationGroup() {
        app.goTo().groupPage();
        if (app.group().all().size() == 0) {
            app.group().create(new GroupData().withName("test1"));
        }
    }

        @Test
        public void testGroupDeletion () {
            Set<GroupData> before = app.group().all();
            GroupData deleteGroup = before.iterator().next();
            app.group().delete(deleteGroup);
            Set<GroupData> after = app.group().all();
            Assert.assertEquals(after.size(), before.size() - 1, "Check count groups");

            before.remove(deleteGroup);
            Assert.assertEquals(before, after, "Check List");
        }



}