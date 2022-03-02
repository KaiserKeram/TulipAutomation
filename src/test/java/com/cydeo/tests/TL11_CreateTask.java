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

public class TL11_CreateTask {

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
    public void create_task_successfuly() {
        ArrayList<String> username = new ArrayList<>();
        username.addAll(Arrays.asList("hr31@cybertekschool.com", "hr32@cybertekschool.com", "hr33@cybertekschool.com",
                "helpdesk31@cybertekschool.com", "helpdesk32@cybertekschool.com", "helpdesk33@cybertekschool.com",
                "marketing31@cybertekschool.com", "marketing32@cybertekschool.com", "marketing33@cybertekschool.com"));

        String password = "UserUser";


        for (int j = 0; j < username.size(); j++) {


            driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys(username.get(j));
            driver.findElement(By.xpath("//input[@name='USER_PASSWORD']")).sendKeys(password);
            driver.findElement(By.xpath("//input[@class='login-btn']")).click();

            WebElement task = driver.findElement(By.xpath("//span[.='Task']/span"));
            task.click();

            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

            WebElement taskTitle = driver.findElement(By.xpath("//input[@data-bx-id=\"task-edit-title\"]"));
            taskTitle.sendKeys("Cydeo B25");
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

           WebElement iframe = driver.findElement(By.xpath("//iframe[@class=\"bx-editor-iframe\"]"));
            driver.switchTo().frame(1);

            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            WebElement taskMessage = driver.findElement(By.xpath("//body[@style=\"min-height: 84px;\"]"));
            taskMessage.sendKeys("Group 11");


            driver.switchTo().defaultContent();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            WebElement sendButton = driver.findElement(By.xpath("//button[@id=\"blog-submit-button-save\"]"));

            sendButton.click();

            WebElement taskPopUp = driver.findElement(By.xpath("//div[@class=\"feed-create-task-popup-title\"]"));

            Assert.assertTrue(taskPopUp.isDisplayed());

            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            WebElement profileModule = driver.findElement(By.xpath("//div[@id='user-block']"));
            profileModule.click();


            driver.findElement(By.xpath("//a[.='Log out']")).click();

            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


            driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).clear();


        }
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }


}