package com.udemy.spring.springselenium.pages.windows;

import com.udemy.spring.springselenium.pages.BaseClass;
import com.udemy.spring.springselenium.xalu.annotations.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Page
public class MainPage extends BaseClass {

    @FindBy(tagName = "a")
    private List<WebElement> links;

    public void goTo()
    {
        driver.get("https://vins-udemy.s3.amazonaws.com/ds/window/main.html");
    }

    public void clickAllLinks()
    {
        links.forEach(WebElement::click);
    }
    @Override
    public boolean isLoaded() {
        return false;
    }
}
