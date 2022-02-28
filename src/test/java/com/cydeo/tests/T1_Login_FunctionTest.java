package com.cydeo.tests;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
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

public class T1_Login_FunctionTest {


    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://login2.nextbasecrm.com/");
    }


     //Click
    @Test
    public void login_with_valid_credentials_with_login_btn() {
        // 2-write username
        WebElement inputUserName= driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUserName.sendKeys("hr32@cydeo.com");
        ///hr32@cydeo.com
        //helpdesk1@cybertekschool.com  UserUser
        //marketing33@cydeo.com

        // 3-write password
        WebElement inputPassword= driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys("UserUser");


        //4-click login button
        WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
        BrowserUtils.sleep(3);
        loginBtn.click();

        // 5 verify title
        String expectedTitle="Portal";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    //Enter button
    @Test
    public void login_with_valid_credentials_with_enter_btn() {
        // 2-write username
        WebElement userName = driver.findElement(By.xpath("(//input[@class='login-inp'])[1]"));
        userName.sendKeys("helpdesk1@cybertekschool.com");

        //3-write password + Enter
        WebElement password = driver.findElement(By.xpath("(//input[@class='login-inp'])[2]"));
        password.sendKeys(("UserUser")+ Keys.ENTER);


        // 4- verify title
        String expectedTitle="Portal";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }



    //negative scnario
    // valid username invalid password
    @Test
    public void login_with_valid_username_invalid_password(){
        // 2-write valid username
        WebElement userName = driver.findElement(By.xpath("(//input[@class='login-inp'])[1]"));
        userName.sendKeys("marketing33@cydeo.com");

        //  3-write invalid password
        WebElement password = driver.findElement(By.xpath("(//input[@class='login-inp'])[2]"));
        password.sendKeys("abcd");


        //  4-click login button
        WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
        BrowserUtils.sleep(3);
        loginBtn.click();


        //  5 verify error message
        String expectedErrorMessage="Incorrect login or password";
        String actualErrorMessage=driver.findElement(By.xpath("//div[@class='errortext']")).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);

    }

    //@AfterMethod
    //public void teardown(){
        //driver.close();
    //}


}



