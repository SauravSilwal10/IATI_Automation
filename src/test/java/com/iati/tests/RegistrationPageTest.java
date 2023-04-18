package com.iati.tests;

import Base.BaseTest;
import com.iati.utils.ConstantsUtils;
import com.iati.utils.ExcelUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegistrationPageTest extends BaseTest {


    @BeforeClass
    public void registerSetup() {
        registrationPage = homePage.doRegisteredPublisherSignup();
        Assert.assertEquals(homePage.getRegistrationTitle(), ConstantsUtils.publisherInfoTitle);
    }

    @DataProvider()
    public Object[][] getRegistrationData() {
        Object[][] data = ExcelUtils.getExcelData(ConstantsUtils.LANGUAGE_SHEET);
        return data;
    }

//    @Test
//    public void publisherInformation() {
//        System.out.println("here");
//        String title=registrationPage.getFormTitle();
//        Assert.assertEquals(title,ConstantsUtils.registrationFormTitle);
//    }

    @Test
    public void publisherInformation() {
        Assert.assertEquals(registrationPage.getFormTitle(), ConstantsUtils.registrationFormTitle);
    }

    @Test
    public void IATI_134_validateBlankField(){
        registrationPage.clickNextButton();
    }

//    @Test public void IATI_135_invalidPublisherName(){
//        registrationPage.sendIncorrectPublisherName("QAtest", "qt987654", "AF-CBR", "123456");
//        registrationPage.doSignButtonClick();
//        Assert.assertEquals(registrationPage.getInvalidUsername(ConstantsUtils.wrongCredential), ConstantsUtils.wrongCredential);
//    }
//
//    @Test
//    public void IATI_136_invalidPublisherID() {
//        registrationPage.sendPublisherID("Admin123");
//        registrationPage.doSignButtonClick();
//        Assert.assertEquals(registrationPage.getInvalidId(ConstantsUtils.wrongCredential), ConstantsUtils.wrongCredential);
//    }



}
