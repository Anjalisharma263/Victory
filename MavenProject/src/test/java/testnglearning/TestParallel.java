package testnglearning;

import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestParallel {
	
	public WebDriver driver;
	
	
	@Parameters({"browser","url"})
	@Test
	public void testWeb(String b, String u) throws InterruptedException {
		
		Date d = new Date();
		System.out.println(d);
		System.out.println(b+"----"+u);
		Thread.sleep(2000);
		
		if(b.equals("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(u);
			
		}else if(b.equals("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(u);
			
		}
		
	}

}
