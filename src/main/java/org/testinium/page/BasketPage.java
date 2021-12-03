package org.testinium.page;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testinium.base.BasePage;
import org.testinium.constants.ConstantsBasketPage;

import java.util.ArrayList;
import java.util.List;

public class BasketPage extends BasePage {


    public BasketPage(WebDriver driver) {
        super(driver);
    }

    public void increaseProductQuantity(){
        Select dropDown = new Select(findElement(ConstantsBasketPage.QUANTITY_SELECT));
        dropDown.selectByIndex(1);
    }

    public void goToPayment(){
        submitButton(ConstantsBasketPage.PAYMENT_BUTTON);
    }

    public void saveAddress(){
        javascriptExecutor.executeScript("arguments[0].click()",findElement(ConstantsBasketPage.SAVE_BUTTON));
    }

    public boolean checkErrorMessage(){
        WebElement errorMessage = findElement(ConstantsBasketPage.ERROR_MESSAGE);
        String value = errorMessage.getText();
        if(value == null || value == "")
            return false;
        return true;
    }

    public void goToBasketPage(){
        List<WebElement> hyperLinks = findElements(ConstantsBasketPage.EDIT_BASKET);
        String href = hyperLinks.get(1).getAttribute("href");
        driver.get(href);
    }

    /*
    public void addProductFromFavorites(){
        WebElement element = findElement(ConstantsBasketPage.SAVE_FOR_LATER);
        List<WebElement> favorites = element.findElements(By.cssSelector("a[class='gg-ui-btn-default btn-add-to-basket']"));
        Collections.shuffle(favorites);
        System.out.println(favorites.get(0).getAttribute("class"));
        favorites.get(0).click();
        favorites.get(1).click();
    }
    */

    public void newTab(){
        String clickLink = Keys.chord(Keys.CONTROL, Keys.ENTER);
        driver.findElement(ConstantsBasketPage.HOME).sendKeys(clickLink);
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

}
