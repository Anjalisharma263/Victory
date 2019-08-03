package testcases;

import org.testng.annotations.Test;

import base.Page;
import pages.LandingPage;
import pages.MyProfilePage;

public class UploadPhotoTest {
	
	
	@Test
	public void uploadPhoto() {
		
		LandingPage lp = Page.topNav.gotoHome();
		MyProfilePage mp = lp.gotoProfile();
		mp.uploadPhoto();
		Page.topNav.logOut();
		
	}

}
