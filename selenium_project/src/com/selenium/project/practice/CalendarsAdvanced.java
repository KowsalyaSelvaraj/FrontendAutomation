package com.selenium.project.practice;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.devtools.v112.css.model.CSSStyleSheetHeader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarsAdvanced {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		//Selenium to capture Logs in the mentioned file. 
		File targetFile = new File("C:\\Users\\LENOVO\\git\\FrontendAutomation\\selenium_project\\logfiles\\captureLog.log");
		ChromeDriverService service = new ChromeDriverService.Builder().withLogFile(targetFile).build();

		//open Chrome Driver
		WebDriver driver = new ChromeDriver(service);

		//Set the Dimension of the window to 1920, 2210
		driver.manage().window().setSize( new Dimension(1920,2210));

		driver.navigate().to("https://jqueryui.com/datepicker/");

		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		
		Thread.sleep(3000);
		//Click on datepicker text box
		WebElement calenderElement = driver.findElement(By.id("datepicker"));
		calenderElement.click();

		Thread.sleep(3000);
		//click on Next button in calendar
		WebElement nextElement = driver.findElement(By.xpath("//a[@title='Next']"));
		nextElement.click();

		Thread.sleep(3000);
		//select the date
		WebElement dateElement = driver.findElement(By.xpath("//a[text()='10']"));
		dateElement.click();

		System.out.println("Selected Date is => "+calenderElement.getAttribute("value"));


		driver.switchTo().defaultContent();

		driver.quit();
	}

}
