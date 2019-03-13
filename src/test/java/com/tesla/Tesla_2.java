package com.tesla;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Tesla_2 {

	@Test
	public void CarbonImpact() {
		System.out.println("Test is starting");
		// Create driver
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		sleep(3000);

		driver.manage().window().maximize();

		// open the page
		String url = "https://www.tesla.com/en_CA/carbonimpact";
		driver.get(url);
		sleep(2000);
		System.out.println("Page is opened");

		// scroll leader board 
		WebElement Elementt = driver.findElement(By.xpath(".//div[@id='root']//section[@class='app']/section[3]//li[.='world']")); 
		sleep(3000);
		// This will scroll the page till the element is found
		js.executeScript("arguments[0].scrollIntoView();", Elementt);
		System.out.println("view");

		// click on world
		WebElement cashclick = driver
				.findElement(By.xpath(".//*[@id=\"root\"]/div/section/section[3]/section[1]/ul/li[2]"));
		cashclick.click();
		sleep(4000);
		System.out.println("click on world");
		
		//verification
		String rCellValue = driver.findElement(By.xpath(".//*[@id=\"root\"]/div/section/section[3]/section[3]/section[2]/div[5]/span[1]")).getText();
		 System.out.println(rCellValue);
		
		 String cCellValue = driver.findElement(By.xpath(".//*[@id=\"root\"]/div/section/section[3]/section[3]/section[2]/div[5]/span[2]/span")).getText();
		 System.out.println(cCellValue);
		
		 if ( (rCellValue.equals("5") ) && ( cCellValue.equals("Canada")))
		 {
		 System.out.println("Test Passes");}
		
		 else{System.out.println("Canada is not #5 and Test Fails");}
		 
		
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
