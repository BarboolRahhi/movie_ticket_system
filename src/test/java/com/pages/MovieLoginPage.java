package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MovieLoginPage {
	
	public MovieLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name = "email")
	WebElement email;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "/html/body/app-root/div/div[2]/div/app-login/div/div/div/div/form/button")
	WebElement loginBtn;
	
	
	public void loginUser(String email, String password) {
		this.email.sendKeys(email);
		this.password.sendKeys(password);
	}
	
	public void submit() throws InterruptedException {
		this.loginBtn.click();
		
	}

}
