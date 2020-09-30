package com.step_defination;

import org.junit.BeforeClass;

import com.base_class.Library;
import com.pages.MovieLoginPage;
import com.pages.TheatreAddPage;
import com.selenium_reuseablefunction.SeleniumUtility;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MovieTheatreSteps extends Library {

	TheatreAddPage addPage;
	SeleniumUtility seleniumUtility;

	@Given("To open add theatre form")
	public void to_open_add_theatre_form() {
		addPage = new TheatreAddPage(driver);
		addPage.clickAddBtn();
		logger.info("clicking to add button....");
	}

	@Then("fill theatre form")
	public void fill_theatre_form() {
		addPage = new TheatreAddPage(driver);
		addPage.fillForm();
		logger.info("filling theatre form....");
	}

	@Then("Click Save Button")
	public void click_Save_Button() {
		addPage = new TheatreAddPage(driver);
		addPage.clickSaveBtn();
		logger.info("clicking to save button....");
	}

	@Then("Take the Screenshot and the Title")
	public void take_the_Screenshot_and_the_Title() {
		seleniumUtility = new SeleniumUtility(driver);
		seleniumUtility.to_take_screenshot("movie_login");
		seleniumUtility.getTitle();
		logger.info("Taken Screenshot Of Login Page And Title printed in console");
	}

	@Then("Close the browser")
	public void close_the_browser() {
		tearDown();
		logger.info("Browser is Closed");
	}

}
