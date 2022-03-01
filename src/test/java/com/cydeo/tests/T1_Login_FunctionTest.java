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
import org.testng.annotations.DataProvider;
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


    @DataProvider(name = "credentials")
    public Object[][] credentials() {
        return new Object[][]{
                {"hr16@cydeo.com", "UserUser"}, {"hr17@cydeo.com", "UserUser"}, {"hr18@cydeo.com", "UserUser"},
                {"helpdesk16@cydeo.com", "UserUser"}, {"helpdesk17@cydeo.com", "UserUser"}, {"helpdesk18@cydeo.com", "UserUser"},
                {"marketing16@cydeo.com", "UserUser"}, {"marketing17@cydeo.com", "UserUser"}, {"marketing18@cydeo.com", "UserUser"}
        };
    }




    @Test(dataProvider = "credentials", priority = 1)
    public void login_with_valid_credentials_with_login_btn(String userName, String password) {
        // 2-write username
        WebElement inputUserName= driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUserName.sendKeys(userName);
        ///hr32@cydeo.com
        //helpdesk1@cybertekschool.com  UserUser
        //marketing33@cydeo.com

        // 3-write password
        WebElement inputPassword= driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys(password);


        //4-click login button
        WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
        BrowserUtils.sleep(3);
        loginBtn.click();

        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        // 5 verify title
        String expectedTitle="Portal";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    //Enter button
    @Test(dataProvider = "credentials", priority = 2)
    public void login_with_valid_credentials_with_enter_btn(String userName, String password) {
        // 2-write username
        WebElement userName1 = driver.findElement(By.xpath("(//input[@class='login-inp'])[1]"));
        userName1.sendKeys(userName);

        //3-write password + Enter
        WebElement password1 = driver.findElement(By.xpath("(//input[@class='login-inp'])[2]"));
        password1.sendKeys((password)+ Keys.ENTER);


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

    @AfterMethod
    public void teardown(){
        driver.close();
    }


}



