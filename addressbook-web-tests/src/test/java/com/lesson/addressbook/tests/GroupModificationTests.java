package com.lesson.addressbook.tests;

import com.lesson.addressbook.model.GroupData;
import com.lesson.addressbook.model.Groups;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
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
            Groups before = app.group().all();
            GroupData modifiedGroup = before.iterator().next();
            GroupData group = new GroupData()
                    .withId(modifiedGroup.getId()).withName("test1m").withHeader("test2m").withFooter("test3m");
            app.group().modify(group);
            assertThat(app.group().count(), equalTo(before.size()));
            Groups after = app.group().all();
            assertThat(after, equalTo(before.withOut(modifiedGroup).withAdded(group)));
        }
}

