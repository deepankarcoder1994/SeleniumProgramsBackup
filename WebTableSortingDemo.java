import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WebTableSortingDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Personal_docs\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		// Algorithm to Implement this

		// Click on Column
		driver.findElement(By.xpath("//tr/th[1]")).click();

		// Capture all the WebElements into list
		List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));

		// Capture text of all WebElements into new(original) List by using Java Streams
		List<String> originalList = elementsList.stream().map(s -> s.getText()).collect(Collectors.toList());

		// Sort on the original list of step3 -> sorted list by using Java Streams
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());

		// compare the original list vs sorted list
		Assert.assertTrue(originalList.equals(sortedList));
		List<String> price;

		// Test case => Scan the name column with getText -> Rice -> Print the price of
		// the vegetable.
		//Using customised methods and Pagination to Achieve this test case
		do {
			List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
			price = rows.stream().filter(s -> s.getText().contains("Rice")).map(s -> getPriceVeggie(s))
					.collect(Collectors.toList());
			// to print all the elements in the list
			price.forEach(a -> System.out.println(a));
			if (price.size() < 1) {
				driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
			}
		} while (price.size() < 1);

	}

	// Implementing the custom method to print the price of selected vegetable
	private static String getPriceVeggie(WebElement s) {
		String pricevalue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return pricevalue;
	}

}
