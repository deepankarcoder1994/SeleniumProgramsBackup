import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) throws InterruptedException {
		//1.Give me the count of links on the page.
		System.setProperty("webdriver.chrome.driver", "D:\\Personal_docs\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//2.Give me the count of links on the footer section
		//Syntax of limiting the scope of Webdriver.
		WebElement footerdriver = driver.findElement(By.id("gf-BIG"));
	    System.out.println(footerdriver.findElements(By.tagName("a")).size());
	    
	    
	    //3.get the count of links only in the first column ie.Discount Coupons
	    WebElement columndriver = footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
	    System.out.println(columndriver.findElements(By.tagName("a")).size());
	    
	    //Please explain this to Interviewer as the optimization you did in project
	    
	    //4.Click on each link in the Column and check if the pages are opening.
	    for(int i=1;i<columndriver.findElements(By.tagName("a")).size();i++) {
	    	String clickonlinkTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
	    	columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
	    	Thread.sleep(5);
	    }//opens all the tabs
	    	
	    	//Code to Iterate to each and every tab and get the window title.
	    	Set<String> abc = driver.getWindowHandles();
	    	Iterator<String> it = abc.iterator();
	    	
	    	while(it.hasNext()) {
	    		//it.next() will print the window id 
	    		driver.switchTo().window(it.next());
	    		System.out.println(driver.getTitle());
	    	}
	    }
	}


