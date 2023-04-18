package com.iati.pages;

import com.iati.pages.element.*;


import com.iati.utils.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActivityDetailPage {
    private WebElement webElement;
    private WebDriver driver;
    private WaitUtils waitUtils;
    private ActionUtils actionUtils;
    private ElementUtils elementUtils;
    private DropdownUtils dropdownUtils;
    private JSExecutorUtils jsExecutorUtils;

    private By activityTitle = By.cssSelector("h4.ellipsis__title span.overflow-hidden.ellipsis__title");


    /*---------------------------------Elements locator----------------------------------------------------------------*/

    private By elementName = By.xpath("//div[@class='elements__listing mt-3 grid grid-cols-2 gap-2']/a/div[last()]");
    private By elementSingle = By.xpath("//a/div[normalize-space()='result']");
    private By sectionOtherIdentifier = By.id("other_identifier");


    public ActivityDetailPage(WebDriver driver) {
        this.driver = driver;
        elementUtils = new ElementUtils(driver);
        waitUtils = new WaitUtils(driver);
        jsExecutorUtils = new JSExecutorUtils(driver);
    }

    public String getActivityTitle()
    {
        return waitUtils.visibilityOfElement(activityTitle, 3).getText();
    }


    public OtherIdentifierPage moveToOtherIdentifier() {
        By locator = elementUtils.getLocator("div", "other-identifier");
        webElement = waitUtils.presenceOfElement(locator, 2);
        jsExecutorUtils.doJsMoveToElement(webElement, true);
        webElement.click();
        return new OtherIdentifierPage(driver);
    }

    public MigrationScript moveTOMigrationScript() {
        By locator = elementUtils.getLocator("div","title");
        webElement = waitUtils.presenceOfElement(locator,2);
        jsExecutorUtils.doJsMoveToElement(webElement,true);
        webElement.click();
        return new MigrationScript(driver);

    }


    public DescriptionPage moveToDescription() {
        By locator = elementUtils.getLocator("div", "description");
        webElement = waitUtils.presenceOfElement(locator, 2);
        jsExecutorUtils.doJsMoveToElement(webElement, true);
        webElement.click();
        return new DescriptionPage(driver);
    }

    public ActivityStatusPage moveToActivityStatus() {
        By locator = elementUtils.getLocator("div", "activity-status");
        webElement=waitUtils.presenceOfElement(locator,2);
        jsExecutorUtils.doJsMoveToElement(webElement,true);
        webElement.click();
        return new ActivityStatusPage(driver);
    }

    public ActivityScopePage moveTOActivityScope(){
        By locator = elementUtils.getLocator("div","activity-scope");
        webElement = waitUtils.presenceOfElement(locator,2);
        jsExecutorUtils.doJsMoveToElement(webElement,true);
        webElement.click();
        return new ActivityScopePage(driver);

    }
    public Boolean getOtherIdentifierSection() {
        webElement=waitUtils.presenceOfElement(sectionOtherIdentifier,2);
        return webElement.isDisplayed();
    }



}
