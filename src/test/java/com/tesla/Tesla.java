package com.tesla;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Tesla {

	@Test
	public void AutoPilot() {
		System.out.println("Test is starting");
		// Create driver
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		sleep(3000);

		driver.manage().window().maximize();

		// open the page
		String url = "https://www.tesla.com/en_CA";
		driver.get(url);
		WebElement models = driver
				.findElement(By.xpath("./html//div[@id='product-models']//div[@class='hide-on-mobile']/a[@title='Build your own Model S']"));
		models.click();
		//sleep(2000);
		//System.out.println("Page is opened");

		// scroll to cash table
		WebElement Elementt = driver.findElement(By.id("summary-header"));
		sleep(3000);
		// This will scroll the page till the element is found
		js.executeScript("arguments[0].scrollIntoView();", Elementt);
		//System.out.println("scroll to cash");

		// click on Cash
		WebElement cashclick = driver
				.findElement(By.xpath("//*[@id=\"summary-lease-cash-wrapper\"]/ul/li[3]/a[contains(text(),'Cash')]"));
		cashclick.click();
		//sleep(4000);
		//System.out.println("click on cash");

		// Check cash price
		String initialcashvalue = driver.findElement(By.xpath(".//*[@id=\"cash\"]/div[3]/div[2]/h2")).getText();
		sleep(3000);
		// String initialcashvalue1 = initialcashvalue.getText();
		System.out.println("initialcashvalue =" + initialcashvalue);
		

		// scroll to auto pilot
		// Find element by link text and store in variable "Element"
		WebElement Element = driver.findElement(By.id("options_category_C_OPTS"));
		sleep(3000);
		// This will scroll the page till the element is found
		js.executeScript("arguments[0].scrollIntoView();", Element);
		//sleep(4000);
		//System.out.println("scrolled");

		// put check mark
		WebElement checkmark = driver.findElement(By.className("container-checkbox"));
		checkmark.click();
		//sleep(4000);
		//System.out.println("click auto pilot");
		
		//cost of auto pilot
		String costauto = driver.findElement(By.xpath(".//*[@id=\"options_category_C_OPTS\"]/div/div[1]/div/div/div[2]/div[2]/div[2]/h4[1]")).getText();    
		//sleep(4000);
		System.out.println("cost of auto pilot=" + costauto);
		

		// Check cash price again
		String finalcashvalue = driver.findElement(By.xpath(".//*[@id=\"cash\"]/div[3]/div[2]/h2")).getText();
		sleep(3000);
		// String initialcashvalue1 = initialcashvalue.getText();
		System.out.println("finalcashvalue =" + finalcashvalue);
		
		

		// Close browser
		driver.quit();

	}

	/**
	 * @author Shabab Zaman static sleep
	 */

	private void sleep(long milllis) {
		try {
			Thread.sleep(milllis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
