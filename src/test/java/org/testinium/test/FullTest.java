package org.testinium.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.testinium.base.BaseTest;
import org.testinium.page.BasketPage;
import org.testinium.page.HomePage;
import org.testinium.page.LoginPage;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FullTest extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;
    BasketPage basketPage;
    public static final String USERNAME = "email";
    public static final String PASSWORD = "sifre";

    @Before
    public void before(){
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        basketPage = new BasketPage(driver);
    }

    @Test
    public void aHomePageTest(){
        homePage.moveToLogin();
        homePage.clickLoginButton();
    }

    @Test
    public void bLoginTest(){
        loginPage.login(USERNAME,PASSWORD);
    }

    @Test
    public void cSearchTest(){
        homePage.searchProduct("şapka");
        homePage.scrollPage();
    }

    @Test
    public void dGetRandomProductsTest(){
        homePage.getRandomProducts();
    }

    @Test
    public void eGoHomePage(){
        homePage.goHomePage();
    }

    @Test
    public void fSearchBag(){
        homePage.searchProduct("çanta");
        homePage.addProductToBasket();
        homePage.goToBasket();
    }

    @Test
    public void gBasketPage(){
        basketPage.increaseProductQuantity();
        basketPage.goToPayment();
        basketPage.saveAddress();
        Assert.assertTrue(basketPage.checkErrorMessage());
        basketPage.goToBasketPage();
    }

    @Test
    public void hLogout(){
        basketPage.newTab();
        homePage.logout();
    }
}
