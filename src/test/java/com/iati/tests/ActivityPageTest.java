package com.iati.tests;

import Base.BaseTest;
import com.iati.utils.ConstantsUtils;
import com.iati.utils.ExcelUtils;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class ActivityPageTest extends BaseTest {

    @BeforeClass
    public void activitySetup() {
        homePage.sendUsernamePassword("Publisher 3", "test1234");
        activityPage = homePage.doSignButtonClick();
        Assert.assertEquals(activityPage.getActivityTitle(), ConstantsUtils.activitiesTitles);
    }

    @DataProvider(name = "Registration_DataSet")
    public Object[][] getLangList() {
        Object[][] data = ExcelUtils.getExcelData(ConstantsUtils.LANGUAGE_SHEET);
        return data;
    }

    @Test(priority = -2)
    public void makeAddActivityOpen() {
        activityPage.displayAddActivityPopup();
        Assert.assertEquals(activityPage.getFormTitle(), ConstantsUtils.activityPopupTitle);
    }

    @Test(dependsOnMethods = {"makeAddActivityOpen"}, priority = -1)
    public void verifySectionTitle() {
        Assert.assertEquals(activityPage.getSectionLabels(), ConstantsUtils.addActivitySectionTitle());
    }

    @Test(dependsOnMethods = {"makeAddActivityOpen"}, priority = 0)
    public void verifyFieldTitle() {
        List<String> formTitle = activityPage.getFieldLabels("label", "class", "label");
        Assert.assertEquals(formTitle, ConstantsUtils.addActivityFormTitle());
    }
/*
    public static void main(String[] args) {
        Object[][] data = ExcelUtils.getExcelData(ConstantsUtils.LANGUAGE_SHEET);
        System.out.println(data.length);
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < 1; j++) {
                list.add(data[i][j]);
            }
        }
        System.out.println(list);
    }*/

    @Test(dependsOnMethods = {"makeAddActivityOpen"}, priority = 1)
    public void IATI183_verifyLanguageList() {
        Assert.assertEquals(activityPage.getActivityLanguage(ConstantsUtils.activityLangCount), activityPage.getLanguageExcelList());
    }

    @Test(dependsOnMethods = {"makeAddActivityOpen"}, priority = 2)
    public void IATI179_verifyBlankField() {
        activityPage.doPopupSaveButtonClick();
        Assert.assertEquals(activityPage.getBlankFieldValidationMsg(), ConstantsUtils.addActivityValidationMsg());
    }

    @Test(dependsOnMethods = {"makeAddActivityOpen"}, priority = 3)
    public void IATI210_verifyIATIIdentifier() {
        String activityID = activityPage.getActivityIdentifier(ConstantsUtils.activityID);
        Assert.assertEquals(activityPage.getActivityIATIIdentifier(), ConstantsUtils.activityIdPrefix + activityID);

    }

    @Test(dependsOnMethods = {"makeAddActivityOpen"}, priority = 4)
    public void IATI209_verifyCancelAddActivity() {
        activityPage.doPopupCancelButtonClick();
        Assert.assertEquals(activityPage.getActivityTitle(), ConstantsUtils.activitiesTitles);
    }

    @Test(dependsOnMethods = {"makeAddActivityOpen"}, priority = 5)
    public void IATI212_verifyAddActivity() {
        makeAddActivityOpen();
        activityPage.sendActivityNarrative(ConstantsUtils.activityNarrative);
        activityPage.sendActivityLanguage(ConstantsUtils.activityLangCount);
        activityPage.sendActivityIdentifier(ConstantsUtils.activityID);
        activityDetailPage = activityPage.doPopupSaveButtonClick();
        Assert.assertEquals(ConstantsUtils.activityNarrative, activityDetailPage.getActivityTitle());
    }

    @Ignore
    @Test
    public void IATI180_validateDuplicateActivity() {

    }
}