package qa.ivo.test.amazon.pages;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import qa.ivo.test.Driver;
import qa.ivo.test.amazon.product.TodaysDealProduct;

/**
 * Handle a page of product results
 *
 */

public class TodaysDealsProductList {
	private static final String PRODUCT_CONTAINER_CSS = "[class='a-section dealContainer']";
	private List<TodaysDealProduct> products = new LinkedList<TodaysDealProduct>();
	
	/**
	 * Retrieve the list of products from the current page
	 * @param driver
	 */
	public TodaysDealsProductList(WebDriver driver) {
		Driver.waitForElement(driver, By.cssSelector(PRODUCT_CONTAINER_CSS));
		
		List<WebElement> containers = driver.findElements(By.cssSelector(PRODUCT_CONTAINER_CSS));
		
		for (WebElement e : containers) {
			products.add(new TodaysDealProduct(e));
		}
	}
	
	/**
	 * Get the products that have been retrieved from the page
	 */
	public List<TodaysDealProduct> getProducts() {
		return products;
	}
}
