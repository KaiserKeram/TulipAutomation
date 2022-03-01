package com.cydeo.tests;

import com.cydeo.utilities.CRM_Utilities;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TL_5_LogOutFunctionTest {

    WebDriver driver;
    @BeforeMethod
    public void setDriver(){
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.getProperty("env"));
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    //-------------------------------- Test with HR Credential-----------------------------------

    @Test(priority=1)
    public void hrLogOut(){

        CRM_Utilities.crm_login( driver,"hr37@cydeo.com","UserUser");
        driver.findElement(By.id("user-name")).click();
        driver.findElement(By.linkText("Log out")).click();
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).clear();

        CRM_Utilities.crm_login( driver,"hr38@cydeo.com","UserUser");
        driver.findElement(By.id("user-name")).click();
        driver.findElement(By.linkText("Log out")).click();
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).clear();

        CRM_Utilities.crm_login( driver,"hr39@cydeo.com","UserUser");
        driver.findElement(By.id("user-name")).click();
        driver.findElement(By.linkText("Log out")).click();
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).clear();
    }

    //-------------------------------- Test with helpdesk Credential-----------------------------------

    @Test(priority=2)
    public void helpdeskLogOut(){
        CRM_Utilities.crm_login( driver,"helpdesk37@cydeo.com","UserUser");
        driver.findElement(By.id("user-name")).click();
        driver.findElement(By.linkText("Log out")).click();
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).clear();

        CRM_Utilities.crm_login( driver,"helpdesk38@cydeo.com","UserUser");
        driver.findElement(By.id("user-name")).click();
        driver.findElement(By.linkText("Log out")).click();
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).clear();

        CRM_Utilities.crm_login( driver,"helpdesk39@cydeo.com","UserUser");
        driver.findElement(By.id("user-name")).click();
        driver.findElement(By.linkText("Log out")).click();
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).clear();
    }

    //-------------------------------- Test with marketing Credential-----------------------------------


    @Test(priority=3)
    public void marketingLogOut(){
        CRM_Utilities.crm_login( driver,"marketing37@cydeo.com","UserUser");
        driver.findElement(By.id("user-name")).click();
        driver.findElement(By.linkText("Log out")).click();
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).clear();

        CRM_Utilities.crm_login( driver,"marketing38@cydeo.com","UserUser");
        driver.findElement(By.id("user-name")).click();
        driver.findElement(By.linkText("Log out")).click();
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).clear();

        CRM_Utilities.crm_login( driver,"marketing39@cydeo.com","UserUser");
        driver.findElement(By.id("user-name")).click();
        driver.findElement(By.linkText("Log out")).click();
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).clear();
    }

}
