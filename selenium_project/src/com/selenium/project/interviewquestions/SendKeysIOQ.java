package com.selenium.project.interviewquestions;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SendKeysIOQ {
   
	static WebElement q;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		SendKeysIOQ sendKeysIOQ = new SendKeysIOQ();
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		
		WebDriver driver = new ChromeDriver(chromeOptions);
		
		PageFactory.initElements(driver, SendKeysIOQ.class);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		
		//1. Send Keys with send keys method
		driver.navigate().to("https://www.google.com/");
		q.sendKeys("Different varaities Banana Fruit \n");
		
		sendKeysIOQ.takeScreenShotMethod("Banana",screenshot);
		sendKeysIOQ.getUrlOfCurrentWindow(driver);
	
		//2.Send Keys with javascript Executor document
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		
		driver.navigate().to("https://www.google.com/");
		executor.executeScript("document.getElementsByName('q')[0].value='Mango Fruit'");
		q.submit();
		sendKeysIOQ.takeScreenShotMethod("Mango",screenshot);
		sendKeysIOQ.getUrlOfCurrentWindow(driver);
		
		
		//3. Send Keys with Java script with arguments
		driver.navigate().to("https://www.google.com/");
		executor.executeScript("arguments[0].value='Apple Fruite'",q);
		q.submit();
		sendKeysIOQ.takeScreenShotMethod("Apple",screenshot);
		sendKeysIOQ.getUrlOfCurrentWindow(driver);
		
		driver.quit();
	}
	
	public void takeScreenShotMethod(String fruitsName,TakesScreenshot screenshot) throws IOException {
		
		File srcFile =  screenshot.getScreenshotAs(OutputType.FILE);
		File desFile = new File("C:\\Users\\lap\\Pictures\\"+fruitsName+".jpg");
		FileHandler.copy(srcFile, desFile);	
		
		
	}
	
	public void getUrlOfCurrentWindow(WebDriver driver) {
		
		System.out.println(driver.getCurrentUrl());
	}

}
