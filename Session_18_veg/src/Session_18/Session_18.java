package Session_18;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Session_18 {

	String projectPath = System.getProperty("user.dir");
	WebDriver driver; 
	
	@BeforeClass
	public void Launch_portal() {
		System.setProperty("webdriver.chrome.driver", projectPath+"/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


	}
	@Test
	public void Add_to_Cart() {	
		driver.findElement(By.xpath("//*[@id='root']/div/div[1]/div/div[1]/div[3]/button")).click();
		driver.findElement(By.xpath("//*[@id='root']/div/div[1]/div/div[2]/div[3]/button")).click();
		driver.findElement(By.xpath("//*[@id='root']/div/div[1]/div/div[3]/div[3]/button")).click();
		driver.findElement(By.xpath("//*[@id='root']/div/div[1]/div/div[4]/div[3]/button")).click();
		driver.findElement(By.xpath("//*[@id='root']/div/div[1]/div/div[5]/div[3]/button")).click();
		driver.findElement(By.xpath("//*[@id='root']/div/header/div/div[3]/a[4]/img")).click();
	}
	@Test (dependsOnMethods = "Add_to_Cart")
	public void Vegetable_Name()
	{
		String Vegetable_1 = driver.findElement(By.xpath("//*[@id='root']/div/header/div/div[3]/div[2]/div[1]/div[1]/ul/li[1]/div[1]/p[1]")).getText();
		System.out.println("Product Name "+ Vegetable_1);
		String Vegetable_2 = driver.findElement(By.xpath("//*[@id='root']/div/header/div/div[3]/div[2]/div[1]/div[1]/ul/li[2]/div[1]/p[1]")).getText();
		System.out.println("Product Name "+ Vegetable_2);
		String Vegetable_3 = driver.findElement(By.xpath("//*[@id='root']/div/header/div/div[3]/div[2]/div[1]/div[1]/ul/li[3]/div[1]/p[1]")).getText();
		System.out.println("Product Name "+ Vegetable_3);
		String Vegetable_4 = driver.findElement(By.xpath("//*[@id='root']/div/header/div/div[3]/div[2]/div[1]/div[1]/ul/li[4]/div[1]/p[1]")).getText();
		System.out.println("Product Name "+ Vegetable_4);
		String Vegetable_5 = driver.findElement(By.xpath("//*[@id='root']/div/header/div/div[3]/div[2]/div[1]/div[1]/ul/li[5]/div[1]/p[1]")).getText();
		System.out.println("Product Name "+ Vegetable_5);
	}
	@Test (dependsOnMethods = "Vegetable_Name")
	public void Vegetable_Cost()
	{
		String Product_Cost_1 = driver.findElement(By.xpath("//*[@id='root']/div/header/div/div[3]/div[2]/div[1]/div[1]/ul/li[1]/div[2]/p[2]")).getText();
		System.out.println("Product Price "+ Product_Cost_1);
		String Product_Cost_2 = driver.findElement(By.xpath("//*[@id='root']/div/header/div/div[3]/div[2]/div[1]/div[1]/ul/li[2]/div[2]/p[2]")).getText();
		System.out.println("Product Price "+ Product_Cost_2);
		String Product_Cost_3 = driver.findElement(By.xpath("//*[@id='root']/div/header/div/div[3]/div[2]/div[1]/div[1]/ul/li[3]/div[2]/p[2]")).getText();
		System.out.println("Product Price "+ Product_Cost_3);
		String Product_Cost_4 = driver.findElement(By.xpath("//*[@id='root']/div/header/div/div[3]/div[2]/div[1]/div[1]/ul/li[4]/div[2]/p[2]")).getText();
		System.out.println("Product Price "+ Product_Cost_4);
		String Product_Cost_5 = driver.findElement(By.xpath("//*[@id='root']/div/header/div/div[3]/div[2]/div[1]/div[1]/ul/li[5]/div[2]/p[2]")).getText();
		System.out.println("Product Name "+ Product_Cost_5);
		int Vegetable_Cost_1 =Integer.parseInt(Product_Cost_1);
		int Vegetable_Cost_2 =Integer.parseInt(Product_Cost_2);
		int Vegetable_Cost_3 =Integer.parseInt(Product_Cost_3);
		int Vegetable_Cost_4 =Integer.parseInt(Product_Cost_4);
		int Vegetable_Cost_5 =Integer.parseInt(Product_Cost_5);
		int Total_Cost = (Vegetable_Cost_1+Vegetable_Cost_2+Vegetable_Cost_3+Vegetable_Cost_4+Vegetable_Cost_5);
		System.out.println("Total Vegetable "+Total_Cost);	
		driver.findElement(By.xpath("//*[@id='root']/div/header/div/div[3]/div[2]/div[2]/button")).click();
		String TotalCost = driver.findElement(By.xpath("//*[@id='root']/div/div/div/div/span[1]")).getText();
		System.out.println("Total Vegetable Cost "+TotalCost);
		int TotalCos =Integer.parseInt(TotalCost);
		Assert.assertEquals(Total_Cost, TotalCos);
	}
	@AfterClass
	public void finish() 
	{
	driver.quit();
	System.out.println("Added Products Successfully");
	} 
}