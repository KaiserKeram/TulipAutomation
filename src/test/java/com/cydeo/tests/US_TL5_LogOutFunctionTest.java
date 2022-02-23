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

public class US_TL5_LogOutFunctionTest {

    WebDriver driver;

    @BeforeMethod
    public void setDriver(){
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://login2.nextbasecrm.com/");
    }

    @Test
    public void logOutFunctionTesting(){

        WebElement inputUsername = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUsername.sendKeys("hr37@cydeo.com");

        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys("UserUser");

        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();

        WebElement profileButton = driver.findElement(By.id("user-name"));
        profileButton.click();

        WebElement logOutButton = driver.findElement(By.linkText("Log out"));
        logOutButton.click();

        Assert.assertEquals(driver.getTitle(), "Authorization","Title verification FAILED!!!");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}

