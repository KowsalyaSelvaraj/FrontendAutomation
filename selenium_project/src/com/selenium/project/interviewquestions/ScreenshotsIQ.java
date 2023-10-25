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
import java.util.logging.FileHandler;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
//import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotsIQ {

	public static void main(String[] args) throws IOException, AWTException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.navigate().to("https://www.leafground.com/alert.xhtml;jsessionid=node017fseuzt732a1r4v2kdasfpr1120314.node0");
		
		  
		TakesScreenshot screenshot =(TakesScreenshot) driver;
		File sourceFile =  screenshot.getScreenshotAs(OutputType.FILE);
		File targetFile = new File("C:\\Users\\lap\\Pictures\\Camera Roll\\sample.png");
		FileUtils.copyFile(sourceFile, targetFile); 
		//FileHandler.copy();
		
		//
		
		WebElement alertPromptDialogElement = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt104']"));
		alertPromptDialogElement.click();
		
		Robot robot = new Robot();
		
		Dimension screenSizeDimension = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rectangle = new Rectangle(screenSizeDimension);
		BufferedImage sourceImage = robot.createScreenCapture(rectangle);
		File destinationImageFile = new File("C:\\Users\\lap\\Pictures\\Camera Roll\\robotimage.png");
		ImageIO.write(sourceImage, "png", destinationImageFile);
				
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("hello Bro");
		alert.accept();
		
		WebElement extraMessage = driver.findElement(By.xpath("//span[@id='confirm_result']"));
		String messageString =  extraMessage.getText();
		System.out.println(messageString);
		
		//Robot robot1 = new Robot();
		Dimension screenSizeDimension1 = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rectangle1 = new Rectangle(screenSizeDimension1);
		BufferedImage sourceImage1 = robot.createScreenCapture(rectangle1);
		File destinationImageFile1 = new File("C:\\Users\\lap\\Pictures\\Camera Roll\\robotimage1.png");
		ImageIO.write(sourceImage1, "png", destinationImageFile1);
		
		
		driver.quit();
		
		
	}

}
