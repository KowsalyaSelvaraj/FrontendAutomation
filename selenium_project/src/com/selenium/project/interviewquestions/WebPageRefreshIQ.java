package com.selenium.project.interviewquestions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebPageRefreshIQ {

	public static void main(String[] args) throws AWTException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();


		driver.get("https://www.google.com/");

		driver.findElement(By.name("q")).sendKeys("Doll"+Keys.ENTER);

		//using Get method
		driver.get(driver.getCurrentUrl());
		System.out.println("Refreshed Using Get method");

		//using refresh method
		driver.navigate().refresh();
		System.out.println("Refreshed using Refresh method");

		//using JavaScript
		WebElement searchElement = driver.findElement(By.name("q"));
		searchElement.clear();
		searchElement.sendKeys("horse"+Keys.ENTER);
//		searchElement.click();


		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("location.reload()");//history.go(0);
		System.out.println("Refreshed using JS method");
		
		//Refresh with Robot class
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_F5);
		robot.keyRelease(KeyEvent.VK_F5);
		System.out.println("Refreshed using Robot method");






















		driver.quit();
	}

}
