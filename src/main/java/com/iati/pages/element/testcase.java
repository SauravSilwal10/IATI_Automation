package com.iati.pages.element;

import com.iati.utils.*;
import com.iati.utils.DropdownUtils;
import com.iati.utils.ElementUtils;
import com.iati.utils.JSExecutorUtils;
import com.iati.utils.WaitUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.iati.utils.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class testcase {
    WebDriver driver;
    private ElementUtils elementUtil;
    private WaitUtils waitUtils;
    private DropdownUtils dropdownUtils;
    private JSExecutorUtils jsExecutorUtils;
    private WebElement webElement;
    private CommonComponentPage commonComponentPage;
    int outerIndex = 0;

    public void setupChromeDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
        options();
    }
    public testcase(WebDriver driver) {
        this.driver = driver;
        elementUtils = new ElementUtils(driver);
        waitUtils = new WaitUtils(driver);
        dropdownUtils = new DropdownUtils(driver);
        jsExecutorUtils = new JSExecutorUtils(driver);
    }


    void options() {
        driver.manage().window().maximize();

    }
    public void login() {
        String url = "https://iatipublisher-dev.yipl.com.np/";
        driver.get(url);
    }

    public void sendKeys() {
        driver.findElement(By.xpath("//input[@id =\"username\"]")).sendKeys("shyam");
        driver.findElement(By.xpath("//input[@id =\"password\"]")).sendKeys("12345678");
        driver.findElement(By.xpath("//button[@id =\"btn\"]")).click();
    }

    public void testListOfElements(String element[]) throws Exception {
       List<WebElement> listItems = driver.findElements(By.xpath("//td[contains(@class,'title')]"));
            int index = 0;
            for (WebElement listItem : listItems) {
                String itemText = listItem.getText();
                System.out.println("Name of title:" + itemText);
                listItem.click();
                if (index++ == 5) {
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    js.executeScript("window.scrollBy(0,350)", "");
                }
                for (int i = 0; i > element.length; i++) {
                    By xpathTitle = elementUtils.getLocator("div", "activity-status");
                    return waitUtils.visibilityOfElement(xpathTitle, 2).getText();
                    String currentWindowHandle = driver.getWindowHandle();
                    button.click();
                    if (driver.getWindowHandles().size() > 1) {
                        for (String windowHandle : driver.getWindowHandles()) {
                            if (!windowHandle.equals(currentWindowHandle)) {
                                driver.switchTo().window(windowHandle);
                                String newWindowTitle = driver.getTitle();
                                System.out.println("The title of the new window is \"" + newWindowTitle + "\"");
                                driver.navigate().back();
                                driver.navigate().back();
                            }
                        }
                    } else {

                        String currentPageSource = driver.getPageSource();
                        System.out.println("The page source of the current window is \"" + currentPageSource + "\"");
                        driver.navigate().back();
                        driver.navigate().back();
                    }
                }
            }
        }
    }

