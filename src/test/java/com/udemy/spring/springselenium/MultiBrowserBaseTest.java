package com.udemy.spring.springselenium;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.testng.annotations.Test;

public class MultiBrowserBaseTest extends SpringBaseTestNG {

    @Autowired
    private ApplicationContext ctx;

    @Test
    public void browserTest()
    {
        this.ctx.getBean("createChromeDriver",WebDriver.class).get("https://www.google.com/");
        this.ctx.getBean("createFireFoxDriver",WebDriver.class).get("https://www.yahoo.com/");
    }
}
