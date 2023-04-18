package com.iati.tests;

import Base.BaseTest;
import com.iati.utils.ConstantsUtils;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.xml.soap.SAAJResult;

public class ActivityStatusTest extends BaseTest {

    @BeforeTest
    public void activityStatusSetup() {
        homePage.sendUsernamePassword("Publisher 3", "test1234");
        activityPage = homePage.doSignButtonClick();
        activityPage.displayAddActivityPopup();
        activityPage.fillForm(faker.chuckNorris().fact(), ConstantsUtils.activityLangCount, ConstantsUtils.activityID);
        activityDetailPage = activityPage.doPopupSaveButtonClick();
        activityStatusPage = activityDetailPage.moveToActivityStatus();
    }

    @Test(priority = 1)
    public void validateCodeActivityStatusLabel() {
        Assert.assertEquals(activityStatusPage.getCodeList(), ConstantsUtils.activityStatusDropDown());
    }

    @Test(priority = 1)
    public void validateActivityStatusTitle() {
        Assert.assertEquals(activityStatusPage.getActivityStatusTitle(), ConstantsUtils.activityStatusTitle);
    }

    @Test(priority = 1)
    public void validateActivityStatusCoreElements() {
        Assert.assertEquals(activityStatusPage.getActivityStatusCoreElement(), ConstantsUtils.activityCoreElements);
    }

    @Test(priority = 1)
    public void validateActivityStatusMandatorySubElements() {
        Assert.assertEquals(activityStatusPage.getActivityMandatorySubElements(),
                ConstantsUtils.activityMandatorySubElements);
    }

    @Test(priority = 1)
    public void validateActivityStatusRecommendedSubElements() {
        Assert.assertEquals(activityStatusPage.getRecommendedSubElements(),
                ConstantsUtils.activityRecommendedSubElements);
    }

    @Test(priority = 1)
    public void validateActivityStatusCode() {
        Assert.assertEquals(activityStatusPage.getActivityStatusCode(), ConstantsUtils.activityStatusCode);
    }

    @Test(priority = 2)
    public void validateDropDown() {
        activityStatusPage = activityDetailPage.moveToActivityStatus();
        activityStatusPage.sendCodeList(6);
    }

    @Test(priority = 3)
    public void validateSaveAndExit() {
        activityStatusPage.SaveAndExit();

    }

    @Test(priority = 4)
    public void validateActivityYourActivities() {
        activityStatusPage = activityDetailPage.moveToActivityStatus();
        activityStatusPage.getYourActivities();

    }

}