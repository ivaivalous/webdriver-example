package qa.ivo.test.amazon.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;

import qa.ivo.test.amazon.product.TodaysDealProduct;

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
	
	/**
	 * Get a list of Today's Deals products
	 * @return
	 */
	public List<TodaysDealProduct> getProducts() {
		return new TodaysDealsProductList(driver).getProducts();
	}
	
	// Additional methods related to the page can be added...
}
