package com.selenium.project.practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnXpath {


	public static void main(String[] args) throws InterruptedException, AWTException {
		//Different types of Xpath ( Consider element is a house)
		//Absolute xpath -> //html/body/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div/ul/li[1]/svg ( Straight ah ponga left eduncga pillayar kovil varum anga uturn edunga athukku pakathu veedu)
		//Relative xpath -> //*[@id="item-0"]/svg (pillayar kovi lukku pakathu veedu)

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();

		driver.get("https://demoqa.com/automation-practice-form");

		driver.navigate().refresh();

		//explicit wait
		WebDriverWait myWait = new WebDriverWait(driver,Duration.ofSeconds(30));

		myWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("userName-label"))));

		//Use robot class to zoom in and zoom out Ctrl+ Minus(-)
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);

		robot.keyPress(KeyEvent.VK_MINUS);
		robot.keyRelease(KeyEvent.VK_MINUS);

		robot.keyPress(KeyEvent.VK_MINUS);
		robot.keyRelease(KeyEvent.VK_MINUS);

		robot.keyRelease(KeyEvent.VK_CONTROL);

		//Hw try maximizing the window ctrl + Plus
		//Finding xpath with name, class, id 
		//tagname[@attributeName = 'Value in the attribute']
		//input[@id='firstName']

		//input[@id='firstName']
		//example
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(" Kowsalya ");

		//
		//
		//Finding xpath with text() displayed 
		//tagname[text() = 'Value of the text displayed']
		//label[text()='Female']
		//example
		driver.findElement(By.xpath("//label[text()='Female']")).click();

		//
		//Finding xpath with contains/start-with/ends-with displayed
		//tagname[contains/starts-with/ends-with(@attribute/text(),'Partial or full Value in attribute/ partial or full value in text')]

		//input[not(contains(@id,'Email'))]
		//input[contains(@id,'Email')]
		//example
		driver.findElement(By.xpath("//input[contains(@id,'Email')]")).sendKeys("kowsalya@gmail.com");

		//unable to find the element directly
		//then use its following or preceding elements
		//tagname[text()/@attri = 'value']//following::tagName[nth occurrence]
		//label[text()='Mobile']//following::input[1]
		driver.findElement(By.xpath("//label[text()='Mobile']//following::input[1]")).sendKeys("9058789458");


		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://demoqa.com/text-box");

		//unable to find the element directly
		//then use its following or preceding elements
		//tagname[text()/@attri = 'value']//preceding::tagName[nth occurrence]
		//label[text()='Mobile']//following::input[1]
		driver.findElement(By.xpath("//button[@id='submit']//preceding::textarea[1]")).sendKeys("Chennai - 600071");

		//HW
		//FindAll xpaths in this Page https://demoqa.com/text-box

		//Use robot class to zoom in and zoom out Ctrl+ Minus(-)
		robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);

		robot.keyPress(KeyEvent.VK_MINUS);
		robot.keyRelease(KeyEvent.VK_MINUS);

		robot.keyPress(KeyEvent.VK_MINUS);
		robot.keyRelease(KeyEvent.VK_MINUS);

		robot.keyRelease(KeyEvent.VK_CONTROL);

		//Hw try maximizing the window ctrl + Plus

		//	Dynamic Xpath
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://demoqa.com/links");
		driver.findElement(By.xpath("//*[text()='Following links will send an api call']//preceding::a[1]")).click(); // it will be keepon changing so we need to go to dynamic xpath
		//*[text()='Following links will send an api call']//preceding::a[1]
	}
	
	public void scrollToElementByLocator(WebDriver driver, WebElement element) {
		
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		
		executor.executeScript("", null);
		
		
		
	}
}
