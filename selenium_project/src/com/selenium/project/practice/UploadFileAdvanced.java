package com.selenium.project.practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.fasterxml.jackson.databind.PropertyNamingStrategy.UpperCamelCaseStrategy;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadFileAdvanced {

	public static void main(String[] args) throws InterruptedException, AWTException {


		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		try{

			driver.manage().window().maximize();

			driver.get("https://www.google.co.in/imghp?hl=en&ogbl");

			WebElement uploadButtonElement = driver.findElement(By.xpath("//img[@class='Gdd5U']"));
			uploadButtonElement.click();

			driver.findElement(By.xpath("//*[@id='ow7']/div[3]/c-wiz/div[2]/div/div[3]/div[2]/div/div[2]/span")).click();



			StringSelection selection = new StringSelection("C:\\Users\\lap\\Downloads\\TestLeaf Logo.png");

			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

			Robot robot = new Robot();

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);

			Thread.sleep(3000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			Thread.sleep(3000);



		} catch (Exception e) {
			//TODO: handle exception
		}

		finally {
			driver.close();
		}

	}

}
