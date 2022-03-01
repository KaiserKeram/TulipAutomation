package com.cydeo.tests;

import com.cydeo.utilities.CRM_Utilities;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US14_DaskTopOptionValidation {
    WebDriver driver;
    String hrUser = "hr37@cydeo.com",
            helpDaskUser = "helpdesk37@cydeo.com",
            mktUser = "marketing39@cydeo.com",
            password = "UserUser";
    String feed = "test123";

    @BeforeMethod
    public void setUpDriver(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://login2.nextbasecrm.com");
    }

    @AfterMethod
    public void teardown(){
        driver.close();
    }


    //==========Validation Process=========================
    public void desktopOptionDisplays() {

        WebElement macOsLogo = driver.findElement(By.xpath("//a[@class='b24-app-block-content-apps']"));
        WebElement windowsLogo = driver.findElement(By.xpath("//a[@class='b24-app-block-content-apps b24-app-block-separate']"));
        WebElement linux = driver.findElement(By.xpath("//a[@class='b24-app-block-content-apps b24-app-block-separate']"));

        Assert.assertTrue(macOsLogo.isDisplayed());
        Assert.assertTrue(windowsLogo.isDisplayed());
        Assert.assertTrue(linux.isDisplayed());

    }


    // ========Test for each Group of User ====================
    @Test(priority = 1)
    public void hrValidate() {
        CRM_Utilities.crm_login(driver,hrUser,password);
        desktopOptionDisplays();
    }

    @Test(priority = 2)
    public void helpDaskValidate() {
        CRM_Utilities.crm_login(driver,helpDaskUser,password);
        desktopOptionDisplays();
    }

    @Test(priority = 3)
    public void mktValidate(){
        CRM_Utilities.crm_login(driver,mktUser,password);
        desktopOptionDisplays();
    }






}
