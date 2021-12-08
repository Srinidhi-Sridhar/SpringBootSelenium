package com.udemy.spring.springselenium.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class WebDriverConfig {

    @Value("${chromeDriverVersion}")
    String chromeDriverVersion;

    @Value("${fireFoxVersion}")
    String fireFoxVersion;

    @Value("${default_timeout:30}")
    private int timeOut;

    @Bean
    @ConditionalOnProperty(name = "browserName", havingValue = "chrome")
    public WebDriver createChromeDriver() {
        WebDriverManager.chromedriver().driverVersion(chromeDriverVersion).setup();
        return new ChromeDriver();
    }

    @Bean
    @ConditionalOnProperty(name = "browserName", havingValue = "firefox")
    public WebDriver createFireFoxDriver() {
        WebDriverManager.firefoxdriver().driverVersion(fireFoxVersion).setup();
        return new FirefoxDriver();
    }

    @Bean
    public WebDriverWait webDriverWait(WebDriver driver) {
        return new WebDriverWait(driver, timeOut);
    }
}
