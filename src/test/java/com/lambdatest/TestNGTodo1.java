package com.lambdatest;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGTodo1 extends BasePage{

//    @Test
//    public void basicTest() throws InterruptedException {
//        String spanText;
//        System.out.println("Loading Url");
//        driver.executeScript("lambdatest_executor: {\"action\": \"stepcontext\", \"arguments\": {\"data\": \"Opening WebApp\", \"level\": \"info\"}}");
//
//        driver.get(baseUrl());
//
//        driver.executeScript("lambdatest_executor: {\"action\": \"stepcontext\", \"arguments\": {\"data\": \"Checking List Items\", \"level\": \"info\"}}");
//
//        System.out.println("Checking Box");
//        driver.findElement(By.name("li1")).click();
//
//        System.out.println("Checking Another Box");
//        driver.findElement(By.name("li2")).click();
//
//        System.out.println("Checking Box");
//        driver.findElement(By.name("li3")).click();
//
//        System.out.println("Checking Another Box");
//        driver.findElement(By.name("li4")).click();
//
//        driver.executeScript("lambdatest_executor: {\"action\": \"stepcontext\", \"arguments\": {\"data\": \"Adding Items\", \"level\": \"info\"}}");
//
//        driver.findElement(By.id("sampletodotext")).sendKeys(" List Item 6");
//        driver.findElement(By.id("addbutton")).click();
//
//        driver.findElement(By.id("sampletodotext")).sendKeys(" List Item 7");
//        driver.findElement(By.id("addbutton")).click();
//
//        driver.findElement(By.id("sampletodotext")).sendKeys(" List Item 8");
//        driver.findElement(By.id("addbutton")).click();
//
//        driver.executeScript("lambdatest_executor: {\"action\": \"stepcontext\", \"arguments\": {\"data\": \"Checking More Items\", \"level\": \"info\"}}");
//
//        System.out.println("Checking Another Box");
//        driver.findElement(By.name("li1")).click();
//
//        System.out.println("Checking Another Box");
//        driver.findElement(By.name("li3")).click();
//
//        System.out.println("Checking Another Box");
//        driver.findElement(By.name("li7")).click();
//
//        System.out.println("Checking Another Box");
//        driver.findElement(By.name("li8")).click();
//        Thread.sleep(300);
//
//        driver.executeScript("lambdatest_executor: {\"action\": \"stepcontext\", \"arguments\": {\"data\": \"Adding and Verify List Items\", \"level\": \"info\"}}");
//        System.out.println("Entering Text");
//        driver.findElement(By.id("sampletodotext")).sendKeys("Get Taste of Lambda and Stick to It");
//
//        driver.findElement(By.id("addbutton")).click();
//
//        System.out.println("Checking Another Box");
//        driver.findElement(By.name("li9")).click();
//
//        // Let's also assert that the todo we added is present in the list.
//
//        spanText = driver.findElementByXPath("/html/body/div/div/div/ul/li[9]/span").getText();
//        Assert.assertEquals("Get Taste of Lambda and Stick to It", spanText);
//        Status = "passed";
//        Thread.sleep(150);
//
//        System.out.println("TestFinished");
//
//    }

    @Test
    public void Task1() throws InterruptedException {
        driver.get(baseUrl());
        // Step 2: Click “Simple Form Demo”
        WebElement simpleFormLink = driver.findElement(By.linkText("Simple Form Demo"));
        simpleFormLink.click();

        // Step 3: Validate that the URL contains “simple-form-demo”
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("simple-form-demo"), "URL does not contain 'simple-form-demo'");

        System.out.println("URL contains 'simple-form-demo'");

        // Step 4: Create a variable for string value
        String message = "Welcome to LambdaTest";

        // Step 5: Enter the value in the input field
        WebElement inputBox = driver.findElement(By.id("user-message"));
        inputBox.clear();
        inputBox.sendKeys(message);

        // Step 6: Click “Get Checked Value”
        WebElement showMessageButton = driver.findElement(By.id("showInput"));
        showMessageButton.click();

        // Step 7: Validate displayed message
        WebElement displayedMessage = driver.findElement(By.id("message"));
        String actualMessage = displayedMessage.getText();
        Assert.assertEquals(actualMessage, message, "Displayed message does not match the input message.");

        System.out.println("Message displayed correctly: " + actualMessage);
        Status = "passed";
        Thread.sleep(150);

        System.out.println("TestFinished");
    }






}