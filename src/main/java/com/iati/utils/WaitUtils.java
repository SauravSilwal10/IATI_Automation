package com.iati.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WaitUtils {

    private WebDriver driver;
    private WebDriverWait webDriverWait;
    private WebElement webElement;

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
    }



    public Boolean waitForTitle(String title, long waitTime) {
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
        return webDriverWait.until(ExpectedConditions.titleIs((title)));
    }

    public WebElement presenceOfElement(By locator, long waitTime) {
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public List<WebElement> presenceOfElements(By locator, long waitTime) {
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
        return webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public boolean waitForElementToBeLocated(By locator, long waitTime, String text) {
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
        webElement = visibilityOfElement(locator, waitTime);
        return webDriverWait.until(ExpectedConditions.textToBePresentInElement(webElement, text));
    }

    public WebElement visibilityOfElement(By locator, long waitTime) {
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public List<WebElement> visibilityOfElements(By locator, long waitTime) {
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
        return webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public WebElement waitElementToBeClickable(By locator, long waitTime) {
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
        return webDriverWait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitTillElementGone(By locator, long waitTime) {
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
        if (visibilityOfElement(locator, waitTime).isDisplayed()) {
            webDriverWait.until(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(locator)));
            System.out.println("spinner");
        } else {
            System.out.println("spinner absent.");
        }
    }


    public void clickOnReady(By locator, int waitTime) {
        waitElementToBeClickable(locator, waitTime).click();
    }
}
