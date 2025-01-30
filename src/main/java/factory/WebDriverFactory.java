package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import config.ConfigReader;

public class WebDriverFactory {
    public static WebDriver createDriver() {
        String browser = ConfigReader.getBrowser().toLowerCase();
        switch (browser) {
            case "chrome":
                return new ChromeDriver();
            case "firfox":
                return new FirefoxDriver();
            case "edge":
                return new EdgeDriver();
            default:
                throw new IllegalArgumentException("Unsupported browser : " + browser);
        }
    }
}
