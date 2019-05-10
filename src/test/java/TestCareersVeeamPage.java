import driver.DriverManager;
import driver.DriverManagerFactory;
import driver.DriverType;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.CareersVeeamPage;

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

    @AfterMethod
    public void afterMethod() {
        driverManager.quitDriver();
    }

    @Test(priority = 1)
    public void openCountryListTest() {
        Assert.assertTrue(objCareersPage.openCountriesList());
    }

    @Test(priority = 2)
    @Parameters(value = "country")
    public void chooseCountryTest(String country) {
        String actualCountry = objCareersPage.chooseCountry(country);
        Assert.assertEquals(country, actualCountry);
    }

    @Test(priority = 3)
    public void openLanguagesListTest() {
        Assert.assertTrue(objCareersPage.openLanguageList());
    }

    @Test(priority = 4)
    @Parameters(value = "language")
    public void chooseLanguageTest(String language) {
        String actualLanguage = objCareersPage.chooseLanguage(language);
        Assert.assertEquals(language, actualLanguage);
    }

    @Test(priority = 6)
    @Parameters(value = "jobsFound")
    public void jobsCountTest(String jobsFound) {
        Assert.assertEquals(jobsFound, objCareersPage.jobsFoundOnPage(jobsFound));
    }

    @Test(priority = 7)
    @Parameters(value = "jobsFound")
    public void vacanciesBlocksCountTest(String jobsFound) {
        Assert.assertEquals(Integer.parseInt(jobsFound.replaceAll("\\D", "")),
                objCareersPage.vacanciesCount());
    }
}
