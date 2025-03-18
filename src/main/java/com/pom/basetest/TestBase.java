package com.pom.basetest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {
	public static WebDriver driver;
    public static Properties prop = new Properties();
	FileInputStream fStream;
    public TestBase() {
    	try {
			fStream = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\ProjectData.properties" );
			prop.load(fStream);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public static void initBrowser() {
    	String browserKey = prop.getProperty("browser_name");
		if (browserKey.equalsIgnoreCase("chrome")) {
			System.getProperty("webdriver.chromedriver.driver",
					System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		} else{
			System.getProperty("webdriver.chromedriver.driver",
					System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
    }
    
	public static void openUrl(String UrlKey) {
		String url = prop.getProperty(UrlKey);
		driver.get(url);
	}
	
	public static void clickButton(String locatorKey) {
	      WebElement element = getElement(locatorKey);
	      element.click();
	}
	
	public static void wait(int waitTime, String locatorKey) {
		WebDriverWait waitDriver = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
		waitDriver.until(ExpectedConditions.presenceOfElementLocated( getLocator(locatorKey)));
	}
	
	public static By getLocator(String locatorKey) {
		By by;
		if(locatorKey.endsWith("_xpath")) {
			by = By.xpath(prop.getProperty(locatorKey));
		}else if(locatorKey.endsWith("_name")) {
			by = By.name(prop.getProperty(locatorKey));
		}else if(locatorKey.endsWith("_css")) {
			by = By.cssSelector(prop.getProperty(locatorKey));
		}
		else{
			by = By.id(prop.getProperty(locatorKey));
		}
		return by;
		
	}
	
	public static void pressEnterKey() {
		Actions builder = new Actions(driver);
		builder.keyDown(Keys.RETURN).build().perform();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void mouseHover(String locatorKey) {
		Actions builder = new Actions(driver);
		builder.moveToElement(getElement(locatorKey)).build().perform();;
		
	}
	
	public static WebElement getElement(String locatorKey) {
		WebElement element;
		if(locatorKey.endsWith("_xpath")) {
			element = driver.findElement(By.xpath(prop.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_name")) {
			element = driver.findElement(By.name(prop.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_css")) {
			element = driver.findElement(By.cssSelector(prop.getProperty(locatorKey)));
		}
		else{
			element = driver.findElement(By.id(prop.getProperty(locatorKey)));
		}
		return element;
		
	}
	
	public static void getWindowHandlesandSwitchtoNextWindow() {
		Set<String> GUID = driver.getWindowHandles();
		Iterator<String> idIterator = GUID.iterator();
		String homePageID = idIterator.next();
		String loginPageID = idIterator.next();
		driver.switchTo().window(loginPageID);
		
	}
	
	public static void quitDriver() {
		driver.quit();
	}
}
