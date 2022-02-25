package com.cydeo.tests;

import com.cydeo.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC04 {
  static WebDriver driver;
    @BeforeClass
    public static void driverSetup(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }



   @Test
    public void goToMyprofile(){

        driver.get("https://login1.nextbasecrm.com");




        // user login with helpdesk16@cydeo.com
           WebElement userlogin = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
           userlogin.sendKeys("helpdesk16@cydeo.com");
           WebElement password = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
           password.sendKeys("UserUser");
           WebElement loginBttn = driver.findElement(By.xpath("//input[@type='submit']"));
           loginBttn.click();
           String expectedTitle = "Portal";
           String actualTitle = driver.getTitle();
           Assert.assertEquals(expectedTitle, actualTitle);


           WebElement usernameMenu = driver.findElement(By.xpath("//span[@id='user-name']"));
           Assert.assertTrue(usernameMenu.isDisplayed());
           usernameMenu.click();
           WebElement myprofileOption = driver.findElement(By.xpath("//*[@id=\"popup-window-content-menu-popup-user-menu\"]/div/div/a[1]/span[2]"));
           Assert.assertTrue(myprofileOption.isDisplayed());
           myprofileOption.click();
           Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"profile-menu-filter\"]/a[1]")).isDisplayed());
           Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"profile-menu-filter\"]/a[2]")).isDisplayed());
           Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"profile-menu-filter\"]/a[3]")).isDisplayed());
           Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"profile-menu-filter\"]/a[4]")).isDisplayed());
           Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"profile-menu-filter\"]/a[5]")).isDisplayed());

       }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
   }





