package com.udemy.spring.springselenium.xalu.config;

import com.udemy.spring.springselenium.xalu.annotations.LazyConfiguration;
import com.udemy.spring.springselenium.xalu.annotations.ThreadScopeBean;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Profile;

import java.net.URL;

@LazyConfiguration
@Profile("remote")
public class RemotWebDriver {

    @Value("${chromeDriverVersion}")
    String chromeDriverVersion;
    @Value("${selenium.grid.url}")
    private URL remoteUrl;

    @ThreadScopeBean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(name = "browser", havingValue = "fireFox")
    public WebDriver remoteFixeFoxDriver() {
        return new RemoteWebDriver(this.remoteUrl, DesiredCapabilities.firefox());
    }

    @ThreadScopeBean
    @ConditionalOnProperty(name = "browser", havingValue = "safari")
    public WebDriver remoteSafariDriver() {
        return new RemoteWebDriver(this.remoteUrl, DesiredCapabilities.safari());
    }

    @ThreadScopeBean
    @ConditionalOnMissingBean
    public WebDriver remoteChromeDriver() {
        WebDriverManager.chromedriver().driverVersion(chromeDriverVersion).setup();
        return new RemoteWebDriver(this.remoteUrl, DesiredCapabilities.chrome());
    }
}
