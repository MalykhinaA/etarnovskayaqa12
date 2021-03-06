package appmanager;

import model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupHeleper extends HelperBase {

  public GroupHeleper(WebDriver wd) {
    super(wd);
  }

  public int getGroupCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public void returnToGroupsPage() {
    click(By.linkText("group page"));
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

  public void initGroupDeletion() {
    click(By.name("delete"));
  }

  public void selectGroup() {
    click(By.name("selected[]"));}

  public void selectGroupByIndex(int index) {

   wd.findElements(By.name("selected[]")).get(index).click();
  }
  public void initGroupModification() {
    click(By.name("edit"));
  }

  public void confirmGroupModification() {
    click(By.name("update"));
  }

  public boolean isThereAGroup() {
    return isElementPresent(By.name("selected[]"));
  }

  public void createGroup(GroupData group) {
    initGroupCreation();
    fillGroupForm(group);
    submitGroupCreation();
    returnToGroupsPage();
  }
}
