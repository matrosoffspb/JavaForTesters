package com.lesson.addressbook.appmanager;

import com.lesson.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ContactHelper extends HelperBase {

    public ContactHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void submitCreationContact() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("middlename"), contactData.getMiddlename());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("nickname"), contactData.getNickname());
        type(By.name("company"), contactData.getCompany());
        type(By.name("address"), contactData.getAddress());
        type(By.name("home"), contactData.getHomephone());
        type(By.name("email"), contactData.getEmail());
        type(By.name("homepage"), contactData.getHomepage());
    }

    public void goToAddNewContact() {
        click(By.linkText("add new"));
    }

    public void closeAlertWindow() {
        acceptAlert();
    }

    public void deleteContact() {

        click(By.xpath(".//*[@value='Delete']"));
    }

    public void selectContact() {
        click(By.xpath(".//*[@class=\"center\"][1]"));
    }

    public void editContact() {
        click(By.xpath(".//*[@href=\"edit.php?id=22\"]"));
    }

    public void updateContact() {
        click(By.xpath("//div[@id='content']/form[1]/input[22]"));
    }
}
