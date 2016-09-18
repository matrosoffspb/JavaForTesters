package com.lesson.addressbook.appmanager;

import com.lesson.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void submitCreationContact() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void fillContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("middlename"), contactData.getMiddlename());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("nickname"), contactData.getNickname());
        type(By.name("company"), contactData.getCompany());
        type(By.name("address"), contactData.getAddress());
        type(By.name("home"), contactData.getHomephone());
        type(By.name("email"), contactData.getEmail());
        type(By.name("homepage"), contactData.getHomepage());

        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")), "Modification group");
        }
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
        click(By.xpath(".//*[@name=\"entry\"][1]//*[@class=\"center\"][1]"));
    }

    public void goToHomePage() {
        click(By.xpath(".//*[@href=\"./\"]"));
    }

    public void returnToHomePage(){
        click(By.linkText("home page"));
    }

    public void editContact() {
        click(By.xpath(".//*[@name=\"entry\"][1]//*[@title=\"Edit\"]"));
    }

    public void updateContact() {
        click(By.xpath(".//*[@value='Update'][2]"));
    }

    public void createContact(ContactData contact) {
        goToAddNewContact();
        fillContactForm(contact, true);
        submitCreationContact();
        returnToHomePage();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }
}
