package com.lesson.addressbook.tests;

import com.lesson.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void checkCreationGroup() {
        app.goTo().groupPage();
        if (app.group().all().size() == 0) {
            app.group().create(new GroupData().withName("test1"));
        }
            }

        @Test
        public void testGroupModification() {
            Set<GroupData> before = app.group().all();
            GroupData modifiedGroup = before.iterator().next();
            GroupData group = new GroupData()
                    .withId(modifiedGroup.getId()).withName("test1m").withHeader("test2m").withFooter("test3m");
            app.group().modify(group);
            Set<GroupData> after = app.group().all();
            Assert.assertEquals(after.size(), before.size(), "Check count groups");

            before.remove(modifiedGroup);
            before.add(group);
            Assert.assertEquals(before, after, "Check list");
        }


    }

