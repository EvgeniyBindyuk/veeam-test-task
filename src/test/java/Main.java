import pages.CareersVeeamPage;
import utils.Countries;
import utils.Helper;
import utils.Languages;

public class Main {
    public static void main(String[] args) {

        CareersVeeamPage page = new CareersVeeamPage();
        Helper helper = new Helper(page.driver);
        page.driver.get("https://careers.veeam.com/");
        page.driver.manage().window().maximize();
        helper.scrollDown();
        page.openCountriesList();
        page.chooseCountry(Countries.CANADA);
        helper.scrollDown();
        page.openLanguageList();
        page.chooseLanguage(Languages.FRENCH);
        page.applyLanguageChoiсe();

    }
}
