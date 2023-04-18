package com.iati.pages.element;


import com.iati.utils.ElementUtils;
import com.iati.utils.JSExecutorUtils;
import com.iati.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.iati.pages.ActivityDetailPage;
import org.openqa.selenium.WebElement;

import java.util.List;


public class CommonComponentPage {
    private WebDriver driver;
    private WebElement webElement;
    private ElementUtils elementUtils;
    private WaitUtils waitUtils;
    private JSExecutorUtils jsExecutorUtils;

    By yourActivities = By.xpath("//div/a[(@href='/activities')and (text()='Your Activities')]");
    By title = By.xpath("//h4[contains(@class,'ellipsis__title')]/span");
    By saveButton = By.xpath("//button[@type='submit' and  @class='primary-btn save-btn']");
    By cancelButton = By.xpath("//a[contains(text(),'Cancel')]");
    By Delete = By.xpath("");


    //Add more
    By addMore = By.xpath("//button[@form_type='description_narrative']");
    By section = By.xpath("");
    By formFields = By.xpath("");


    public CommonComponentPage(WebDriver driver) {
        this.driver = driver;
        elementUtils = new ElementUtils(driver);
        waitUtils = new WaitUtils(driver);
        jsExecutorUtils = new JSExecutorUtils(driver);
    }

    public ActivityDetailPage clickSaveButton() {
        waitUtils.clickOnReady(saveButton, 2);
        return new ActivityDetailPage(driver);
    }

    public String getTitle() {
        return waitUtils.visibilityOfElement(title, 2).getText();
    }

    public void clickYourActivities() {
        waitUtils.visibilityOfElement(yourActivities, 1).click();
    }

    public ActivityDetailPage clickCancelButton() {
        waitUtils.visibilityOfElement(cancelButton, 2);
        return new ActivityDetailPage(driver);
    }


    /*---------------------------------Add more ----------------------------------------------*/

    //count the parent element number
    //get parent element

    /**
     * add more click for the element present over the
     * @param addMore
     * @param clickCount
     */
    public void clickAddMoreElement(String addMore, int clickCount) {
        By addMoreLocator = elementUtils.getAddButtonLocator(addMore);
        webElement = waitUtils.presenceOfElement(addMoreLocator, 2);
        for (int i = 1; i <= clickCount; i++) {
            jsExecutorUtils.doJsMoveToElement(webElement, true);
            webElement.click();
        }
    }

    private int addMoreElementCount(By locator) {
        int elementCount = waitUtils.presenceOfElements(locator, 3).size();
        return elementCount;
    }

    public int addMoreSubElementCount(By parentField) {
        return waitUtils.presenceOfElements(parentField, 2).size();
    }

    public void fillParentInputField(String addMore, int clickCount, By parentField, String text) {
        clickAddMoreElement(addMore, clickCount);
        int numOfFields = addMoreElementCount(parentField);
        List<WebElement> inputFields = waitUtils.presenceOfElements(parentField, 2);
        for (WebElement e : inputFields) {
            if ((numOfFields == (clickCount + 1)) && (e.getTagName().equals("input"))) {
                jsExecutorUtils.doJsMoveToElement(e, true);
                elementUtils.performSendKeys(e, text);
            }
        }
    }

    public void fillSubElementField( int clickCount, By field, String text) {
        int numOfFields = addMoreSubElementCount(field);
        List<WebElement> inputFields = waitUtils.presenceOfElements(field, 2);
        for (WebElement e : inputFields) {
            if (numOfFields == (clickCount+1) && e.getTagName().equals("textarea")) {
                jsExecutorUtils.doJsMoveToElement(e, true);
                elementUtils.performSendKeys(e, text);
            }
        }
    }
}



