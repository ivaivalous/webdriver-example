package qa.ivo.test.amazon.pages;

import org.openqa.selenium.WebDriver;

public class TodaysDealsPage extends Page {
	
	private WebDriver driver;

	/**
	 * Navigate to the Today's Deals page
	 */
	@Override
	public WebDriver load() {
		MainPage mainPage = new MainPage();
		driver = mainPage.load();
		mainPage.loadTodaysDeals();
		return driver;
	}

	/**
	 * Close the browser window
	 */
	@Override
	public void close() {
		driver.close();
	}
	
	// Additional methods related to the page can be added...
}
