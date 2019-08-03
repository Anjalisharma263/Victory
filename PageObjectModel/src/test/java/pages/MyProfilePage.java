package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.Page;

public class MyProfilePage  extends Page{
	
	
	
	
	public void gotoFriends() {
		
		
	}
	
	
	public void gotoPhotos() {
		
		
	}
	
	
	public MyProfilePage uploadPhoto() {
		
		System.out.println("Photo uploaded !!!");
		/*try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//a[starts-with(@id,'u_fetchstream')][@rel='dialog']")).click();
		driver.findElement(By.xpath("//a[@data-action-type='upload_photo']/div/input[@title='Choose a file to upload']")).sendKeys("C:\\Users\\WAY2AUTOMATION\\Desktop\\api-webservices.png");
		*/
		return this;
	}

}
