package com.cydeo.tests;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US8_VOTE_a_POLL_Jewel {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://login1.nextbasecrm.com");

        //log in
        WebElement InputUserName = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        InputUserName.sendKeys("hr31@cydeo.com"); // passed
        // InputUserName.sendKeys("helpdesk1@cybertekschool.com"); //
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
       // WebElement oneOption = driver.findElement(By.xpath("//*[@id=\"question1212\"]/table/tbody/tr[1]/td[1]/div/span/label[1]/span"));
        WebElement oneOption = driver.findElement(By.xpath("//*[@id=\"question120\"]/table/tbody/tr[1]/td[1]/div/span/label[1]/span"));
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        oneOption.click();

        WebElement secondOption = driver.findElement(By.xpath("//*[@id=\"question120\"]/table/tbody/tr[2]/td[1]/div/span/label[1]/span"));
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
      //  Assert.assertEquals(oneOption.isSelected(), !(secondOption.isSelected()), "one button is not selected");
        System.out.println("oneOption.isSelected() = " + oneOption.isSelected());
        System.out.println("secondOption.isSelected() = " + secondOption.isSelected());

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //


        WebElement voteButton = driver.findElement(By.xpath("//button[@data-bx-vote-button='actVoting']"));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        voteButton.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //verify VOTE AGAIN is displayed

        String expectedText = "VOTE AGAIN";
        String actualText = driver.findElement(By.xpath("//*[@id=\"vote-nSLjLH1171\"]/form/div[2]/button[1]")).getText();
        System.out.println("actualText = " + actualText);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Assert.assertEquals(actualText, expectedText, "not match");


        //click VOTE AGAIN button;
      //  driver.findElement(By.xpath("//*[@id=\"vote-nSLjLH1171\"]/form/div[2]/button[1]")).click();


    }
}
