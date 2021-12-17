package com.udemy.spring.springselenium;

import com.udemy.spring.springselenium.pages.google.GooglePage;
import com.udemy.spring.springselenium.xalu.annotations.LazyAutowired;
import com.udemy.spring.springselenium.xalu.utils.UtilityFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;


public class Google2Test extends BaseTest {

    @LazyAutowired
    UtilityFunctions utilityFunctions;

    @LazyAutowired
    private GooglePage googlePage;

    @Test
    public void searchTest() throws IOException {
        googlePage.goTo();
        Assert.assertTrue(googlePage.isLoaded());
        googlePage.getSearchComponent().searchSomething("Java");
        Assert.assertTrue(googlePage.getSearchResult().getCount() > 2);
        utilityFunctions.takeScreenShot();
        googlePage.driver.quit();
    }

    @AfterTest
    public void closeDriver() {
        googlePage.driver.quit();
    }
}
