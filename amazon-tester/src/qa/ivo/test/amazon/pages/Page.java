package qa.ivo.test.amazon.pages;

import org.openqa.selenium.WebDriver;

/**
 * Generic Amazon web page.
 *
 */

public abstract class Page {

	/**
	 * Load the web page
	 */
	public abstract WebDriver load();
	
	/**
	 * Close the page
	 */
	public abstract void close();
}
