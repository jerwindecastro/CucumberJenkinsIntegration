package com.pom.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pom.basetest.TestBase;

import junit.framework.Assert;

public class HomePageTest extends TestBase {
	@FindBy(xpath="//div[5]")
	WebElement dealshoverBtn;
	
	public HomePageTest() {
		PageFactory.initElements(driver, this);
	}
	
	public void verifyPageTitle(String expectedTitle) {
		String actualTitle = driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
		System.out.println("Home Page");
		System.out.println("Actual title:" + actualTitle);
		System.out.println("Expected title:" + expectedTitle);
	}
	
	public AddDealsTest mouseHover() {
		Actions builder = new Actions(driver);
		builder.moveToElement(dealshoverBtn).build().perform();;
		return new AddDealsTest();
		
	}

}
