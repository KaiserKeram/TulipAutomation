package com.cydeo.tests;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Tulip_TL_6 {
    //1. User go to "https://login2.nextbasecrm.com/"
    //2.can able to login with valid data
    // user name = hr31@cydeo.com
    // password = UserUser
    //3.User go to homepage
    //4.User can able to see all the 5 options under the "my profile" module
    // expected option:
    // My Profile
    //Edit Profile Settings
    //Themes
    //Configure notifications
    //Logout

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //  1-go to login page
        driver.get("https://login1.nextbasecrm.com/");
    }

    @Test
    public void loginAllUser() {
        ArrayList<String> username = new ArrayList<>();
        username.addAll(Arrays.asList("hr31@cybertekschool.com", "hr32@cybertekschool.com", "hr33@cybertekschool.com",
                "helpdesk31@cybertekschool.com", "helpdesk32@cybertekschool.com", "helpdesk33@cybertekschool.com",
                "marketing31@cybertekschool.com", "marketing32@cybertekschool.com", "marketing33@cybertekschool.com"));

        String password = "UserUser";

        //for (String eachUser : username) {

        for (int j = 0; j < username.size(); j++) {


            driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys(username.get(j));
            driver.findElement(By.xpath("//input[@name='USER_PASSWORD']")).sendKeys(password);
            driver.findElement(By.xpath("//input[@class='login-btn']")).click();
            WebElement profileModule = driver.findElement(By.xpath("//div[@id='user-block']"));
            profileModule.click();

            WebElement module;
            ArrayList<String> actualText = new ArrayList<>();
            ArrayList<String> expectedText = new ArrayList<>(Arrays.asList("My Profile", "Edit Profile Settings", "Themes", "Configure notifications", "Logout"));

            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            for (int i = 1; i <= 5; i++) {
                module = driver.findElement(By.xpath("(//div[@class='menu-popup-items'])/*[" + i + "]/*[2]"));

                actualText.add(module.getText());


            }
            System.out.println("expectedText = " + expectedText);
            System.out.println("actualText = " + actualText);

            Assert.assertTrue(actualText.equals(expectedText));

            driver.findElement(By.xpath("//a[.='Log out']")).click();

            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


            driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).clear();
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}






