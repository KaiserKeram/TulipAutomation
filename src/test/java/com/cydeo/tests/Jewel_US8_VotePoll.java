package com.cydeo.tests;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Jewel_US8_VotePoll {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {

        //We are getting the browserType dynamically from our configuration.properties file
        String browserType = ConfigurationReader.getProperty("browser");

        driver = WebDriverFactory.getDriver(browserType);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get(ConfigurationReader.getProperty("env1"));

        com.nextbasecrm.utilities.CRM_Utilities.crm_login(driver);

    }

    @Test
    public void Vote() {

        WebElement optionButton = driver.findElement(By.xpath("//label[.='JAVA']"));

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", optionButton);
        optionButton.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement voteButton = driver.findElement(By.xpath("(//button[.='Vote'])[1]"));

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", voteButton);

        voteButton.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement voteAgainButton = driver.findElement(By.xpath("(//button[.='Vote again'])[1]"));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", voteAgainButton);
        Assert.assertTrue(voteAgainButton.isDisplayed());

        voteAgainButton.click();
    }

    @AfterMethod
    public void tearDown() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.quit();
    }
}
