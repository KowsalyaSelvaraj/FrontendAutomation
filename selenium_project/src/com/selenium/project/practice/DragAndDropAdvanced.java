package com.selenium.project.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDropAdvanced {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//Go to Drag and Drop page
		driver.get("https://www.leafground.com/drag.xhtml");
		
		//Drag and Drop
		WebElement fromElement = driver.findElement(By.id("form:drag_content"));
		WebElement toElement = driver.findElement(By.id("form:drop_content"));
		
		Actions actions = new Actions(driver);
		
		//actions.clickAndHold(fromElement).moveToElement(toElement).release(toElement).build().perform();
		
		actions.dragAndDrop(fromElement, toElement).build().perform();
		
		
		
		driver.quit(); 
	}

}
