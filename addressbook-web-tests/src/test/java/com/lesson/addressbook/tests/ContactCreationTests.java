package com.lesson.addressbook.tests;

import com.lesson.addressbook.model.ContactData;
import com.lesson.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactCreationTests extends TestBase {

    @BeforeMethod
    public void checkCreationGroup() {
        app.goTo().groupPage();
        if (app.group().all().size() == 0) {
            app.group().create(new GroupData().withName("test1"));
        }
        app.goTo().homePage();
    }

    @Test
    public void ContactCreationTests() {
        Set<ContactData> before = app.contact().all();
        ContactData contact = new ContactData()
                .withFirstname("Bob").withMiddlename("Marly").withLastname("Dilan").withNickname("bobby77")
                .withComapany("Job").withAddress("Anything address").withHomephone("999-00-00")
                .withEmail("bobby77@pro.com").withHomepage("facebook.com").withGroup("test1");
        app.contact().create(contact);
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() + 1, "Check list contacts");

        contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
        before.add(contact);
        Assert.assertEquals(before, after);
    }
}
