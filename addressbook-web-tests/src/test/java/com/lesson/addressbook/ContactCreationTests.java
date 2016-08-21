package com.lesson.addressbook;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;

public class ContactCreationTests extends TestBase{

    @Test
    public void ContactCreationTests() {

        goToAddNewContact();
        fillContactForm(new ContactData("Bob", "Marly", "Dilan", "bobby77", "Job", "Anything address", "999-00-00", "bobby77@pro.com", "facebook.com"));
        submitCreationContact();
        returnHomePage();
    }
    @Test
    public void ContactCreationTests2() {

        goToAddNewContact();
        fillContactForm(new ContactData("Rob", "Grey", "Stark", "robby88", "Hunt", "In deep forest", "777-00-00", "robert@pro.com", "myspace.com"));
        submitCreationContact();
        returnHomePage();
    }
}
