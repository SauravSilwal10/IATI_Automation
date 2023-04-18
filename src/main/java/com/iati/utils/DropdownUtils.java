package com.iati.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DropdownUtils {
    private WebDriver driver;
    private WaitUtils waitUtils;

    public DropdownUtils(WebDriver driver) {
        this.driver = driver;
        waitUtils = new WaitUtils(driver);
    }

    /**Click in to the dropdown data that matches with string value
     *
     * @param locator
     * @param value
     */
    public void doSelectElementDropdown(By locator, String value) {
        List<WebElement> optionList = driver.findElements(locator);
        for (WebElement element : optionList) {
            if (element.getText().equals(value)) {
                element.click();
                break;
            }
        }
    }
    public void doSelectElementDropdown(By locator,int count) {
        List<WebElement> optionList = waitUtils.presenceOfElements(locator,3);
        String value = getElementDropdown(locator,count);
        for (WebElement element : optionList) {
            if (element.getText().equals(value)) {
                element.click();
                break;
            }
        }
    }

    /**
     * Get specific random data from the list and selects to dropdown
     * @param locator
     * @return specific dropdown element
     */
    private String getElementDropdown(By locator,int count ){
        Random random = new Random();
        ArrayList<String> list=getDropdownList(locator,count);
        System.out.println(list.size());
        int index=random.nextInt(list.size());
        return list.get(index);
    }

    /**
     * Create array of dropdown lists from the web lists
     * @param locator
     * @return array list dropdown list
     */

    public ArrayList<String> getDropdownList(By locator,int count) {
        List<WebElement> optionList = driver.findElements(locator);
        int optionListCount = optionList.size();
        ArrayList<String> textList = new ArrayList<>();
        for (WebElement e : optionList) {
            if (optionListCount == count) {
                textList.add(e.getText());
            }
        }
        System.out.println(textList);
        return textList;
    }

}
