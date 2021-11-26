package Scroll;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Scroll_browser1 {

    WebDriver driver = null;
    String projectPath = System.getProperty("user.dir");

    @Parameters("browserName")
    @BeforeTest
    public void setup(String browserName) {
        System.out.println("Browser name is : " + browserName);
        System.out.println("Thread ID : "+ Thread.currentThread().getId());

        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", projectPath+"/Drivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", projectPath+"/Drivers/geckodriver.exe");
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS);
        } 
    }
    
    @Test
    public void LaunchUrl() throws Exception {
    	driver.get("https://freecrm.com/");
    		 
    	    
    	
}
    @Test(dependsOnMethods="LaunchUrl")
    public void Scroll() throws Exception {
    	
    	JavascriptExecutor j = (JavascriptExecutor) driver;
    	j.executeScript("window.scrollBy(0,5000)");   	 
    	Thread.sleep(10000);
    	
}
    @Test(dependsOnMethods="Scroll")
    public void twitterlaunch() throws InterruptedException {
    	
    	WebElement element = driver.findElement(By.xpath("//a[@href='https://twitter.com/cogmento']"));
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    	element.click();
    	
    	
    }
    @Test(dependsOnMethods="twitterlaunch")
    public void facebooklaunch() throws InterruptedException {
    	WebElement element = driver.findElement(By.xpath("//a[@href='https://www.facebook.com/cogmento']"));
    	
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    	element.click();
    	
    	
    }
    @Test(dependsOnMethods="facebooklaunch")
    public void githublaunch() throws InterruptedException {
    	WebElement element = driver.findElement(By.xpath("//a[@href='https://github.com/cogmento']"));
    	
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    	element.click();
    	
    }
    @Test(dependsOnMethods="githublaunch")
    public void telegram() throws InterruptedException {
    	
    	WebElement element = driver.findElement(By.xpath("//a[@href='https://t.me/cogmento']"));
    	
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    	element.click();
    
    	
    }
}