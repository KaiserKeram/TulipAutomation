package com.cydeo.tests;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TL19_CorrectModuleAccess {
    WebDriver driver;
    List<String> expectedModuleName = new ArrayList<>(Arrays.asList("Activity Stream", "Tasks", "Chat and Calls", "Workgroups", "Drive", "Calendar",
            "Contact Center", "Time and Reports", "Employees", "Services", "Company"));


    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://login2.nextbasecrm.com");

    }

    @DataProvider(name = "credentials")
    public Object[][] credentials() {
        return new Object[][]{
                {"hr16@cydeo.com", "UserUser"}, {"hr17@cydeo.com", "UserUser"}, {"hr18@cydeo.com", "UserUser"},
                {"helpdesk16@cydeo.com", "UserUser"}, {"helpdesk17@cydeo.com", "UserUser"}, {"helpdesk18@cydeo.com", "UserUser"},
                {"marketing16@cydeo.com", "UserUser"}, {"marketing17@cydeo.com", "UserUser"}, {"marketing18@cydeo.com", "UserUser"}
        };
    }

    @Test(dataProvider = "credentials", priority = 1)
    public void moduleVisibilityTest(String userName, String passWord) {
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys(userName);
        driver.findElement(By.xpath("//input[@name='USER_PASSWORD']")).sendKeys(passWord, Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        List<String> actualModuleName = new ArrayList<>();
        List<WebElement> modules = driver.findElements(By.xpath("//a[@class='menu-item-link']/span[@class='menu-item-link-text']"));
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        for (WebElement module : modules) {
            actualModuleName.add(module.getText());
        }
        Assert.assertTrue(actualModuleName.contains(expectedModuleName), (actualModuleName + " VS " + expectedModuleName));
    }

    @Test(dataProvider = "credentials", priority = 2)
    public void moduleAccessibilityTest(String userName, String passWord) {
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys(userName);
        driver.findElement(By.xpath("//input[@name='USER_PASSWORD']")).sendKeys(passWord, Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        List<String> expectedModuleTitleList = new ArrayList<>(Arrays.asList("Portal", "Site map", "Chat and Calls", "Workgroups and projects", "Site map", "Site map", "Contact Center", "Absence Chart", "Company Structure", "Meeting Rooms", "Company"));
        List<String> actualModuleTitleList = new ArrayList<>();
        for (String eachModule : expectedModuleName) {
            driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
            WebElement module = driver.findElement(By.xpath("//a[@title='" + eachModule + "']"));
            module.click();
            driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
            actualModuleTitleList.add(driver.getTitle());
            if (eachModule.equals("Chat and Calls")) {
                driver.navigate().back();
            }
        }
        Assert.assertTrue(actualModuleTitleList.equals(expectedModuleTitleList), (actualModuleTitleList + " VS " + expectedModuleName));

    }


    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}




