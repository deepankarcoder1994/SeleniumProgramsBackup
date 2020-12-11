import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * 
 * Cart Automation as well as Implicit wait Concept
 */

public class ECommerceWebsite_Automation {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Personal_docs\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Declaring Array of Objects you want to Add in the Cart.
		String[] itemsNeeded = { "Cucumber", "Brocolli", "Beetroot", "Carrot" };
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		Thread.sleep(3000);
		addItems(driver, itemsNeeded);

		// AFter adding items to cart checking out code.
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//div[@class='cart-preview active']/div/button")).click();
		driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
		System.out.println(driver.findElement(By.xpath("//span[@class='promoInfo']")).getText());

	}

	// Method for Adding elements to a Cart.
	public static void addItems(WebDriver driver, String[] itemsNeeded) {
		int j = 0;
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < products.size(); i++) {
			// Format it to get actual Vegetable Name.
			// Splitting the name based on - and trimming one extra whitespace
			String[] name = products.get(i).getText().split("-");
			String formattedName = name[0].trim();
			// Check whether name you extracted is present in ArrayList or not?
			// Convert Array into ArrayList for easy Search
			List itemsNeededList = Arrays.asList(itemsNeeded);

			if (itemsNeededList.contains(formattedName)) {
				j++;
				// Click on Add to Cart
				// here we are first Identifying the Object having text as
				// Cucumber and Getting the text for Clicking on
				// Add to cart Button
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				// Check if 3 items are added.If yes then break from loop.
				if (j == itemsNeeded.length)
					break;
			}
		}
	}
}
