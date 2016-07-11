package com.refrence.javacore;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class navigation {

	public static void main(String[] args) throws AWTException, InterruptedException {
		
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		driver.get("http://testingpool.com");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		// Working
		
//		alignleft wp-image-2855
		WebElement sqlIcon = driver.findElement(By.cssSelector(".alignleft.wp-image-2855"));
		
		wait.until(ExpectedConditions.elementToBeClickable(sqlIcon));
		sqlIcon.click();
		Thread.sleep(3000);

		driver.navigate().back();
		Thread.sleep(3000);
		
		driver.navigate().forward();
		Thread.sleep(3000);
		
		driver.navigate().refresh();
		
				
		
	}

}
