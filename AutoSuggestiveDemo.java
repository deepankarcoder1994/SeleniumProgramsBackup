import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestiveDemo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Personal_docs\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.redbus.in/");
		driver.findElement(By.id("src")).sendKeys("Be");
		Thread.sleep(3000);
		//xpath designed by myself using parent child syntax(//ul[@class='autoFill']/li)
		List<WebElement> options = driver.findElements(By.xpath("//ul[@class='autoFill']/li"));
		for(WebElement option :options){
			if(option.getText().equalsIgnoreCase("Bengaluru")){
				option.click();
				break;
			}
		}
		
		
		
		
		
		
		
		

	}

}
