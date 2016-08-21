package com.lesson.addressbook;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase{

    @Test
    public void ContactDeletionTests() {

        selectContact();
        deleteContact();
        returnHomePage();
    }

    private void deleteContact() {

        wd.findElement(By.xpath(".//*[@value='Delete']")).click();
    }

    private void selectContact() {
        wd.findElement(By.xpath(".//*[@class=\"center\"][1]")).click();
    }
}
