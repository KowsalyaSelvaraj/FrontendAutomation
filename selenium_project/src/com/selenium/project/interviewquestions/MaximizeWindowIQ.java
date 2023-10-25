package com.selenium.project.interviewquestions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

//import java.awt.Dimension;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MaximizeWindowIQ {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		MaximizeWindowIQ maximizeWindowIQ = new MaximizeWindowIQ();

		WebDriverManager.chromedriver().setup();

		//use ChromeOptions
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");

		WebDriver driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.navigate().to("https://www.leafground.com/");

		maximizeWindowIQ.getSizDimension(driver,"ChromeOptions");

		//System.out.println("ChromeOptions :\tX :"+sizeDimension.getWidth()+"\tY: "+sizeDimension.getHeight());
		//use Set Size
		//	Dimension dimension = driver.manage().window().getSize();
		Dimension dimension = new Dimension(800,500);
		driver.manage().window().setSize(dimension);
		maximizeWindowIQ.getSizDimension(driver,"SetSize");


		//use window.maximize 
		driver.manage().window().maximize();
		maximizeWindowIQ.getSizDimension(driver,"Maximize");


		driver.navigate().to("https://www.leafground.com/");

		//go to driver
		WebElement browserElement = driver.findElement(By.xpath("//span[text()='Browser']//parent::a"));
		browserElement.click();

		WebElement alertElement = driver.findElement(By.xpath("//span[text()='Alert']//parent::a"));
		alertElement.click();

		System.out.println("Current URL :\t"+driver.getCurrentUrl());
		driver.quit();

	}

	public  void getSizDimension(WebDriver driver,String typeOfMax) {


		Dimension sizeDimension = driver.manage().window().getSize();
		System.out.println(typeOfMax+": \tX :"+sizeDimension.getWidth()+"\tY: "+sizeDimension.getHeight());

		//return driver.manage().window().getSize();

	}

}
