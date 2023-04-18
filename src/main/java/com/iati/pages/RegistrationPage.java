package com.iati.pages;

import com.iati.utils.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.iati.utils.ConstantsUtils;

import java.util.ArrayList;
import java.util.List;


public class RegistrationPage {
    private WebDriver driver;
    private final ActionUtils action;
    private final WaitUtils waitUtils;
    private final ElementUtils elementUtils;
    private final JSExecutorUtils jsExecutorUtils;
    WebElement webElement;


    /*publisher information*/
    By publisherToolTip = By.xpath("//div[@class='help']/button");
    By publisherInfoTitle = By.xpath("//h2[text()='Create IATI Publisher Account']");
    By publisherInfoDesc = By.xpath("//h2[text()='Create IATI Publisher Account']/following-sibling::p");
    By publisherFormTitle = By.xpath("(//div/span[text()='Publisher Information'])[2]");
    By publisherToolTipTitle = By.cssSelector("div.help__text");
    By publisherToolTipText = By.cssSelector("div.help__text>p");

    /*Publisher Information*/
    By publisherNameTitle = By.xpath("//label[@for='publisher-name']");
    By publisherName = By.id("publisher-name");
    By publisherIdTitle = By.xpath("//label[@for='publisher-id']");
    By publisherId = By.id("publisher-id");
    By publisherCountryTitle = By.xpath("//label[@for='country_select']");
    By publisherCountry = By.xpath("(//div[@class='multiselect vue__select'])[1]/input");
    By orgRegAgencyTitle = By.xpath("//label[@for='registration-agency']");
    By orgRegAgency = By.xpath("(//div[@class='multiselect vue__select'])[2]/input");
    By orgRegNumTitle = By.xpath("//label[@for='registration-number']");
    By orgRegNum = By.id("registration-number");
    By orgIdentifierTitle = By.xpath("//label[@for='identifier']");
    By orgIdentifier = By.xpath("//input[@class='form__input' and @disabled]");
    By nextButton = By.xpath("//button[contains(@class,'btn-next')]");
    By alreadyLoginText = By.xpath("//span[@class='text-sm font-normal text-n-40']");
    By loginButton = By.xpath("//span[@class='text-sm font-normal text-n-40']/a");
    By invalidPublisherName = By.xpath("//span[@class='error']");
    By invalidPublisherId = By.xpath("//span[@class='error']");


    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        waitUtils = new WaitUtils(driver);
        action = new ActionUtils(driver);
        elementUtils = new ElementUtils(driver);
        jsExecutorUtils = new JSExecutorUtils(driver);
    }

    public String getPageTitle() {
        String title = waitUtils.visibilityOfElement(publisherInfoTitle, 2).getText();
        return title;
    }

    public String getTitleDescription() {
        String description = waitUtils.visibilityOfElement(publisherInfoDesc, 2).getText();
        return description;
    }

    public String getFormTitle() {
        String title = waitUtils.presenceOfElement(publisherFormTitle, 2).getText();
        return title;
    }

    public List<String> getTooltipTitle() {
        List<WebElement> listTitles = waitUtils.presenceOfElements(publisherToolTipTitle, 2);
        ArrayList<String> titles = new ArrayList<>();
        for (WebElement e : listTitles) {
            titles.add(e.getText());
        }
        return titles;
    }



    public List<String> getTooltipParagraph() {
        List<WebElement> listPara = waitUtils.presenceOfElements(publisherToolTipText, 2);
        ArrayList<String> paragraph = new ArrayList<>();
        for (WebElement e : listPara) {
            paragraph.add(e.getText());
        }
        return paragraph;
    }


    public void sendIncorrectPublisherName(String publisherNameField, String publisherIdField, String organizationRegAgencyField, String organizationRegNumberField) {
        WebElement publisherNameElement = waitUtils.waitElementToBeClickable(publisherName, ConstantsUtils.waitTime);
        WebElement publisherIdElement = waitUtils.waitElementToBeClickable(publisherId, ConstantsUtils.waitTime);
        WebElement organizationRegAgencyElement = waitUtils.waitElementToBeClickable(orgRegAgency,ConstantsUtils.waitTime);
        WebElement organizationRegNumberElement = waitUtils.waitElementToBeClickable(orgRegNum, ConstantsUtils.waitTime);
        elementUtils.performSendKeys(publisherNameElement,publisherNameField);
        elementUtils.performSendKeys(publisherIdElement,publisherIdField);
        elementUtils.performSendKeys(organizationRegAgencyElement,organizationRegAgencyField);
        elementUtils.performSendKeys(organizationRegNumberElement,organizationRegNumberField);
    }

    public void sendPublisherName(String text) {
        webElement = waitUtils.presenceOfElement(publisherName, 2);
        elementUtils.performSendKeys(webElement, text);
    }

    public void sendPublisherID(String text) {
        webElement = waitUtils.presenceOfElement(publisherId, 2);
        elementUtils.performSendKeys(webElement, text);
    }

    public ArrayList<String> getFieldLabel() {
        return elementUtils.getMultipleElements(publisherFormTitle);
    }

    public void clickNextButton(){
        webElement= waitUtils.waitElementToBeClickable(nextButton, ConstantsUtils.waitTime);
        jsExecutorUtils.doJsMoveToElement(webElement, true);
        waitUtils.clickOnReady(nextButton, ConstantsUtils.waitTime);
    }


//    public String getInvalidUsername(String registrationStepI) {
//        String message = null;
//        jsExecutorUtils.doJsMoveToElement(waitUtils.presenceOfElement(publisherName,2),true );
//        if (waitUtils.waitForElementToBeLocated(invalidPublisherName, ConstantsUtils.waitTime, registrationStepI)) {
//            message = elementUtils.getElement(invalidPublisherName).getText();
//        }
//        return message;
//    }
//
//    public String getInvalidId(String registrationStepI) {
//        String message = null;
//        jsExecutorUtils.doJsMoveToElement(waitUtils.presenceOfElement(publisherId,2),true );
//        if (waitUtils.waitForElementToBeLocated(invalidPublisherId, ConstantsUtils.waitTime, registrationStepI)) {
//            message = elementUtils.getElement(invalidPublisherId).getText();
//        }
//        return message;
//    }

    public String getInvalidUsername(String registrationStepI) {
        String message = null;
        jsExecutorUtils.doJsMoveToElement(waitUtils.presenceOfElement(publisherName,2),true );
        if (waitUtils.waitForElementToBeLocated(invalidPublisherName, ConstantsUtils.waitTime, registrationStepI)) {
            message = elementUtils.getElement(invalidPublisherName).getText();
        }
        return message;
    }

    public String getInvalidId(String registrationStepI) {
        String message = null;
        jsExecutorUtils.doJsMoveToElement(waitUtils.presenceOfElement(publisherId,2),true );
        if (waitUtils.waitForElementToBeLocated(invalidPublisherId, ConstantsUtils.waitTime, registrationStepI)) {
            message = elementUtils.getElement(invalidPublisherId).getText();
        }
        return message;
    }


    public ActivityPage doSignButtonClick() {
        webElement = waitUtils.waitElementToBeClickable(nextButton, ConstantsUtils.waitTime);
        jsExecutorUtils.doJsMoveToElement(webElement, true);
        waitUtils.clickOnReady(nextButton, ConstantsUtils.waitTime);
        return new ActivityPage(driver);
    }


}
