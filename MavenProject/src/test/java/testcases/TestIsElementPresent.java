package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestIsElementPresent {
	
	public static WebDriver driver;
	
	public static boolean isElementPresent(By by) {
		
		/*try {
		driver.findElement(By.id(id));
		return true;
		}catch(Throwable t) {
			
			return false;
		}*/
		
		
		int size = driver.findElements(by).size();
		
		if(size==0) {
			
			return false;
		}else {
			
			return true;
		}
		
	}

	
	
	
	
	public static void main(String[] args) {


		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.gmail.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		System.out.println(isElementPresent(By.xpath("//*[@id='identifierId']")));

	}

}
