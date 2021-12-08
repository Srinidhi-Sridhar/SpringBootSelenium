package com.udemy.spring.springselenium.pages.google;

import com.udemy.spring.springselenium.pages.BaseClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GooglePage extends BaseClass {

    @Autowired
    private SearchResult searchResult;

    public SearchResult getSearchResult() {
        return searchResult;
    }

    public SearchComponent getSearchComponent() {
        return searchComponent;
    }

    @Autowired
    private SearchComponent searchComponent;

    @Value("${application.url}")
    private String url;

    public void goTo()
    {
        driver.get(url);
    }
    @Override
    public boolean isLoaded() {
      return this.searchComponent.isLoaded();
    }
}
