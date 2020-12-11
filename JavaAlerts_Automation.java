import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * If you want to click ok in alert box then use accept() method
 * 
 * If you want to click Cancel in alert box then use dismiss() method
 */

public class JavaAlerts_Automation {

	public static void main(String[] args) throws InterruptedException {
		String text = "Deepankar Sharma";
		System.setProperty("webdriver.chrome.driver", "D:\\Personal_docs\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.xpath("//input[@name='enter-name']")).sendKeys(text);
		driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
		System.out.println(driver.switchTo().alert().getText());
		Thread.sleep(3000);
		// method for switching the context from Driver Browser to Alert and
		// accepting the alert
		driver.switchTo().alert().accept();

		// Clicking on Confirm Button
		driver.findElement(By.xpath("//input[@value='Confirm']")).click();
		System.out.println(driver.switchTo().alert().getText());
		// method for switching the context from Driver Browser to Alert and
		// accepting the alert
		Thread.sleep(3000);
		driver.switchTo().alert().dismiss();
	}

}
