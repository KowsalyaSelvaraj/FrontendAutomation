package com.selenium.project.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarsAdvanced {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().setSize( new Dimension(1920,2210));
		
		driver.navigate().to("https://jqueryui.com/datepicker/");
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));

		//Click on datepicker text box
		WebElement calenderElement = driver.findElement(By.id("datepicker"));
		calenderElement.click();
		
		//click on Next button in calendar
		WebElement nextElement = driver.findElement(By.xpath("//a[@title='Next']"));
		nextElement.click();
		
		//select the date
		WebElement dateElement = driver.findElement(By.xpath("//a[text()='10']"));
		dateElement.click();
		
		//System.out.println(calenderElement.getText());
		
		
		driver.switchTo().defaultContent();
		
		driver.quit();
	}

}
