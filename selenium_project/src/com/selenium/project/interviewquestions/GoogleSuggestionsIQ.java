package com.selenium.project.interviewquestions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
//import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

//import java.util.logging.FileHandler;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSuggestionsIQ {

	public static void main(String[] args) throws IOException, AWTException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		Dimension dimension = new Dimension(1920,800);
		driver.manage().window().setSize(dimension);;
		
		driver.navigate().to("https://www.google.com/");
		
		WebElement searchBoxElement = driver.findElement(By.name("q"));
		searchBoxElement.sendKeys("hey days");
		
		// take screenshot of those files 
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File("C:\\Users\\lap\\Pictures\\Camera Roll\\googleSearch.jpg");
		org.openqa.selenium.io.FileHandler.copy(sourceFile, destinationFile); 
		
		
		List<WebElement> searchResultsList = driver.findElements(By.xpath("//ul[@role='listbox']/li"));
		
		int totalNumberOfResultsInList = searchResultsList.size();
		
		//print count of list items
		System.out.println("Total NUmber of results is : "+totalNumberOfResultsInList);
		
		//print the list of items 
		for (WebElement result : searchResultsList) {
			
			System.out.println(result.getText());
		}
		
		//select hey days restaurant
		
		for (WebElement webElement : searchResultsList) {
			
			if (webElement.getText().contains("restaurant")) {
				
				webElement.click();
				break;
			}
			else {
				continue;
			}
		}
		
		//verify image selected Hey days restaurant
		Robot robot = new Robot();
		java.awt.Dimension dimension2 = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rectangle = new Rectangle(dimension2);
		BufferedImage image = robot.createScreenCapture(rectangle);
		File imageFile = new File("C:\\Users\\lap\\Pictures\\Camera Roll\\AfterGoogleSearch.jpg");
		ImageIO.write(image, "jpg", imageFile);
		
		
		//verify hey days restaurant is clicked 
		String currentURLString =   driver.getCurrentUrl();
		
		if (currentURLString.contains("hey+days+restaurant")) {
			
			System.out.println("Clicked on hey days restaurant "+driver.getTitle()+" Hey Jolly!!!");
			
		} else {
			System.out.println("Hey days page has not clicked");
		
		}
		
		driver.close();
		
		
	
	}

}
