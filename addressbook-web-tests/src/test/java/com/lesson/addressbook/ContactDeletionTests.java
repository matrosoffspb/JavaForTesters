package com.lesson.addressbook;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase{

    @Test
    public void ContactDeletionTests() {

        selectContact();
        deleteContact();
        closeAlertWindow();
    }

}
