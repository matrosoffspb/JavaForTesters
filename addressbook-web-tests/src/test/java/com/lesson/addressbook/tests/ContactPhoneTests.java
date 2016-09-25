package com.lesson.addressbook.tests;


import com.lesson.addressbook.model.ContactData;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase {

    @Test
    public void testContactPhone() {
        app.goTo().homePage();
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData()
                    .withFirstname("Bob").withMiddlename("Marly").withLastname("Dilan").withNickname("bobby77")
                    .withComapany("Job").withAddress("Anything address").withHomephone("111")
                    .withEmail("bobby77@pro.com").withHomepage("facebook.com").withGroup("test1"));
        }
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getHomephone(), equalTo(contactInfoFromEditForm.getHomephone()));

    }


}
