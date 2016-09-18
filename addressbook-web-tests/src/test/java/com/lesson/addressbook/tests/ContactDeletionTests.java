package com.lesson.addressbook.tests;

import com.lesson.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

    @Test
    public void ContactDeletionTests() {
        checkCreationGroup();
        app.getContactHelper().goToHomePage();
        int before = app.getContactHelper().getContactCount();
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Bob", "Marly", "Dilan", "bobby77", "Job", "Anything address", "999-00-00", "bobby77@pro.com", "facebook.com", "test1"));
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteContact();
        app.getContactHelper().closeAlertWindow();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before - 1, "Check list contacts");
    }

}
