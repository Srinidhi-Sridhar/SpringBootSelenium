package com.udemy.spring.springselenium.xalu.utils;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class WindowSwitchService {
    @Autowired
    private ApplicationContext applicationContext;

    public void switchByTitle(String title) {
        WebDriver driver = this.applicationContext.getBean(WebDriver.class);
        driver.getWindowHandles().stream().map(handle -> driver.switchTo().window(handle).getTitle())
                .filter(e -> e.startsWith(title)).findFirst().orElseGet(()->{
                    throw new RuntimeException("No Such Window");
                });
    }

    public void switchByIndex(int index) {
        WebDriver driver = applicationContext.getBean(WebDriver.class);
       String [] arr= driver.getWindowHandles().toArray(new String [0]);
       driver.switchTo().window(arr[index]);
    }
}
