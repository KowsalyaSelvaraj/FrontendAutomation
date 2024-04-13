package com.selenium.project.practice;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SortableAdvanced {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.tutorialspoint.com/jqueryui/jqueryui_sortable.htm");
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("(//b[contains(text(),'sortexample')])[1]"));
		executor.executeScript("arguments[0].scrollIntoView(true);", element);
		
		driver.switchTo().frame(1);
		
		
		List<WebElement> listOfElements = driver.findElements(By.xpath("//ul[@id='sortable-1']/li"));
		
		System.out.println("Size of List "+listOfElements.size());
		WebElement fromElement = listOfElements.get(4);
		WebElement toElement = listOfElements.get(0);
		
		
		
		Actions actions = new Actions(driver);
		
		actions.clickAndHold(toElement);
		actions.moveToElement(fromElement);
		actions.release(fromElement);
		actions.build().perform();
		
		System.out.println("Element on the 1st Position is "+listOfElements.get(0).getText());
		
		driver.quit();
	}

}
