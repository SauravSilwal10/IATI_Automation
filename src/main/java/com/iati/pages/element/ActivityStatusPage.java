package com.iati.pages.element;

import com.iati.utils.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class ActivityStatusPage {
    WebDriver driver;
    private ElementUtils elementUtils;
    private WaitUtils waitUtils;
    private DropdownUtils dropdownUtils;
    private JSExecutorUtils jsExecutorUtils;
    private WebElement webElement;

    By statusCodeInput = By.id("select2-activity_status-container");

    By statusCodeType = By.xpath("//ul[contains(@class,'select2-results__options')]/li");


    By statusSave = By.xpath("//button[contains(text(), 'Save and Exit')]");

    By yourActivities =By.xpath("//a[contains(text(),'Your Activities')]");

    public ActivityStatusPage(WebDriver driver) {
        this.driver = driver;
        elementUtils = new ElementUtils(driver);
        waitUtils = new WaitUtils(driver);
        dropdownUtils = new DropdownUtils(driver);
        jsExecutorUtils = new JSExecutorUtils(driver);
    }



    public void getYourActivities(){
        waitUtils.visibilityOfElement(yourActivities,0).click();

    }

    public String getActivityStatusTitle() {
        By xpathTitle = elementUtils.getLocator("div", "activity-status");
        return waitUtils.visibilityOfElement(xpathTitle, 2).getText();
    }
    public String getActivityStatusCoreElement() {
        By xpathTitle = elementUtils.getLocator("div", "Core Elements");
        return waitUtils.visibilityOfElement(xpathTitle, 2).getText();
    }

    public String getActivityMandatorySubElements() {
        By xpathTitle = elementUtils.getLocator("div", "Mandatory sub-elements");
        return waitUtils.visibilityOfElement(xpathTitle, 2).getText();
    }
    public String getRecommendedSubElements() {
        By xpathTitle = elementUtils.getLocator("div", "Recommended sub-elements");
        return waitUtils.visibilityOfElement(xpathTitle, 2).getText();
    }


    public String getActivityStatusCode(){
        return elementUtils.getTextLabel("label","for","activity_status");
    }

    public ArrayList<String> getCodeList() {
        waitUtils.visibilityOfElement(statusCodeInput,0).click();
        List<WebElement> codeList=waitUtils.visibilityOfElements(statusCodeType,2);
        ArrayList<String> code = new ArrayList<String>();
        for (WebElement e : codeList) {
            code.add(e.getText());
        }
        System.out.println(code);
        return code;
    }
    public void sendCodeList(int count ) {
        waitUtils.visibilityOfElement(statusCodeInput, 1).click();
        dropdownUtils.doSelectElementDropdown(statusCodeType,count);
    }
    public void SaveAndExit(){
        waitUtils.visibilityOfElement(statusCodeInput,2).click();
        dropdownUtils.doSelectElementDropdown(statusCodeType,"3 - Finalisation");
        waitUtils.visibilityOfElement(statusSave,1).click();
    }


}
