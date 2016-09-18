package com.lesson.addressbook.tests;

import com.lesson.addressbook.model.ContactData;
import com.lesson.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void ContactCreationTests() {
        List<ContactData> before = app.getContactHelper().getContactList();
        checkCreationGroup();
        app.getContactHelper().createContact(new ContactData("Bob", "Marly", "Dilan", "bobby77", "Job", "Anything address", "999-00-00", "bobby77@pro.com", "facebook.com", "test1"));
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1, "Check list contacts");
    }

    @Test
    public void ContactCreationTests2() {
        List<ContactData> before = app.getContactHelper().getContactList();
        checkCreationGroup();
        app.getContactHelper().createContact(new ContactData("Rob", "Grey", "Stark", "robby88", "Hunt", "In deep forest", "777-00-00", "robert@pro.com", "myspace.com", "test1"));
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1, "Check list contacts");
    }
}
