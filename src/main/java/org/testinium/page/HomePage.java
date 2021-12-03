package org.testinium.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testinium.base.BasePage;
import org.testinium.constants.ConstantsHomePage;

import java.util.Collections;
import java.util.List;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }


    public void moveToLogin(){
        WebElement element = findElement(ConstantsHomePage.LOGIN_AREA);
        actions.moveToElement(element).perform();
    }

    public void clickLoginButton(){
        clickElement(ConstantsHomePage.LOGIN_BUTTON);
    }

    public void searchProduct(String word){
        sendKeys(ConstantsHomePage.SEARCH_INPUT, word);
        submitButton(ConstantsHomePage.SEARCH_BUTTON);
    }

    public void getRandomProducts(){
        List<WebElement> links = findElements(ConstantsHomePage.PRODUCT_LIST);
        Collections.shuffle(links);
        links.get(0).click();
        links.get(1).click();
        links.get(2).click();
        links.get(3).click();
    }

    public void goHomePage(){
        WebElement element = findElement(ConstantsHomePage.HOME);
        String href = element.getAttribute("href");
        driver.get(href);
    }

    public void addProductToBasket(){
        List<WebElement> products = findElements(ConstantsHomePage.BUTTON_LIST);
        javascriptExecutor.executeScript("arguments[0].click()",products.get(6));
    }

    public void goToBasket(){
        List<WebElement> areas = findElements(ConstantsHomePage.BASKET_AREA);
        actions.moveToElement(areas.get(1));
        String href = findElement(ConstantsHomePage.BASKET_HYPERLINK).getAttribute("href");
        driver.get(href);

    }

    public void logout(){
        actions.moveToElement(findElement(ConstantsHomePage.USER_AREA)).perform();
        List<WebElement> userLinks = findElements(ConstantsHomePage.USER_LINKS);
        String href = userLinks.get(15).getAttribute("href");
        driver.get(href);
    }




}
