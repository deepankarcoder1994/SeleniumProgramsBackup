import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


/*
 * 
 * @deepankars
 * Date-- 06/12/2020
 */

//Goal of below Program
//Enter the letters Beng
//Verify if Airport option is displayed in the auto suggestive box.

public class JavaScriptDOM {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Personal_docs\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.ksrtc.in");
		
		driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys("BENG");
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.DOWN);
		
		
		// By normal xpath traversal we are not able to retrieve the Text
		System.out.println(driver.findElement(By.xpath("//input[@id='fromPlaceName']")).getText());
		

		// Javascript DOM can extract hidden elements
		// because selenium cannot identify hidden elements -( AJAX implementation)
		// Investigate the properties of Object if it has hidden text

		// JavaScriptExecutor Syntax

		JavascriptExecutor js = (JavascriptExecutor) driver;
		String script = "return document.getElementById(\"fromPlaceName\").value;";
		String text = (String) js.executeScript(script);
		System.out.println(text);
		int i=0;
		//	BENGALURU INTERNATION AIRPORT
		while(!text.equalsIgnoreCase("BENGALURU INTERNATIO AIRPORT")) {
			i++;
			driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.DOWN);
			text = (String) js.executeScript(script);	
			System.out.println(text);
			if(i>10) {
				break;
			}
		}
		
		if(i>10) {
			System.out.println("Element not found");
		}else {
			System.out.println("Element is found");
		}
	}

}
