package com.selenium.project.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenChromeBrowser {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\lap\\Desktop\\KOWSALYA\\Selenium Training\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
        
		//Open Web Browser Chrome 
		//launch google.com
		WebDriver driverChrome = new ChromeDriver();
		
		driverChrome.manage().window().maximize();
		driverChrome.get("https://www.google.com/");
		Thread.sleep(1000);
		driverChrome.close();
		
		//Open Web Browser Chrome 
		//launch google.com
		WebDriverManager.firefoxdriver().setup();
		WebDriver driverFirefox = new FirefoxDriver();
				
		driverFirefox.manage().window().maximize();
		driverFirefox.get("https://www.google.com/");
		Thread.sleep(1000);
		driverFirefox.close();		
		
	}

}
