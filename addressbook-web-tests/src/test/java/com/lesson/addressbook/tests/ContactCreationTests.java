package com.lesson.addressbook.tests;

import com.lesson.addressbook.model.ContactData;
import com.lesson.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @BeforeMethod
    public void checkCreationGroup() {
        app.goTo().groupPage();
        if (app.group().list().size() == 0) {
            app.group().create(new GroupData().withName("test1"));
        }
        app.goTo().homePage();
    }

    @Test
    public void ContactCreationTests() {
        List<ContactData> before = app.contact().list();
        ContactData contact = new ContactData()
                .withFirstname("Bob").withMiddlename("Marly").withLastname("Dilan").withNickname("bobby77")
                .withComapany("Job").withAddress("Anything address").withHomephone("999-00-00")
                .withEmail("bobby77@pro.com").withHomepage("facebook.com").withGroup("test1");
        app.contact().create(contact);
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size() + 1, "Check list contacts");

        contact.withId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        before.add(contact);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }

    @Test
    public void ContactCreationTests2() {
        List<ContactData> before = app.contact().list();
        ContactData contact = new ContactData()
                .withFirstname("Rob").withMiddlename("Grey").withLastname("Stark").withNickname("robby88")
                .withComapany("Hunt").withAddress("In deep forest").withHomephone("777-00-00")
                .withEmail("robert@pro.com").withHomepage("myspace.com").withGroup("test1");
        app.contact().create(contact);
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size() + 1, "Check list contacts");

        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
            }
}
