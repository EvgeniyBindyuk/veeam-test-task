package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CareersVeeamPage {

    @FindBy(css = "dd[id=\"country-element\"] span[class=\"selecter-selected\"]")
    WebElement countriesList;

    @FindBy(css = "span[data-value=\"Canada\"]")
    WebElement canada;

    @FindBy(css = "div[id=\"language\"]")
    WebElement languagesList;

    @FindBy(css = "label[for=\"ch-10\"]")
    WebElement french;

    @FindBy(css = "a[class=\"selecter-fieldset-submit\"]")
    WebElement applyLanguage;

    @FindBy(css = "div[class=\"vacancies-blocks-container\"]")
    WebElement jobList;

    @FindBy(xpath = "//dd[@id=\"country-element\"]/div")
    WebElement isCountriesListOpened;

    @FindBy(xpath = "//div[@id=\"language\"]")
    WebElement isLanguagesListOpened;

    public CareersVeeamPage(ChromeDriver driver) {
        PageFactory.initElements(driver, this);
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

    public String chooseLanguage(String language) {
        if (language.equalsIgnoreCase("french")) {
            french.click();
            return french.getAttribute("innerText").trim();
        }
        return null;
    }

    public boolean applyLanguageChoice() {
        applyLanguage.click();
        return isLanguagesListOpened.getAttribute("class").endsWith("selecter");
    }
}
