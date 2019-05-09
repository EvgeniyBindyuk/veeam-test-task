import org.junit.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.CareersVeeamPage;
import utils.Helper;
import utils.WebDriverSettings;

public class TestCareersVeeamPage extends WebDriverSettings {
    private CareersVeeamPage objCareersPage;
    private Helper helper;

    @BeforeTest
    public void setup() {
        helper = new Helper(driver);
        objCareersPage = new CareersVeeamPage(driver);
        driver.get("https://careers.veeam.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void openCountryListTest() {
        helper.scrollDown();
        helper.scrollDown();
        Assert.assertTrue(objCareersPage.openCountriesList());
    }

    @Test
    @Parameters(value = "country")
    public void chooseCountryTest(String country) {
        Assert.assertEquals("canada", objCareersPage.chooseCountry(country));
    }
}
