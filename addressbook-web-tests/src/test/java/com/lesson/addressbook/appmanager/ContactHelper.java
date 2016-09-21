package com.lesson.addressbook.appmanager;

import com.lesson.addressbook.model.ContactData;
import com.lesson.addressbook.model.Contacts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    public void selectId(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }
    public void returnToHomePage() {
        click(By.xpath(".//*[@href=\"./\"]"));
    }
    public void edit() {
        wd.findElement(By.xpath(".//*[@title=\"Edit\"]")).click();
            }

    public void modify(ContactData contact) {
        selectId(contact.getId());
        edit();
        fillForm((contact), false);
        update();
        returnToHomePage();
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

    public void delete(ContactData contact) {
        selectId(contact.getId());
        delete();
        closeAlertWindow();
        returnToHomePage();

    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public Contacts all() {
        Contacts contacts = new Contacts();
        List<WebElement> elements = wd.findElements(By.xpath(".//*[@name = \"entry\"]"));
        for (WebElement element : elements) {
            String firstname = element.findElements(By.tagName("td")).get(2).getText();
            String lastname = element.findElements(By.tagName("td")).get(1).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            ContactData contact = new ContactData().withId(id).withFirstname(firstname).withLastname(lastname);
            contacts.add(contact);
        }
        return contacts;
    }



}
