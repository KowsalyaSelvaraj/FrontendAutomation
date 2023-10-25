package com.selenium.project.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoCompleteAdvanced {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		try {

			driver.manage().window().maximize();

			driver.get("https://www.google.com/");

			WebElement searchBoxElement = driver.findElement(By.name("q"));
			searchBoxElement.sendKeys("school");

			Thread.sleep(5000);
			List<WebElement> listOfElements = driver.findElements(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[2]/div[2]/div[2]/ul[1]/div/ul/li"));

			System.out.println(listOfElements.size());

			for(WebElement textElement : listOfElements)
			{
				if(textElement.getText().equals("school leave letter"))
				{
					textElement.click();
					break;
				}
			}
		}
		catch (Exception e) {
			System.out.println("Exception is "+e);
		}
		finally {

			driver.close();
		}
	}

}
