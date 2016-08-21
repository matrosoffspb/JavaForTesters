package com.lesson.addressbook.tests;

import com.lesson.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void ContactCreationTests() {
        app.goToAddNewContact();
        app.fillContactForm(new ContactData("Bob", "Marly", "Dilan", "bobby77", "Job", "Anything address", "999-00-00", "bobby77@pro.com", "facebook.com"));
        app.submitCreationContact();
        app.getNavigationHelper().returnHomePage();
    }
    @Test
    public void ContactCreationTests2() {
        app.goToAddNewContact();
        app.fillContactForm(new ContactData("Rob", "Grey", "Stark", "robby88", "Hunt", "In deep forest", "777-00-00", "robert@pro.com", "myspace.com"));
        app.submitCreationContact();
        app.getNavigationHelper().returnHomePage();
    }
}
