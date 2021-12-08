package com.udemy.spring.springselenium;

import com.udemy.spring.springselenium.pages.google.GooglePage;
import com.udemy.spring.springselenium.utils.UtilityFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class GoogleTest extends BaseTest {

    @Autowired
    private GooglePage googlePage;

    @Lazy
    @Autowired
    UtilityFunctions utilityFunctions;

    @Test
    public void searchTest() throws IOException {
        googlePage.goTo();
        Assert.assertTrue(googlePage.isLoaded());
        googlePage.getSearchComponent().searchSomething("Hello");
        Assert.assertTrue(googlePage.getSearchResult().getCount() > 2);
        utilityFunctions.takeScreenShot();
    }

    @AfterTest
    public void closeDriver() {
        googlePage.driver.quit();
    }
}
