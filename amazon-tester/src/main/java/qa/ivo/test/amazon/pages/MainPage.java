package qa.ivo.test.amazon.pages;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import qa.ivo.test.Driver;

/**
 * Responsible for handling Amazon's main page.
 *
 */
public class MainPage extends Page {
	private static final Logger LOGGER = Logger.getLogger(MainPage.class.getName());
	private WebDriver driver;
	
	private static final String AMAZON_HOME = "https://www.amazon.com";
	private static final String TODAYS_DEALS_SELECTOR = "[href*='/gp/goldbox/ref=nav_cs_gb']";
	private static final String TODAYS_DEALS_HEADING = "gbh1-bold";
	private static final String GIFT_CARDS_REGISTRY_SELECTOR = "[href*='ref=nav_cs_gc_registry']";
	private static final String GIFT_CARDS_IMAGES = "img[src*='gift-cert']";
	
	public WebDriver load() {
		driver = Driver.get(AMAZON_HOME);
		return driver;
	}
	
	/**
	 * loadTodaysDeals will navigate to the "Today's Deals" page.
	 */
	public TodaysDealsPage loadTodaysDeals() {
		WebElement button = driver.findElements(By.cssSelector(TODAYS_DEALS_SELECTOR)).get(0);
		button.click();
		
		Driver.waitForElement(driver, By.className(TODAYS_DEALS_HEADING));
		LOGGER.info("Navigated to Today's Deals");

		return new TodaysDealsPage();
	}
	
	public GiftCardsRegistryPage loadGiftCardsRegistryPage() {
		WebElement button = driver.findElements(By.cssSelector(GIFT_CARDS_REGISTRY_SELECTOR)).get(0);
		button.click();
		
		Driver.waitForElement(driver, By.cssSelector(GIFT_CARDS_IMAGES));
		LOGGER.info("Navigated to Gift Cards & Registry");

		return new GiftCardsRegistryPage();
	}
	
	public void close() {
		driver.close();
	}
}
