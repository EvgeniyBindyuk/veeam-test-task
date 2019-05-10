package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Helper {
    private WebDriver driver;

    public Helper(WebDriver driver) {
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
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        for (int i = 0; i < count; i++) {
            jse.executeScript("window.scrollBy(0,250)", "");
        }
    }

}
