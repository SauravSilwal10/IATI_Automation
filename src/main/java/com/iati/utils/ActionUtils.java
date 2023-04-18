package com.iati.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionUtils {

    private WebDriver driver;
    private ElementUtils elementUtils;
    private Actions action;

    public ActionUtils(WebDriver driver) {
        this.driver = driver;
        elementUtils = new ElementUtils(driver);
        action = new Actions(driver);

    }


    /**
     * doMoveToElement and it's overloaded variant are used to move over the menus and sub menus
     *
     * @param locator:locator for menus and sub menus
     */
    public void doMoveToElement(By locator) {
        action.moveToElement(elementUtils
                .getElement(locator))
                .perform();
    }

    public void doMoveToElement(By locator1, By locator2) {
        action.moveToElement(elementUtils.getElement(locator1)).perform();
        elementUtils.getElement(locator2)
                .click();
    }

    public void doMoveToElement(By locator1, By locator2, By locator3) {
        action.moveToElement(elementUtils.getElement(locator1))
                .perform();
        action.moveToElement(elementUtils.getElement(locator2))
                .perform();
        elementUtils.getElement(locator3)
                .click();
    }

    public void doClickHoldDragDrop(WebElement sourceElement, WebElement targetElement) {
        action.clickAndHold(sourceElement)
                .moveToElement(targetElement)
                .release()
                .build()
                .perform();
    }

    public void doDragDrop(By sourceElement, By targetElement) {
        action.dragAndDrop(elementUtils.getElement(sourceElement), elementUtils.getElement(targetElement))
                .perform();
    }

    public void doActionSendKeys(By locator, String value) {
        action.sendKeys(elementUtils.getElement(locator), value);
    }

    public void doActionClick(By locator) {
        action.click(elementUtils.getElement(locator));
    }

    public void doDoubleClick() {
        action.doubleClick();
    }

    public void doDoubleClick(By locator) {
        action.doubleClick(elementUtils.getElement(locator));
    }

    public void doContextClick() {
        action.contextClick();
    }

    public void doContextClick(By locator) {
        action.contextClick(elementUtils.getElement(locator));
    }
}

