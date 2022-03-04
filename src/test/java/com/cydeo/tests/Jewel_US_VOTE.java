package com.cydeo.tests;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Jewel_US_VOTE {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://login2.nextbasecrm.com");

        //log in
        WebElement InputUserName = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        InputUserName.sendKeys("hr31@cydeo.com"); // passed
        //  InputUserName.sendKeys("helpdesk31@cybertekschool.com"); //
        // InputUserName.sendKeys("marketing33@cybertekschool.com"); //

        WebElement InputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        InputPassword.sendKeys("UserUser");

        WebElement loginButton = driver.findElement(By.xpath("//input[@class='login-btn']"));
        loginButton.click();
        //----------------------------------------
    }

    @Test
    public void locateVOTE() throws InterruptedException {
        //test case 2 test: task with no title;
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //  WebElement oneOption = driver.findElement(By.xpath("//*[@id=\"question1203\"]/table/tbody/tr[1]/td[1]/div/span/label[1]/span"));
        WebElement oneOption = driver.findElement(By.xpath("//*[@id=\"question1204\"]/table/tbody/tr[1]/td[1]/div/span/label[2]"));

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        oneOption.click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //
        //WebElement voteButton = driver.findElement(By.xpath("//*[@id=\"vote-nSLjLH1162\"]/form/div[2]/button[2]/text()"));
        WebElement voteButton = driver.findElement(By.xpath("//*[@id=\"vote-mPlAdu1163\"]/form/div[2]/button[2]/text()"));
        //*[@id="vote-nSLjLH1163"]/form/div[2]/button[2]/text()
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        voteButton.click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }


}

