package com.iati.pages.element;


import com.iati.utils.DropdownUtils;
import com.iati.utils.ElementUtils;
import com.iati.utils.JSExecutorUtils;
import com.iati.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class OtherIdentifierPage {


    private WebDriver driver;
    private ElementUtils elementUtil;
    private WaitUtils waitUtils;
    private DropdownUtils dropdownUtils;
    private JSExecutorUtils jsExecutorUtils;
    private WebElement webElement;
    private CommonComponentPage commonComponentPage;


    By title = By.xpath("//h4[contains(@class,'ellipsis__title')]/span");
    By otherIdentifierRef = By.cssSelector("input#reference");
    By otherIdentifierTypeField = By.id("select2-reference_type-container");
    By otherIdentifierType = By.cssSelector("span.select2-results ul li");
    By otherIdentifierTypeInput = By.cssSelector("input.select2-search__field ");
    By otherIdentifierTypeList = By.cssSelector("ul#select2-reference_type-results li");
    By otherIdentifierOwnerOrgLabels = By.cssSelector("label[for*='owner_org[0]']");
    By otherIdentifierLangField = By.id("select2-owner_org0narrative0language-container");
    By otherIdentifierLangList = By.cssSelector("ul#select2-owner_org0narrative0language-results li");
    By getOtherIdentifierLangInput = By.cssSelector("input.select2-search__field");


    //Add more
    By ownerOrgRef = By.cssSelector("input[id*='[ref]']");
    By subElementOwnerOrg = By.cssSelector("div[class*='subelement']>div");
    By narrativeOwnerOrg = By.cssSelector("textarea[id*='[narrative]']");


    public OtherIdentifierPage(WebDriver driver) {
        this.driver = driver;
        waitUtils = new WaitUtils(driver);
        elementUtil = new ElementUtils(driver);
        dropdownUtils = new DropdownUtils(driver);
        jsExecutorUtils = new JSExecutorUtils(driver);
        commonComponentPage = new CommonComponentPage(driver);
    }



    public String getOtherIdentifierTitle() {
        By xpathTitle = elementUtil.getLocator("div", "other-identifier");
        return waitUtils.visibilityOfElement(xpathTitle, 2).getText();
    }

    public String getOtherIdentifierRef() {
        String label = elementUtil.getTextLabel("label", "for", "reference");
        return label;
    }

    public void sendOtherIdentifierRef(String text) {
        webElement = waitUtils.visibilityOfElement(otherIdentifierRef, 2);
        elementUtil.performSendKeys(webElement, text);
    }

    public String getOtherIdentifierType() {
        String label = elementUtil.getTextLabel("label", "for", "reference_type");
        return label;
    }


    public ArrayList<String> getOtherIdentifierTypeList(int count) {
        elementUtil.clickElement(otherIdentifierTypeField);
        return dropdownUtils.getDropdownList(otherIdentifierType, count);
    }

    public void sendOtherIdentifierType(int count) {
        /* elementUtil.clickElement(otherIdentifierTypeField);*/
        dropdownUtils.doSelectElementDropdown(otherIdentifierTypeList, count);

    }
    /*====================================Owner Org====================================================*/

    public String getOwnerOrgLabel() {
        return elementUtil.getTextLabel("label", "for", "owner_org");
    }

    public ArrayList<String> getOtherIdentifierOwnerOrgLabels() {
        By ownerOrgLabel = elementUtil.getLocator("label", "Owner org");
        webElement = waitUtils.visibilityOfElement(ownerOrgLabel, 2);
        jsExecutorUtils.doJsMoveToElement(webElement, true);
        return elementUtil.getMultipleElements(otherIdentifierOwnerOrgLabels);
    }


    public void sendOtherIdentifierOwnerOrgRef(String ref) {
        webElement = elementUtil.getElement("input", "id", "owner_org[0][ref]");
        elementUtil.performSendKeys(webElement, ref);
    }

    public void sendOtherIdentifierOwnerOrgNarrative(String narrative) {
        webElement = elementUtil.getElement("textarea", "id", "owner_org[0][narrative][0][narrative]");
        elementUtil.performSendKeys(webElement, narrative);
    }

    public void sendOtherIdentifierOwnerOrgLang(int count) {
        webElement = waitUtils.presenceOfElement(otherIdentifierLangField, 2);
        webElement.click();
        dropdownUtils.doSelectElementDropdown(otherIdentifierLangList, count);
    }


    public void fillOtherIdentifierForm(String ref, int typeCount, String ownerRef, String narrative, int langCount) {
        sendOtherIdentifierRef(ref);
        sendOtherIdentifierType(typeCount);
        sendOtherIdentifierOwnerOrgRef(ownerRef);
        sendOtherIdentifierOwnerOrgNarrative(narrative);
        sendOtherIdentifierOwnerOrgLang(langCount);
    }

    /*====================================Add More====================================================*/
    public void fillAddMoreOwnerOrg(int countClick, String text) {
        commonComponentPage.fillParentInputField("add more owner org", countClick, ownerOrgRef, text);
    }


    public void fillAddMore(int countClick,String text) {
        int ownerOrgSize = waitUtils.visibilityOfElements(ownerOrgRef, 0).size();
        int size = commonComponentPage.addMoreSubElementCount(subElementOwnerOrg);
        commonComponentPage.clickAddMoreElement("add more", countClick);
        commonComponentPage.fillSubElementField(countClick,narrativeOwnerOrg,text);
    }




}
