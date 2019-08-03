package base;

import org.openqa.selenium.By;

import pages.LandingPage;

public class TopNavigation {
	
	
/*	public WebDriver driver;
	
	public TopNavigation(WebDriver driver) {
		
		this.driver = driver;
	}
	*/
	
	public void doSearch() {
		
		
	}
	
	public void logOut() {
		
		Page.driver.findElement(By.id("userNavigationLabel")).click();
		Page.driver.findElement(By.xpath("//*[contains(text(),'Log Out')]")).click();
	}
	
	
	public LandingPage gotoHome() {
		
		
		Page.driver.findElement(By.xpath("//*[starts-with(@id,'js_')]/div/div/div[1]/div[1]/h1/a/span")).click();
		
		return new LandingPage();
	}

}
