import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

/*
 * 
 * @deepankars
 * Date-- 06/12/2020
 */

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		System.setProperty("webdriver.chrome.driver", "D:\\Personal_docs\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Broken URL
		// Step 1: Get all URL's tied up to the links using selenium
		// Java methods will call those URL's and gets you the status code
		// if status code > 400 then that URL is not working => Link which is tied to
		// URL is broken
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		// Getting the list of all the footer links
		List<WebElement> links = driver.findElements(By.xpath("//li[@class='gf-li']/a"));

		// Creating an Object of SoftAssert Class so that all links should be scanned
		SoftAssert a = new SoftAssert();

		// Iterating through all the Links

		for (WebElement link : links) {

			String url = link.getAttribute("href");

			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();

			int respCode = conn.getResponseCode();
			System.out.println(respCode);
			// Below is soft Assertion.
			a.assertTrue(respCode < 400, "The Link with Text" + link.getText() + " is broken with code" + respCode);
		}

		a.assertAll();

	}

}
