package qa.ivo.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Driver {
	private static final int MAX_ELEMENT_LOAD_WAIT_TIME_SECONDS = 30;
    private static WebDriver driver;
    
    static {
    	// This should be parameterized
    	System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
    }

    /**
     * Start a Selenium session and load the provided URL
     * @param url URL to load
     * @return a WebDriver instance
     */
    public static WebDriver get(String url) {
    	DesiredCapabilities capability = DesiredCapabilities.firefox();

        try {
        	// This should be parameterized
			driver = new RemoteWebDriver(new URL("http://localhost:9999/wd/hub"), capability);
		} catch (MalformedURLException e) {
			// TODO this can be handled in a better way
			e.printStackTrace();
		}

        driver.get(url);
        return driver;
    }
    
    /**
     * Wait for an element to become visible
     */
    public static void waitForElement(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, MAX_ELEMENT_LOAD_WAIT_TIME_SECONDS);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
