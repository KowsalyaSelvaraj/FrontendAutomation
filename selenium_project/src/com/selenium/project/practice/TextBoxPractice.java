package com.selenium.project.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TextBoxPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		//Maximize  window 
		driver.manage().window().maximize();
		
		//Go to Leaf Ground Text page
		driver.get("https://www.leafground.com/input.xhtml");
		
		WebElement  nameBoxElement = driver.findElement(By.id("j_idt88:name"));
		nameBoxElement.sendKeys("Kowsalya S");
		
		WebElement appendElement = driver.findElement(By.xpath("//input[@id='j_idt88:j_idt91']"));
		appendElement.sendKeys("India");
		
		WebElement getTextElement = driver.findElement(By.id("j_idt88:j_idt97"));
		String valueString =getTextElement.getAttribute("value");
				
		System.out.println("Value of the String : " + valueString);
		
		WebElement clearElement = driver.findElement(By.id("j_idt88:j_idt95")); 
		clearElement.clear();
		
		WebElement disabledElement = driver.findElement(By.id("j_idt88:j_idt93"));
		boolean enabled =  disabledElement.isEnabled();
		System.out.println("Text Box is Enabled TRUE or FALSE : " +enabled);
		
		driver.quit();
	}

}
