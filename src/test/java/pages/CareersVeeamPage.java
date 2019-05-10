package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Helper;

public class CareersVeeamPage {

    private Helper helper;
    private ChromeDriver driver;

    @FindBy(css = "dd[id=\"country-element\"] span[class=\"selecter-selected\"]")
    WebElement countriesList;

    @FindBy(css = "span[data-value=\"Canada\"]")
    WebElement canada;

    @FindBy(css = "div[id=\"language\"]")
    WebElement languagesList;

    @FindBy(css = "label[for=\"ch-10\"]")
    WebElement french;

    @FindBy(css = "a[class=\"selecter-fieldset-submit\"]")
    WebElement applyLanguageButton;

    @FindBy(xpath = "//dd[@id=\"country-element\"]/div")
    WebElement isCountriesListOpened;

    @FindBy(xpath = "//div[@id=\"language\"]")
    WebElement isLanguagesListOpened;

    @FindBy(css = "a[class=\"content-loader-button load-more-button \"]")
    WebElement showAllJobsButton;

//    @FindBy(css = "div[class=\"vacancies-blocks-container\"]")
//    WebElement vacanciesBlocks;

    @FindBy(css = "div[class*=\"row vacancies-blocks\"] h3")
    WebElement jobsFound;

    public CareersVeeamPage(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        helper = new Helper(this.driver);
    }

    public boolean openCountriesList() {
        helper.scrollDown(2);
        countriesList.click();
        return isCountriesListOpened.getAttribute("class").endsWith("open");
    }

    public String chooseCountry(String country) {
        //need to change to switch if there are more countries
        if ("Canada".equals(country)) {
            canada.click();
            return canada.getAttribute("innerText");
        } else {
            countriesList.click();
        }
        return null;
    }

    public boolean openLanguageList() {
        languagesList.click();
        return isLanguagesListOpened.getAttribute("class").endsWith("open");
    }

    public String chooseLanguage(String language) {
        //need to change to switch if there are more languages
        if (language.equals("French")) {
            french.click();
            applyLanguageButton.click();
            return french.getAttribute("innerText").trim();
        } else {
            languagesList.click();
        }
        return null;
    }

    public String jobsFoundOnPage(String jobsCount) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.textToBePresentInElement(jobsFound, jobsCount));
        return jobsFound.getAttribute("innerText");
    }

    public int vacanciesCount() {
        if (helper.isElementPresent(By.cssSelector("a[class=\"content-loader-button load-more-button \"]"))) {
            showAllJobsButton.click();
        }
        return driver.findElements(
                By.xpath("//div[@class=\"vacancies-blocks-container\"]/div")
        ).size();
    }
}
