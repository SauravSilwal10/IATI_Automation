package com.iati.pages;

import com.iati.utils.ConstantsUtils;
import com.iati.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class FooterPage {
    WebElement webElement;
    WaitUtils waitUtils;

    /*Footer*/
    private By iATILogoFooter;
    private By iATIPublisher = By.xpath("//div/span[contains(text(),'IATI Publisher')]");
    private By iATIPublisherList = By.xpath("//div/span[contains(text(),'IATI Publisher')]/following-sibling::ul/li");
    private By iATIStandard = By.xpath("//div/span[contains(text(),'IATI Standard')]");
    private By iATIStandardList = By.xpath("//div/span[contains(text(),'IATI Standard')]/following-sibling::ul/li");
    private By footerPara =By.xpath("//div[contains(@class,'text-xs')]/p");
    private By footerIATISupportEmail=By.xpath("//a[@href='mailto:support@iatistandard.org']");
    private By footerCopyright=By.xpath("//div[contains(@class,'footer__container')]/span[contains(text(),'Copyright IATI 2022. All rights reserved.')]");
    private By footerYTLogo;
    private By footerTwitter;

    public FooterPage(WebDriver driver) {
        waitUtils = new WaitUtils(driver);
    }

    public String getIATIPublisher() {
        webElement = waitUtils.visibilityOfElement(iATIPublisher, ConstantsUtils.waitTime);
        return webElement.getText();
    }

    public List<String> getIATIPublisherList() {
        List<WebElement> list = waitUtils.visibilityOfElements(iATIPublisherList,ConstantsUtils.waitTime);
        List<String> menuList = new ArrayList<>();
        for (WebElement e : list) {
            menuList.add(e.getText());
        }
        return menuList;
    }
    public String getIATIStandard() {
        webElement = waitUtils.visibilityOfElement(iATIStandard, ConstantsUtils.waitTime);
        return webElement.getText();
    }


    public List<String> getIATIStandardList() {
        List<WebElement> list = waitUtils.visibilityOfElements(iATIStandardList,ConstantsUtils.waitTime);
        List<String> menuList = new ArrayList<>();
        for (WebElement e : list) {
            menuList.add(e.getText());
        }
        return menuList;
    }

    public List<String> getFooterNote() {
        List<WebElement> list = waitUtils.visibilityOfElements(footerPara,ConstantsUtils.waitTime);
        System.out.println(list.size());
        List<String> footerNoteList = new ArrayList<>();
        for (WebElement e : list) {
            footerNoteList.add(e.getText());
            System.out.println(e.getText());
        }
        return footerNoteList;
    }

    public Boolean isSupportEmailPresent(String emailID) {
        webElement = waitUtils.visibilityOfElement(footerIATISupportEmail, ConstantsUtils.waitTime);
        String mailID = webElement.getText();
        if(mailID.equals(emailID)) {
            return true ;
        }else{
            return false;
        }
    }

    public Boolean isCopyrightTextPresent(String cpyrigthText) {
        webElement = waitUtils.visibilityOfElement(footerCopyright, ConstantsUtils.waitTime);
        String copyright = webElement.getText();
        if(copyright.equals(cpyrigthText)) {
            return true ;
        }else{
            return false;
        }
    }
}
