package com.cydeo.tests;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US02_TC01 {
    public WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://login2.nextbasecrm.com");
    }
    @Test
    public void checkboxOnTheLoginPage(){
        //verify title of page
        String LoginPageActualTitle = driver.getTitle();
        String LoginPageExpectedTile = "Authorization";
        Assert.assertEquals(LoginPageActualTitle,LoginPageExpectedTile);

        // verify checkbox on the login page
        WebElement checkBox = driver.findElement(By.id("USER_REMEMBER"));
        System.out.println("checkBox.isDisplayed() = " + checkBox.isDisplayed());

    }
    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
