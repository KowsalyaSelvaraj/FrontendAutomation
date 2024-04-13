package com.selenium.project.interviewquestions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollUpandDown {

	public static void main(String[] args) throws IOException, InterruptedException, AWTException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		
		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://echoecho.com/html.htm");
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		
		/*executor.executeScript("window.scroll(0,450)", "");
		
		
		TakesScreenshot screesnhoTakesScreenshot = (TakesScreenshot) driver;
		File srcFile = screesnhoTakesScreenshot.getScreenshotAs(OutputType.FILE);
		File desFile = new File("C:\\Users\\lap\\Pictures\\Camera Roll\\ScrollTo450.jpg");
		FileHandler.copy(srcFile, desFile);
		
		executor.executeScript("window.scroll(0,-450)", "");*/
		
		executor.executeScript("window.scrollTo(0,document.body.scrollHeight)","");
		Thread.sleep(2000);
		executor.executeScript("window.scrollTo(0,0)","");
		Thread.sleep(2000);
		
		driver.navigate().to("https://echoecho.com/applets.htm");
		//go to a particular element with scrolling
		WebElement element = driver.findElement(By.xpath("//a[text()='<< BACK TO MENU']"));
		executor.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(2000);
		
		//using robot class page up and down
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_PAGE_UP);
		robot.keyRelease(KeyEvent.VK_PAGE_UP);
		Thread.sleep(2000);
		
		
		driver.quit();
		
		
	
	}

}
