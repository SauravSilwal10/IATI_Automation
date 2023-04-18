package com.iati.tests;

import Base.BaseTest;
import com.iati.utils.ConstantsUtils;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class HomePageTest extends BaseTest {

    @Test(priority = 1)
    public void
    checkIATILogoTest() {
        Assert.assertTrue(navBarPage.getIATILogo());
    }

    @Test(priority = 2)
    public void validateNavMenuList() {
        int count = navBarPage.getCountNavMenuList();
        ArrayList<String> menu = navBarPage.getNavList();
        Assert.assertEquals(count, ConstantsUtils.navBarMenuCount);
        Assert.assertEquals(menu, ConstantsUtils.navBarMenuList());
    }

    @Test(priority = 2)
    public void validateSignInHeader() {
        Assert.assertEquals(homePage.getSignInFormTitle(), ConstantsUtils.formHeader);

    }

    @Test(priority = 2)
    public void validateSignInDescription() {
        Assert.assertEquals(homePage.getSignInFormDescription(), ConstantsUtils.formDescription);

    }

    @Test(priority = 2)
    public void validateUsernameTitle() {
        Assert.assertEquals(homePage.getUsernameTitle(), ConstantsUtils.formUsernameLabel);
    }

    @Test(priority = 2)
    public void validatePasswordTitle() {
        Assert.assertEquals(homePage.getPasswordTitle(), ConstantsUtils.formPasswordLabel);
    }

    @Test(priority = 2)
    public void validateForgotPasswordDescription() {
        Assert.assertEquals(homePage.getForgotPasswordDescription(), ConstantsUtils.formForgotPassword);
    }


    @Test(priority = 3)
    public void validateLanguageList() {
        Assert.assertEquals(navBarPage.getLanguageTitle(), ConstantsUtils.languageTitle);
        Assert.assertEquals(navBarPage.getCountLanguageList(), ConstantsUtils.languagesCount);
        Assert.assertEquals(navBarPage.getLanguageList(), ConstantsUtils.languages());
    }

    @Test(priority = 4)
    public void verifyIATIHeader() {
        Assert.assertEquals(navBarPage.getHeaderTitle(), ConstantsUtils.IATIHeader);
    }

    @Test(priority = 6)
    public void verifySignInFormTitle() {
        Assert.assertEquals(homePage.getSignInFormTitle(), ConstantsUtils.signInTitle);
    }

    @Test(priority = 7)
    public void verifyWelcomeTextDescription() {
        Assert.assertEquals(homePage.getWelcomeTextDescription(), ConstantsUtils.welcomeText);
    }

    @Test(priority = 8)
    public void IATI3_validateIncorrectUsernameTest() {
        homePage.sendUsernamePassword("User", "test123");
        homePage.doSignButtonClick();
        Assert.assertEquals(homePage.getValidationUsernameLogin(ConstantsUtils.wrongCredential), ConstantsUtils.wrongCredential);
    }

    @Test(priority = 9)
    public void IATI4_validateIncorrectPasswordTest() {
        homePage.sendUsernamePassword("User_A", "test12");
        homePage.doSignButtonClick();
        Assert.assertEquals(homePage.getValidationUsernameLogin(ConstantsUtils.wrongCredential), ConstantsUtils.wrongCredential);
    }


    @Test(priority = 10)
    public void IATI26_verifyCaseSensitiveTest() {
        homePage.sendUsernamePassword("user_a", "test123");
        homePage.doSignButtonClick();
        Assert.assertEquals(homePage.getValidationUsernameLogin(ConstantsUtils.wrongCredential), ConstantsUtils.wrongCredential);
    }

    @Test(priority = 11)
    public void IATI2_validateBlankFieldSignInTest() {
        homePage.sendUsernamePassword(" ", " ");
        homePage.doSignButtonClick();
        Assert.assertEquals(homePage.getValidationUsernameLogin(ConstantsUtils.blankUsername), ConstantsUtils.blankUsername);
        Assert.assertEquals(homePage.getValidationPasswordLogin(ConstantsUtils.blankPassword), ConstantsUtils.blankPassword);
    }

    @Ignore
    @Test(priority = 12)
    public void checkFooterIATILogo() {

    }

    @Test(priority = 12)
    public void verifyIATIPublisherTitle() {
        Assert.assertEquals(footerPage.getIATIPublisher(), ConstantsUtils.IATIPublisherTitle);
    }

    @Test(priority = 12)
    public void verifyIATIPublisherList() {
        Assert.assertEquals(footerPage.getIATIPublisherList(), ConstantsUtils.footerIATIPublisher());
    }

    @Test(priority = 12)
    public void verifyIATIStandardTitle() {
        Assert.assertEquals(footerPage.getIATIStandard(), ConstantsUtils.IATIStandardTitle);
    }

    @Test(priority = 12)
    public void verifyIATIPublisherStandardList() {
        Assert.assertEquals(footerPage.getIATIStandardList(), ConstantsUtils.footerIATIStandard());
    }

    @Test(priority = 12)
    public void verifyFooterNote() {
        Assert.assertEquals(footerPage.getFooterNote(), ConstantsUtils.footerNotes());

    }

    @Test(priority = 12)
    public void checkSupportMail() {
        Assert.assertTrue(footerPage.isSupportEmailPresent(ConstantsUtils.footerSupportEmail));
    }

    @Test(priority = 12)
    public void verifyFooterCopyrightText() {
        Assert.assertTrue(footerPage.isCopyrightTextPresent(ConstantsUtils.footerCpyRightText));

    }

    @Test(priority = 13)
    public void IATI1_successfulSignInTest() {
        homePage.sendUsernamePassword("Publisher 3", "test1234");
        this.activityPage = homePage.doSignButtonClick();
        String headerTitle = activityPage.getActivityTitle();
        Assert.assertEquals(headerTitle, ConstantsUtils.headerYourActivities);
    }


    /*  @Test(priority = 5)
      public void IATI42_characterLimitation() {
          ArrayList<String> noFeesNoMinimum = homepa.getNoFeesNoMinimumText();
          Assert.assertEquals(noFeesNoMinimum, ConstantsUtils.noFeesNoMinimumTitle());
      }
  */


  /*  @Test
    public void IATI8_verifyLoginBackTest() {
        ArrayList<String> noFeesNoMinimum = homepa.getNoFeesNoMinimumText();
        Assert.assertEquals(noFeesNoMinimum, ConstantsUtils.noFeesNoMinimumTitle());
    }*/


}

