package org.testinium.constants;

import org.openqa.selenium.By;

public class ConstantsBasketPage {
    public static final By QUANTITY_SELECT = By.cssSelector("select[class='amount'");
    public static final By PAYMENT_BUTTON = By.cssSelector("input[class='gg-d-24 gg-ui-btn-primary gg-ui-btn-lg btn-pay']");
    public static final By SAVE_BUTTON = By.cssSelector("button[class='gg-ui-btn-primary gg-btn post-address gg-ui-btn-fluid post-address-button gg-ui-btn-lg']");
    public static final By ERROR_MESSAGE = By.cssSelector("div[class='gg-input-error-text gg-d-24']");
    public static final By EDIT_BASKET = By.cssSelector("a[class='header-link pl10']");
    //public static final By SAVE_FOR_LATER = By.id("save-id-later-slider");
    public static final By HOME = By.cssSelector("a[class='logo_gg imglink logo-small']");
}
