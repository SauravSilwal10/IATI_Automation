package com.iati.pages.element;

import com.iati.utils.DropdownUtils;
import com.iati.utils.ElementUtils;
import com.iati.utils.JSExecutorUtils;
import com.iati.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class MigrationScript {
    WebDriver driver;
    private ElementUtils elementUtils;
    private WaitUtils waitUtils;
    private DropdownUtils dropdownUtils;
    private JSExecutorUtils jsExecutorUtils;
    private WebElement webElement;

    public MigrationScript(WebDriver driver) {
        this.driver = driver;
        elementUtils = new ElementUtils(driver);
        waitUtils = new WaitUtils(driver);
        dropdownUtils = new DropdownUtils(driver);
        jsExecutorUtils = new JSExecutorUtils(driver);
    }

    public  String getMigrationTitle() {
        By xpathTitle = elementUtils.getLocator("div", "title");
        return waitUtils.visibilityOfElement(xpathTitle, 10).getText();
    }



}
