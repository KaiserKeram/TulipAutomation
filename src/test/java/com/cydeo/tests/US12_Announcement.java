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
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://login1.nextbasecrm.com/");
        driver.findElement(By.xpath("//input[@class='login-inp']")).sendKeys("hr28@cybertekschool.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("UserUser");
        WebElement loginBtn = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginBtn.click();

    }

    @Test
    public void validMessage() throws InterruptedException {
        String myAnouncement="xyy";
        driver.findElement(By.xpath("//span[@id='feed-add-post-form-link-text']")).click();//more button
        driver.findElement(By.xpath("//span[text()='Announcement']")).click();//announcements button
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']")));
        driver.findElement(By.xpath("//body[@style='min-height: 119px;']")).sendKeys(myAnouncement);
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//button[@class='ui-btn ui-btn-lg ui-btn-primary']")).click();
        WebElement expectedAnnoucement = driver.findElement(By.xpath("//div[@class='feed-post-text-block-inner-inner']"));
        String locator="//div[contains(.,'"+myAnouncement+"')]";
        WebElement element = driver.findElement(By.xpath(locator));
        Assert.assertTrue(element.isDisplayed());
        Thread.sleep(5000);
    }




    @Test
    public void emptyContent()  {
        driver.findElement(By.cssSelector("span[id='feed-add-post-form-link-text']")).click();
        driver.findElement(By.xpath("//span[text()='Announcement']")).click();
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

  //      driver.close();
    }
}