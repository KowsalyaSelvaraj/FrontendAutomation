package com.selenium.project.practice;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertPractise {

	public static void main(String[] args) throws AWTException, IOException, InterruptedException {

		WebDriverManager.chromedriver().setup();
		
		//Selenium to capture Logs in the mentioned file. 
		File targetFile = new File("C:\\Users\\LENOVO\\git\\FrontendAutomation\\selenium_project\\logfiles\\captureLog.log");
		ChromeDriverService service = new ChromeDriverService.Builder().withLogFile(targetFile).build();
		
		
		WebDriver driver = new ChromeDriver(service);

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//
		driver.get("https://www.leafground.com/alert.xhtml");

		//Click on alert 
		WebElement clickonElement = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt91']/span[2]"));
		clickonElement.click();

		//take screenshot of alert 
		//Note : Full Windows screenshot will be taken
		//As control is not with web driver
		Robot robot = new Robot();
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rectangle = new Rectangle(dimension);
		BufferedImage bufferedImage = robot.createScreenCapture(rectangle);
		File desFile = new File("C:\\Users\\LENOVO\\git\\FrontendAutomation\\selenium_project\\DownloadedFiles\\SimpleAlert.jpg");
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
		//take screenshot of alert 
		//Note : Full Windows screenshot will be taken
		//As control is not with web driver
		Robot robot1= new Robot();
		Dimension dimension2 = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rectangle2 = new Rectangle(dimension2);
		BufferedImage imagesourceBufferedImage = robot1.createScreenCapture(rectangle2);
		File confirmationFile = new File("C:\\Users\\LENOVO\\git\\FrontendAutomation\\selenium_project\\DownloadedFiles\\ConfirmationPopup.jpg");
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

		//Take screenshot using TakesScreenshot as screenshot is taken by web driver
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File srcFile =  screenshot.getScreenshotAs(OutputType.FILE);
		File desFile2 = new File("C:\\Users\\LENOVO\\git\\FrontendAutomation\\selenium_project\\DownloadedFiles\\SweetAlert.jpeg");
		FileHandler.copy(srcFile, desFile2);


		WebElement dismissElement = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt98']"));
		dismissElement.click();
		System.out.println("Clicked on Sweet Window Alert");

		
		driver.close();

	}

}
