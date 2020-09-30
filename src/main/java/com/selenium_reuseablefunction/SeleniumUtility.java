package com.selenium_reuseablefunction;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base_class.Library;

public class SeleniumUtility extends Library {
	
	
	public SeleniumUtility(WebDriver driver) {
		this.driver = driver;
	}

	public void to_take_screenshot(String Screenshotname) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(source, new File("src/test/resources/ScreenShots/" + Screenshotname + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void getTitle() {
		System.out.println(driver.getTitle());
	}

	public void Explicitlywait(String XpathLocator) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(XpathLocator))));
	}

	public void dropdown(WebElement element, String name) {
		Select select = new Select(element);
		select.selectByVisibleText(name);
	}

	public void quit() {
		driver.close();
	}

}
