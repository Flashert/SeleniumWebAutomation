package org.testinium.base;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {

    protected static WebDriver driver;

    @BeforeClass
    public static void setup(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        chromeOptions.addArguments("disable-translate");
        driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.gittigidiyor.com");
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
        driver.quit();
    }

}
