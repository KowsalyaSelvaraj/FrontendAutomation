package com.selenium.project.practice;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
//import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHeight;
import org.openqa.selenium.Point;

//import com.graphbuilder.curve.Point;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ButtonOperationsPractise {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		//Selenium to capture Logs in the mentioned file. 
		File targetFile = new File("C:\\Users\\LENOVO\\git\\FrontendAutomation\\selenium_project\\logfiles\\captureLog.log");
		ChromeDriverService service = new ChromeDriverService.Builder().withLogFile(targetFile).build();

		//open Chrome Driver
		WebDriver driver = new ChromeDriver(service);

		driver.manage().window().maximize();

		driver.get("https://www.leafground.com/button.xhtml");

		//position of a webElement
		//get X and Y Co ordinate
		WebElement positionButtonElement = driver.findElement(By.id("j_idt88:j_idt94"));
		Point xypoint  = positionButtonElement.getLocation();
		int xValue = xypoint.getX();
		int yValue = xypoint.getY();
		System.out.println("X Co ordinate value "+ xValue+"\nY Co Ordinate Value "+yValue);

		//Get Color
		WebElement colorOfButtonElement = driver.findElement(By.id("j_idt88:j_idt96"));

		String colorString = colorOfButtonElement.getCssValue("background-color");
		System.out.println(colorString +" is the color of the button");


		//button size 
		WebElement sizeButtonElement = driver.findElement(By.id("j_idt88:j_idt98"));
		int hightOfButton =	sizeButtonElement.getSize().getHeight();
		int widthOfButton = sizeButtonElement.getSize().getWidth();
		System.out.println("Height of Button: "+hightOfButton+"\nWidth of Button: "+widthOfButton);

		//click on a button
		WebElement clickButtonElement = driver.findElement(By.id("j_idt88:j_idt90"));
		clickButtonElement.click();

		driver.close();


	}

}
