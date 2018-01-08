package tests;

import model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  FirefoxDriver wd;

  public static boolean isAlertPresent(FirefoxDriver wd) {
    return ApplicationManager.isAlertPresent(wd);
  }
  public int getGroupCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public void start() {
    wd = new FirefoxDriver(new FirefoxOptions()
            .setLegacy(true));
    wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    openAddressbook();
    login("admin", "secret");
  }

  public void stop() {
    wd.quit();
  }

  public void returnToGroupsPage() {
    click(By.linkText("group page"));
  }

  public void submitGroupCreation() {
    click(By.name("submit"));
  }

  public void goToGroupsPage() {
    click(By.linkText("groups"));
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
    click(By.name("selected[]"));
  }

  public void openAddressbook() {
    wd.get("http://localhost/addressbook/");
  }

  public void login(String userName, String password) {
    type(By.name("user"), userName);
    type(By.name("pass"), password);
    click(By.xpath("//form[@id='LoginForm']/input[3]"));
  }

  public void type(By locator, String text) {
    click(locator);
    wd.findElement(locator).clear();
    wd.findElement(locator).sendKeys(text);
  }

  public void click(By locator) {
    wd.findElement(locator).click();
  }
}
