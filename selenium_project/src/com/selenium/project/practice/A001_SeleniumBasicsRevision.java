package com.selenium.project.practice;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class A001_SeleniumBasicsRevision {

	public static int i=0;
	//declare and launch driver and close the driver
	@Test(enabled = false)
	public void launchBrowserAndMaxandMinWindow() {

		//	WebDriverManager.firefoxdriver().setup();

		System.setProperty("webdriver.edge.driver", "C:\\Users\\kowsalyas\\Drivers\\msedgedriver.exe");

		WebDriver driver = new EdgeDriver();

		driver.manage().window().maximize();

		driver.get("https://demoqa.com/");

		driver.manage().window().minimize();
	}

	@Test(enabled = false)
	public void launchBrowserAndWaitforIt() throws InterruptedException {

		//	WebDriverManager.firefoxdriver().setup();

		System.setProperty("webdriver.edge.driver", "C:\\Users\\kowsalyas\\Drivers\\msedgedriver.exe");

		WebDriver	driver = new EdgeDriver();

		driver.manage().window().maximize();
		Thread.sleep(2000);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get("https://demoqa.com/");
		driver.manage().window().minimize();
		Thread.sleep(2000);

		driver.close();
		
		//driver.quit();
	}

	@Test(enabled = false)
	public void explicitWait() throws InterruptedException {

		System.setProperty("webdriver.edge.driver", "C:\\Users\\kowsalyas\\Drivers\\msedgedriver.exe");

		WebDriver	driver = new EdgeDriver();

		driver.manage().window().maximize();

		driver.get("https://demoqa.com/");

		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30), Duration.ofSeconds(20));

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(""))));

	}

	@Test(enabled = false)
	public void locateElements() throws InterruptedException {

		//We can locate the element using locators
		//Different types of locators
		//ID,NAME, CLass, linked Text, Partial linked text
		//Inspect the element and find the locator and then give it in code and access it
		//Example : When a teacher wants to distribute exam paper after correction teacher will locate the students using their id's 
		System.setProperty("webdriver.edge.driver", "C:\\Users\\kowsalyas\\Drivers\\msedgedriver.exe");

		WebDriver	driver = new EdgeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.manage().window().maximize();
		driver.get("https://demoqa.com/automation-practice-form");

		String parentWindowString = driver.getWindowHandle();

		System.out.println("Parent window "+parentWindowString);

		//Locators -> find element by => ID
		driver.findElement(By.id("firstName")).sendKeys("Jaya Shree");
		//Thread.sleep(5000);

		String firestNameString =  driver.findElement(By.id("firstName")).getAttribute("value");
		System.out.println("First name is "+firestNameString);
		driver.findElement(By.id("firstName")).clear();
		//Thread.sleep(5000);

		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://demoqa.com/links");
		driver.findElement(By.linkText("Home")).click();

		Thread.sleep(5000);
		//
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://demoqa.com/links");
		//	driver.findElement(By.partialLinkText("HomeVCQww")).click(); // it will be keepon changing so we need to go to dynamic xpath


		//Handling multiple windows

		Thread.sleep(3000);

		Set<String> openedWindowSet = driver.getWindowHandles();

		for(String windowString : openedWindowSet) {

			if(windowString.equals(parentWindowString)) {
				driver.switchTo().window(parentWindowString);
			}
		}

		System.out.println(openedWindowSet);


		//driver.close();
	}

	@Test(enabled = false)
	public void locateElementsWithXpath() throws AWTException {

		//Different types of Xpath ( Consider element is a house)
		//Absolute xpath -> //html/body/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div/ul/li[1]/svg ( Straight ah ponga left eduncga pillayar kovil varum anga uturn edunga athukku pakathu veedu)
		//Relative xpath -> //*[@id="item-0"]/svg (pillayar kovi lukku pakathu veedu)

		System.setProperty("webdriver.edge.driver", "C:\\Users\\kowsalyas\\Drivers\\msedgedriver.exe");

		WebDriver	driver = new EdgeDriver();

		driver.manage().window().maximize();

		driver.get("https://demoqa.com/automation-practice-form");

		driver.navigate().refresh();

		//explicit wait
		WebDriverWait myWait = new WebDriverWait(driver,Duration.ofSeconds(30));

		myWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("userName-label"))));

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
		Robot robot = new Robot();
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

	@Test(enabled = false)
	public void navigation() throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\kowsalyas\\Drivers\\msedgedriver.exe");

		WebDriver	driver = new EdgeDriver();

		driver.manage().window().maximize();
		//navigation commands
		//To => Go to a URL works same as get()
		//Refresh() => Refresh the page
		//Forward => go to next page
		//Back => go one page back
		driver.navigate().to("https://www.google.com/");

		driver.findElement(By.name("q")).sendKeys("Books \n");

		driver.navigate().refresh();

		Thread.sleep(5000);

		driver.navigate().back();

		Thread.sleep(5000);

		driver.navigate().forward();

		Thread.sleep(5000);
	}

	@Test(enabled = false)

	public void handingAlerts() throws InterruptedException, AWTException, IOException {

		System.setProperty("webdriver.edge.driver", "C:\\Users\\kowsalyas\\Drivers\\msedgedriver.exe");

		WebDriver driver = new EdgeDriver();

		driver.manage().window().maximize();


		driver.navigate().to("https://demoqa.com/alerts");

		takeScreenshot(driver);

		driver.findElement(By.id("alertButton")).click();

		Alert alert = driver.switchTo().alert();
		
		Thread.sleep(5000);
		//takeScreenshot(driver);
		takeScreenshotWindow();
		alert.accept();


		//Wait and accept the alert 
		driver.findElement(By.xpath("//span[contains(text(),'after 5 seconds')]//following::button[1]")).click();

		WebDriverWait myWait = new WebDriverWait(driver,Duration.ofSeconds(30));

		myWait.until(ExpectedConditions.alertIsPresent());
		alert.accept();


		//Cancel  the alert 
		driver.findElement(By.xpath("//span[contains(text(),'confirm box will appear')]//following::button[1]")).click();
		myWait.until(ExpectedConditions.alertIsPresent());
		alert.dismiss();

		String textDisplayedString =	driver.findElement(By.id("confirmResult")).getText();
		System.out.println(textDisplayedString);

		//Use robot class to zoom in and zoom out Ctrl+ Minus(-)
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);

		robot.keyPress(KeyEvent.VK_MINUS);
		robot.keyRelease(KeyEvent.VK_MINUS);

		robot.keyPress(KeyEvent.VK_MINUS);
		robot.keyRelease(KeyEvent.VK_MINUS);

		robot.keyRelease(KeyEvent.VK_CONTROL);

		//Send Text data to the alert 
		driver.findElement(By.xpath("//span[contains(text(),'prompt box will appear')]//following::button[1]")).click();
		myWait.until(ExpectedConditions.alertIsPresent());
		alert.sendKeys("Jaya Shree");
		Thread.sleep(5000);
		alert.accept();
		String dataGivenString =	driver.findElement(By.id("promptResult")).getText();
		System.out.println(dataGivenString);
	}

	@Test(enabled = true)
	public void buttonActions() {
		try {
			WebDriverManager.firefoxdriver().setup();

			WebDriver	driver = new FirefoxDriver();

			driver.manage().window().maximize();
			driver.navigate().to("https://demoqa.com/");

			//get title of the page
			String titleString = driver.getTitle();

			System.out.println("Title of the window"+titleString);

			//We can do scrolling using Javascript executor

			JavascriptExecutor executor = (JavascriptExecutor) driver;
			//executor.executeScript("window.scrollBy(0,1000)");

			executor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[text()='Elements']//preceding::div[1]")));

			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[text()='Elements']//preceding::div[1]")).click();

			executor.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.xpath("//span[text()='Buttons']")));

			Thread.sleep(5000);

			driver.findElement(By.xpath("//span[text()='Buttons']")).click();


			WebDriverWait myWait = new WebDriverWait(driver,Duration.ofSeconds(30));

			myWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("doubleClickBtn"))));

			Actions action = new Actions(driver);
			action.doubleClick(driver.findElement(By.id("doubleClickBtn"))).build().perform();

			action.contextClick(driver.findElement(By.id("rightClickBtn"))).build().perform();

			action.click(driver.findElement(By.xpath("//button[text()='Click Me']"))).build().perform();

			
			List<WebElement> resultElements =	driver.findElements(By.xpath("//button[@id='rightClickBtn']//following::p"));
			for(WebElement element : resultElements) {
				System.out.println(element.getText());
			}

		}catch (Exception e) {
			System.out.println(e);
			String	finalStatus  = "Fail";
		}
	}

	@Test(enabled = true)
	public void handingMultipleFrames() {


		System.setProperty("webdriver.edge.driver", "C:\\Users\\kowsalyas\\Drivers\\msedgedriver.exe");

		WebDriver driver = new EdgeDriver();

		driver.manage().window().maximize();


		driver.navigate().to("https://demoqa.com/frames");

		//if the element is inside the frame then we need to go to the frame 
		//driver.switchTo().frame(driver.findElement(By.id("frame1")));
		driver.switchTo().frame("frame1");
		String elementInsideFrameString = driver.findElement(By.id("sampleHeading")).getText();
		System.out.println("element text inside frame "+elementInsideFrameString);
		
		
		
		//come back to default content
		driver.switchTo().defaultContent();
		
		driver.findElement(By.xpath("//div[@id='framesWrapper']/div[1]")).getText();
		
	}

	@Test(enabled = false)
	public void datePicker() throws InterruptedException {

		System.setProperty("webdriver.edge.driver", "C:\\Users\\kowsalyas\\Drivers\\msedgedriver.exe");

		WebDriver	driver = new EdgeDriver();

		driver.manage().window().maximize();

		driver.get("https://demoqa.com/date-picker");

		WebDriverWait myWait = new WebDriverWait(driver,Duration.ofSeconds(30));

		WebElement element = driver.findElement(By.xpath("//div[@class='main-header']"));
		myWait.until(ExpectedConditions.visibilityOf(element));

		//Wait and accept the alert 
		driver.findElement(By.id("datePickerMonthYearInput")).click();

		Select selectYear = new Select(driver.findElement(By.className("react-datepicker__year-select")));

		selectYear.selectByVisibleText("2025");

		Thread.sleep(5000);

		Select selectMonth = new Select(driver.findElement(By.className("react-datepicker__month-select")));

		selectMonth.selectByValue("10");

		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[text()='10' and not(contains(@class,'outside'))]")).click();

		Thread.sleep(5000);

	}

	@Test(enabled = true)
	public void uploadAndDownload() throws AWTException, InterruptedException {

		System.setProperty("webdriver.edge.driver", "C:\\Users\\kowsalyas\\Drivers\\msedgedriver.exe");

		WebDriver	driver = new EdgeDriver();

		driver.manage().window().maximize();

		driver.get("https://demoqa.com/");

		driver.navigate().to(driver.getCurrentUrl());

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//*[text()='Elements']//preceding::div[1]")));
		
		driver.findElement(By.xpath("//*[text()='Elements']//preceding::div[1]")).click();

		executor.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.xpath("//span[text()='Upload and Download']")));
		driver.findElement(By.xpath("//span[text()='Upload and Download']")).click();

		//click on download button
		driver.findElement(By.id("downloadButton")).click();

		Thread.sleep(5000);

		File file = new File("C:\\Users\\kowsalyas\\Downloads");
		File[] files = file.listFiles();
		long lastModified = Long.MIN_VALUE;
		String downloadedFile="";

		for(File file2 : files) {

			if(file2.lastModified()>lastModified) 
			{
				System.out.println(file2.getName());
				downloadedFile = file2.getName();
				lastModified = file2.lastModified();
			}
		}
		System.out.println(lastModified);

		if(downloadedFile.contains("sample")) {
			System.out.println("file downloaded ");
		}else {
			System.out.println("file not downloaded");
		}

