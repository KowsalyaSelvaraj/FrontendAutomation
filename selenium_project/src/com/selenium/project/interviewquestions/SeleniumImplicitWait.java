package com.selenium.project.interviewquestions;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumImplicitWait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		//open Chrome Driver
		WebDriver driver = new ChromeDriver();

		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.navigate().to("https://phptravels.com/");
		
		String parentWindowString = driver.getWindowHandle();
		

		WebElement loginElement = driver.findElement(By.xpath("//a[text()='Login']"));
		loginElement.click();

		Set<String> allWindowStrings = driver.getWindowHandles();

		for (String window : allWindowStrings) {
			
			if(!window.equalsIgnoreCase(parentWindowString))
			{
				driver.switchTo().window(window);
				break;
			}
		}
		
		WebElement emailElement = driver.findElement(By.id("inputEmail"));
		
		emailElement.sendKeys("kowsalya@gmail.com");
		
		WebElement passwordElement = driver.findElement(By.name("password"));
		passwordElement.sendKeys("kowsalya");
		
		WebElement viewPassElement = driver.findElement(By.xpath("//i[@class='fas fa-eye']/parent::button"));
		viewPassElement.click();
		
		WebElement loginButtonElement = driver.findElement(By.xpath("//div[@class='float-left']/child::button"));
		loginButtonElement.click();
		
		
		WebElement errorMessagElement = driver.findElement(By.xpath("//div[contains(text(),'complete the captcha')]"));
		String messageString =   errorMessagElement.getText();
		
		boolean errorMessage =  errorMessagElement.isDisplayed();
		
		if (errorMessage) {
			System.out.println("Error Message Printed is   : "+messageString);
		}
		else {
			System.out.println("No error message");
		}
		
		driver.quit();
		
	}

}
