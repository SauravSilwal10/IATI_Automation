package com.iati.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JSExecutorUtils {

    private WebDriver driver;


    public JSExecutorUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void doJsMoveToElement(WebElement webElement,boolean flag) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView("+flag+")", webElement);
    }

    public void scrollPageDown(String height) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void flashElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='3px solid red'", element);
    }

}
