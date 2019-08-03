package testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestDropdowns {

	public static void main(String[] args) {

		/*
		 * English - US
		 * English - UK
		 * 
		 */

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.wikipedia.org/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		
		//driver.findElement(By.id("searchLanguage")).sendKeys("Eesti");
		WebElement dropdown = driver.findElement(By.id("searchLanguage"));
		
		Select select = new Select(dropdown);
		//select.selectByVisibleText("Eesti");
		select.selectByValue("hi");
		
		
		List<WebElement> values = dropdown.findElements(By.tagName("option"));
		
		System.out.println("Total values in dropdown are : "+values.size());
		
		System.out.println(values.get(7).getText());
		
		
		for(int i=0; i<values.size(); i++) {
			
			
			System.out.println(values.get(i).getAttribute("lang"));
		}
		
		
		WebElement block = driver.findElement(By.xpath("//*[@id='www-wikipedia-org']/div[6]/div[3]"));
		
		
		List<WebElement> links = block.findElements(By.tagName("a"));
		
		System.out.println("Total links are : "+links.size());
		
		
		
		for(WebElement link: links) {
			
			System.out.println(link.getText()+" --- URL IS --- "+link.getAttribute("href"));
		}
		
		
		
		

	}

}
