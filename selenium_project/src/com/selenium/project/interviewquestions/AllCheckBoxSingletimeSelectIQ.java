package com.selenium.project.interviewquestions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AllCheckBoxSingletimeSelectIQ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		
		WebDriver driver = new ChromeDriver(chromeOptions);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.navigate().to("https://www.leafground.com/checkbox.xhtml;jsessionid=node0g1y7x4bej4fe1779sn2mexie7161609.node0");
		
		List<WebElement> checkBoxList = driver.findElements(By.xpath("//input[@type='checkbox']"));
		
		for (WebElement webElement : checkBoxList) {
			
			webElement.click();
			
		}
	}

}
