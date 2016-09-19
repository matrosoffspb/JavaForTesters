package com.lesson.addressbook.appmanager;

import com.lesson.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void submitCreationContact() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void fillForm (ContactData contactData, boolean creation) {
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

    public void delete () {

        click(By.xpath(".//*[@value='Delete']"));
    }

    public void select(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
           }

    public void returnToHomePage() {
        click(By.xpath(".//*[@href=\"./\"]"));
    }
    public void edit(int index) {
        wd.findElements(By.xpath(".//*[@title=\"Edit\"]")).get(index).click();
            }

    public void update() {
        click(By.xpath(".//*[@value='Update'][2]"));
    }

    public void create(ContactData contact) {
        goToAddNewContact();
        fillForm(contact, true);
        submitCreationContact();
        returnToHomePage();
        }

    public void delete(int index) {
        select(index);
        delete();
        closeAlertWindow();
        returnToHomePage();
    }

//    public boolean isThere() {
//        return isElementPresent(By.name("selected[]"));
//    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> list() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> elements = wd.findElements(By.xpath(".//*[@name = \"entry\"]"));
        for (WebElement element : elements) {
            String firstname = element.findElements(By.tagName("td")).get(2).getText();
            String lastname = element.findElements(By.tagName("td")).get(1).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            ContactData contact = new ContactData(id, firstname, null, lastname, null, null, null, null, null, null, null);
            contacts.add(contact);
        }
    return contacts;
    }
}
