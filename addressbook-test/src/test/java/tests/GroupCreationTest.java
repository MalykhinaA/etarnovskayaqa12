package tests;

import model.GroupData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupCreationTest extends TestBase {

  @Test
  public void groupCreationTest() {
    goToGroupsPage();
    int before = wd.findElements(By.name("selected[]")).size();
    initGroupCreation();
    fillGroupForm(new GroupData("group", "head", "foo"));
    submitGroupCreation();
    returnToGroupsPage();
    int after = wd.findElements(By.name("selected[]")).size();
    Assert.assertEquals(after, before+1);

  }

  @Test
  public void GroupCreationTest1() {

    goToGroupsPage();
    initGroupCreation();
    fillGroupForm(new GroupData("group", "head", "foo"));
    submitGroupCreation();
    returnToGroupsPage();

  }

  @Test
  public void GroupCreationEmptyTest() {

    goToGroupsPage();
    initGroupCreation();
    fillGroupForm(new GroupData("", "", ""));
    submitGroupCreation();
    returnToGroupsPage();

  }

}
