package com.lesson.addressbook.tests;

import com.lesson.addressbook.model.ContactData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactDetailsTest extends TestBase{

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
    public void testContactDetails () {
        app.goTo().homePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromDetailsForm = app.contact().infoFromDetailsForm(contact);
        assertThat(mergeDetails(contact), equalTo(cleaned(contactInfoFromDetailsForm.getDetails())));

    }


    private String mergeDetails (ContactData contact) {
        return Arrays.asList(contact.getFirstname(), contact.getLastname(), contact.getAddress(),
                contact.getAllPhones(),contact.getAllEmails()).stream().filter((s) -> ! s.equals(""))
                .map(ContactDetailsTest :: cleaned).collect(Collectors.joining("\n"));
    }

    public static String cleaned(String detail) {
        return detail.replaceAll("H:", "").replaceAll("M:", "").replaceAll("\\sDilan", "\nDilan")
                .replace(" ","").replaceAll("\n\n", "\n").replaceAll("(www.pro1.com)", "").replaceAll("[-()]", "");
    }
}
