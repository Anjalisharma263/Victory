package testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.TestUtil;
import java.lang.Object;
import java.util.concurrent.TimeUnit;

public class FindInhouseDirection extends BaseTest {
	
	@Test
	public void  findInhouseDirection() {
		
	System.out.println("going to click continue button");
		click("continuebtn_ID");
		System.out.println(" clicked continue button");
		click("getDirection_ID");
		System.out.println(" clicked getdirection  button");
//		Boolean isAllowLocationPresent =BaseTest.isElementPresent("allowLocation_ID");
//		if(isAllowLocationPresent==true) {
//			System.out.println("location button found");
//			click("allowLocation_ID");
//		}
		
		try {
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(Config.getProperty("implicit.wait")),TimeUnit.SECONDS);
			driver.findElement(By.id("detail_layout_parent")).click();
		//	driver.findElement(By.xpath("//*[id='card_recycler_view']//*")).click();
		}
		catch(Throwable t) {
			System.out.println(t.getMessage());
		}
		
		try {
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(Config.getProperty("implicit.wait")),TimeUnit.SECONDS);
			driver.findElement(By.id("menu_items_mapit")).click();
		//	driver.findElement(By.xpath("//*[id='card_recycler_view']//*")).click();
		}
		catch(Throwable t) {
			System.out.println(t.getMessage());
		}
	//	findElementByAndroidUIAutomator(new UiSelector().textContains("Find a Person"))
		//driver.findElement(By.xpath(xpathExpression)(OR.getProperty(key))).click();
		//click("findPersonDropDown_Xpath");
//		Boolean findPersonDropDown =isElementPresent("findPersonDropDown_Xpath");
//		System.out.println(findPersonDropDown);
		/*click("findPersonDropDown_Xpath");
		System.out.println(" clicked findperson button");*/
	}

}
