package com.selenium.project.practice;

import java.io.File;
//import java.io.FileInputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DownloadAdvanced {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		try {

			driver.manage().window().maximize();

			driver.get("https://www.leafground.com/file.xhtml");

			WebElement downloadElement = driver.findElement(By.id("j_idt93:j_idt95"));
			downloadElement.click();
			Thread.sleep(5000);

			File fileLocation = new File("C:\\Users\\lap\\Downloads");

			File[]  totalFiles = fileLocation.listFiles();

			for (File file : totalFiles) {

				if(file.getName().equals("TestLeaf Logo.png"))
				{
					System.out.println("File Successfully Downloaded");
					break;
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			driver.close();
		}
	}

}
