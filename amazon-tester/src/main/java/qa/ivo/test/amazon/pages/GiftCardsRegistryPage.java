package qa.ivo.test.amazon.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GiftCardsRegistryPage extends MainPage {
	
	private WebDriver driver;
	
	@Override
	public WebDriver load() {
		MainPage mainPage = new MainPage();
		driver = mainPage.load();
		
		mainPage.loadGiftCardsRegistryPage();
		return driver;
	}
	
	@Override
	public void close() {
		driver.close();
	}
	
	/**
	 * Select a category from the Gift Cards page.
	 * Category title can be a partial name.
	 * Both categories represented by images and ones using text
	 * are supported. Quotation marks in category names must be escaped.
	 * @param categoryTitle
	 */
	public void selectCategory(String categoryTitle) {
		// Try selecting an image-represented category
		String selector = "[alt*='" + categoryTitle + "']";
		
		List<WebElement> results = driver.findElements(By.cssSelector(selector));
		
		if (!results.isEmpty()) {
			// Result found, navigate to category
			results.get(0).click();
		} else {
			// No image results, look for a button instead
			selector = "[title*='" + categoryTitle + "']";
			results = driver.findElements(By.cssSelector(selector));
			
			// Follow the first result
			// TODO The case when there are no results should be handled
			results.get(0).click();
		}
	}
	
	// Additional methods related to the page can be added...
}
