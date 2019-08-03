import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBrowser {

	public static String browser = "chrome";
	public static WebDriver driver;
	
	public static void main(String[] args) {
		
		

			if (browser.equals("chrome")) {

			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			// System.setProperty("webdriver.chrome.driver",
			// "F:\\selenium-prerequisite\\executables\\chromedriver.exe");
			driver = new FirefoxDriver();
		}

		driver.get("http://google.com");
		System.out.println(driver.getTitle());

		// driver.close();
		driver.quit();

	}

}
