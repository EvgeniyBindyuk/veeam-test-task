package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import utils.Country;
import utils.Language;
import utils.WebDriverSettings;

import java.util.concurrent.TimeUnit;

public class CareersVeeamPage extends WebDriverSettings {
    public ChromeDriver driver;

    {
        System.setProperty("webdriver.chrome.driver", "/Program Files/ChromeDriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @FindBy(id = "country-element")
    private
    WebElement countriesList;

    @FindBy(css = "span[data-value=\"Canada\"]")
    private
    WebElement Canada;

    @FindBy(css = "div[id=\"language\"]")
    private
    WebElement languagesList;

    @FindBy(css = "label[for=\"ch-10\"]")
    WebElement french;

    public void openCountriesList() {
        countriesList.click();
    }

    public void chooseCountry(Country countryType) {
        if (countryType == Country.CANADA) {
            Canada.click();
        }
    }

    public void openLanguageList() {
        languagesList.click();
    }

    public void chooseLanguage(Language languageType) {
        if (languageType == Language.FRENCH) {
            french.click();
        }
    }
}
