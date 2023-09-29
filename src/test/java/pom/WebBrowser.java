package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Optional;

public class WebBrowser {
    private final WebDriver driver;

    public WebBrowser(boolean isFirefox){
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
        if(isFirefox){
            driver = new FirefoxDriver();
        } else {
            driver = new ChromeDriver();
        }
    }

    public void quitWebWindow () {
        wait2Seconds();
        driver.quit();
    }

    public void wait2Seconds() {
        try {
            Thread.sleep(2 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
