package com.iati.utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class WindowHandleUtils {
    private WebDriver driver;

    public WindowHandleUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void moveToNewTab(int tabNumber) {
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(tabNumber));
    }

    public void goBack() {
        driver.navigate().back();
    }


    public String getAlertText() {
        Alert alertPopup = driver.switchTo().alert();
        return alertPopup.getText();
    }


    public void acceptAlert() {
        Alert alertPopup = driver.switchTo().alert();
        alertPopup.accept();
    }
}
