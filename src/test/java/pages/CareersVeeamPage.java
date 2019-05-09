package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Countries;
import utils.Languages;
import utils.WebDriverSettings;

public class CareersVeeamPage extends WebDriverSettings {

    @FindBy(css = "dd[id=\"country-element\"]")
    private
    WebElement countriesList;

    @FindBy(css = "span[data-value=\"canada\"]")
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

    public CareersVeeamPage() {
        PageFactory.initElements(this.driver, this);
    }

    public void openCountriesList() {
        countriesList.click();
    }

    public String chooseCountry(Countries countriesType) {
        if (countriesType == Countries.CANADA) {
            canada.click();
            return canada.getAttribute("innerText");
        }
        return null;
    }

    public void openLanguageList() {
        languagesList.click();
    }

    public String chooseLanguage(Languages languagesType) {
        if (languagesType == Languages.FRENCH) {
            french.click();
            return french.getAttribute("innerText");
        }
        return null;
    }

    public void applyLanguageChoiсe() {
        applyLanguage.click();
    }
}
