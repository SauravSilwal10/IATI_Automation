package com.iati.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ElementUtils {

    private final WebDriver driver;
    private final WaitUtils waitUtils;
    private WebElement webElement;


    public ElementUtils(WebDriver driver) {
        this.driver = driver;
        waitUtils = new WaitUtils(driver);
    }

    public By getLocator(String tagName, String elementName) {
        String elementPath = "//" + tagName + "[normalize-space()='" + elementName + "']";
        return By.xpath(elementPath);
    }

    /***
     * Finding element from the locator
     * @param locator
     * @return Webe lement
     */
    public WebElement getElement(By locator) {
        webElement = driver.findElement(locator);
        return webElement;
    }

    /**
     * Finding web element from the locator's string
     *
     * @param tagName
     * @param attrib
     * @param labelText
     * @return Web element
     */
    public WebElement getElement(String tagName, String attrib, String labelText) {
        String path = "//" + tagName + "[@" + attrib + "='" + labelText + "']";
        return waitUtils.visibilityOfElement(By.xpath(path), 2);
    }

    /**
     * Get element count from findElements
     *
     * @param locator
     * @return int for count
     */
    public int getElementsCount(By locator) {
        int count = driver.findElements(locator).size();
        return count;
    }

    /**
     * perform sendKeys with web element and text
     *
     * @param element
     * @param text
     */
    public void performSendKeys(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    /**
     * overloaded sendKeys with locator
     *
     * @param locator
     * @param text
     */
    public void performSendKeys(By locator, String text) {
        webElement = driver.findElement(locator);
        webElement.clear();
        webElement.sendKeys(text);
    }


    public void clickElement(By locator) {
        webElement = getElement(locator);
        if (webElement.isDisplayed())
            webElement.click();
    }


    public boolean doIsDisplayed(By locator) {
        return getElement(locator).isDisplayed();
    }


    /**
     * Collects menu/list of the items and stores it in array
     *
     * @param locator
     * @return Arraylists of the collected list of text
     */
    public ArrayList<String> getMultipleElements(By locator) {
        List<WebElement> elementList = waitUtils.presenceOfElements(locator, 4);
        System.out.println("Size of elements:" + elementList.size());
        ArrayList<String> elements = new ArrayList<>();
        for (WebElement e : elementList) {
            String text = e.getText();
            if (!(e.getText().isEmpty()) && e.isDisplayed()) {
                elements.add(text);
            }
        }
        System.out.println("Element in lists:" + elements);
        return elements;
    }

    /**
     * Collects single element form menu/list of the items collection
     *
     * @param locator
     * @return single webElement
     */
    public WebElement getSingleWebElement(By locator) {
        List<WebElement> elementList = waitUtils.visibilityOfElements(locator, 5);
        System.out.println("Size of elements:" + elementList.size());
        for (WebElement e : elementList) {
            System.out.println(e);
            webElement = e;
            break;
        }
        return webElement;
    }


    /**
     * Collects the set of the links and performs click on link of the given value
     *
     * @param locator
     * @param value   name/label
     * @return none
     */
    public void doLinkClick(By locator, String value) {
        List<WebElement> linkList = waitUtils.visibilityOfElements(locator, 5);
        for (WebElement e : linkList) {
            String text = e.getText();
            if (text.equals(value)) {
                e.click();
                break;
            }
        }
    }

    /***
     * Check for the display of the element over dom
     * @param locator
     * @param size
     * @return boolean flag
     */
    public boolean isElementPresent(By locator, int size) {
        boolean flag = false;
        webElement = getSingleWebElement(locator);
        JSExecutorUtils jsExecutorUtils = new JSExecutorUtils(driver);
        jsExecutorUtils.doJsMoveToElement(webElement, true);
        int s = waitUtils.visibilityOfElements(locator, 5).size();
        if (s == size && webElement.isDisplayed()) {
            flag = true;
        }
        return flag;
    }

    /**
     * Acquire href form a tag and return attribute
     *
     * @param locator
     */
    public String getLink(By locator) {
        webElement = waitUtils.visibilityOfElement(locator, 5);
        String link = webElement.getAttribute("href");
        return link;
    }

    /**
     * Printing list of fetched element form dom
     *
     * @param locator printed list on console
     */
    public void printList(By locator) {
        List<WebElement> list = waitUtils.visibilityOfElements(locator, 3);
        for (WebElement e : list) {
            System.out.println();
        }
    }


    /*---------------------------------Elements locator----------------------------------------------------------------*/

    /**
     * For the label all over the form with the xpath on format of //tagname[@attrib='attribText']
     *
     * @param tagName
     * @param labelText
     * @return list of web elements
     */
    public List<WebElement> getTextLabels(String tagName, String attrib, String labelText) {
        String path = "//" + tagName + "[@" + attrib + "='" + labelText + "']";
        return waitUtils.visibilityOfElements(By.xpath(path), 2);
    }

    /**
     * For the label all over the form with the xpath on format of //tagname[@attrib='attribText']
     *
     * @param tagName
     * @param labelText
     * @return text value
     */
    public String getTextLabel(String tagName, String attrib, String labelText) {
        String path = "//" + tagName + "[@" + attrib + "='" + labelText + "']";
        return waitUtils.visibilityOfElement(By.xpath(path), 2).getText();
    }


    /**
     * For the common buttons over the pages
     *
     * @param elementName
     * @return xpath of the element
     */
    public By getAddButtonLocator(String elementName) {
        String elementPath = "//button[normalize-space()='" + elementName + "']";
        return By.xpath(elementPath);
    }
/*

    public List<By> getLocatorCommonSubElements(String subElementName, String fieldName, int size) {
        List<By> locators = new ArrayList<>();
        for (int count = 0; count <= (size + 1); count++) {
            if (count == 1) {
                System.out.println("element with id 1 unavailable in the system");
            } else if(count != 1){
                By subElement = By.id("\"" + subElementName + '[' + count + fieldName + ']' + "\"");
                locators.add(subElement);
            }
        }
    return locators;
    }
*/



}
