import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CalenderUIAutomation {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Personal_docs\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://spicejet.com/");
		
		//Source and Destination City Selector
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("(//a[contains(text(),'Bhopal')])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[contains(text(),'Shirdi ')])[2]")).click();
		
		
		       //DepartDate Locator
			  //.ui-state-default.ui-state-highlight.ui-state-active
		  driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
		  
		  //Click one of the checkboxes
		  driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
		  
		 
		  
		  //Validating if UI elements are disabled or enabled with Attributes
		  
		  driver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_1']")).click();
		  if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1")){
			  System.out.println("It's enabled");
			  Assert.assertTrue(true);
		  }else{
			  
			  Assert.assertTrue(false);
		  }
		  
		  
	}

}
