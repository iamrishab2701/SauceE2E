package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    private By userNameField = By.id("user-name");
    private By passWordField = By.id("password");
    private By loginButton = By.id("login-button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        driver.findElement(userNameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passWordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public String getPageTitle(){
        return driver.getTitle();
    }
}
