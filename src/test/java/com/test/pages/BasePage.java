package com.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    WebDriver driver = null;
    WebDriverWait wait = null;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
    }

    public WebElement findElement(By by) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by)); //
        return driver.findElement(by);
    }
    public void clickElement(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by)); //buton tıklanana kadar bekleyecek
        findElement(by).click();
    }
    public void sendKeys(By by, String text) {
        wait.until(ExpectedConditions.elementToBeClickable(by));
        findElement(by).sendKeys(text);
    }
    public String getTitle(){
        return driver.getTitle();

    }
    public void clearTest(By by){
        findElement(by).clear();
    }
}
