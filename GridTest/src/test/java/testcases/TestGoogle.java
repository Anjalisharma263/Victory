package testcases;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestGoogle {

	public WebDriver driver;
	public DesiredCapabilities cap = new DesiredCapabilities();



	@Parameters({"browser"})
	@Test
	public void testWeb(String b) throws InterruptedException, MalformedURLException {

		Date d = new Date();
		System.out.println(d);
		System.out.println(b);
		Thread.sleep(2000);

		if (b.equals("chrome")) {
			
			
			cap.setPlatform(Platform.ANY);
			cap.setBrowserName("chrome");
			
			ChromeOptions options = new ChromeOptions();
			options.merge(cap);

		

		} else if (b.equals("firefox")) {

			cap.setBrowserName("firefox"); 
			cap.setPlatform(Platform.ANY);
			
			FirefoxOptions options = new FirefoxOptions();
			options.merge(cap);
		

		}
		
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
		
		driver.get("http://google.com");
		driver.findElement(By.name("q")).sendKeys("Hello Selenium !!!");
		
		driver.quit();

	}

}
