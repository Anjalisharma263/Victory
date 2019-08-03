package testnglearning;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestCase2 {
	
	
	@Test
	public void validateTitles() {
		
		String expected_title = "yahoo.com";
		String actual_title = "gmail.com";
		
		System.out.println("Beginning");
		
		/*SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actual_title, expected_title);
		softAssert.assertEquals("raman", "raman");
		softAssert.assertEquals("tom", "tom");
		Assert.assertEquals(actual_title, expected_title);
		Assert.assertEquals("raman", "rahul");
		Assert.assertEquals("tom", "cory");
		
		System.out.println("Ending");
		
		softAssert.assertAll();*/
		
		Assert.assertTrue(false,"button not present");
		//Assert.assertTrue(false,"Button not present");
		//Assert.fail("Failing the test as the condition is not met");		
		/*if(expected_title.equals(actual_title)) {
			
			System.out.println("Test case pass");
		}else {
			
			System.out.println("Test case fail");
		}*/
		
	}

}
