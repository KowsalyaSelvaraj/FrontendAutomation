package com.selenium.project.interviewquestions;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrintGoogleSearchResultsIQ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.navigate().to("https://www.google.com/");
		
		WebElement searchBoxElement = driver.findElement(By.name("q"));
		searchBoxElement.sendKeys("Loyola"+Keys.ENTER);
		
		//Print all the URL
		List<WebElement> totalLinksElements = driver.findElements(By.xpath("//a"));

		Iterator<WebElement> iterator = totalLinksElements.iterator();

		while (iterator.hasNext()) {
			System.out.println(iterator.next().getAttribute("href"));

		}
		
		//Print only Specific URLS
		List<WebElement> specificURList = driver.findElements(By.xpath("//div[@class='BYM4Nd']//following::cite[@class='iUh30 tjvcx']"));
		Iterator<WebElement> iterator2 = specificURList.iterator();
		
		System.out.println("-----------------------------------------------------------------------------\n---------------------------------");
		
		while (iterator2.hasNext()) {
			System.out.println(iterator2.next().getText());
			
		}
		
		
		
		driver.quit();
	}
}