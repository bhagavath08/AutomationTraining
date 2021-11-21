package Demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Cross_Browser {

	String projectPath = System.getProperty("user.dir");
	WebDriver driver; 
	
	@BeforeTest
	public void setup() {
		
	System.setProperty("webdriver.chrome.driver", projectPath+"/Drivers/chromedriver.exe");
	
	 driver = new ChromeDriver();
		}
	@Test
	public void Googletest() throws Exception {
	driver.get("https://google.com");
	Thread.sleep(10000);
	}
	@Test
	public void yahootest() throws Exception {
	driver.get("https://yahoo.com");
	Thread.sleep(10000);
	}
	@AfterTest
	public void finish() {
	driver.quit();
	System.out.println("Test is successful");
	}
		
}
