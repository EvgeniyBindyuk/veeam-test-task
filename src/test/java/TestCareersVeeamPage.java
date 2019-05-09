import org.junit.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.CareersVeeamPage;
import utils.Helper;
import utils.WebDriverSettings;

public class TestCareersVeeamPage extends WebDriverSettings {
    private CareersVeeamPage objCareersPage;

    @BeforeTest
    public void setup() {
        Helper helper = new Helper(driver);
        objCareersPage = new CareersVeeamPage(driver);
        driver.get("https://careers.veeam.com/");
        driver.manage().window().maximize();
        helper.scrollDown(2);
    }

    @Test(priority = 1)
    public void openCountryListTest() {
        Assert.assertTrue(objCareersPage.openCountriesList());
    }

    @Test(priority = 2)
    @Parameters(value = "country")
    public void chooseCountryTest(String country) {
        Assert.assertEquals(country, objCareersPage.chooseCountry(country));
    }

    @Test(priority = 3)
    public void openLanguagesListTest() {
        Assert.assertTrue(objCareersPage.openLanguageList());
    }

    @Test(priority = 4)
    @Parameters(value = "language")
    public void chooseLanguageTest(String language) {
        Assert.assertEquals(language, objCareersPage.chooseLanguage(language));
    }

    @Test(priority = 5)
    public void applyLanguageChoiceTest() {
        Assert.assertTrue(objCareersPage.applyLanguageChoice());
    }

}
