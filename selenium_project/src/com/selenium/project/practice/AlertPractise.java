package com.selenium.project.practice;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
//import java.util.logging.FileHandler;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.logging.log4j.message.EntryMessage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertPractise {

	public static void main(String[] args) throws AWTException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//
		driver.get("https://www.leafground.com/alert.xhtml");
		
		//Click on alert 
		WebElement clickonElement = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt91']/span[2]"));
		clickonElement.click();
		
		Robot robot = new Robot();
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rectangle = new Rectangle(dimension);
		BufferedImage bufferedImage = robot.createScreenCapture(rectangle);
		File desFile = new File("C:\\Users\\lap\\Pictures\\Camera Roll\\SimpleAlert.jpg");
		ImageIO.write(bufferedImage, "jpg", desFile);
		
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		WebElement alertMessagElement = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt91']//following::span[@id='simple_result']"));
		String message1 = alertMessagElement.getText();
		System.out.println("Alert (Simple Dialog) "+message1);
		
		//Click on Confirmation alert yes or no 
		WebElement clickonConfirmBoxElement = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt93']/span[2]"));
		clickonConfirmBoxElement.click();
		
		Thread.sleep(3000);
		Robot robot1= new Robot();
		Dimension dimension2 = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rectangle2 = new Rectangle(dimension2);
		BufferedImage imagesourceBufferedImage = robot1.createScreenCapture(rectangle2);
		File confirmationFile = new File("C:\\Users\\lap\\Pictures\\Camera Roll\\ConfirmationPopup.jpg");
		ImageIO.write(imagesourceBufferedImage, "jpg", confirmationFile);
		
		Alert alertConfAlert = driver.switchTo().alert();
		alertConfAlert.dismiss();
		
		WebElement confirmMessagElement = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt93']//following::span[@id='result']"));
		String message2 = confirmMessagElement.getText();
		System.out.println("Alert (Confirm Dialog) "+message2);
		
		//Click on Prompt box
		WebElement clickOnPromptElement = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt104']/span[2]"));
		clickOnPromptElement.click();
		
		Alert promptAlert = driver.switchTo().alert();
		promptAlert.sendKeys("Its glad to meet you");
		promptAlert.accept();
		
		//sweet alert 
		WebElement sweetAlertSimpleDialogElement = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt95']"));
		sweetAlertSimpleDialogElement.click();
		
		
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File srcFile =  screenshot.getScreenshotAs(OutputType.FILE);
		File desFile2 = new File("C:\\Users\\lap\\Pictures\\Camera Roll\\SweetAlert.jpeg");
		FileHandler.copy(srcFile, desFile2);
		
		
		WebElement dismissElement = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt98']"));
		dismissElement.click();
		System.out.println("Clicked on Sweet Window Alert");
		
		//Alert alert2 = driver.switchTo().alert();
		
//		alert2.dismiss();
		
		driver.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
