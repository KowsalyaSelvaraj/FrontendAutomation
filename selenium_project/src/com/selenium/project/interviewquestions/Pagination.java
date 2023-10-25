package com.selenium.project.interviewquestions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Pagination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://mdbootstrap.com/docs/b4/jquery/tables/pagination/");
		
		List<String> positionList = new ArrayList<String>();
		List<WebElement> numberOfPagesElements = driver.findElements(By.xpath("//div[@id='dtBasicExample_paginate']//a"));
		List<WebElement> positionListElements;
		WebElement nextButtonElement;
		int pagesTotalCount =  numberOfPagesElements.size();
		
		if(pagesTotalCount>0)
		{
			do {
			 positionListElements = driver.findElements(By.xpath("//tr/td[@class='sorting_1']//following-sibling::td[1]"));
			 nextButtonElement = driver.findElement(By.xpath("//li[@id='dtBasicExample_next']"));
			 
			for(WebElement name:positionListElements)
			{
				positionList.add(name.getText());
			}
				
			if(!nextButtonElement.getAttribute("class").contains("disabled"))
			{
				nextButtonElement.click();
			}
			else {
				break;
			}
			}while(true);
			
			
			}
		else {
			System.out.println("No Pagination Required");
		}
		
		for (String position : positionList) 
			System.out.println(position);
		
		String titleOfPageString =   driver.getTitle();
		System.out.println(titleOfPageString+" is the title of the page");
		driver.quit();
	}
	}
