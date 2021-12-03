package org.testinium.base;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;
    protected JavascriptExecutor javascriptExecutor;

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 30, 750);
        actions = new Actions(driver);
        javascriptExecutor = (JavascriptExecutor) driver;
    }

    public WebElement findElement(By by){
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public List<WebElement> findElements(By by){
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public void clickElement(By by){
        WebElement element = findElement(by);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void sendKeys(By by, CharSequence text){
        WebElement element = findElement(by);
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(text);
    }
    public void submitButton(By by){
        wait.until(ExpectedConditions.presenceOfElementLocated(by)).submit();
    }

    public void scrollPage(){
        javascriptExecutor.executeScript("window.scrollBy(0,8000)");
    }




}
