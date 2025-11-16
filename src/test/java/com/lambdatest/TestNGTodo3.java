package com.lambdatest;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGTodo3 extends BasePage{



    @Test
    public void testInputFormSubmission() throws InterruptedException {
        Status = "failed";
        // Step 1: Navigate to the "Input Form Submit" page
        driver.get(baseUrl());
        driver.findElement(By.linkText("Input Form Submit")).click();

        // Step 2: Validate if the error messages are shown for empty required fields
        validateRequiredFieldErrors();

        // Step 3: Fill the form with hardcoded valid data
        fillForm("John Doe", "john.doe@example.com", "password123", "Example Corp.",
                "https://example.com", "New York", "123 Main St", "Apt 101",
                "New York", "10001", "United States");

        // Step 4: Submit the form
        driver.findElement(By.xpath("//button[@type='submit' and text()='Submit']")).click();

        // Step 5: Validate the success message
        validateSuccessMessage();
    }

    private void validateRequiredFieldErrors() {
        // Validate required field error messages
        WebElement nameField = driver.findElement(By.id("name"));
        WebElement emailField = driver.findElement(By.id("inputEmail4"));
        WebElement passwordField = driver.findElement(By.id("inputPassword4"));

        Assert.assertTrue(nameField.getAttribute("validationMessage").contains("Please fill out this field."),
                "Name field validation message not displayed correctly.");
        Assert.assertTrue(emailField.getAttribute("validationMessage").contains("Please fill out this field."),
                "Email field validation message not displayed correctly.");
        Assert.assertTrue(passwordField.getAttribute("validationMessage").contains("Please fill out this field."),
                "Password field validation message not displayed correctly.");

        System.out.println("Error messages for empty required fields validated.");
    }

    private void fillForm(String name, String email, String password, String company, String website,
                          String city, String address1, String address2, String state, String zipCode, String country) {

        // Fill in the form fields with the provided values
        driver.findElement(By.id("name")).sendKeys(name);
        driver.findElement(By.id("inputEmail4")).sendKeys(email);
        driver.findElement(By.id("inputPassword4")).sendKeys(password);
        driver.findElement(By.id("company")).sendKeys(company);
        driver.findElement(By.id("websitename")).sendKeys(website);
        driver.findElement(By.id("inputCity")).sendKeys(city);
        driver.findElement(By.id("inputAddress1")).sendKeys(address1);
        driver.findElement(By.id("inputAddress2")).sendKeys(address2);
        driver.findElement(By.id("inputState")).sendKeys(state);
        driver.findElement(By.id("inputZip")).sendKeys(zipCode);

        // Select "United States" from the country dropdown
        WebElement countryDropdown = driver.findElement(By.name("country"));
        Select selectCountry = new Select(countryDropdown);
        selectCountry.selectByVisibleText(country);

        System.out.println("✅ Form filled with provided data.");
    }

    private void validateSuccessMessage() throws InterruptedException {
        // Validate the success message
        WebElement successMessage = driver.findElement(By.xpath("//p[@class='success-msg hidden']"));
        String successText = successMessage.getText();

        Assert.assertTrue(successText.contains("Thanks for contacting us, we will get back to you shortly."),
                "Success message not displayed correctly.");

        System.out.println("Form submitted successfully. Success message is displayed.");
        Status = "passed";
        Thread.sleep(150);

        System.out.println("TestFinished");
    }




}