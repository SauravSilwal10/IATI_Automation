package com.iati.tests;

import Base.BaseTest;
import com.iati.utils.ConstantsUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

public class ActivityScopeTest  extends BaseTest {

 @BeforeTest
    public void activityScopeSetup() {
        homePage.sendUsernamePassword("testing","12345678");
        activityPage=homePage.doSignButtonClick();
        activityPage.displayAddActivityPopup();
        activityPage.fillForm(faker.chuckNorris().fact(), ConstantsUtils.activityLangCount, ConstantsUtils.activityID);
        activityDetailPage = activityPage.doPopupSaveButtonClick();
        activityScopePage = activityDetailPage.moveTOActivityScope();
    }
    @Test(priority = 1)
    public void  validateActivityScopeTitle(){
        Assert.assertEquals(activityScopePage.getActivityScopeTitle(),ConstantsUtils.activityScopeTitle);
    }
@Test(priority = 1)
    public void validateActivityScopeCode(){
     Assert.assertEquals(activityScopePage.getActivityScopeCode(),ConstantsUtils.activityScopeCode);
}
@Test(priority = 1)
    public void validateCodeActivityScopeLabel(){
        Assert.assertEquals(activityScopePage.getCodeList(),ConstantsUtils.activityScopeCodeList());
    }

    @Test(priority = 1)
    public void validateActivityScopeDropdown(){
        activityScopePage.sendCodeList(8);
    }

@Test(priority = 2)
    public void validateSaveAndExit(){
     activityScopePage.SaveAndExit();

}


}
