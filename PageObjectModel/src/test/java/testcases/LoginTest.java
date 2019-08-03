package testcases;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.LandingPage;

public class LoginTest {
	
	@Test//dataPRovider='getData'
	public void doLogin(/*String username, String password*/) {
		
		HomePage home = new HomePage();
		LandingPage lp = home.doLogin("prafulgupta84@yahoo.in", "Selenium@123");
	
		
	}
	
	
	//@DataProvider
	// TestUtil.getData("sheetName")

}
