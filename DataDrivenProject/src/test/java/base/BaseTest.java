package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.functions.ExpectedCondition;
import io.github.bonigarcia.wdm.WebDriverManager;
//import utilities.DbManager;
import utilities.ExcelReader;
import utilities.MonitoringMail;

public class BaseTest {

	/*
	 * WebDriver 
	 * Implicit and ExplicitWait 
	 * Screenshot
	 *  Properties
	 *   Log4J 
	 *   JavaMail
	 * Database
	 *  TestNG 
	 *  Excel Reader
	 *   Listeners 
	 *   ReportNG
	 *    Keywords - type, click,
	 * isElementPresent, captureScreenshot
	 * 
	 * 
	 * 
	 * 
	 */


	public static Properties OR = new Properties();
	public static Properties Config = new Properties();
	public static FileInputStream fis;
	public static ExcelReader excel = new ExcelReader("./src/test/resources/excel/testdata.xlsx");
	public static WebDriverWait wait;
	public static Logger log = Logger.getLogger(BaseTest.class.getName());
	public static MonitoringMail mail = new MonitoringMail();
	public static WebElement dropdown;
	protected static RemoteWebDriver driver;
	static DesiredCapabilities cabs = new DesiredCapabilities();
	static Properties prop= new Properties();
	
	public static void click(String key) {
		try {
			if (key.endsWith("_XPATH")) {
				driver.findElement(By.xpath(OR.getProperty(key))).click();
			} else if (key.endsWith("_ID")) {
				driver.findElement(By.id(OR.getProperty(key))).click();
			} else if (key.endsWith("_CSS")) {
				driver.findElement(By.cssSelector(OR.getProperty(key))).click();
			}
		} catch (Throwable t) {

			log.error(t.getMessage());

		}

		log.info("Clicking on an element : " + key);

	}

	public static void type(String key, String value) {

		try {
			if (key.endsWith("_ID")) {
				driver.findElement(By.id(OR.getProperty(key))).sendKeys(value);
			} else if (key.endsWith("_XPATH")) {
				driver.findElement(By.xpath(OR.getProperty(key))).sendKeys(value);
			} else if (key.endsWith("_CSS")) {
				driver.findElement(By.cssSelector(OR.getProperty(key))).sendKeys(value);
			}
		} catch (Throwable t) {

			log.error(t.getMessage());

		}

		log.info("Typing in an Element : " + key + " entered value as : " + value);
	}
	
	
	
	public static void select(String key,String value) {
		
		
		try {
			if (key.endsWith("_XPATH")) {
				dropdown = driver.findElement(By.xpath(OR.getProperty(key)));
			} else if (key.endsWith("_ID")) {
				dropdown =driver.findElement(By.id(OR.getProperty(key)));
			} else if (key.endsWith("_CSS")) {
				dropdown =driver.findElement(By.cssSelector(OR.getProperty(key)));
			}
		} catch (Throwable t) {

			log.error(t.getMessage());

		}
		Select select = new Select(dropdown);
		select.selectByVisibleText(value);

		log.info("Selecting an element : " + key+" the value as "+value);

	}

	
	
	

	public static boolean isElementPresent(String key) {

		try {
			if (key.endsWith("_XPATH")) {
				driver.findElement(By.xpath(OR.getProperty(key)));
				
			} else if (key.endsWith("_ID")) {
				driver.findElement(By.id(OR.getProperty(key)));
				
			} else if (key.endsWith("_CSS")) {
				driver.findElement(By.cssSelector(OR.getProperty(key)));
				
			}
		} catch (Throwable t) {
        System.out.println(t.getMessage());
			log.error(t.getMessage());
			return false;

		}

		log.info("Finding an element : " + key);
		return true;
	}

	@BeforeSuite
	public void setUp() throws MalformedURLException {
		
		Date d = new Date();
		System.setProperty("current.date", d.toString().replace(":", "_").replace(" ", "_"));

		PropertyConfigurator.configure("./src/test/resources/properties/log4j.properties");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("BROWSER_NAME", "Android");
		capabilities.setCapability("VERSION", "6.0.1");
		capabilities.setCapability("deviceName", "Nexus 5");
		capabilities.setCapability("platformName", "Android");
	    capabilities.setCapability("noReset", "true");
		capabilities.setCapability("newCommandTimeout", "5");

		if (driver == null) {

			try {
				fis = new FileInputStream("./src/test/resources/properties/Config.properties");
				Config.load(fis);
				log.info("Config file loaded !!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				fis = new FileInputStream("./src/test/resources/properties/OR.properties");
				OR.load(fis);
				log.info("OR file loaded !!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		/*	if (Config.getProperty("browser").equals("chrome")) {

				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				log.info("Chrome Browser launched !!!");

			} else if (Config.getProperty("browser").equals("firefox")) {

				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				log.info("Firefox Browser launched !!!");

			} else if (Config.getProperty("browser").equals("ie")) {

				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				log.info("IE Browser launched !!!");

			}*/

		/*
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(Config.getProperty("implicit.wait")),
					TimeUnit.SECONDS);*/
			capabilities.setCapability("appPackage", "com.logicjunction.ljindoorandroidclientia");
			// This package name of your app (you can get it from apk info app)
			capabilities.setCapability("appActivity", "com.logicjunction.ljindoorandroidclientia.SplashScreenActivity"); 

			driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			wait = new WebDriverWait(driver, 20);
			//driver.findElement(By.id(OR.getProperty("continuebtn_ID")));
			//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id(OR.getProperty("continuebtn_ID")))));
			/*try {
				DbManager.setMysqlDbConnection();
				log.info("Database Connection established !!!");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}

	}

	@AfterSuite
	public void tearDown() {

	//	driver.quit();
		log.info("Test execution completed !!!");

	}

}
