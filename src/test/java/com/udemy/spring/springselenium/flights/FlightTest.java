package com.udemy.spring.springselenium.flights;

import com.udemy.spring.springselenium.BaseTest;
import com.udemy.spring.springselenium.pages.flights.FlightPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FlightTest extends BaseTest {

    @Autowired
    private FlightAppDetails flightAppDetails;

    @Autowired
    private FlightPage flightPage;

    @Test
    public void flightTest()
    {
        flightPage.gotToUrl(flightAppDetails.getAppUrl());
        Assert.assertTrue(flightPage.isLoaded());
        Assert.assertEquals(flightPage.getLabels(),flightAppDetails.getAppLables());
        flightPage.driver.quit();
    }


}
