package com.selenium.project.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TableAdvanced {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.navigate().to("https://www.careerlauncher.com/rbi-grade-b/states-capital-cm-governor/");

		//Number of Columns
		List<WebElement> columnsElements = driver.findElements(By.tagName("th"));
		int numberOfColumns = columnsElements.size();
		System.out.println("Number of Columns in both the tables together =>"+numberOfColumns);

		//Number of Rows
		List<WebElement> rowsElements = driver.findElements(By.tagName("tr"));
		int numberOfRows = rowsElements.size();
		System.out.println("Number of rows in both the tables are =>"+numberOfRows);
		
		//Find the Chief minister of Tamilnadu
		WebElement tNCMElement = driver.findElement(By.xpath("//td[normalize-space()='Tamil Nadu']//following::td[3]"));
		String cMString =   tNCMElement.getText();
		System.out.println("Tamilnadu CM is "+cMString);
		
		//Find lowest data
		driver.navigate().to("https://www.leafground.com/grid.xhtml");	
		
		String amountString=null;
		List<Integer> amountIntegers = new ArrayList<Integer>();
		List<WebElement> amountElements = driver.findElements(By.xpath("//td[5]"));
		for (WebElement webElement : amountElements) {
			
			amountString = webElement.getText().substring(1,3);
			amountIntegers.add(Integer.parseInt(amountString));
		}
		
		System.out.println("Amounts in dollor are "+amountIntegers);
		
		int smallAmount = Collections.min(amountIntegers);
		
		
		String amountString2 = Integer.toString(smallAmount);
		
		String fullAmount = "$"+amountString2+".00";
		System.out.println("Smallest amount "+fullAmount);
		////td[5]/span[text()='$79.00']//preceding::td[4]//div/div -----Escape sequence
		String xpathString = "//td[5]/span[text()='"+fullAmount+"']//preceding::td[4]//div/div";
		
		WebElement checkBoxElement = driver.findElement(By.xpath(xpathString));
		checkBoxElement.click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.quit();
	}

}
