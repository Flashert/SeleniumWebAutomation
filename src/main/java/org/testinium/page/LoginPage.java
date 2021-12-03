package org.testinium.page;

import org.openqa.selenium.WebDriver;
import org.testinium.base.BasePage;
import org.testinium.constants.ConstantsLoginPage;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password){
        sendKeys(ConstantsLoginPage.USERNAME_INPUT, username);
        sendKeys(ConstantsLoginPage.PASSWORD_INPUT, password);
        submitButton(ConstantsLoginPage.LOGIN_BUTTON);
    }

}
