package com.lesson.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

    @Test
    public void ContactDeletionTests() {
        app.selectContact();
        app.deleteContact();
        app.closeAlertWindow();
    }

}
