package com.iati.pages;

import com.iati.utils.ConstantsUtils;
import com.iati.utils.ElementUtils;
import com.iati.utils.JSExecutorUtils;
import com.iati.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;
    private WebElement webElement;
    private WaitUtils waitUtils;
    private ElementUtils elementUtils;
    private JSExecutorUtils jsExecutorUtils;


    /*Registration option*/
    private By iATIPublishingTool = By.xpath("//span[contains(@class,'left__title')]");
    /* private By languageEN = By.xpath("//ul[contains(@class,'')]");
     private By languageFR = ;
     private By languageES = ;*/
    private By iATIPublisherHeader = By.xpath("//h1[normalize-space()='IATI Publisher']");
    private By iATIPublishingToolText = By.xpath(("//span[contains(@class,'left__title')]/following-sibling::p"));
    private By registerJoinNowTitle = By.xpath("//button[normalize-space='Join Now']/parent::span");
    private By registerJoinNow = By.xpath("//button[normalize-space()='Join Now']");


    /*sign in fields*/
    private By signInTitle = By.xpath("//h2[contains(text(),'Sign In')]");
    private By welcomeTextDescription = By.xpath("//h2[contains(text(),'Sign In')]/following-sibling::span");
    private By usernameTitle = By.xpath("//label[@for='Username']");
    private By usernameField = By.id("username");
    private By passwordTitle = By.xpath("//label[@for='Password']");
    private By passwordField = By.id("password");
    private By forgotPasswordTitle = By.xpath("//div[@id='right']//p[1]");
    private By errorUser = By.xpath("//input[@id='username']/following-sibling::span");
    private By errorPassword = By.xpath("//input[@id='password']/following-sibling::span");
    private By forgotPasswordField = By.xpath("//a[normalize-space()='Reset.']");
    private By signInButton = By.xpath("//button[@id='btn']");
    private By spinner = By.xpath("//div[@class='overlay__content']");


    /*  for registration*/
    private By joinNow = By.xpath("//button[contains(text(),'Join Now')]");
    private By joinNowTitle = By.xpath("//h2[contains(text(),'Join Now.')]");
    private By registerWithIati = By.xpath("(//div[contains(@class,'right__icon')])[2]/following-sibling::div");
    private By registerTitle = By.xpath("//h2[text()='Create IATI Publisher Account']");


    public HomePage(WebDriver driver) {
        this.driver = driver;
        waitUtils = new WaitUtils(driver);
        elementUtils = new ElementUtils(driver);
        jsExecutorUtils = new JSExecutorUtils(driver);
    }

    public String getIATIPublisherHeader() {
        webElement= waitUtils.presenceOfElement(iATIPublisherHeader,3);
        return webElement.getText();
    }

    public String getSignInFormTitle() {
        webElement = waitUtils.visibilityOfElement(signInTitle, 3);
        return webElement.getText();
    }

    public String getWelcomeTextDescription() {
        webElement = waitUtils.visibilityOfElement(welcomeTextDescription, 3);
        return webElement.getText();
    }

    public String getForgotPasswordDescription() {
        webElement = waitUtils.visibilityOfElement(forgotPasswordTitle, 3);
        return webElement.getText();
    }

    public String getSignInFormDescription() {
        webElement = waitUtils.visibilityOfElement(welcomeTextDescription, 3);
        return webElement.getText();
    }

    public String getUsernameTitle() {
        webElement= waitUtils.presenceOfElement(usernameTitle, ConstantsUtils.waitTime);
        return webElement.getText();
    }

    public String getPasswordTitle() {
        webElement= waitUtils.presenceOfElement(passwordTitle, ConstantsUtils.waitTime);
        return webElement.getText();
    }

    public void sendUsernamePassword(String username, String password) {
        WebElement usernameElement = waitUtils.waitElementToBeClickable(usernameField, ConstantsUtils.waitTime);
        WebElement passwordElement = waitUtils.waitElementToBeClickable(passwordField, ConstantsUtils.waitTime);
        jsExecutorUtils.doJsMoveToElement(usernameElement,true);
        elementUtils.performSendKeys(usernameElement,username);
        elementUtils.performSendKeys(passwordElement,password);

    }

    public String getValidationUsernameLogin(String validationMsg) {
        String message = null;
        jsExecutorUtils.doJsMoveToElement(waitUtils.presenceOfElement(usernameField,2),true );
        if (waitUtils.waitForElementToBeLocated(errorUser, ConstantsUtils.waitTime, validationMsg)) {
            message = elementUtils.getElement(errorUser).getText();
        }
        return message;
    }

    public String getValidationPasswordLogin(String validationMsg) {
        String message = null;
        if (waitUtils.waitForElementToBeLocated(errorPassword, ConstantsUtils.waitTime, validationMsg)) {
            message = elementUtils.getElement(errorPassword).getText();
        }
        return message;
    }

    public ActivityPage doSignButtonClick() {
        webElement = waitUtils.waitElementToBeClickable(signInButton, ConstantsUtils.waitTime);
        jsExecutorUtils.doJsMoveToElement(webElement, true);
        waitUtils.clickOnReady(signInButton, ConstantsUtils.waitTime);
        //waitUtils.waitTillElementGone(spinner, 1);
        return new ActivityPage(driver);
    }

    public RegistrationPage doRegisteredPublisherSignup() {
        webElement = waitUtils.visibilityOfElement(joinNow, 2);
        jsExecutorUtils.doJsMoveToElement(webElement,true);
        waitUtils.clickOnReady(joinNow,2);
        jsExecutorUtils.doJsMoveToElement(webElement,false);
        WebElement elementTitle = elementUtils.getElement(joinNowTitle);
        String title = elementTitle.getText();
        if(title.equals(ConstantsUtils.joinNowTitle)){
            WebElement registerElement= waitUtils.visibilityOfElement(registerWithIati,2);
            jsExecutorUtils.doJsMoveToElement(registerElement,true);
            registerElement.click();
        }
        return new RegistrationPage(driver);
    }

    public String getRegistrationTitle() {
        webElement = waitUtils.visibilityOfElement(registerTitle, 3);
        return webElement.getText();
    }

}
