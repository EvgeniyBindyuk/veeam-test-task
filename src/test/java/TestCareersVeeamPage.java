import org.junit.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.CareersVeeamPage;
import utils.WebDriverSettings;

public class TestCareersVeeamPage extends WebDriverSettings {
    private CareersVeeamPage objCareersPage;

    @BeforeTest
    public void setup() {
        objCareersPage = new CareersVeeamPage(driver);
        driver.get("https://careers.veeam.com/");
        driver.manage().window().maximize();
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
