package com.reference.javacore;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class alertPopup {

	public static void main(String[] args) throws AWTException {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		driver.get("http://testingpool.com/wp-content/uploads/2015/08/AlertHandles.html");
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		// Back to main window
//		String windowHandle = driver.getWindowHandle();
//		driver.navigate().;
		
		// 1- Confirm button
		WebElement btnConfirm = driver.findElement(By.id("btnConfirm"));
		btnConfirm.click();
		
		// Cancel popup
//		Alert alert = driver.switchTo().alert();
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.dismiss();

		btnConfirm.click();

		// Ok button
		alert.accept();

		// id='btnPrompt'

		// 2- Alert button
		WebElement btnAlert = driver.findElement(By.id("btnAlert"));
		btnAlert.click();

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_SPACE);
		alert.accept();
		
		// 3- Alert button
		WebElement btnPrompt = driver.findElement(By.id("btnPrompt"));
		btnPrompt.click();
		
		alert.sendKeys("Hello");
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_SPACE);
		alert.accept();
		
//		Robot robot = new Robot();
//		driver.get("the url");
//		Alert alert=driver.switchTo().alert();
//		alert.sendKeys("username");
//		robot.keyPress(KeyEvent.VK_TAB);
//		alert.sendKeys("password");
//		alert.accept()

		
//		driver.quit();
		
		/**
		 * Reference: http://www.softwaretestinghelp.com/handle-alerts-popups-selenium-webdriver-selenium-tutorial-16/
		 * 
		 */
	}

}
