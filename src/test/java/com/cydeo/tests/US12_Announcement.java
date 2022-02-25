package com.cydeo.tests;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US12_Announcement {
    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        String appUrl="https://nextbasecrm.com/";
        String userName="hr28@cybertekschool.com";
        String password="UserUser";
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(appUrl);
        WebElement loginBtn=driver.findElement(By.xpath("//a[text()='Login']"));
        loginBtn.click();
        driver.findElement(By.xpath("//input[@class='login-inp']")).sendKeys(userName);
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
        WebElement loginBtn1= driver.findElement(By.xpath("//input[@value='Log In']"));
        loginBtn1.click();
    }
    @Test
    public void validMessage()  {
        WebElement moreBtn=driver.findElement(By.cssSelector("span[id='feed-add-post-form-link-text']"));
        moreBtn.click();
        WebElement announcementsBtn=driver.findElement(By.xpath("//span[text()='Announcement']"));
        announcementsBtn.click();
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']")));
        String myAnouncement="please join the meeting in 10 minutes";

        driver.findElement(By.xpath("//body")).sendKeys(Keys.CLEAR+myAnouncement);

        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//button[@class='ui-btn ui-btn-lg ui-btn-primary']")).click();
        String expectedAnoucement=driver.findElement(By.xpath("//*[@id=\"blog_post_body_1395\"]")).getText();
        Assert.assertEquals(myAnouncement,expectedAnoucement);
        // need to verify if i got it in other page . one step left

    }
    @Test
    public void emptyContent()  {
        WebElement moreBtn=driver.findElement(By.cssSelector("span[id='feed-add-post-form-link-text']"));
        moreBtn.click();
        WebElement announcementsBtn=driver.findElement(By.xpath("//span[text()='Announcement']"));
        announcementsBtn.click();
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']")));
        driver.findElement(By.xpath("//body")).sendKeys(Keys.CLEAR+" ");

        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//button[@class='ui-btn ui-btn-lg ui-btn-primary']")).click();
        String  expextedAlert="The message title is not specified";
        String actualAlert= driver.findElement(By.xpath("//span[@class='feed-add-info-text']")).getText();
        Assert.assertEquals(actualAlert,expextedAlert);
    }
    @AfterMethod
    public void teardown(){
          driver.close();
    }
}
/*
test case #1:
link : https://login2.nextbasecrm.com/
Steps:: Users are on the homepage
            Users click MORE tab and select ANNOUNCEMENTS
            Users write announcements message
    Users click the SEND button
           Verify the announcements is displayed on the feed
test case 2:
Description:  Users create announcements without content
Environment:  https://login2.nextbasecrm.com/
Steps::Users are on the homepage
            Users click MORE tab and select ANNOUNCEMENT
    Users click the SEND button
           Verify “The message title is not specified” warning message is displayed on the page

 */

