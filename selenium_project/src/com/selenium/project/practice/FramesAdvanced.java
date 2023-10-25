package com.selenium.project.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesAdvanced {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//go to leaf ground frames page
		
		driver.get("https://www.leafground.com/frame.xhtml");
		
		driver.switchTo().frame(0);
		WebElement button1Element = driver.findElement(By.id("Click"));
		button1Element.click();
		
		
		String afterClickingString = button1Element.getText();
		System.out.println(afterClickingString);
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(2);
		driver.switchTo().frame("frame2");
		//driver.switchTo().frame(driver.findElement(By.id("frame2")));
		
		WebElement button2Element = driver.findElement(By.id("Click"));
		button2Element.click();
		
		
		driver.switchTo().defaultContent();
		
		List<WebElement> totalIframElements = driver.findElements(By.tagName("iframe"));
		int sizeOIframe =   totalIframElements.size();
		System.out.println("Total Number of Frames : "+sizeOIframe);
		
		driver.close();
		
	}

}
