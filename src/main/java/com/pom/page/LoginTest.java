package com.pom.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pom.basetest.TestBase;

import junit.framework.Assert;

public class LoginTest extends TestBase {
	
	@FindBy(css="a[href='https://ui.cogmento.com/?lang=en']")
	WebElement loginBtn;
	
	@FindBy(name="email")
	WebElement emailTxtBox;
	
	@FindBy(name="password")
	WebElement passwordTxtBox;
	
	@FindBy(xpath="//div[contains(text(),'Login')]")
	WebElement submitBtn;
	
	public LoginTest() {
		PageFactory.initElements(driver, this);
	}
	
	public void verifyPageTitle(String expectedTitle) {
		String actualTitle = driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
	}
	
	public void Login() throws InterruptedException {
//		wait(2000,"LoginButton_css");
		Thread.sleep(2000);
		loginBtn.click();
		getWindowHandlesandSwitchtoNextWindow();
	}
	
	public HomePageTest enterCredentials() {
		emailTxtBox.sendKeys(prop.getProperty("email"));
		passwordTxtBox.sendKeys(prop.getProperty("password"));
		submitBtn.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new HomePageTest();
	}

}
