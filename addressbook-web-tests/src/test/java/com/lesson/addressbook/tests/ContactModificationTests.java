package com.lesson.addressbook.tests;

import com.lesson.addressbook.model.ContactData;
import com.lesson.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.*;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void checkCreationGroup() {
        app.goTo().groupPage();
        if (app.group().list().size() == 0) {
            app.group().create(new GroupData().withName("test1"));
        }
        app.goTo().homePage();
    }

    @Test
    public void testContactModification() {
        if (app.contact().list().size() == 0) {
            app.contact().create(new ContactData()
                    .withFirstname("Bob").withMiddlename("Marly").withLastname("Dilan").withNickname("bobby77")
                    .withComapany("Job").withAddress("Anything address").withHomephone("999-00-00")
                    .withEmail("bobby77@pro.com").withHomepage("facebook.com").withGroup("test1"));
        }
        List<ContactData> before = app.contact().list();
        int index = before.size() - 1;
        app.contact().edit(index);
        ContactData contact = new ContactData()
                .withId(before.get(index).getId()).withFirstname("Bob1").withMiddlename("Marly1").withLastname("Dilan")
                .withNickname("bobby717").withComapany("Job1").withAddress("Anything address1").withHomephone("999-00-001")
                .withEmail("bobby77@pro1.com").withHomepage("facebook1.com").withGroup(null);
        app.contact().fillForm((contact), false);
        app.contact().update();
        app.goTo().homePage();
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size(), "Check list contacts");

        before.remove(index);
        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
