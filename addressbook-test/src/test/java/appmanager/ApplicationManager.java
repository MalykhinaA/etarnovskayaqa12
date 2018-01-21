package appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  WebDriver wd;

  public GroupHeleper groupHelper;
  public NavigationHelper navigationHelper;
  public SessionHelper sessionHelper;
  private String browser;

  public ApplicationManager(String browser) {
    this.browser = browser;
  }


  public void start() {
      if(browser.equals(BrowserType.FIREFOX)){
      wd = new FirefoxDriver(new FirefoxOptions()
              .setLegacy(true));
    } else
      if(browser.equals(BrowserType.CHROME)){
      wd = new ChromeDriver();
      } else
        if (browser.equals(BrowserType.IE)){
          wd = new InternetExplorerDriver();
        }


    wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    sessionHelper = new SessionHelper(wd);
    sessionHelper.openAddressbook("http://localhost/addressbook/");
    groupHelper = new GroupHeleper(wd);
    navigationHelper = new NavigationHelper(wd);
    sessionHelper.login("admin", "secret");
  }

  public void stop() {
    wd.quit();
  }





  public SessionHelper getSessionHelper() {
    return sessionHelper;
  }
  public GroupHeleper getGroupHelper() {
    return groupHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }
}

