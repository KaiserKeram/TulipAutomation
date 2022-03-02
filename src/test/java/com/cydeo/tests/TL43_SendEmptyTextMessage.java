package com.cydeo.tests;

import com.cydeo.utilities.CRM_utilities;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TL43_SendEmptyTextMessage {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {

        //1. Open browser and User go to homepage and login
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://login.nextbasecrm.com/");

       // driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys("marketing36@cybertekschool.com");

        //driver.findElement(By.xpath("//input[@type='password']")).sendKeys("UserUser");

       // driver.findElement(By.xpath("//input[@value='Log In']")).click();


    }

    // 2. User clicks the MESSAGE tab.
    @Test
    public void sendMessageOnFeed()  {
        CRM_utilities.crm_login(driver,"marketing36@cybertekschool.com","UserUser");
        WebElement messageTab = driver.findElement(By.xpath("//span[@id=\"feed-add-post-form-tab-message\"]"));
        messageTab.click();


        // 3. User click the SEND button.
        driver.switchTo().defaultContent();
        WebElement sendButton = driver.findElement(By.xpath("//button[@id=\"blog-submit-button-save\"]"));
        sendButton.click();

        //4.Verify warning message: "The message title is not specified".
        WebElement warningMessage = driver.findElement(By.xpath("//span[@class=\"feed-add-info-text\"]"));
        String actualMessage=warningMessage .getText();
        String expectedMessage="The message title is not specified";
        Assert.assertEquals(actualMessage,expectedMessage);

        // verify message display in Activity Stream
        //Loop through the List of WebElement and verify expected  result
        String expectedPostedMessage="hello hello";
        List<WebElement> AllPostedText=driver.findElements(By.xpath("//div[@class='feed-post-text-block-inner-inner']"));
        for (WebElement eachPostedText : AllPostedText) {
            String eachMessage=eachPostedText.getText();
            if(eachMessage.equals(expectedPostedMessage)) {
                System.out.println("posted message display in the Activity Stream");
            }
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

}
