package qa.ivo.test.amazon.product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * This class represents an Amazon product,
 * as discovered via Today's Deals
 *
 */

public class TodaysDealProduct {
	private String name;
	private String price;
	
	// Is-Prime status does not seem to be displayed on this type of listing page
	private boolean isPrime = false;
	
	/**
	 * Read a product's details from the web element it
	 * is wrapped in
	 */
	public TodaysDealProduct(WebElement source) {
		name = source.findElement(By.cssSelector("#dealTitle.restVisible")).getText();
		
		// TODO price can be a float, it can also contain alternative prices, currency
		try {
			price = source.findElement(By.className("priceBlock")).getText();
		} catch (Exception e) {
			// TODO handle gracefully
			price = "N/A";
		}
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
