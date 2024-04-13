package com.selenium.project.interviewquestions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetVsNavigateIQ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://www.google.com/");
		WebElement searchboxElement =  driver.findElement(By.name("q"));
		searchboxElement.sendKeys("School"+Keys.ENTER);
		driver.navigate().back();
		System.out.println("Get Completed");
		
		driver.navigate().to("https://www.google.com/");
		WebElement searchboxElement1 =  driver.findElement(By.name("q"));
		searchboxElement1.sendKeys("School"+Keys.ENTER);
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		System.out.println("Navigate to, back, forward, refresh operations completed Completed");
		
		//
		driver.quit();
	}

}
