import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;


/*
 * 
 * @deepankars
 * Date-- 06/12/2020
 */

public class SSLCertificationsDemo {

	public static void main(String[] args) {
		
		//General chrome profile
		//Desired capabilities
		DesiredCapabilities ch =DesiredCapabilities.chrome();
		//Handling both SSL and Insecure Certifications
		ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		ch.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		
		//Merging desiredcapabilities to your local browser
		ChromeOptions c = new ChromeOptions();
		c.merge(ch);
		
		System.setProperty("webdriver.chrome.driver", "D:\\Personal_docs\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(c);
		driver.get("https://www.ksrtc.in"); // any site having ssl certifications can be added
	}

}
