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

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://login2.nextbasecrm.com");
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys("helpdesk1@cydeo.com");
        driver.findElement(By.xpath("//input[@name='USER_PASSWORD']")).sendKeys("UserUser", Keys.ENTER);
    }

    @DataProvider(name = "expectedModuleNames")

    public Object[][] expectModuleNames() {
        return new Object[][]{
                {"Activity Stream", "Portal"}, {"Tasks", "Site map"}, {"Chat and Calls", "Chat and Calls"}, {"Workgroups", "Workgroups and projects"}, {"Drive", "Site map"}, {"Calendar", "Site map"},
                {"Contact Center", "Contact Center"}, {"Time and Reports", "Absence Chart"}, {"Employees", "Company Structure"}, {"Services", "Meeting Rooms"}, {"Company", "Company"}
        };
    }

    @Test
    public void moduleVisibilityTest() {
        List<String> expectedModuleName = new ArrayList<>(Arrays.asList("Activity Stream", "Tasks", "Chat and Calls", "Workgroups", "Drive", "Calendar",
                "Contact Center", "Time and Reports", "Employees", "Services", "Company"));
        List<String> actualModuleName = new ArrayList<>();
        List<WebElement> modules = driver.findElements(By.xpath("//a[@class='menu-item-link']/span[@class='menu-item-link-text']"));
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        for (WebElement module : modules) {
            actualModuleName.add(module.getText());
        }
        Assert.assertTrue(actualModuleName.contains(expectedModuleName), (actualModuleName + " VS " + expectedModuleName));
    }

    @Test (dataProvider = "expectedModuleNames")
    public void moduleAccessibilityTest(String expectedModuleName,String expectedPageTitle) {
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        WebElement module = driver.findElement(By.xpath("//a[@title='"+expectedModuleName+"']"));
        module.click();
        driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
        Assert.assertEquals(driver.getTitle(),expectedPageTitle);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}




