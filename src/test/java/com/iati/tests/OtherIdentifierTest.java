package com.iati.tests;

import Base.BaseTest;
import com.iati.utils.ConstantsUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class OtherIdentifierTest extends BaseTest {

    @BeforeClass
    public void otherIdentifierSetup() {
        homePage.sendUsernamePassword("Publisher 3", "test1234");
        activityPage = homePage.doSignButtonClick();
        activityPage.displayAddActivityPopup();
        activityPage.fillForm(ConstantsUtils.activityNarrative, ConstantsUtils.activityLangCount, String.valueOf(faker.hashCode()));
        activityDetailPage = activityPage.doPopupSaveButtonClick();
    }

    @Test(priority = 1)
    public void goToOtherIdentifier() {
        otherIdentifierPage = activityDetailPage.moveToOtherIdentifier();
        Assert.assertEquals(otherIdentifierPage.getOtherIdentifierTitle(), ConstantsUtils.otherIdTitle);
    }

    @Ignore
    @Test(priority = 1)
    public void validateOtherIdentifierTitle() {
    }

    @Test(priority = 2)
    public void validateOtherIdentifierRefLabel() {
        Assert.assertEquals(otherIdentifierPage.getOtherIdentifierRef(), ConstantsUtils.otherIdentifierRef);

    }

    @Test(priority = 3)
    public void validateOtherIdentifierTypeLabel() {
        Assert.assertEquals(otherIdentifierPage.getOtherIdentifierType(), ConstantsUtils.otherIdentifierType);
    }

    @Test(priority = 4)
    public void validateOtherIdentifierTypeList() {
        Assert.assertEquals(otherIdentifierPage.getOtherIdentifierTypeList(ConstantsUtils.otherIdentifierTypeCount), ConstantsUtils.otherIdentifierTypeList());
    }

    @Test(priority = 5)
    public void validateOtherIdentifierOwnerOrgTitle() {
        Assert.assertEquals(otherIdentifierPage.getOwnerOrgLabel(), ConstantsUtils.otherIdentifierOwnerOrgLabel);
    }

    @Test(priority = 6)
    public void validateOtherIdentifierOwnerOrgFieldLabels() {
        Assert.assertEquals(otherIdentifierPage.getOtherIdentifierOwnerOrgLabels(), ConstantsUtils.otherIdentifierOwnerOrgLabels());
    }


    @Ignore
    @Test
    public void validateFillParentOwnerOrg() {
        goToOtherIdentifier();
        otherIdentifierPage.fillAddMoreOwnerOrg(4, faker.harryPotter().spell());
        otherIdentifierPage.fillAddMore(4, faker.harryPotter().quote());
    }

    @Test(priority = 7,description = "Verify other-identifier with all ")
    public void validateFilledOtherIdentifierForm() {
        otherIdentifierPage
                .fillOtherIdentifierForm(
                        faker.harryPotter().house(),
                        ConstantsUtils.otherIdentifierTypeCount,
                        faker.harryPotter().house(),
                        faker.harryPotter().quote(),
                        ConstantsUtils.activityLangCount);
        activityDetailPage = commonComponentPage.clickSaveButton();
        Assert.assertTrue(activityDetailPage.getOtherIdentifierSection());
    }


}
