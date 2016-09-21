package com.lesson.addressbook.appmanager;

import com.lesson.addressbook.model.GroupData;
import com.lesson.addressbook.model.Groups;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.security.acl.Group;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupHelper extends HelperBase {

    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void returnGroupPage() {
        click(By.linkText("group page"));
    }

    public void delete () {
        click(By.name("delete"));
    }

      public void selectId (int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public void initGroupModification() {
        click(By.name("edit"));
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }

    public void create (GroupData group) {
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        groupCashe = null;
        returnGroupPage();
    }

    public void modify (GroupData group) {
        selectId(group.getId());
        initGroupModification();
        fillGroupForm(group);
        submitGroupModification();
        groupCashe = null;
        returnGroupPage();
    }

    public void delete(GroupData group) {
        selectId(group.getId());
        delete();
        groupCashe = null;
        returnGroupPage();
    }

    public boolean isThereAGroup() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getGroupCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    private Groups groupCashe = null;

    public Groups all () {
        if (groupCashe != null){
            return new Groups(groupCashe);
        }
        groupCashe = new Groups();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements){
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            GroupData group = new GroupData().withId(id).withName(name);
            groupCashe.add(group);
        }

        return new Groups(groupCashe);
    }


}
