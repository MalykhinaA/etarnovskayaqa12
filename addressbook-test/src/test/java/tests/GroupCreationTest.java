package tests;

import model.GroupData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupCreationTest extends TestBase {

  @Test
  public void groupCreationTest() {
    app.goToGroupsPage();
    int before = app.getGroupCount();
    app.initGroupCreation();
    app.fillGroupForm(new GroupData("group", "head", "foo"));
    app.submitGroupCreation();
    app.returnToGroupsPage();
    int after = app.getGroupCount();
    Assert.assertEquals(after, before+1);

  }

  @Test
  public void GroupCreationTest1() {

    app.goToGroupsPage();
    app.initGroupCreation();
    app.fillGroupForm(new GroupData("group", "head", "foo"));
    app.submitGroupCreation();
    app.returnToGroupsPage();

  }

  @Test
  public void GroupCreationEmptyTest() {

    app.goToGroupsPage();
    app.initGroupCreation();
    app.fillGroupForm(new GroupData("", "", ""));
    app.submitGroupCreation();
    app.returnToGroupsPage();

  }

}
