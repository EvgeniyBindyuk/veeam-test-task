import org.openqa.selenium.JavascriptExecutor;
import pages.CareersVeeamPage;
import utils.Country;
import utils.Language;

public class Main {
    public static void main(String[] args) {
        CareersVeeamPage page = new CareersVeeamPage();
        page.driver.get("https://careers.veeam.com/");
        page.driver.manage().window().maximize();
        JavascriptExecutor jse = page.driver;
        jse.executeScript("window.scrollBy(0,250)", "");
        page.openCountriesList();
        page.chooseCountry(Country.CANADA);
        page.openLanguageList();
        page.chooseLanguage(Language.FRENCH);

    }
}
