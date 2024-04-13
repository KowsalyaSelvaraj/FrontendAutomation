package com.selenium.project.interviewquestions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EnterActionIQ {

	public static void main(String[] args) throws IOException, AWTException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com/");
		
		//Keys.Enter
		WebElement searchBoxElement = driver.findElement(By.name("q"));
		searchBoxElement.sendKeys("Trichy"+Keys.ENTER);
		
		System.out.println("Current url is in trichy : "+driver.getTitle());
		
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File trichySourceFile =  screenshot.getScreenshotAs(OutputType.FILE);
		File trichyDestinationFile = new File("C:\\Users\\lap\\Pictures\\Camera Roll\\TrichyScreenshot.jpg");
		FileHandler.copy(trichySourceFile, trichyDestinationFile);
		
/*		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_T);
		robot.keyRelease(KeyEvent.VK_T);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		
		String parentwindowString = driver.getWindowHandle();
		
		Set<String> allWindowSet = driver.getWindowHandles();
		
		for (String string : allWindowSet) {
			
			if(!string.equals(parentwindowString))
			{
				driver.switchTo().window(string);
				break;
			}
		}*/
		
		//Submit
		driver.get("https://www.google.com/");
		WebElement searchBoxElement1 = driver.findElement(By.name("q"));
		searchBoxElement1.sendKeys("Chennai");
		searchBoxElement1.submit();
		
		System.out.println("Current url is in Chennai  : "+driver.getTitle());
		
		TakesScreenshot screenshot1 = (TakesScreenshot) driver;
		File trichySourceFile1 =  screenshot1.getScreenshotAs(OutputType.FILE);
		File trichyDestinationFile1 = new File("C:\\Users\\lap\\Pictures\\Camera Roll\\ChennaiScreenshot.jpg");
		FileHandler.copy(trichySourceFile1, trichyDestinationFile1);
		
		
		//Robot key press key release 
		driver.get("https://www.google.com/");
		WebElement searchBoxElement2 = driver.findElement(By.name("q"));
		searchBoxElement2.sendKeys("Madurai");
		
		Robot robot2 = new Robot();
		robot2.keyPress(KeyEvent.VK_ENTER);
		robot2.keyRelease(KeyEvent.VK_ENTER);
		System.out.println("Current URL is in Madurai : "+driver.getTitle());
		
		TakesScreenshot screenshot2   = (TakesScreenshot) driver;
		File trichySourceFile2 =  screenshot2.getScreenshotAs(OutputType.FILE);
		File trichyDestinationFile2 = new File("C:\\Users\\lap\\Pictures\\Camera Roll\\MaduraiScreenshot.jpg");
		FileHandler.copy(trichySourceFile2, trichyDestinationFile2);
		
		// Submit with /n 
		driver.get("https://www.google.com/");
		WebElement searchBoxElement3 = driver.findElement(By.name("q"));
		searchBoxElement3.sendKeys("."
				+ "");
		System.out.println("Current URL is in Coimbatore : "+driver.getTitle());
		
		TakesScreenshot screenshot3 = (TakesScreenshot) driver;
		File comFile =  screenshot3.getScreenshotAs(OutputType.FILE);
		File desFile = new File("C:\\Users\\lap\\Pictures\\Camera Roll\\Coimbatore.jpg");
		FileUtils.copyFile(comFile, desFile); 

		
		
		driver.quit();
		
		
		
		
		
		
		
		
	}

}
