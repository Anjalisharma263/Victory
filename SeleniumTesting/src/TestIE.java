import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class TestIE {

	public static void main(String[] args) {


	/*	DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		
		
		WebDriver driver = new InternetExplorerDriver(capabilities);
*/		
		
		WebDriver driver = new EdgeDriver();
		
		driver.get("http://google.com");

	}

}
