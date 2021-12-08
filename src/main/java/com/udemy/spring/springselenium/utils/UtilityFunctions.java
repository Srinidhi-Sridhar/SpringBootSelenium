package com.udemy.spring.springselenium.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;

@Lazy
@Component
public class UtilityFunctions {

    @Autowired
    private TakesScreenshot driver;

    @Value("${screenshot.path}")
    private Path path;

    public void takeScreenShot() throws IOException {
        File source = this.driver.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source,new File(path + dateTimeStamp() +".png"));
    }

    public String dateTimeStamp()
    {
        return new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
    }
}
