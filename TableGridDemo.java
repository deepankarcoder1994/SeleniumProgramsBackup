import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * 
 * @deepankars
 * Date-- 06/12/2020
 */

/*
 * Automating Cricbuzz website
 * 
 */

public class TableGridDemo {

	public static void main(String[] args) {
		int sum = 0;
		System.setProperty("webdriver.chrome.driver", "D:\\Personal_docs\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(
				"https://www.cricbuzz.com/live-cricket-scorecard/31918/jst-vs-kdt-8th-match-lanka-premier-league-2020");
		
       //Concept No 1. How to take WebElement as a section and placing instead of driver
		WebElement table = driver.findElement(By.cssSelector("div[class='cb-col cb-col-100 cb-ltst-wgt-hdr']"));
		int rowcount = table.findElements(By.cssSelector("cb-col cb-col-100 cb-scrd-itms")).size();
		
		// Concept 2.Traversing to the third child of the parent to grab only the runs scored by a
		// Individual Player.
		int count = table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)"))
				.size();

		for (int i = 0; i < count - 2; i++) {

			String value = table
					.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).get(i)
					.getText();
			// Converting String into Integer
			int valueinteger = Integer.parseInt(value);
			sum = sum + valueinteger;
		}

		// System.out.println(sum);

		// Traversing from Extras to Numbers through following siblings concept
		String Extras = driver.findElement(By.xpath("//div[text()='Extras']/following-sibling::div")).getText();
		int extrasValue = Integer.parseInt(Extras);
		int TotalsumValue = sum + extrasValue;

		System.out.println(TotalsumValue);

		// traversing to total number through siblings concept again
		String ActualTotal = driver.findElement(By.xpath("//div[text()='Total']/following-sibling::div")).getText();
		int ActualTotalValue = Integer.parseInt(ActualTotal);
		//Comparing both the totals
		if(ActualTotalValue == TotalsumValue) {
			System.out.println("Count Matches");
		}else {
			System.out.println("Count fails");
		}
	}

}
