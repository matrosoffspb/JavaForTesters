package com.lesson.addressbook.tests;

import com.lesson.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void checkCreationGroup() {
        app.goTo().groupPage();
        if (app.group().list().size() == 0) {
            app.group().create(new GroupData().withName("test1"));
        }
            }

        @Test
        public void testGroupModification() {
            List<GroupData> before = app.group().list();
            int index = before.size() - 1;
            GroupData group = new GroupData()
                    .withId(before.get(index).getId()).withName("test1m").withHeader("test2m").withFooter("test3m");
            app.group().modify(index, group);
            List<GroupData> after = app.group().list();
            Assert.assertEquals(after.size(), before.size(), "Check count groups");

            before.remove(index);
            before.add(group);
            Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
            before.sort(byId);
            after.sort(byId);
            Assert.assertEquals(before, after, "Check list");
        }


    }

