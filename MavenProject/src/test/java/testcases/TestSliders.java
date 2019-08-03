package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestSliders {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get("https://jqueryui.com/resources/demos/slider/default.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		
		WebElement mainSlider = driver.findElement(By.xpath("//*[@id=\"slider\"]"));
		
		int width = mainSlider.getSize().width/2;
		
		WebElement slider = driver.findElement(By.xpath("//*[@id=\"slider\"]/span"));
		
		Thread.sleep(3000);
		new Actions(driver).dragAndDropBy(slider, width, 0).perform();
		
		
		
	}

}
