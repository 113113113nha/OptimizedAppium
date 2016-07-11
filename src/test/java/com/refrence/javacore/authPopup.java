package com.refrence.javacore;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class authPopup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String URI = "dev.octo.tokyo";
		String Username = "dev";
		String Password = "q8naj4kh";
		
		String URL = "http://" + Username + ":" + Password + "@" + URI;
		
		System.out.println(URI);
		
		WebDriver driver = new FirefoxDriver();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		driver.quit();
		
	}

}
