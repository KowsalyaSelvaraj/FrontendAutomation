package com.selenium.project.practice;

import java.awt.Label;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioButtonPractise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		// go to radio button
		driver.get("https://www.leafground.com/radio.xhtml");

		// find the selected Radio Button browser Safari
		WebElement option1 = driver.findElement(By.xpath("//*[@id='j_idt87:console2:0']"));
		System.out.println("Option 1 - " + option1.isSelected());

		WebElement option2 = driver.findElement(By.xpath("//*[@id='j_idt87:console2:1']"));
		System.out.println("Option 2 - " + option2.isSelected());

		WebElement option3 = driver.findElement(By.xpath("//*[@id='j_idt87:console2:2']"));
		System.out.println("Option 3 - " + option3.isSelected());

		WebElement option4 = driver.findElement(By.xpath("//*[@id='j_idt87:console2:3']"));
		System.out.println("Option 4 - " + option4.isSelected());

		List<WebElement> optionsElements = driver.findElements(By.name("j_idt87:console2"));
		int i = 0;
		String Label = null;
		for (WebElement optionElement : optionsElements) {
			if (optionElement.isSelected()) {
				Label = driver.findElement(By.xpath("//label[@for='j_idt87:console2:" + i + "']")).getText();
				System.out.println("Value " + optionElement.getAttribute("value") + " Browser is " + Label);
				break;
			}
			i++;
		}

		// Select a age group
		WebElement AgeGroup = driver.findElement(By.id("j_idt87:console1:1"));
				AgeGroup.click();
		//driver.quit();
	}

}
