package qa.ivo.test;

import java.util.List;
import java.util.logging.Logger;

import org.testng.annotations.Test;

import qa.ivo.test.amazon.pages.GiftCardsRegistryPage;
import qa.ivo.test.amazon.pages.MainPage;
import qa.ivo.test.amazon.pages.TodaysDealsPage;
import qa.ivo.test.amazon.product.SearchResultProduct;
import qa.ivo.test.amazon.product.TodaysDealProduct;

public class AmazonTestCases {
	
	private static final Logger LOGGER = Logger.getLogger(AmazonTestCases.class.getName());
	
	@Test
	public void loadAmazonHomePage() {
		MainPage mainPage = new MainPage();
		
		// Load Amazon's home page
		mainPage.load();
		
		// Go to "Today's Deals"
		mainPage.loadTodaysDeals();
		
		// Close the browser window
		mainPage.close();
	}
	
	@Test
	public void loadTodaysDeals() {
		TodaysDealsPage today = new TodaysDealsPage();
		
		// Load "Today's Deals"
		today.load();
		
		// Close the browser window
		today.close();
	}
	
	@Test
	public void loadGiftCardsRegistryPage() {
		GiftCardsRegistryPage giftsPage = new GiftCardsRegistryPage();
		
		// Load "Gift Cards & Registry"
		giftsPage.load();

		// Close the browser window
		giftsPage.close();
	}
	
	@Test
	public void selectGiftCardImageCategory() {
		GiftCardsRegistryPage giftsPage = new GiftCardsRegistryPage();
		
		// Load "Gift Cards & Registry"
		giftsPage.load();
		
		// Go to a image-represented gift card category
		giftsPage.selectCategory("All Gift Cards");	
	}

	@Test
	public void selectGiftCardTextCategory() {
		GiftCardsRegistryPage giftsPage = new GiftCardsRegistryPage();
		
		// Load "Gift Cards & Registry"
		giftsPage.load();
		
		// Go to a image-represented gift card category
		giftsPage.selectCategory("send a gift card by mail");	
	}
	
	@Test
	public void searchAmazon() {
		MainPage mainPage = new MainPage();
		
		// Load Amazon's home page
		mainPage.load();
		
		// Search for "Java Books"
		List<SearchResultProduct> results = mainPage.search("Java Books");
		
		// Print information on the products
		for (SearchResultProduct product : results) {
			LOGGER.info(product.toString());
		}
	}

	@Test
	public void listTodaysDeals() {
		TodaysDealsPage today = new TodaysDealsPage();
		
		// Load "Today's Deals"
		today.load();

		// Print information on the products
		for (TodaysDealProduct product : today.getProducts()) {
			LOGGER.info(product.toString());
		}
	}
}
