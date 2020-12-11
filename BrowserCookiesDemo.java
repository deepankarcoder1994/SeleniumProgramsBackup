import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * 
 * @deepankars
 * Date-- 06/12/2020
 */

/*
 * maximising window and deleting the cookies before execution.
 * Screenshot capturing demo in selenium
 * 
 */

public class BrowserCookiesDemo {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "D:\\Personal_docs\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//Maximising the window
		driver.manage().window().maximize();
		//Deleting the cookies
		driver.manage().deleteAllCookies();
		//You can delete one cookie as well.
		//driver.manage().deleteCookieNamed("sessionkey");
		driver.get("https://www.ksrtc.in");
		
		//Screenshot capturing program in Selenium
		File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("D://screenshot.png"));

	}

}
