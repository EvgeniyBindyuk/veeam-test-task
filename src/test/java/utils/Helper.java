package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

public class Helper {
    private ChromeDriver driver;

    public Helper(ChromeDriver driver) {
        this.driver = driver;
    }

    public void scrollDown() {
        JavascriptExecutor jse = driver;
        jse.executeScript("window.scrollBy(0,250)", "");
    }

}
