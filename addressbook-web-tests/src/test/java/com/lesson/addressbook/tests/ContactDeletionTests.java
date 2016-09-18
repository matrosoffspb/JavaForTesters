package com.lesson.addressbook.tests;

import com.lesson.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ContactDeletionTests extends TestBase {

    @Test
    public void ContactDeletionTests() {
        checkCreationGroup();
        app.getContactHelper().goToHomePage();
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Bob", "Marly", "Dilan", "bobby77", "Job", "Anything address", "999-00-00", "bobby77@pro.com", "facebook.com", "test1"));
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() -1);
        app.getContactHelper().deleteContact();
        app.getContactHelper().closeAlertWindow();
        app.getContactHelper().goToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1, "Check list contacts");

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);
        }
    }
