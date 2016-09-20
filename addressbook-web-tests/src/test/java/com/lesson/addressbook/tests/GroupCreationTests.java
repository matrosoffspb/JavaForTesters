package com.lesson.addressbook.tests;

import com.lesson.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Set;


public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.goTo().groupPage();
        Set<GroupData> before = app.group().all();
        GroupData group = new GroupData().withName("test2");
        app.group().create(group);
        Set<GroupData> after = app.group().all();
        Assert.assertEquals(after.size(), before.size() + 1, "Check count groups" );

        group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
        before.add(group);
        Assert.assertEquals(before, after, "Check list");
    }

}
