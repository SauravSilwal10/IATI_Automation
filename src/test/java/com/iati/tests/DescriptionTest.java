package com.iati.tests;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import com.iati.utils.ConstantsUtils;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class DescriptionTest  extends BaseTest {
    @BeforeTest
    public  void descriptionSetup(){
        homePage.sendUsernamePassword("testing","12345678");

    }
    @Test(priority = 1)
    public void validateDescriptionTitle(){
        Assert.assertEquals(activityDescriptionPage.getDescriptionTitle(),ConstantsUtils.descriptionTitle);
    }

}
