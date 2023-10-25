package com.selenium.project.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
//import org.testng.xml.LaunchSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownSelectablePractise {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();

		//launch web browser and maximize
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		//launch the url dropdown 
		driver.get("https://www.leafground.com/select.xhtml");

		//select a dropDown Value
		WebElement dropDownVisibleTestElement = driver.findElement(By.className("ui-selectonemenu"));
		Select select = new Select(dropDownVisibleTestElement);
		select.selectByVisibleText("Selenium");
		Thread.sleep(5000);
		dropDownVisibleTestElement.sendKeys("Playwright");


		List<WebElement> listOfOptions = select.getOptions();
		int numberOfItems = listOfOptions.size();
		System.out.println("Number of Options: "+numberOfItems );


	}

}
