package testnglearning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBrowser {
	
	public WebDriver driver;
	
	@Test(threadPoolSize = 5, invocationCount = 4,  timeOut = 10000)
	public void testBrowser() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://gmail.com");
		

	}

}
