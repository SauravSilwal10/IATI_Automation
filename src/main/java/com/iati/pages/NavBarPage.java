package com.iati.pages;

import com.iati.utils.ElementUtils;
import com.iati.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class NavBarPage {
    private final WaitUtils waitUtils;
    private final ElementUtils elementUtils;
    private WebElement webElement;

    /*---------------------------------Homepage----------------------------------------------------------------*/
    /*Nav bar*/
    private final By iATILogo = By.xpath("//nav/a/*[name()='svg']");
    private final By navMenuList = By.xpath("//ul[@id='nav-list']/li");
    /* private By publishingChecklist = ;
       private By iATIStandard = ;
       private By support = ;*/
    private final By languageTitle = By.xpath("//div[contains(@class,'languages')]/div/span");
    private final By languageList = By.xpath("//div[contains(@class,'languages')]/div/ul/li");
    private final By headerTitleIATIPublisher = By.xpath("//h1[contains(text(),'IATI Publisher')]");


    public NavBarPage(WebDriver driver) {
        waitUtils = new WaitUtils(driver);
        elementUtils = new ElementUtils(driver);
    }


    /*---------------------------------Homepage----------------------------------------------------------------*/
    public boolean getIATILogo() {
        webElement = waitUtils.visibilityOfElement(iATILogo, 10);
        Boolean flag = webElement.isDisplayed();
        return flag;
    }

    public String getHeaderTitle() {
        webElement = waitUtils.visibilityOfElement(headerTitleIATIPublisher, 5);
        String header = webElement.getText();
        return header;
    }

    public String getLanguageTitle() {
        webElement = waitUtils.visibilityOfElement(languageTitle, 5);
        String title = webElement.getText();
        return title;
    }

    public int getCountNavMenuList() {
        int count = elementUtils.getElementsCount(navMenuList);
        return count;
    }

    public ArrayList<String> getNavList() {
        ArrayList<String> menuList = elementUtils.getMultipleElements(navMenuList);
        return menuList;
    }

    public ArrayList<String> getLanguageList() {
        List<WebElement> webElements = waitUtils.visibilityOfElements(languageList, 5);
        ArrayList<String> menuList = new ArrayList<>();
        for (WebElement e : webElements) {
            menuList.add(e.getText());
        }
        return menuList;
    }

    public int getCountLanguageList() {
        List<WebElement> webElements = waitUtils.visibilityOfElements(languageList, 5);
        int count = webElements.size();
        return count;
    }



}

