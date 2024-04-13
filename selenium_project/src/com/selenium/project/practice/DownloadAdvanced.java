package com.selenium.project.practice;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DownloadAdvanced {

	public static void main(String[] args) {
		

		String downloadPathString = "C:\\Users\\LENOVO\\git\\FrontendAutomation\\selenium_project\\DownloadedFiles";
		boolean isDownloaded = false;
		WebDriverManager.chromedriver().setup();


		//Setup Download directory to project path
		Map<String, Object> chromePreferencesMap = new HashMap<String,Object>();
		chromePreferencesMap.put("download.default_directory", downloadPathString);
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption("prefs", chromePreferencesMap);

		//Selenium to capture Logs in the mentioned file. 
		File targetFile = new File("C:\\Users\\LENOVO\\git\\FrontendAutomation\\selenium_project\\logfiles\\captureLog.log");
		ChromeDriverService service = new ChromeDriverService.Builder().withLogFile(targetFile).build();


		WebDriver driver = new ChromeDriver(service,chromeOptions);
		try {

			driver.manage().window().maximize();

			driver.get("https://www.leafground.com/file.xhtml");

			WebElement downloadElement = driver.findElement(By.id("j_idt93:j_idt95"));
			downloadElement.click();
			Thread.sleep(5000);

			File fileLocation = new File(downloadPathString);

			File[]  totalFiles = fileLocation.listFiles();

			for (File file : totalFiles) {

				if(file.getName().equals("TestLeaf Logo.png"))
				{
					System.out.println("File Successfully Downloaded");
					isDownloaded = true;
					break;
				}
			}
			
			if(!isDownloaded) {
				System.out.println("File not downloaded");
		
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			driver.close();
		}
	}

}
