package com.udemy.spring.springselenium.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;

import java.net.URL;

@Lazy
@Configuration
@Profile("remote")
public class RemotWebDriver {

    @Value("${chromeDriverVersion}")
    String chromeDriverVersion;
    @Value("${selenium.grid.url}")
    private URL remoteUrl;

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(name = "browser", havingValue = "fireFox")
    public WebDriver remoteFixeFoxDriver() {
        return new RemoteWebDriver(this.remoteUrl, DesiredCapabilities.firefox());
    }

    @Bean
    @ConditionalOnProperty(name = "browser", havingValue = "safari")
    public WebDriver remoteSafariDriver() {
        return new RemoteWebDriver(this.remoteUrl, DesiredCapabilities.safari());
    }

    @Bean
    @ConditionalOnMissingBean
    public WebDriver remoteChromeDriver() {
        WebDriverManager.chromedriver().driverVersion(chromeDriverVersion).setup();
        return new RemoteWebDriver(this.remoteUrl, DesiredCapabilities.chrome());
    }
}
