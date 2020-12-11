import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ParentChildRelationshipLocator {
	/*
	 * When you have multiple instances of a xpath in your webpage then identify the parent so that it will refer your element based on
	 * the parent and identify it quickly
	 * Syntax is 
	 * parent xpath child xpath
	 * 
	 * For ex => //div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //input[@value='Bengaluru (BLR)']
	 * 
	 */

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Personal_docs\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://spicejet.com/");
		//Chennai xpath
		//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //input[@value='Chennai (MAA)']
		//bengaluru xpath
		//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //input[@value='Bengaluru (BLR)']
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("(//a[contains(text(),'Bhopal')])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[contains(text(),'Shirdi ')])[2]")).click();
	}

}
