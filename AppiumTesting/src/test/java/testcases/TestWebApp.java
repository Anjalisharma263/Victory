package testcases;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestWebApp {
	
	
	public static AndroidDriver driver;

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		//File app = new File(".\\app\\selendroid.apk");

		DesiredCapabilities cap = new DesiredCapabilities();
		
		//cap.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "android");
		//cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		
	
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.samsung.android.contacts");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.android.dialer.DialtactsActivity");
		

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.id("com.samsung.android.contacts:id/floating_action_button")).click();
		driver.findElement(By.id("com.samsung.android.contacts:id/one")).click();
		driver.findElement(By.id("com.samsung.android.contacts:id/two")).click();
		driver.findElement(By.id("com.samsung.android.contacts:id/three")).click();
		driver.findElement(By.id("com.samsung.android.contacts:id/five")).click();
		
		driver.findElement(By.id("com.samsung.android.contacts:id/dialButtonImage1")).click();
	/*
	 * app package, app activity
		driver.get("http://google.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.name("q")).sendKeys("Hello Appium !!!");
		
*/		Thread.sleep(2000);
		driver.quit();
	}

}
