package tests;

import driver.DriverManager;
import driver.DriverManagerFactory;
import driver.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.CareersVeeamPage;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Listeners(listeners.ListenerTest.class)
public class TestCareersVeeamPage {
    private CareersVeeamPage objCareersPage;
    private DriverManager driverManager;

    @BeforeTest
    public void setup() {
        driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
        WebDriver driver = driverManager.getDriver();
        objCareersPage = new CareersVeeamPage(driver);
        driver.get("https://careers.veeam.com/");
        driver.manage().window().maximize();
    }

    @AfterTest
    public void quit() {
        driverManager.quitDriver();
    }

    @Test(priority = 1)
    @Parameters({"country", "language"})
    public void chooseCountryAndLanguage(String country, String language) {
        assertTrue(objCareersPage.openCountriesList());
        String actualCountry = objCareersPage.chooseCountry(country);
        assertEquals(country, actualCountry);
        assertTrue(objCareersPage.openLanguageList());
        String actualLanguage = objCareersPage.chooseLanguage(language);
        assertEquals(language, actualLanguage);
    }

    @Test(priority = 2)
    @Parameters(value = "jobsFound")
    public void jobsCountTest(String jobsFound) {
        assertEquals(jobsFound, objCareersPage.jobsFoundOnPage(jobsFound));
        assertEquals(Integer.parseInt(jobsFound.replaceAll("\\D", "")),
                objCareersPage.vacanciesBlockCount());
    }
}
