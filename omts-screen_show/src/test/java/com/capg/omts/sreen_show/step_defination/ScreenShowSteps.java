package com.capg.omts.sreen_show.step_defination;




import com.capg.omts.sreen_show.base_class.Library;

import com.capg.omts.sreen_show.pages.ScreenShowHomePage;
import com.capg.omts.sreen_show.selenium_reuseablefunction.SeleniumUtility;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class ScreenShowSteps extends Library {
	ScreenShowHomePage screen;
	
	    SeleniumUtility seleniumUtility;
	    @Given("Open  OnlineMovieTicketSystem")
	    public void open_OnlineMovieTicketSystem() {
	       browserSetUp();
	       logger.info("OnlineMovieTicketSystem is Launched");
	    }

	    @When("Goto Screen And Click On Add Screen")
	    public void goto_Screen_And_Click_On_Add_Screen() {
	    	screen=new ScreenShowHomePage(driver);
	    	screen.goToScreen();
	    	 logger.info("Opened Screen Page ");
	    }

	    @Then("Enter ScreenDetails")
	    public void enter_ScreenDetails() {
	    	screen=new ScreenShowHomePage(driver);
	    	screen.enterScreenId(properties.getProperty("screenId"));
	    	screen.enterScreenName(properties.getProperty("screenName"));
	    	screen.enterRows(properties.getProperty("rows"));
	    	screen.enterColumns(properties.getProperty("columns"));
	    	screen.enterShowId(properties.getProperty("showId"));
	    	screen.enterShowName(properties.getProperty("showName"));
	    	screen.enterShowStartTime(properties.getProperty("showStartTime"));
	    	screen.enterShowEndTime(properties.getProperty("showEndTime"));
	    }

	    @Then("Click AddScreen Button")
	    public void click_AddScreen_Button() {
	    	screen=new ScreenShowHomePage(driver);
	    	 seleniumUtility=new SeleniumUtility(driver);
	    	screen.addScreen();
	    	 seleniumUtility.switchToAlert();
	   
	    }

	    @Then("Take the Screenshot and the Title")
	    public void take_the_Screenshot_and_the_Title() {
	    	  seleniumUtility=new SeleniumUtility(driver);
	    
//   seleniumUtility.switchToAlert();
    seleniumUtility.to_take_screenshot("addScreen");
	    }

	

	  }
