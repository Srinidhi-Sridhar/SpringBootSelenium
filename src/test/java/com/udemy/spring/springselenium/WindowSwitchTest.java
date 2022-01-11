package com.udemy.spring.springselenium;

import com.udemy.spring.springselenium.pages.windows.MainPage;
import com.udemy.spring.springselenium.pages.windows.PageA;
import com.udemy.spring.springselenium.pages.windows.PageB;
import com.udemy.spring.springselenium.pages.windows.PageC;
import com.udemy.spring.springselenium.xalu.utils.WindowSwitchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@TestPropertySource(properties = "browser=firefox")
public class WindowSwitchTest extends BaseTest {
    @Autowired
    private MainPage mainPage;

    @Autowired
    private PageA pageA;
    @Autowired
    private PageB pageB;
    @Autowired
    private PageC pageC;

    @Autowired
    WindowSwitchService windowSwitchService;

    @BeforeClass
    public void setup()
    {
        mainPage.goTo();
        mainPage.clickAllLinks();
        mainPage.isLoaded();
    }
    @Test
    public void test()
    {
        windowSwitchService.switchByTitle("Page A");
        pageA.addArea("Hi Page A");
        windowSwitchService.switchByTitle("Page B");
        pageB.addArea("Hi Page B");
        windowSwitchService.switchByIndex(1);
        pageC.addArea("Hi Page C");
        mainPage.driver.quit();
    }

}
