package com.pom.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pom.basetest.TestBase;

public class AddDealsTest extends TestBase{
	@FindBy(xpath="/html/body/div[1]/div/div[1]/div[5]/button")
	WebElement dealsAddBtn;
	
	@FindBy(name="title")
	WebElement titleTxtbox;
	
	@FindBy(xpath="/html/body/div[1]/div/div[2]/div[2]/div/div[2]/form/div[2]/div[2]/div/div/input")
	WebElement companyTxtbox;
	
	@FindBy(xpath="//button[contains(text(),'Save')]")
	WebElement saveBtn;
	
	public AddDealsTest() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickAddBtn() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dealsAddBtn.click();
	}
	
	public void enterData() {
		System.out.println("Entering data");
		mouseHover("TitleTextBox_name");
		titleTxtbox.sendKeys(prop.getProperty("title"));
		companyTxtbox.sendKeys(prop.getProperty("company"));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pressEnterKey();
	}
	
	public void saveData() {
		saveBtn.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
