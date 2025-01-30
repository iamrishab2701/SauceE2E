package base;

import java.io.File;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import io.qameta.allure.testng.AllureTestNg;
import utils.DriverManager;

@Listeners({AllureTestNg.class})
public class BaseTest {

    private static final String ALLURE_RESULTS_DIR = "allure-results";

    static {
        System.setProperty("allure.results.directory", ALLURE_RESULTS_DIR);
    }

    @BeforeMethod
    public void setUp() {
        ensureAllureDirectoryExists();
        DriverManager.initDriver();
        DriverManager.getDriver().get(config.ConfigReader.getBaseUrl());
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }

    private void ensureAllureDirectoryExists() {
        File allureResultsDir = new File(ALLURE_RESULTS_DIR);
        if (!allureResultsDir.exists()) {
            allureResultsDir.mkdirs();
        }
    }
}
