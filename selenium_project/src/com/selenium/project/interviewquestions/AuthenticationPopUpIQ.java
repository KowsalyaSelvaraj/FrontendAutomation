package com.selenium.project.interviewquestions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AuthenticationPopUpIQ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");

		WebDriver driver = new ChromeDriver(options);

		//driver.navigate().to("http://the-internet.herokuapp.com/basic_auth"); // not allow to go into webPage
		//		can't handled by selenium
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth"); ///to overcome AUth pop up

		String currentUrlString = driver.getCurrentUrl();
		System.out.println(currentUrlString);

		String messageString = driver.findElement(By.xpath("//p")).getText();
		System.out.println(messageString);

		driver.close();

	}

}
