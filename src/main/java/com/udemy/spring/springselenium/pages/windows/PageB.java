package com.udemy.spring.springselenium.pages.windows;

import com.udemy.spring.springselenium.pages.BaseClass;
import com.udemy.spring.springselenium.xalu.annotations.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Page
public class PageB extends BaseClass {
    @FindBy(id = "area")
    private WebElement textArea;

    public void addArea(String message)
    {
        textArea.sendKeys(message);
    }
    @Override
    public boolean isLoaded() {
    return this.webDriverWait.until((d) -> this.textArea.isDisplayed());
    }
}
