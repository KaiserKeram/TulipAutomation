package com.cydeo.tests;

import com.cydeo.utilities.CRM_utilities;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.text.Utilities;
import java.util.concurrent.TimeUnit;

import static com.cydeo.utilities.CRM_utilities.crm_login;

public class TL43_SendSimpleTextMessages {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {

        //1. Open browser and User go to homepage and login
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


        // 2. User clicks the MESSAGE tab
        @Test
        public void sendMessageOnFeed(){
            CRM_utilities.crm_login(driver,"marketing36@cybertekschool.com","UserUser");
            WebElement messageTab = driver.findElement(By.xpath("//span[@id=\"feed-add-post-form-tab-message\"]"));
            messageTab.click();


            // 3.write a message on message feed
            driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']")));
            WebElement iframeMessageBox = driver.findElement(By.xpath("/html/body"));
            iframeMessageBox.sendKeys("Hi.");


            // 4. User click the SEND button.
            driver.switchTo().defaultContent();
            WebElement sendButton = driver.findElement(By.xpath("//button[@id=\"blog-submit-button-save\"]"));
            sendButton.click();

        }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

}
