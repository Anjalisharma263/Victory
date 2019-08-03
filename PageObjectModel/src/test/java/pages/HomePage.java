package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import base.Page;

public class HomePage extends Page {
	
	
	/*
	 * 
	 * Properties
	 * Logs
	 * Excel
	 * Screenshot
	 * 
	 * 
	 * 
	 */
	
	
	
	public LandingPage doLogin(String username, String password) {
		
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("pass")).sendKeys(password);
		driver.findElement(By.id("pass")).sendKeys(Keys.ENTER);
		return new LandingPage();
	
	}
	
	
	public void createAccount(String firstName, String surName, String email) {
		
		
		
	}
	
	
	public void validateLinks() {
		
		
		
	}

}
