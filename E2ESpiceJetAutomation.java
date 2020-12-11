import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

/*
 * 
 * Spicejet website ticket booking homepage fully automated
 */

public class E2ESpiceJetAutomation {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Personal_docs\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://spicejet.com/");

		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();

		// Source and Destination City Selector Code
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("(//a[contains(text(),'Bengaluru')])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[contains(text(),'Chennai ')])[2]")).click();

		// DepartDate Locator
		// .ui-state-default.ui-state-highlight.ui-state-active
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();

		// Return date disbaled code

		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) {
			System.out.println("It's disabled");
			Assert.assertTrue(true);
		} else {

			Assert.assertTrue(false);
		}

		// Selecting Number of passengers Code
		driver.findElement(By.id("divpaxinfo")).click();
		Select s = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult")));
		s.selectByValue("6");

		// Clicking senior citizen checkbox in the UI
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();

		// Selecting the Currency from Currency Dropdown
		Select s1 = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
		// Select by Value
		s1.selectByValue("INR");

		// Now click on Search Button
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_btn_FindFlights']")).click();
	}

}
