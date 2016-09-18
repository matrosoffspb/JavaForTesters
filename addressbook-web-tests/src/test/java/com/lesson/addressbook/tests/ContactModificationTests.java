package com.lesson.addressbook.tests;

import com.lesson.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ContactModificationTests extends TestBase {
    @Test
    public void testContactModification() {
        checkCreationGroup();
        app.getContactHelper().goToHomePage();
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Bob", "Marly", "Dilan", "bobby77", "Job", "Anything address", "999-00-00", "bobby77@pro.com", "facebook.com", "test1"));
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().editContact(0);
        app.getContactHelper().fillContactForm(new ContactData("Bob1", "Marly1", "Dilan1", "bobby77", "Job", "Anything address", "999-00-00", "bobby77@pro.com", "facebook.com", null), false);
        app.getContactHelper().updateContact();
        app.getNavigationHelper().returnHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size(), "Check list contacts");
    }
}
