import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropdownAutomation {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Personal_docs\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://spicejet.com/");
		//xpath for Chennai
		//input[@value='Chennai (MAA)']
		//xpath for Bengaluru
		//input[@value='Bengaluru (BLR)']
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		
		driver.findElement(By.xpath("//input[@class='select_CTXT valid']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='Chennai (MAA)'])[2]")).click();
	}

}
