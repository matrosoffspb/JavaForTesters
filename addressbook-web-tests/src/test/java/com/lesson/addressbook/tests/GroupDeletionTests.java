package com.lesson.addressbook.tests;

import com.lesson.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class GroupDeletionTests extends TestBase {

    @BeforeMethod
    public void checkCreationGroup() {
        app.getNavigationHelper().gotoGroupPage();
        if (!app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("test1", null, null));
        }
    }

        @Test
        public void testGroupDeletion () {
            List<GroupData> before = app.getGroupHelper().getGroupList();
            app.getGroupHelper().selectGroup(before.size() - 1);
            app.getGroupHelper().deleteGroup();
            app.getGroupHelper().returnGroupPage();
            List<GroupData> after = app.getGroupHelper().getGroupList();
            Assert.assertEquals(after.size(), before.size() - 1, "Check count groups");

            before.remove(before.size() - 1);
            Assert.assertEquals(before, after, "Check List");
        }

    }