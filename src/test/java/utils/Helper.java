package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

public class Helper {
    private ChromeDriver driver;

    public Helper(ChromeDriver driver) {
        this.driver = driver;
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void scrollDown(int count) {
        JavascriptExecutor jse = driver;
        for (int i = 0; i < count; i++) {
            jse.executeScript("window.scrollBy(0,250)", "");
        }
    }

}
