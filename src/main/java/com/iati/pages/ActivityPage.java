package com.iati.pages;


import com.iati.utils.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ActivityPage {
    private WebElement webElement;
    private WebDriver driver;
    private WaitUtils waitUtils;
    private ActionUtils actionUtils;
    private ElementUtils elementUtils;
    private DropdownUtils dropdownUtils;
    private JSExecutorUtils jsExecutorUtils;

    private By activityTitle = By.xpath("//h4[contains(text(),'Your Activities')]");
    private By addActivity = By.xpath("//span[contains(text(),'Add Activity')]");
    private By addActivityManually = By.xpath("//a[@id=\"add-activity-manually\"]");

    //Popup
    private By addActivityFormTitle = By.xpath(("//h5[contains(text(),'Add a title')]"));
    private By addActivitySectionLabel = By.xpath("//p[@class='form-group-title']");
    private By addActivityNarrative = By.cssSelector("input[placeholder='Type narrative here']");
    private By addActivityIdentifier = By.cssSelector("input[placeholder='Type activity-identifier here']");
    private By addActivityIATIId = By.xpath("//input[@class='form__input'and @placeholder='']");
    private By addActivityLang = By.className("multiselect-search");
    private By addActivityLangInput = By.cssSelector("input.multiselect-search");
    private By addActivityLangList = By.cssSelector("div.multiselect-dropdown>ul>li.multiselect-option>span");
    private By addActivitySave = By.xpath("//div/div/button[normalize-space()='Save']");
    private By addActivityCancel = By.xpath("//button[normalize-space()='Cancel']");
    private By addActivityValidationMsg = By.xpath("//div/span[@class='error' and @role='alert' and contains(text(),' field is required.') ] ");


    public ActivityPage(WebDriver driver) {
        this.driver = driver;
        elementUtils = new ElementUtils(driver);
        waitUtils = new WaitUtils(driver);
        actionUtils = new ActionUtils(driver);
        dropdownUtils = new DropdownUtils(driver);
        jsExecutorUtils = new JSExecutorUtils(driver);
    }


    public String getActivityTitle() {
        String headerActivity = waitUtils.visibilityOfElement(activityTitle, 4).getText();
        return headerActivity;
    }


    /*=================================ADD ACTIVITY POPUP ============================================================*/

    public void displayAddActivityPopup() {
        waitUtils.presenceOfElement(addActivity, 2).click();
        webElement = waitUtils.visibilityOfElement(addActivityManually, 3);
        actionUtils.doMoveToElement(addActivityManually);
        webElement.click();
    }

    public String getFormTitle() {
        return waitUtils.visibilityOfElement(addActivityFormTitle, 3).getText();
    }

    public List<String> getSectionLabels() {
        return elementUtils.getMultipleElements(addActivitySectionLabel);
    }

    public List<String> getFieldLabels(String tag, String attrib, String label) {
        List<WebElement> labelElement = elementUtils.getTextLabels(tag, attrib, label);
        List<String> labelList = new ArrayList<>();
        for (WebElement e : labelElement) {
            labelList.add(e.getText());
        }
        return labelList;
    }

    public List<String> getBlankFieldValidationMsg() {
        return elementUtils.getMultipleElements(addActivityValidationMsg);
    }

    public void sendActivityNarrative(String narrative) {
        actionUtils.doMoveToElement(addActivityNarrative);
        elementUtils.performSendKeys(addActivityNarrative, narrative);
    }

    public void sendActivityLanguage(int count) {
        elementUtils.clickElement(addActivityLangInput);
        dropdownUtils.doSelectElementDropdown(addActivityLangList,count);
    }

    public List<Object> getLanguageExcelList() {
        Object[][] data = ExcelUtils.getExcelData(ConstantsUtils.LANGUAGE_SHEET);
        System.out.println(data.length);
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < 1; j++) {
                list.add((data[i][j]));
            }
        }
        return list;
    }

    public List<String> getActivityLanguage(int count) {
        elementUtils.clickElement(addActivityLangInput);
        return dropdownUtils.getDropdownList(addActivityLangList,count);
    }

    public void sendActivityIdentifier(String text) {
        waitUtils.presenceOfElement(addActivityIdentifier,3).click();
        elementUtils.performSendKeys(addActivityIdentifier, text);
    }

    public String getActivityIdentifier(String text) {
        sendActivityIdentifier(text);
        String activityID= waitUtils.visibilityOfElement(addActivityIdentifier,3).getAttribute("value");
        return activityID;
    }

    public String getActivityIATIIdentifier() {
        String id = null;
        webElement = waitUtils.visibilityOfElement(addActivityIATIId,3);
        if (!(webElement.isEnabled())) {
            id=webElement.getAttribute("value");
        }
        return id ;
    }

    public void fillForm(String narrative,int count, String id) {
        sendActivityNarrative(narrative);
        sendActivityLanguage(count);
        sendActivityIdentifier(id);
    }

    public ActivityDetailPage doPopupSaveButtonClick() {
        webElement = waitUtils.presenceOfElement(addActivitySave, 2);
        jsExecutorUtils.doJsMoveToElement(webElement, true);
        waitUtils.clickOnReady(addActivitySave, 0);
        return new ActivityDetailPage(driver);
    }

    public void doPopupCancelButtonClick() {
        webElement = waitUtils.presenceOfElement(addActivityCancel, 2);
        jsExecutorUtils.doJsMoveToElement(webElement, true);
        waitUtils.clickOnReady(addActivityCancel, 0);
    }

}

