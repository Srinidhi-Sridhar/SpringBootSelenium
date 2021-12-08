package com.udemy.spring.springselenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public abstract class BaseClass {

    @Autowired
    public WebDriver driver;

    @Autowired
    public WebDriverWait webDriverWait;

    @PostConstruct
    public void init() {
        PageFactory.initElements(this.driver, this);
    }
    public abstract boolean isLoaded();
}
