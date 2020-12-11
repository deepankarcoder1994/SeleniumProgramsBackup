import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


/*
 * 
 * Assertions Demo
 */

public class Assertions_Demo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Personal_docs\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://spicejet.com/");
		//assertFalse() method accepts the false statement in the Argument.
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
		//assertTrue() method accepts the True statement in the Argument.
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		//Count the Number of Checkboxes code
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());

	}

}
