package Base;

import com.github.javafaker.Faker;
import com.iati.factory.DriverFactory;
import com.iati.pages.*;
import com.iati.pages.element.*;


import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

public class BaseTest {
    DriverFactory driverFactory;
    private WebDriver driver;
    public Faker faker;
    public Properties properties;
    public NavBarPage navBarPage;
    public HomePage homePage;
    public FooterPage footerPage;
    public ActivityPage activityPage;
    public ActivityDetailPage activityDetailPage;
    public RegistrationPage registrationPage;
    public CommonNavBarPage commonNavBarPage;
    public OtherIdentifierPage otherIdentifierPage;
    public ActivityStatusPage activityStatusPage;
    public DescriptionPage activityDescriptionPage;
    public CommonComponentPage commonComponentPage;

    public ActivityScopePage activityScopePage;
    public MigrationScript migrationScript;


    @BeforeTest
    public void setup() {
        driverFactory = new DriverFactory();
        properties=driverFactory.initProperties();
        driver = driverFactory.initDriver(properties);
        faker = new Faker();
        homePage = new HomePage(driver);
        commonComponentPage = new CommonComponentPage(driver);
        navBarPage = new NavBarPage(driver);
        commonNavBarPage = new CommonNavBarPage(driver);
        footerPage = new FooterPage(driver);
    }


    @AfterTest
    public void driverQuit() {
        driver.quit();
        System.out.println("Test exited");
    }

}