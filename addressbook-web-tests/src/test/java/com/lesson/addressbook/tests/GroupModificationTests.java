package com.lesson.addressbook.tests;

import com.lesson.addressbook.model.GroupData;
import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {

    @Test
    public void testGroupModification(){
        checkCreationGroup();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("test1m", "test2m", "test3m"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnGroupPage();
    }

}
