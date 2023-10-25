package com.selenium.project.interviewquestions;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActiveElementIQ {

	public static void main(String[] args) throws AWTException, IOException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions chromeOptions = new ChromeOptions();
		
		chromeOptions.addArguments("--headless","--start-maximized"); //not to open the window
		//chromeOptions.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(chromeOptions);
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

		driver.navigate().to("https://www.google.com/");
		
		////New switch to active elements 
		driver.switchTo().activeElement().sendKeys("Tirunelveli \n");
		
		System.out.println("Current Window Title "+driver.getTitle());
		
		//Reload a page twice 
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("location.reload()");//history.go(0)
		javascriptExecutor.executeScript("history.go(0)");
	
		/*	Robot robot = new Robot();
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rectangle = new Rectangle(dimension);
		BufferedImage image = robot.createScreenCapture(rectangle);
		File destinationFile = new File("C:\\Users\\lap\\Pictures\\Camera Roll\\TirunelveliScreenshots.jpg");
		ImageIO.write(image, "jpg", destinationFile);*/
		
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("C:\\Users\\lap\\Pictures\\Camera Roll\\TirunelveliScreenshots.jpg"); 
		FileHandler.copy(srcFile, destFile);
		
		
		driver.quit();	
		
		
		
	}

}
