package com.lesson.addressbook.tests;

import com.lesson.addressbook.model.ContactData;
import com.lesson.addressbook.model.Contacts;
import com.lesson.addressbook.model.GroupData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void checkCreationGroup() {
        app.goTo().groupPage();
        if (app.group().all().size() == 0) {
            app.group().create(new GroupData().withName("test1"));
        }
        app.goTo().homePage();
    }

    @Test
    public void ContactDeletionTests() {
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData()
                    .withFirstname("Bob").withMiddlename("Marly").withLastname("Dilan").withNickname("bobby77")
                    .withComapany("Job").withAddress("Anything address").withHomephone("999-00-00")
                    .withEmail("bobby77@pro.com").withHomepage("facebook.com").withGroup("test1"));
        }
        Contacts before = app.contact().all();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        Contacts after = app.contact().all();
        assertThat(after.size(), equalTo(before.size() - 1));
        assertThat(after, equalTo(before.withOut(deletedContact)));
        }


}
