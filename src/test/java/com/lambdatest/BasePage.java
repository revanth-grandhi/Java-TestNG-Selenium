package com.lambdatest;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class BasePage {
    public RemoteWebDriver driver;
    public String Status = "failed";
    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException {
        String username = System.getenv("LT_USERNAME") == null ? "Your LT Username" : System.getenv("LT_USERNAME");
        String authkey = System.getenv("LT_ACCESS_KEY") == null ? "Your LT AccessKey" : System.getenv("LT_ACCESS_KEY");
        ;
        String hub = "@hub.lambdatest.com/wd/hub";
        ChromeOptions browserOptions = new ChromeOptions();
//        browserOptions.setPlatformName("Windows 10");        // OS
//        browserOptions.setBrowserVersion("latest");          // Browser version

        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", System.getenv("LT_USERNAME"));
        ltOptions.put("accessKey", System.getenv("LT_ACCESS_KEY"));
        ltOptions.put("build", "Selenium 101 Assignment");   // Build name in LT dashboard
        ltOptions.put("name", m.getName());                  // Test name
        ltOptions.put("network", true);                      // Enable network logs
        ltOptions.put("video", true);                        // Enable video recording
        ltOptions.put("console", true);                      // Enable console logs
        ltOptions.put("visual", true);                       // Screenshots


        browserOptions.setCapability("LT:Options", ltOptions);

// Connect to LambdaTest hub
        driver = new RemoteWebDriver(new URL("https://hub.lambdatest.com/wd/hub"), browserOptions);

    }

    public String baseUrl()
    {
        String url="https://www.lambdatest.com/selenium-playground";
        return url;

    }
    @AfterMethod
    public void tearDown() {
        driver.executeScript("lambda-status=" + Status);
        driver.quit();
    }
}
