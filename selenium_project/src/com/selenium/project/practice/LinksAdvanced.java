package com.selenium.project.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinksAdvanced {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.navigate().to("https://www.leafground.com/link.xhtml;jsessionid=node0xpnazxczesi01d659zpmtgifc74078.node0");

		WebElement goToHomElement = driver.findElement(By.linkText("Go to Dashboard"));
		goToHomElement.click();

		driver.navigate().back();

		//where am i going without clicking on link
		WebElement findWherElement = driver.findElement(By.partialLinkText("Find the URL"));
		String whereToGoString = findWherElement.getAttribute("href");
		System.out.println("On Clicking Find the URL without clicking me. URL redirects to  :"+ whereToGoString);
		
		
		//broken link 404 error
		WebElement brokenLinkElement = driver.findElement(By.linkText("Broken?"));
		brokenLinkElement.click();
		
		String titleString = driver.getTitle();
		if(titleString.contains("404"))
		{
			System.out.println(driver.getTitle()+" -> Link is broken");
		}
		else {
			System.out.println(driver.getTitle()+" -> Link is not broken");
		}
		
		driver.navigate().back();
		
		//go to home page again with above link -- will through WebElement goToHomElement 
		//= driver.findElement(By.linkText("Go to Dashboard"));
		
		WebElement goToHomElement1 = driver.findElement(By.linkText("Go to Dashboard"));
		goToHomElement1.click();
		
		driver.navigate().back();
		
		//Number of links in page
		List<WebElement> noOfLinksElements = driver.findElements(By.tagName("a"));
		int sizeOflist = noOfLinksElements.size();
		System.out.println("Total Number of Links in the page : "+ sizeOflist);
		
		driver.quit();
	}

}
