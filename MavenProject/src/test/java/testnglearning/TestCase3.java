package testnglearning;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class TestCase3 {

	

	@Test(priority = 1)
	public void doUserReg() {

		
		Assert.fail("Submit button not present");
		
			
		
		//throw new SkipException(" ");
		
	
	}

	@Test(priority = 2, dependsOnMethods = "doUserReg")
	public void doLogin() {

		System.out.println("Executing Login Test");

	}

	@Test(priority = 3)
	public void isSkip() {

		throw new SkipException("Skipping the test as the condition is not met");

	}

}
