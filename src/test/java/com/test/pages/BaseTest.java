package com.test.pages;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    static WebDriver driver = null;


    public void setUp(){
        System.setProperty("webdriver.chrome.driver","/Users/DENİZ/Desktop/n11testotomation/driver/chromedriver.exe"); //kullanılacak driverin yolu seçilir
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-notifications");
        options.addArguments("disable-popup-blocking");
        options.addArguments("start-maximized");
        setDriver(new ChromeDriver(options));
        getDriver().navigate().to("https://www.trendyol.com/");
    }


    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        BaseTest.driver = driver;
    }

    public void tearDown(){
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getDriver().quit();
    }
}
