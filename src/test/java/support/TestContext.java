package support;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.HashMap;
import java.util.Map;

public class TestContext {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static WebDriverWait getWait() {
        return getWait(5);
    }

    public static WebDriverWait getWait(int timeout) {
        return new WebDriverWait(driver, timeout);
    }

    public static JavascriptExecutor getExecuter() {
        return (JavascriptExecutor) getDriver();
    }

    public static void initialize() {
        initialize("chrome", false);
    }

    public static void teardown() {
        driver.quit();
    }

    public static void initialize(String browser, boolean isHeadless) {
        Dimension size = new Dimension(1920, 1080);
        Point position = new Point(0, 0);
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                Map<String, Object> chromePreferences = new HashMap<>();
                chromePreferences.put("profile.default_content_settings.geolocation", 2);
                chromePreferences.put("download.prompt_for_download", false);
                chromePreferences.put("download.directory_upgrade", true);
                chromePreferences.put("credentials_enable_service", false);
                chromePreferences.put("password_manager_enabled", false);
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.setExperimentalOption("prefs", chromePreferences);
                System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
                if (isHeadless) {
                    chromeOptions.setHeadless(true);
                    chromeOptions.addArguments("--window-size=" + size.getWidth() + "," + size.getWidth());
                    chromeOptions.addArguments("--disable-gpu");
                }
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (isHeadless) {
                    FirefoxBinary firefoxBinary = new FirefoxBinary();
                    firefoxBinary.addCommandLineOptions("--headless");
                    firefoxOptions.setBinary(firefoxBinary);
                }
                driver = new FirefoxDriver(firefoxOptions);
                break;
            default:
                throw new RuntimeException("Driver is not implemented for: " + browser);
        }
    }
}
