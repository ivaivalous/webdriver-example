package qa.ivo.test.amazon.pages;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import qa.ivo.test.amazon.product.SearchResultProduct;

/**
 * Handle a page of product results
 *
 */

public class SearchResultProductList {
	private static final String PRODUCT_CONTAINER_CLASS = "s-item-container";
	private List<SearchResultProduct> products = new LinkedList<SearchResultProduct>();
	
	/**
	 * Retrieve the list of products from the current page
	 * @param driver
	 */
	public SearchResultProductList(WebDriver driver) {
		List<WebElement> containers = driver.findElements(By.className(PRODUCT_CONTAINER_CLASS));
		
		for (WebElement e : containers) {
			products.add(new SearchResultProduct(e));
		}
	}
	
	/**
	 * Get the products that have been retrieved from the page
	 */
	public List<SearchResultProduct> getProducts() {
		return products;
	}
}
