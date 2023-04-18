package com.iati.pages;

import com.iati.utils.ActionUtils;
import com.iati.utils.ElementUtils;
import com.iati.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class CommonNavBarPage {
    private WebDriver driver;
    private ElementUtils elementUtils;
    private WaitUtils waitUtils;
    private ActionUtils actionUtils;

    private WebElement webElement;
    /*---------------------------------Common Navbar----------------------------------------------------------------*/
    private By iATIPubLogo = By.cssSelector("figure a");
    private By navBarLangMenu = By.cssSelector("nav[class='flex grow-0'] ul>li.flex ");
    private By navBarPageMenu = By.cssSelector("nav[class='flex grow justify-end'] ul>li.flex ");
    private By navBarSearch = By.cssSelector("input.search__input");
    private By navBarAdd = By.xpath("//button[contains(@class,'button secondary-btn mr-3.5 font-bold')]");
    private By navBarProfileBtn = By.xpath("//button[contains(@class,'button secondary-btn dropdown-btn')]");
    private By navBarProfileMenu = By.cssSelector("div[class='profile__dropdown'] ul li ");
    private By navBarLogout = By.xpath("//li/button[text()='Logout']");


    /*---------------------------------Common Navbar----------------------------------------------------------------*/

    public CommonNavBarPage(WebDriver driver) {
        this.driver = driver;
        elementUtils = new ElementUtils(driver);
        waitUtils = new WaitUtils(driver);
        actionUtils = new ActionUtils(driver);
    }

    public Boolean getIATIPubLogo() {
        return elementUtils.doIsDisplayed(iATIPubLogo);
    }

    public ArrayList<String> getNavBarLanguageList() {
        ArrayList<String> langList = elementUtils.getMultipleElements(navBarLangMenu);
        return langList;
    }

    public ArrayList<String> getNavBarPageList() {
        ArrayList<String> pageList = elementUtils.getMultipleElements(navBarPageMenu);
        return pageList;
    }

    public void clickAddActivity() {
        waitUtils.clickOnReady(navBarAdd,2);
    }

    public void sendSearchText(String text) {
        elementUtils.performSendKeys(navBarSearch, text);
    }

    public ArrayList<String> getProfileList() {
        WebElement profileButton=waitUtils.presenceOfElement(navBarProfileBtn, 0);
        profileButton.click();
        ArrayList<String> profileList = elementUtils.getMultipleElements(navBarProfileMenu);
        return profileList;
    }

    public void goToPublisherProfile() {

    }
   public void goToUserProfile() {

    }

    public HomePage logOut() {
        actionUtils.doMoveToElement(navBarProfileBtn,navBarLogout);
    /*    waitUtils.clickOnReady(navBarLogout,2);*/
        return new HomePage(driver);
    }

}
