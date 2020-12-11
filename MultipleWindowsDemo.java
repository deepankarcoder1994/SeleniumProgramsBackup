import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindowsDemo {
	
	/**
	 * @author deepankars
	 * Date - 25/11/2020
	 */
	
	/*
	 * By Default selenium will stick to the parent window only.
	 * If you want to do some work in Child Window you have to deliberately switch to 
	 * child window.
	 */

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Personal_docs\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://accounts.google.com/signup");
		driver.findElement(By.xpath("//a[contains(text(),'Help')]")).click();
		//It will print parent window title as by default selenium will stick to parent window only.
		System.out.println("Before Switching");
		System.out.println(driver.getTitle());
			
		//Code to get all the windows currently opened and switch to desired child window by grabbing the id for child window.
		Set<String> ids =driver.getWindowHandles();
		Iterator<String> it = ids.iterator(); 
		String parentid = it.next();
		String childid = it.next();
		driver.switchTo().window(childid);
		System.out.println("After Switching");
		//Now It will print Child window title
		System.out.println(driver.getTitle());
		
		//Let us switch back again to parent window
		driver.switchTo().window(parentid);
		System.out.println(driver.getTitle());
	}

}
