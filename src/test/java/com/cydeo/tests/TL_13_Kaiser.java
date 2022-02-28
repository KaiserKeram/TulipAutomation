package com.cydeo.tests;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TL_13_Kaiser {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void verifyAppreciation_TL16() {
        // Go to the https://nextbasecrm.com/
        driver.get("https://nextbasecrm.com/");

        // Click login button
        WebElement LoginBtn = driver.findElement(By.xpath("//a[. = 'Login']"));
        LoginBtn.click();

        // Enter Login (hr28@cybertekschool.com) and passWord (UserUser)
        WebElement LogIn = driver.findElement(By.xpath("//input[@name = 'USER_LOGIN']"));
        WebElement passWord = driver.findElement(By.xpath("//input[@name = 'USER_PASSWORD']"));
        LogIn.sendKeys("hr28@cybertekschool.com");
        passWord.sendKeys("UserUser");

        // Click Log In button
        WebElement LogInButton = driver.findElement(By.xpath("//input[@type = 'submit']"));
        LogInButton.click();

        // Click the MORE tab.
        WebElement MOREBtn = driver.findElement(By.id("feed-add-post-form-link-text"));
        MOREBtn.click();

        // Click Appreciation Button
        WebElement AppreciationBtn = driver.findElement(By.xpath("//span[text()='Appreciation']"));
        AppreciationBtn.click();

        // Enter Appreciation words
        String AppreciationWords = "Thank you very much!";
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']")));
        driver.findElement(By.xpath("//body")).sendKeys(Keys.CLEAR + AppreciationWords);

        // Click Send key.
        driver.switchTo().defaultContent();
        WebElement SendBtn = driver.findElement(By.xpath("//button[@class='ui-btn ui-btn-lg ui-btn-primary']"));
        SendBtn.click();

        //Verify the Appreciation word is Displayed on the feed
        String expectedMessage = AppreciationWords;
        String actualMessage = driver.findElement(By.xpath("//div[@class = 'feed-post-text-block-inner-inner']")).getText();
        if(actualMessage.equals(expectedMessage)){
            System.out.println("Verification is Passed!");
        }else{
            System.out.println("Verification is Failed!");
        }
    }

    @Test
    public void verifyAppreciation_TL17() {
        // Go to the https://nextbasecrm.com/
        driver.get("https://nextbasecrm.com/");

        // Click login button
        WebElement LoginBtn = driver.findElement(By.xpath("//a[. = 'Login']"));
        LoginBtn.click();

        // Enter Login (hr28@cybertekschool.com) and passWord (UserUser)
        WebElement LogIn = driver.findElement(By.xpath("//input[@name = 'USER_LOGIN']"));
        WebElement passWord = driver.findElement(By.xpath("//input[@name = 'USER_PASSWORD']"));
        LogIn.sendKeys("hr28@cybertekschool.com");
        passWord.sendKeys("UserUser");

        // Click Log In button
        WebElement LogInButton = driver.findElement(By.xpath("//input[@type = 'submit']"));
        LogInButton.click();

        // Click the MORE tab.
        WebElement MOREBtn = driver.findElement(By.id("feed-add-post-form-link-text"));
        MOREBtn.click();

        // Click Appreciation Button
        WebElement AppreciationBtn = driver.findElement(By.xpath("//span[text()='Appreciation']"));
        AppreciationBtn.click();

        // Enter Appreciation words
        String AppreciationWords = "";
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']")));
        driver.findElement(By.xpath("//body")).sendKeys(Keys.CLEAR + AppreciationWords);

        // Click Send key.
        driver.switchTo().defaultContent();
        WebElement SendBtn = driver.findElement(By.xpath("//button[@class='ui-btn ui-btn-lg ui-btn-primary']"));
        SendBtn.click();

        //Verify the warning message is Displayed on the top
        String expectedWarningMessage = "The message title is not specified";
        String actualWarningMessage = driver.findElement(By.xpath("//span[@class = 'feed-add-info-text']")).getText();
        Assert.assertEquals(actualWarningMessage, expectedWarningMessage);
    }

    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }
}
