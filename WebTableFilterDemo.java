import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

/*
 * Checking whether the Web Table Filter is working properly
 * 
 */

public class WebTableFilterDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Personal_docs\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		driver.findElement(By.xpath("//input[@id='search-field']")).sendKeys("Rice");
		List<WebElement> veggies = driver.findElements(By.xpath("//tr/td[1]"));
		
		List filteredList = veggies.stream().filter(veggie->veggie.getText().contains("Rice")).
		collect(Collectors.toList());
		
		//Test case will pass when veggies list have the same content like filteredList
		Assert.assertEquals(veggies.size(), filteredList.size());
	}

}
