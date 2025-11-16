package com.lambdatest;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGTodo2 extends BasePage{


    @Test()
    public void Task2() throws InterruptedException {
        Status="failed";
        driver.get(baseUrl());
        // Step 2: Navigate to the "Drag & Drop Sliders" page
        driver.findElement(By.linkText("Drag & Drop Sliders")).click();

        // Step 3: Locate the slider and its value display (Slider 3, as per your code)
        WebElement slider = driver.findElement(By.xpath("(//input[@type='range'])[3]"));
        WebElement valueDisplay = driver.findElement(By.xpath("(//input[@type='range'])[3]"));

        // Step 4: Move the slider to the value 95 using Actions
        Actions actions = new Actions(driver);

        // Click the slider to focus it and prepare to drag
        actions.click(slider).perform();

        // Step 5: Gradually move the slider towards 95
        for (int i = 0; i < 100; i++) {
            slider.sendKeys(org.openqa.selenium.Keys.ARROW_RIGHT);
            Thread.sleep(30); // Wait for UI update

            // Capture the current value of the slider
            String value = valueDisplay.getAttribute("value");

            // If value reaches 95, break the loop
            if (value.equals("95")) {
                break;
            }
        }

        // Step 6: Validate that the slider value is now 95
        String finalValue = valueDisplay.getAttribute("value");
        Assert.assertEquals(finalValue, "95", " Slider did not move to 95 successfully.");

        System.out.println(" Slider moved to 95 successfully.");
        System.out.println("TestFinished");
        Status = "passed";
        Thread.sleep(150);

        System.out.println("TestFinished");
    }


}