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

        // Go to the https://login2.nextbasecrm.com/
        driver.get("https://login2.nextbasecrm.com/");
    }

    // Test with hr Credential

    @Test (priority = 1)
    public void hrLogIn_1() {
        driver.findElement(By.xpath("//input[@name = 'USER_LOGIN']")).sendKeys("hr37@cydeo.com");
        driver.findElement(By.xpath("//input[@name = 'USER_PASSWORD']")).sendKeys("UserUser");
        driver.findElement(By.xpath("//input[@type = 'submit']")).click();
    }
    @Test (priority = 2)
    public void hrLogIn_2() {
        driver.findElement(By.xpath("//input[@name = 'USER_LOGIN']")).sendKeys("hr38@cydeo.com");
        driver.findElement(By.xpath("//input[@name = 'USER_PASSWORD']")).sendKeys("UserUser");
        driver.findElement(By.xpath("//input[@type = 'submit']")).click();
    }

    @Test (priority = 3)
    public void hrLogIn_3() {
        driver.findElement(By.xpath("//input[@name = 'USER_LOGIN']")).sendKeys("hr39@cydeo.com");
        driver.findElement(By.xpath("//input[@name = 'USER_PASSWORD']")).sendKeys("UserUser");
        driver.findElement(By.xpath("//input[@type = 'submit']")).click();
    }

    // Test with helpdesk Credential

    @Test (priority = 4)
    public void helpdeskLogIn_1() {
        driver.findElement(By.xpath("//input[@name = 'USER_LOGIN']")).sendKeys("helpdesk37@cydeo.com");
        driver.findElement(By.xpath("//input[@name = 'USER_PASSWORD']")).sendKeys("UserUser");
        driver.findElement(By.xpath("//input[@type = 'submit']")).click();
    }
    @Test (priority = 5)
    public void helpdeskLogIn_2() {
        driver.findElement(By.xpath("//input[@name = 'USER_LOGIN']")).sendKeys("helpdesk38@cydeo.com");
        driver.findElement(By.xpath("//input[@name = 'USER_PASSWORD']")).sendKeys("UserUser");
        driver.findElement(By.xpath("//input[@type = 'submit']")).click();
    }

    @Test (priority = 6)
    public void helpdeskLogIn_3() {
        driver.findElement(By.xpath("//input[@name = 'USER_LOGIN']")).sendKeys("helpdesk39@cydeo.com");
        driver.findElement(By.xpath("//input[@name = 'USER_PASSWORD']")).sendKeys("UserUser");
        driver.findElement(By.xpath("//input[@type = 'submit']")).click();
    }

    // Test with marketing Credential

    @Test (priority = 7)
    public void marketingLogIn_1() {
        driver.findElement(By.xpath("//input[@name = 'USER_LOGIN']")).sendKeys("marketing37@cydeo.com");
        driver.findElement(By.xpath("//input[@name = 'USER_PASSWORD']")).sendKeys("UserUser");
        driver.findElement(By.xpath("//input[@type = 'submit']")).click();
    }

    @Test (priority = 8)
    public void marketingLogIn_2() {
        driver.findElement(By.xpath("//input[@name = 'USER_LOGIN']")).sendKeys("marketing38@cydeo.com");
        driver.findElement(By.xpath("//input[@name = 'USER_PASSWORD']")).sendKeys("UserUser");
        driver.findElement(By.xpath("//input[@type = 'submit']")).click();
    }

    @Test (priority = 9)
    public void marketingLogIn_3() {
        driver.findElement(By.xpath("//input[@name = 'USER_LOGIN']")).sendKeys("marketing39@cydeo.com");
        driver.findElement(By.xpath("//input[@name = 'USER_PASSWORD']")).sendKeys("UserUser");
        driver.findElement(By.xpath("//input[@type = 'submit']")).click();
    }

    @Test (priority = 10)
    public void verifyAppreciation_TL16() {

        // Enter Login ("marketing39@cydeo.com") and passWord (UserUser) and click Login button
        driver.findElement(By.xpath("//input[@name = 'USER_LOGIN']")).sendKeys("marketing39@cydeo.com");
        driver.findElement(By.xpath("//input[@name = 'USER_PASSWORD']")).sendKeys("UserUser");
        driver.findElement(By.xpath("//input[@type = 'submit']")).click();

        // Click the MORE tab.
        WebElement moreBtn = driver.findElement(By.id("feed-add-post-form-link-text"));
        moreBtn.click();

        // Click Appreciation Button
        WebElement AppreciationBtn = driver.findElement(By.xpath("//span[text()='Appreciation']"));
        AppreciationBtn.click();

        // Enter Appreciation words
        String AppreciationWords = "amazing code!";
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']")));
        driver.findElement(By.xpath("//body")).sendKeys(Keys.CLEAR + AppreciationWords);

        // Click Send key.
        driver.switchTo().defaultContent();
        WebElement SendBtn = driver.findElement(By.xpath("//button[@class='ui-btn ui-btn-lg ui-btn-primary']"));
        SendBtn.click();

        //Verify the Appreciation word is Displayed on the feed
        String expectedMessage = AppreciationWords;
        String actualMessage = driver.findElement(By.xpath("//div[@class = 'feed-post-text-block-inner-inner']")).getText();
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Test (priority = 11)
    public void verifyAppreciation_TL17() {

        // Enter Login ("marketing39@cydeo.com") and passWord (UserUser) and click Login button
        driver.findElement(By.xpath("//input[@name = 'USER_LOGIN']")).sendKeys("marketing39@cydeo.com");
        driver.findElement(By.xpath("//input[@name = 'USER_PASSWORD']")).sendKeys("UserUser");
        driver.findElement(By.xpath("//input[@type = 'submit']")).click();

        // Click the MORE tab.
        WebElement moreBtn = driver.findElement(By.id("feed-add-post-form-link-text"));
        moreBtn.click();

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