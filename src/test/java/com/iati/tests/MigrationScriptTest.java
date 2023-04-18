package com.iati.tests;

import Base.BaseTest;
import com.iati.pages.element.MigrationScript;
import com.iati.utils.ConstantsUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class MigrationScriptTest  extends  BaseTest{

    @BeforeTest
    public  void MigrationSetup()
    {
        homePage.sendUsernamePassword("testing","12345678");
        activityPage=homePage.doSignButtonClick();
        activityPage.displayAddActivityPopup();
        activityPage.fillForm(faker.chuckNorris().fact(), ConstantsUtils.activityLangCount, ConstantsUtils.activityID);
        activityDetailPage = activityPage.doPopupSaveButtonClick();
        migrationScript = activityDetailPage.moveTOMigrationScript();

    }
    @Test(priority = 1)
    public void validateMigrationTitle(){
        migrationScript.getMigrationTitle();
    }



}
