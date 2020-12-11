import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/*
 * Below Code runs the Test Cases on Node Machine configured in previous lecture.
 * 
 */

public class SeleniumGridDemo {

	public static void main(String[] args) throws MalformedURLException {
		//DesiredCapabilities
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName("chrome");
		dc.setPlatform(Platform.WINDOWS);
		
		//We use RemoteWebDriver for Running the test case on remote machine(Node)
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),dc);
		driver.get("http://google.com");	
	}

}
