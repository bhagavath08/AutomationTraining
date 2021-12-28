package Search_Potato;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Search_Potato {

	String projectPath = System.getProperty("user.dir");
	WebDriver driver; 
	
	@BeforeClass
	public void LaunchURL() 
	{
		System.setProperty("webdriver.chrome.driver", projectPath+"/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
	}
	@Test
	public void TopDeal()
	{
	driver.findElement(By.linkText("Top Deals")).click();	
	ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
	driver.switchTo().window(newTb.get(1));
	String title = driver.getTitle();
	System.out.println("Title Name is: "+title);
	}
	@Test(dependsOnMethods = "TopDeal")
	public void Top_Deals_Page()
	{
	WebElement search = driver.findElement(By.id("search-field"));
	search.sendKeys("Potato");
	}
	@Test(dependsOnMethods = "Top_Deals_Page")
	public void potato()
	{
	List<WebElement> tableRows = driver.findElements(By.xpath("//table[@class='table table-bordered']//tr"));
	String columfirst = "//table[@class='table table-bordered']//tr[";
	String columlast = "]//td";
	String column;
	List<WebElement> tablecolumns;
	for (int i=1;i<tableRows.size();i++)
	{
		column = columfirst+i+columlast;
		tablecolumns=driver.findElements(By.xpath(column));
		
		for (int j=0;j<tablecolumns.size();j++)
		{
			System.out.print(tablecolumns.get(j).getText()+"   ");
		}
		System.out.println();
	}
	}
	@AfterClass
	public void finish() 
	{
	driver.quit();
	System.out.println("Vegetable Search is Succesfull");
	} 
	   
}