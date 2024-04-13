package com.selenium.project.practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnLocators {

	public static void main(String[] args) throws InterruptedException {
		//We can locate the element using locators
		//Different types of locators
		//ID,NAME, CLass, linked Text, Partial linked text
		//Inspect the element and find the locator and then give it in code and access it
		//Example : When a teacher wants to distribute exam paper after correction teacher will locate the students using their id's 
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.manage().window().maximize();
		driver.get("https://demoqa.com/automation-practice-form");

		String parentWindowString = driver.getWindowHandle();

		System.out.println("Parent window "+parentWindowString);

		//Locators -> find element by => ID
		driver.findElement(By.id("firstName")).sendKeys("Jaya Shree");
		//Thread.sleep(5000);

		String firestNameString =  driver.findElement(By.id("firstName")).getAttribute("value");
		System.out.println("First name is "+firestNameString);
		driver.findElement(By.id("firstName")).clear();
		//Thread.sleep(5000);

		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://demoqa.com/links");
		driver.findElement(By.linkText("Home")).click();

		Thread.sleep(5000);
		//
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://demoqa.com/links");
		//	driver.findElement(By.partialLinkText("HomeVCQww")).click(); // it will be keepon changing so we need to go to dynamic xpath


		//Handling multiple windows

		Thread.sleep(3000);

		Set<String> openedWindowSet = driver.getWindowHandles();

		for(String windowString : openedWindowSet) {

			if(windowString.equals(parentWindowString)) {
				driver.switchTo().window(parentWindowString);
			}
		}

		System.out.println(openedWindowSet);


		//driver.close();

	}

}
