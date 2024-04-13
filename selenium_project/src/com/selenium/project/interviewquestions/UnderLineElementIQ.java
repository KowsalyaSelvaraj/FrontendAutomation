package com.selenium.project.interviewquestions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UnderLineElementIQ {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		
		WebDriver driver = new ChromeDriver(options);
		PageFactory.initElements(driver, UnderLineElementIQ.class);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.navigate().to("https://www.google.com/");
		
		
		WebElement tamilElement = driver.findElement(By.xpath("//div[@id='SIvCob']/a[5]"));
		
		String beforeHoveringString = tamilElement.getCssValue("text-decoration");
		
		//hover on the element 
		Actions actions = new Actions(driver);
		actions.moveToElement(tamilElement).build().perform();
		
		while (!tamilElement.getCssValue("text-decoration").contains("underline")) {
			continue;			
		}
		
		String afterhoveringString =  tamilElement.getCssValue("text-decoration");
		System.out.println("Before Hovering : "+beforeHoveringString+"\nAfter Hovering : "+afterhoveringString);
		
		
		//driver.close();
	}

}
