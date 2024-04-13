package com.selenium.project.practice;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoCompleteAdvanced {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		//Selenium to capture Logs in the mentioned file. 
		File targetFile = new File("C:\\Users\\LENOVO\\git\\FrontendAutomation\\selenium_project\\logfiles\\captureLog.log");
		ChromeDriverService service = new ChromeDriverService.Builder().withLogFile(targetFile).build();

		WebDriver driver = new ChromeDriver(service);
		try {

			driver.manage().window().maximize();

			driver.get("https://www.google.com/");

			WebElement searchBoxElement = driver.findElement(By.name("q"));
			searchBoxElement.sendKeys("scho");

			Thread.sleep(5000);
			List<WebElement> listOfElements = driver.findElements(By.xpath("//*[@name='q']//following::ul[@role='listbox']/li"));

			System.out.println("Number of details shown "+listOfElements.size());

			for(WebElement textElement : listOfElements)
			{
				if(textElement.getText().equals("school"))
				{
					textElement.click();
					break;
				}
			}
		}
		catch (Exception e) {
			System.out.println("Exception is "+e);
		}
		finally {

			driver.quit();
		}
	}

}
