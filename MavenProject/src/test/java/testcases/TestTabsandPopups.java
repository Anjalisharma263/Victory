package testcases;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestTabsandPopups {

	public static void main(String[] args) {


		
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("--disable-extensions");
		options.addArguments("--disable-infobars");
	
		
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.hdfcbank.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		
		
		System.out.println("---Generating window ids from first window---");
		
		Set<String> winids = driver.getWindowHandles();
		Iterator<String> iterator = winids.iterator();
		
		String first_window = iterator.next(); //1st
		System.out.println(first_window);
		
		driver.findElement(By.className("popupCloseButton")).click();
		
		
		driver.findElement(By.id("loginsubmit")).click();
		
		System.out.println("---Generating window ids from second window---");
		winids = driver.getWindowHandles();
		iterator = winids.iterator();
		
		System.out.println(iterator.next()); //1st window
		String second_window = iterator.next(); //second window
		System.out.println(second_window);
		
		driver.switchTo().window(second_window);
		
		driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/div/div[1]/div/a")).click();
		
		driver.findElement(By.xpath("//*[@id=\"customertab1\"]/div[1]/div[2]/p[5]/strong/a")).click();
		
		
		System.out.println("---Generating window ids from third window---");
		winids = driver.getWindowHandles();
		iterator = winids.iterator();
		
		System.out.println(iterator.next()); //1st window
		System.out.println(iterator.next());
		
		String third_window = iterator.next(); //3rd window
		System.out.println(third_window);
		
		driver.switchTo().window(third_window);
		
		System.out.println(driver.getTitle().contains("HDFC Bank | Customer"));
		
		/*driver.close(); //3rd window
		driver.switchTo().window(second_window);
		driver.close();
		driver.switchTo().window(first_window);
		driver.close();*/
		
		driver.quit();

	}

}
