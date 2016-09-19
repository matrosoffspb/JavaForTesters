package com.lesson.addressbook.tests;

import com.lesson.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void checkCreationGroup() {
        app.getNavigationHelper().gotoGroupPage();
        if (!app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("test1", null, null));
        }
    }
        @Test
        public void testGroupModification() {
            List<GroupData> before = app.getGroupHelper().getGroupList();
            int index = before.size() - 1;
            GroupData group = new GroupData(before.get(index).getId(), "test1m", "test2m", "test3m");
            app.getGroupHelper().modifyGroup(index, group);
            List<GroupData> after = app.getGroupHelper().getGroupList();
            Assert.assertEquals(after.size(), before.size(), "Check count groups");

            before.remove(index);
            before.add(group);
            Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
            before.sort(byId);
            after.sort(byId);
            Assert.assertEquals(before, after, "Check list");
        }


    }

