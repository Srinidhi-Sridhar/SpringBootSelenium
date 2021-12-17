package com.udemy.spring.springselenium.pages.google;

import com.udemy.spring.springselenium.pages.BaseClass;
import com.udemy.spring.springselenium.xalu.annotations.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@Page
public class GooglePage extends BaseClass {

    @Autowired
    private SearchResult searchResult;
    @Autowired
    private SearchComponent searchComponent;
    @Value("${application.url}")
    private String url;

    public SearchResult getSearchResult() {
        return searchResult;
    }

    public SearchComponent getSearchComponent() {
        return searchComponent;
    }

    public void goTo() {
        driver.get(url);
    }

    @Override
    public boolean isLoaded() {
        return this.searchComponent.isLoaded();
    }
}
