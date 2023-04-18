package com.iati.tests;

import Base.BaseTest;
import com.iati.pages.HomePage;
import com.iati.utils.ConstantsUtils;
import org.testng.Assert;
import org.testng.annotations.*;

public class CommonNavBarTest extends BaseTest {

    @BeforeClass
    public void activitySetup() {
        homePage.sendUsernamePassword("Publisher 3", "test1234");
        activityPage = homePage.doSignButtonClick();
        Assert.assertEquals(activityPage.getActivityTitle(), ConstantsUtils.activitiesTitles);
    }

    @Test(priority = 0)
    public void checkIATIPubLogo() {
        Assert.assertTrue(commonNavBarPage.getIATIPubLogo());
    }

    @Test(priority = 1)
    public void validateLanguageList() {
        Assert.assertEquals(commonNavBarPage.getNavBarLanguageList(), ConstantsUtils.languages());
    }

    @Test(priority = 2)
    public void validatePageList() {
        Assert.assertEquals(commonNavBarPage.getNavBarPageList(), ConstantsUtils.pageList());
    }

    @Test(priority = 3)
    public void validateAddActivity() {
        commonNavBarPage.clickAddActivity();
        Assert.assertEquals(activityPage.getFormTitle(), ConstantsUtils.activityPopupTitle);
    }


    @Ignore
    @Test
    public void validateProfileMenuList() {
        System.out.println(commonNavBarPage.getProfileList());

    }


    @Test(priority = 4)
    public void logout() {
        homePage = commonNavBarPage.logOut();
        Assert.assertEquals(homePage.getIATIPublisherHeader(), ConstantsUtils.IATIPublisherTitle);
    }


}
