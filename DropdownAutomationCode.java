import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


/*
 * Dropdown Automation => This code is only meant for static Dropdowns.
 * 
 */

public class DropdownAutomationCode {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Personal_docs\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("http://spicejet.com/");
			Select s = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
			//Select by Value
			s.selectByValue("USD");
			//Select by Index
			s.selectByIndex(0);
			//select by Text
			s.selectByVisibleText("AED");
	}

}
