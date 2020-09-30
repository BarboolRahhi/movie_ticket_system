package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TheatreAddPage {
	
	public TheatreAddPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	

	@FindBy(xpath = "/html/body/app-root/div/div[2]/div/app-theater-list/div/div/button")
	WebElement addBtn;
	
	@FindBy(id = "tname")
	WebElement tname;
	
	@FindBy(id = "tcity")
	WebElement city;
	
	@FindBy(id = "mName")
	WebElement mname;
	
	@FindBy(id = "mCity")
	WebElement contact;
	
	@FindBy(xpath = "/html/body/app-root/div/div[2]/div/app-edit-theater/div/div/form/div/button[1]")
	WebElement saveBtn;
	
	public void clickAddBtn() {
		addBtn.click();
	}
	
	public void fillForm() {
		tname.sendKeys("Fancy Cinema");
		city.sendKeys("samba");
		mname.sendKeys("janvez");
		contact.sendKeys("8759632114");
	}
	
	public void clickSaveBtn() {
		saveBtn.click();
	}
	
}
