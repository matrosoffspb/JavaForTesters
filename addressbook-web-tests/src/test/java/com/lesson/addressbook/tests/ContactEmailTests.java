package com.lesson.addressbook.tests;


import com.lesson.addressbook.model.ContactData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactEmailTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData()
                    .withFirstname("Bob").withMiddlename("Marly").withLastname("Dilan").withNickname("bobby77")
                    .withComapany("Job").withAddress("Anything address").withHomephone("111")
                    .withEmail("bobby77@pro.com").withHomepage("facebook.com").withGroup("test1"));
        }
    }

        @Test
        public void testContactEmail () {
            app.goTo().homePage();
            ContactData contact = app.contact().all().iterator().next();
            ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
            assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));

        }


    private String mergeEmails(ContactData contact) {
        return Arrays.asList(contact.getEmail()).stream().filter((s) -> ! s.equals(""))
                .map(ContactEmailTests :: cleaned).collect(Collectors.joining("\n"));
    }

    public static String cleaned(String email) {
    return email.replaceAll("\\s", "").replaceAll("[-()]", "");
    }
}
