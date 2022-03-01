package com.cydeo.tests;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US02_TC02_elminur {
    public WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://login2.nextbasecrm.com");
    }

    @Test
    public void messageOnTheLoginPage() {
        //verify title of page
        String LoginPageActualTitle = driver.getTitle();
        String LoginPageExpectedTile = "Authorization";
        Assert.assertEquals(LoginPageActualTitle, LoginPageExpectedTile);

        // “Remember me on this computer” displayed on the page
        WebElement checkBoxLabel=driver.findElement(By.className("login-item-checkbox-label"));
        String expectedLabel="Remember me on this computer";
        String actualLabel=checkBoxLabel.getText();
        Assert.assertEquals(expectedLabel,actualLabel);
        System.out.println("checkBoxLabel.isDisplayed() = " + checkBoxLabel.isDisplayed());

    }
}
