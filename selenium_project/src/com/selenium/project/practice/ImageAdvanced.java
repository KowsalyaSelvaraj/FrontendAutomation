package com.selenium.project.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImageAdvanced {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.navigate().to("https://www.google.com/");
		
		WebElement searchElement = driver.findElement(By.name("q"));
		searchElement.sendKeys("image"+Keys.ENTER);
		
		WebElement imageElement = driver.findElement(By.xpath("//*[@id='dimg_17']"));
		imageElement.click();
		
		WebElement clickedElement = driver.findElement(By.xpath("//*[@id=\"Sva75c\"]/div/div[3]/div[3]/div[2]/c-wiz/div/div[1]/div[3]/div[1]/a[1]/div/div"));
		
		if(clickedElement.getText().equals("Pixabay"))
		{
			System.out.println("Clicked on Image");
		}
		else {
			System.out.println("Page doesn't load ");
		}
		
		//natural Width - to check whether the image is broken image 
		
		WebElement brokenImagElement = driver.findElement(By.xpath("//*[@id='dimg_17']"));
		
		
		if (brokenImagElement.getAttribute("naturalWidth").equals("0")) {
			System.out.println("Image is broken");
			
		}
		else {
			System.out.println("Image is not broken");
		}
		

		driver.quit();

		
		
	}

}
