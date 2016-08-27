package com.lesson.addressbook.tests;

import com.lesson.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
    @Test
    public void testContactModification() {
        app.getContactHelper().editContact();
        app.getContactHelper().fillContactForm(new ContactData("Bob1", "Marly1", "Dilan1", "bobby77", "Job", "Anything address", "999-00-00", "bobby77@pro.com", "facebook.com", null), false);
        app.getContactHelper().updateContact();
        app.getNavigationHelper().returnHomePage();
    }
}
