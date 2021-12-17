package com.udemy.spring.springselenium.pages.google;

import com.udemy.spring.springselenium.xalu.annotations.PageFragment;
import com.udemy.spring.springselenium.pages.BaseClass;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@PageFragment
public class SearchComponent extends BaseClass {

    @FindBy(name = "q")
    private WebElement searchBox;

    @FindBy(name = "btnK")
    private List<WebElement> searchButtons;

    public void searchSomething(final String toBeSearched) {
        searchBox.sendKeys(toBeSearched);
        searchBox.sendKeys(Keys.TAB);
        searchButtons.stream().filter(e -> e.isDisplayed() && e.isEnabled()).findFirst().ifPresent(WebElement::click);
    }

    @Override
    public boolean isLoaded() {
        return this.webDriverWait.until((d) -> this.searchBox.isDisplayed());
    }
}
