package com.selenium.project.practice;

import java.util.Set;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowsAdvanced {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.leafground.com/window.xhtml");

		String parentWindowString = driver.getWindowHandle();
		System.out.println(parentWindowString);

		//Shift to tabs and click on checkBox
		WebElement newTabElement = driver.findElement(By.id("j_idt88:new"));
		newTabElement.click();

		Set<String> totalTabSet = driver.getWindowHandles();

		for(String newTabString : totalTabSet)
		{
			if(!parentWindowString.equals(newTabString))
			{
				driver.switchTo().window(newTabString);
				System.out.println(newTabString);
				break;
			}
		}
		WebElement emailElement =  	driver.findElement(By.id("email"));
		emailElement.sendKeys("Kowsi.23kowsalya@gmail.com");
		
		driver.close();
		driver.switchTo().window(parentWindowString);
		
		//number of windows
		WebElement multipleWindoWebElement = driver.findElement(By.id("j_idt88:j_idt91"));
		multipleWindoWebElement.click();

		int numberOfWindow = driver.getWindowHandles().size();

		System.out.println("Number of Windows opened "+ numberOfWindow);

		//close except the default window
		WebElement closeElement = driver.findElement(By.id("j_idt88:j_idt93"));
		closeElement.click();

		Set<String> multipleWindowSet = driver.getWindowHandles();

		for(String windowString : multipleWindowSet)
		{
			if(!(windowString.equals(parentWindowString)))
			{
				driver.switchTo().window(windowString);
				driver.close();
			}
		}

		driver.switchTo().window(parentWindowString);

		driver.quit();
	}

}
