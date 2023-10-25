package com.selenium.project.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHeight;
import org.openqa.selenium.Point;

//import com.graphbuilder.curve.Point;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ButtonOperationsPractise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		//open Chrome Driver
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.leafground.com/button.xhtml");
		
		//position of a webElement
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
		
		driver.quit();
		
		
	}

}
