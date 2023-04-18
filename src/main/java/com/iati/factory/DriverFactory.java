package com.iati.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DriverFactory {
    WebDriver driver;
    Properties properties;

    /***
     *
     * @param prop name of browser
     * @return driver of the String sent
     */
    public WebDriver initDriver(Properties prop) {

        String browser = prop.getProperty("browser");
        System.out.println("---------------" + browser + " initialization------------------");
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--remote-allow-origins=*");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(chromeOptions);
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
        } else {
            System.out.println("Keyword mismatched with browser");
        }
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        //    driver.manage().deleteAllCookies();

        return driver;
    }

    public Properties initProperties() {
        properties = new Properties();
        try {
            FileInputStream inputStream = new FileInputStream("./src/test/resources/config/config.properties");
            properties.load(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

}
