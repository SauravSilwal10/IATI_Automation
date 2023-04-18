package com.iati.pages.element;

import com.iati.utils.DropdownUtils;
import com.iati.utils.ElementUtils;
import com.iati.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DescriptionPage {
    WebDriver driver;
    private ElementUtils elementUtils;

    private WaitUtils waitUtils;

    private DropdownUtils dropdownUtils;


    public DescriptionPage(WebDriver driver) {
        this.driver =driver;
        elementUtils = new ElementUtils(driver);
        waitUtils =new WaitUtils(driver);
        dropdownUtils = new DropdownUtils(driver);

    }

    public String getDescriptionTitle(){
        By xpathTitle = elementUtils.getLocator("div", "description");
        return waitUtils.visibilityOfElement(xpathTitle,3).getText();
    }


}
