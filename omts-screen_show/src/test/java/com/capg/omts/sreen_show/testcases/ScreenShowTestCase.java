package com.capg.omts.sreen_show.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.capg.omts.sreen_show.base_class.Library;
import com.capg.omts.sreen_show.pages.ScreenShowHomePage;
import com.capg.omts.sreen_show.selenium_reuseablefunction.SeleniumUtility;



public class ScreenShowTestCase extends Library {
	SeleniumUtility seleniumUtil;
	ScreenShowHomePage screenPage;
	@BeforeTest
	public void launchApp()
	{
		browserSetUp();
		logger.info("Browser Launched");
	}
	
	
	@Test
	public void displayScreens() {
		//screenPage=new ScreenShowHomePage(driver);
	
		logger.info("Browser display screen successfully");
	}
	
	@AfterTest
	public void close() {
		
		seleniumUtil = new SeleniumUtility(driver);   
		seleniumUtil.getTitle();
		seleniumUtil.to_take_screenshot("loginPage");
		tearDown();  
		logger.info("Closing Browser");
	}
	
	

}
