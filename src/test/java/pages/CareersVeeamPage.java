package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Languages;

public class CareersVeeamPage {

    private ChromeDriver driver;


    @FindBy(css = "dd[id=\"country-element\"]")
    private
    WebElement countriesList;

    @FindBy(css = "span[data-value=\"Canada\"]")
    private
    WebElement canada;

    @FindBy(css = "div[id=\"language\"]")
    private
    WebElement languagesList;

    @FindBy(css = "label[for=\"ch-10\"]")
    private
    WebElement french;

    @FindBy(css = "a[class=\"selecter-fieldset-submit\"]")
    private
    WebElement applyLanguage;

    @FindBy(css = "div[class=\"vacancies-blocks-container\"]")
    WebElement jobList;

    @FindBy(xpath = "//dd[@id=\"country-element\"]/div")
    WebElement isCountriesListOpened;

    @FindBy(xpath = "//div[@id=\"language\"]")
    WebElement isLanguagesListOpened;

    public CareersVeeamPage(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public boolean openCountriesList() {
        countriesList.click();
        return isCountriesListOpened.getAttribute("class").endsWith("open");
    }

    public String chooseCountry(String country) {
        if (country.equalsIgnoreCase("canada")) {
            canada.click();
            return canada.getAttribute("innerText");
        }
        return null;
    }

    public boolean openLanguageList() {
        languagesList.click();
        return isLanguagesListOpened.getAttribute("class").endsWith("open");
    }

    public String chooseLanguage(Languages languagesType) {
        if (languagesType == Languages.FRENCH) {
            french.click();
            return french.getAttribute("innerText");
        }
        return null;
    }

    public boolean applyLanguageChoiсe() {
        applyLanguage.click();
        return isLanguagesListOpened.getAttribute("class").endsWith("selecter");
    }
}
