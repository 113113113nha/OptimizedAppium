package com.reference.javacore;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import libraries.utility.Log;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class javascriptExecutor {

	public static void main(String[] args) throws AWTException, InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		driver.get("http://tuoitre.vn");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		js.executeScript("window.scrollBy(0,1000)");

		js.executeScript("alert('Welcome to Javascript');");

	}

}
