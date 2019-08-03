package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBrowsers {

	public static void main(String[] args) throws InterruptedException {


		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		driver.get("http://gmail.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		/*String title = driver.getTitle();
		System.out.println(title.length());
		
		
*/
		
	/*	Options man = driver.manage();
		Window win = man.window();
		win.maximize();
		*/
		
		driver.manage().window().maximize();
		
		driver.getTitle().length();
		
		driver.manage().window().maximize();
		
/*		WebElement username = driver.findElement(By.id("identifierId"));
		username.sendKeys("trainer@way2automation.com");
		
		
		WebElement nextBtn = driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/content/span"));
		nextBtn.click();*/
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("identifierId"))).sendKeys("trainer@way2automation.com");
		
		//driver.findElement(By.id("identifierId")).sendKeys("trainer@way2automation.com");
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/content/span")).click();
		
		//Thread.sleep(10000);
		
		
		wait.until(ExpectedConditions.elementToBeClickable(By.name("password"))).sendKeys("sdfsdfdsfs");
		
		//driver.findElement(By.name("password")).sendKeys("asdfsdfs");
		driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/content/span")).click();
	
		System.out.println(driver.findElement(By.xpath("//*[@id=\"password\"]/div[2]/div[2]/div")).getText());
	}

}
