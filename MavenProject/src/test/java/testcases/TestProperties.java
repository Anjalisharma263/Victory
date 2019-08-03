package testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.MonitoringMail;
import utilities.TestConfig;

public class TestProperties {
	
	
	/*
	 * 
	 * Log4j API - jar - done
	 * Logger  - getLogger
	 * Log4j Appenders - log4j.properties
	 * 
	 * Javamail
	 * 
	 * 
	 */

	public static WebDriver driver;
	public static Properties OR = new Properties();
	public static Properties Config = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger(TestProperties.class.getName());
	public static MonitoringMail mail = new MonitoringMail();
	
	public static void click(String key) throws AddressException, MessagingException {
		try {
		if (key.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(key))).click();
		} else if (key.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(key))).click();
		} else if (key.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(key))).click();
		}}catch(Throwable t) {
			
			log.error(t.getMessage());
			mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, t.getMessage(), TestConfig.attachmentPath, TestConfig.attachmentName);
			
		}
		
		log.info("Clicking on an element : "+key);

	}

	public static void type(String key, String value) throws AddressException, MessagingException {

		try {
		if (key.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(key))).sendKeys(value);
		} else if (key.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(key))).sendKeys(value);
		} else if (key.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(key))).sendKeys(value);
		}}catch(Throwable t) {
			
			log.error(t.getMessage());
			mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, t.getMessage(), TestConfig.attachmentPath, TestConfig.attachmentName);
			
		}
		
		log.info("Typing in an Element : "+key+" entered value as : "+value);
	}

	public static void main(String[] args) throws IOException, AddressException, MessagingException {

		Date d = new Date();
		System.setProperty("current.date", d.toString().replace(":", "_").replace(" ", "_"));
		PropertyConfigurator.configure("./src/test/resources/properties/log4j.properties");
		
		
		fis = new FileInputStream("./src/test/resources/properties/OR.properties");
		OR.load(fis);
		log.info("OR Properties loaded !!!");

		fis = new FileInputStream("./src/test/resources/properties/Config.properties");
		Config.load(fis);
		log.info("Config Properties loaded !!!");

		// driver.findElement(By.id(OR.getProperty("username_ID"))).sendKeys(excel);
		System.out.println(OR.getProperty("username_ID"));

		// driver.get(Config.getProperty("testsiteurl"));
		System.out.println(Config.getProperty("testsiteurl"));

		if (Config.getProperty("browser").equals("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			log.info("Chrome browser launched !!!");

		} else if (Config.getProperty("browser").equals("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			log.info("Firefox browser launched !!!");
		} else if (Config.getProperty("browser").equals("ie")) {

			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();

		}

		driver.get(Config.getProperty("testsiteurl"));
		log.info("Navigated to : "+Config.getProperty("testsiteurl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(Config.getProperty("implicit.wait")),
				TimeUnit.SECONDS);

		type("username_ID", "trainer@way2automation.com");
		click("nextBtn_XPATH");
		

		driver.close();

		log.info("Test execution completed !!!");
	}

}
