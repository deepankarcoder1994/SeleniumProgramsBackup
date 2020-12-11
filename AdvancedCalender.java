import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * 
 * @deepankars
 * Date-- 06/12/2020
 */

public class AdvancedCalender {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Personal_docs\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companions");
		//Suppose our target is to click on April 23 2021
		//grabbing all the days by xpath
	    Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='travel_date']")).click();
		
		//while loop will keep on executing untill it becomes false.
		//Selecting a month from calender Logic
		while(!driver.findElement(By.xpath("//div[@class='datepicker-days']/table/thead/tr/th[2]")).getText().contains("April")) {
			driver.findElement(By.xpath("//th[@class='next']")).click();
		}
		
		//getting all the days
		List<WebElement> dates = driver.findElements(By.className("day"));
		//Grab Common Attribute //Put it into the list and Iterate
		int count = driver.findElements(By.className("day")).size();
		//grabbing 30th date by iterating over all the days
		for(int i=0;i<count;i++) {
			String text = driver.findElements(By.className("day")).get(i).getText();
			if(text.equalsIgnoreCase("23")) {
				driver.findElements(By.className("day")).get(i).click();
				break;
			}
		}
		
	}

}
