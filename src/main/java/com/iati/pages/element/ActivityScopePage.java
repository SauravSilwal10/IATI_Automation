package com.iati.pages.element;

import com.iati.utils.DropdownUtils;
import com.iati.utils.ElementUtils;
import com.iati.utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ActivityScopePage {
    WebDriver driver;

    private ElementUtils elementUtils;

    private WaitUtils waitUtils;

    private DropdownUtils dropdownUtils;

    By statusCodeInput = By.xpath("//span[contains(@class,\"select2-selection__arrow\")]");

    By statusCodeType = By.xpath("//ul[contains(@class,\"select2-results__options\")]/li");

    By statusSave = By.xpath( "//button[text()='Save and Exit']");




    public ActivityScopePage(WebDriver driver) {
        this.driver =driver;
        elementUtils = new ElementUtils(driver);
        waitUtils =new WaitUtils(driver);
        dropdownUtils = new DropdownUtils(driver);

    }
    public String getActivityScopeTitle(){
        By xpathTitle = elementUtils.getLocator("div", "activity-scope");
        return waitUtils.visibilityOfElement(xpathTitle,3).getText();
    }
    public String getActivityScopeCode()
    {
        return elementUtils.getTextLabel("label","for","activity_scope");
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
        dropdownUtils.doSelectElementDropdown(statusCodeType,"5 - Sub-national: Multi-first-level administrative areas");
        waitUtils.visibilityOfElement(statusSave,1).click();
    }
}
