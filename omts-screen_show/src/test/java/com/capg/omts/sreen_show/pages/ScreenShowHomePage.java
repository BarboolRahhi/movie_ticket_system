package com.capg.omts.sreen_show.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capg.omts.sreen_show.base_class.Library;

public class ScreenShowHomePage  extends Library{

	public ScreenShowHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}	
	

	
	
	
	@FindBy(id = "screenId")
	WebElement ScreenId;
	@FindBy(id = "screenName")
	WebElement ScreenName;
	@FindBy(xpath = "/html/body/app-root/body/div[2]/app-addscreen/div/form/div[3]/input")
	WebElement Rows;
	@FindBy(xpath = "/html/body/app-root/body/div[2]/app-addscreen/div/form/div[4]/input")
	WebElement Columns;
	@FindBy(xpath = "/html/body/app-root/body/div[2]/app-addscreen/div/form/div[5]/input[1]")
	WebElement ShowId;
	@FindBy(xpath = "/html/body/app-root/body/div[2]/app-addscreen/div/form/div[5]/input[2]")
	WebElement ShowName;
	@FindBy(xpath = "/html/body/app-root/body/div[2]/app-addscreen/div/form/div[5]/input[3]")
	WebElement ShowStartTime;
	@FindBy(xpath = "/html/body/app-root/body/div[2]/app-addscreen/div/form/div[5]/input[4]")
	WebElement ShowEndTime;
	@FindBy(xpath = "/html/body/app-root/body/div[1]/app-header/body/div/a[2]")
	WebElement Screen;
	@FindBy(xpath = "/html/body/app-root/body/div[2]/app-screen/div/div/div/button[1]")
	WebElement ClickScreenButton;
	@FindBy(xpath = "/html/body/app-root/body/div[2]/app-addscreen/div/form/input")
	WebElement AddScreenButton;
///html/body/app-root/body/div[2]/app-displayscreens/div/table/tbody/tr[6]/td[6]/button
	public void goToScreen() {
		Screen.click();
		ClickScreenButton.click();
	}
	
	public void enterScreenId( String screenId) {
		ScreenId.sendKeys(screenId);
	}
	
public void enterScreenName( String screenName) {
	ScreenName.sendKeys(screenName);
	}
public void enterRows( String rows) {
	Rows.sendKeys(rows);
}
public void enterColumns( String columns) {
	Columns.sendKeys(columns);
}
public void enterShowId( String showId) {
	ShowId.sendKeys(showId);
}
public void enterShowName( String showName) {
	ShowName.sendKeys(showName);
}
public void enterShowStartTime( String showStartTime) {
	ShowStartTime.sendKeys(showStartTime);
}
public void enterShowEndTime( String showEndTime) {
	ShowEndTime.sendKeys(showEndTime);
}

	
	public void addScreen()
	{
		AddScreenButton.click();
	}
	

}
