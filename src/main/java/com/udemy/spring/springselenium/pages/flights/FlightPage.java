package com.udemy.spring.springselenium.pages.flights;

import com.udemy.spring.springselenium.pages.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FlightPage extends BaseClass {

    @FindBy(xpath = "//*[@class='T7XnYe pJYzRb']")
    private List<WebElement> elements;

    public void gotToUrl(final String Url) {
        this.driver.get(Url);
    }

    public List<String> getLabels() {
        return this.elements.stream().map(e->e.getAttribute("innerHTML")).map(String::trim).collect(Collectors.toList());
    }

    @Override
    public boolean isLoaded() {
        return this.webDriverWait.until((d) -> !this.elements.isEmpty());
    }
}
