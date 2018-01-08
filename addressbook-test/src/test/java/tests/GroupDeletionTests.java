package tests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class GroupDeletionTests extends TestBase {
  @Test
  public void groupDeletionTest(){
    app.goToGroupsPage();
    int before = app.getGroupCount();
    app.selectGroup();
    app.initGroupDeletion();
    app.returnToGroupsPage();
    int after = app.getGroupCount();
    Assert.assertEquals(after, before-1);
  }



}
