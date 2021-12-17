package com.udemy.spring.springselenium.pages.google;

import com.udemy.spring.springselenium.xalu.annotations.PageFragment;
import com.udemy.spring.springselenium.pages.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@PageFragment
public class SearchResult extends BaseClass {
    @FindBy(className = "yuRUbf")
    private List<WebElement> results;

    public int getCount() {
        return results.size();
    }

    @Override
    public boolean isLoaded() {
        return this.webDriverWait.until((d) -> this.results.isEmpty());
    }
}
