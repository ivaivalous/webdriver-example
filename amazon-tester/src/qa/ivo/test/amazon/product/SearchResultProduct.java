package qa.ivo.test.amazon.product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * This class represents an Amazon product,
 * as discovered via Search Results
 *
 */

public class SearchResultProduct {
	private String name;
	private String price;
	private boolean isPrime;
	
	/**
	 * Read a product's details from the web element it
	 * is wrapped in
	 */
	public SearchResultProduct(WebElement source) {
		name = source.findElement(By.tagName("h2")).getText();
		
		// TODO price can be a float, it can also contain alternative prices, currency
		price = source.findElement(By.className("sx-price-large")).getText();
		
		isPrime = !source.findElements(By.className("a-icon-prime")).isEmpty();
	}
	
	public String getName() {
		return name;
	}
	
	public String getPrice() {
		return price;
	}
	
	public boolean getIsPrime() {
		return isPrime;
	}
	
	@Override
	public String toString() {
		return String.format("Name: %s, price: %s, is Prime: %b", getName(), getPrice(), getIsPrime());
	}
}