//		//upload the file
		Thread.sleep(5000);
		driver.findElement(By.xpath("//label[text()='Select a file']")).click();

		StringSelection stringSelection = new StringSelection("C:\\Users\\kowsalyas\\Documents\\Action1.txt");

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

		Thread.sleep(5000);
		Robot robot = new Robot();

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);

		robot.keyPress(KeyEvent.VK_ENTER);

		robot.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(2000);
		System.out.println("value of uploaded file "+driver.findElement(By.id("uploadFile")).getAttribute("value"));
	}

	public static void takeScreenshot(WebDriver driver) throws IOException {
		//Take screenshot 
		TakesScreenshot scrShot = ((TakesScreenshot)driver);

		//Call getScreenshotAs method to create image file

		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

		//Move image file to new destination

		File DestFile=new File("C:\\Users\\kowsalyas\\Desktop\\image"+i+".png");
		i++;
		//Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
	}

	public static void takeScreenshotWindow() throws IOException, AWTException {
		//Robot Class Initialization
		Robot robot = new Robot();

		//Rectangle Class Initialization
		Rectangle rect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());

		//Defining Output files destination
		File destFile = new File("C:\\Users\\kowsalyas\\Desktop\\imageWindow"+i+".png");
		i++;
		//Screenshot Capture
		BufferedImage img = robot.createScreenCapture(rect);

		//Writing image to destination with its formats
		ImageIO.write(img, "png", destFile);
	}
	
	@Test(enabled = true)
	public void takeAWindowScreenshot() throws IOException {
		
		System.setProperty("webdriver.edge.driver", "C:\\Users\\kowsalyas\\Drivers\\msedgedriver.exe");

		WebDriver	driver = new EdgeDriver();

		driver.manage().window().maximize();

		driver.get("https://demoqa.com/browser-windows");
		driver.findElement(By.id("tabButton")).click();
		takeScreenshot(driver);
		
	}
}
