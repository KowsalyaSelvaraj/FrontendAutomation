package com.selenium.project.interviewquestions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeliniumExplicitWait {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.navigate().to("https://phptravels.org/login");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//h6[@class='h3']")), "Login"));

		WebElement emailAddressElement = driver.findElement(By.id("inputEmail"));
		emailAddressElement.sendKeys("kowsalya@gmail.com");

		WebElement passwordElement = driver.findElement(By.id("inputPassword"));
		passwordElement.sendKeys("kowsalya");

		//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")));

		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@title='reCAPTCHA']")));

		WebElement reCaptchaElement =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='recaptcha-anchor']")));
		reCaptchaElement.click();

		//reCaptchaElement.getAttribute("aria-checked").equals("true")

		/*while (!reCaptchaElement.isSelected()) {

			System.out.println("checking its selected");
			continue;
		}*/

		while (!reCaptchaElement.getAttribute("aria-checked").equals("true")) {
			continue;
		}

		//Thread.sleep(5000);

		driver.switchTo().defaultContent();

		WebElement loginButtonElement = driver.findElement(By.xpath("//button[@id='login']"));
		loginButtonElement.click();

		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@class='alert alert-danger']"),"Login Details Incorrect. Please try again."));

		String errorMessageString = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();

		System.out.println(errorMessageString);

		driver.quit();
	}

}
