package com.lesson.addressbook.tests;

import com.lesson.addressbook.model.ContactData;
import com.lesson.addressbook.model.Contacts;
import com.lesson.addressbook.model.GroupData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void checkCreationGroup() {
        app.goTo().groupPage();
        if (app.group().all().size() == 0) {
            app.group().create(new GroupData().withName("test1"));
        }
        app.goTo().homePage();
    }

    @Test
    public void testContactModification() {
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData()
                    .withFirstname("Bob").withMiddlename("Marly").withLastname("Dilan").withNickname("bobby77")
                    .withComapany("Job").withAddress("Anything address").withHomephone("999-00-00")
                    .withEmail("bobby77@pro.com").withHomepage("facebook.com").withGroup("test1"));
        }
        Contacts before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData()
                .withId(modifiedContact.getId()).withFirstname("Bob1").withMiddlename("Marly1").withLastname("Dilan")
                .withNickname("bobby717").withComapany("Job1").withAddress("Anything address1").withHomephone("999-00-001")
                .withEmail("bobby77@pro1.com").withHomepage("facebook1.com").withGroup(null);
        app.contact().modify(contact);
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before.withOut(modifiedContact).withAdded(contact)));
    }
}
