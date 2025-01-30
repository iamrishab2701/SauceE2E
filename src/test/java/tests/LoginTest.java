package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import config.ConfigReader;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pages.LoginPage;
import utils.DriverManager;

public class LoginTest extends BaseTest {

    @Test(description = "Verify user login with valid credentials")
    @Severity(SeverityLevel.CRITICAL)
    @Story("User logs in succesfully")
    @Description("Login with username and password and verify successful login")
    public void loginTest() {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.enterUsername(ConfigReader.getUsername());
        loginPage.enterPassword(ConfigReader.getPassword());
        loginPage.clickLogin();
    }
}