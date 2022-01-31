package Miniproject;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class Miniproject {
WebDriver driver;
String projectPath = System.getProperty("user.dir");

//Passing Browser name in parameter since we need to run the test parallely in Different browsers
@Parameters("browserName")
@BeforeTest
public void setup(String browserName) {

	if (browserName.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", projectPath + "/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
	} else if (browserName.equalsIgnoreCase("firefox")) {
		System.setProperty("webdriver.gecko.driver", projectPath + "/Drivers/geckodriver.exe");
		driver = new FirefoxDriver();
	} else if (browserName.equalsIgnoreCase("edge")) {
		System.setProperty("webdriver.edge.driver", projectPath + "/Drivers/msedgedriver.exe");
		driver = new EdgeDriver();
	}
}

// Launching PEGA Demo site
@Test
public void launcurl() throws Exception {
driver.get("https://pega-86-demo.iqzsystems.io/prweb/app/default/b0aUC_g2NnC90uEC3dhEbKXJdQTMkXeP*/!STANDARD");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
}
// username entered in the portal
@Test (dependsOnMethods = "launcurl")
public void enterusername() throws Exception
{
WebElement username = driver.findElement(By.xpath("//input[@id='txtUserID']"));
username.sendKeys("tcapron");
}
// passwprd entered in portal
@Test (dependsOnMethods = "enterusername")
public void enterpswd() throws Exception
{
WebElement password = driver.findElement(By.xpath("//input[@id='txtPassword']"));
password.sendKeys("rules@123");
}
//Clicking Login button
@Test (dependsOnMethods = "enterpswd")
public void clicklogin() throws Exception
{
WebElement loginbutton = driver.findElement(By.xpath("//button[@id='sub']"));
loginbutton.click();
}
//Clicking on Menu Plus icon 
@Test (dependsOnMethods = "clicklogin")
public void clickexpandmenu() throws Exception
{
String PageTitle = driver.getTitle();
System.out.println("Print the Title of the Page :" + PageTitle);
WebElement menuitem = driver.findElement(By.xpath("(//span[contains(@role,'presentation')])[1]"));
menuitem.click();
WebElement individuallead = driver.findElement(By.xpath("(//a[contains(@role,'menuitem')])[7]"));
individuallead.click();
// Entering Details in Fields
WebElement firstname = driver.findElement(By.xpath("//input[@id='546ad300']"));
firstname.sendKeys("Bhagavath");
WebElement lastname = driver.findElement(By.xpath("//input[@id='6e54da89']"));
lastname.sendKeys("Arumuf");
//Clicking Submit button
Select stagedropdown = new Select(driver.findElement(By.name("$PpyWorkPage$pLeadStage")));
stagedropdown.selectByVisibleText("Marketing Qualified");
WebElement submitbutton = driver.findElement(By.xpath("//button[@title='Complete this assignment']"));
submitbutton.click();
System.out.println("Individual Lead created successfully");
}
//Clicking on Edit lead button
@Test (dependsOnMethods = "clickexpandmenu")
public void editlead() throws Exception
{
	driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
WebElement editbtn = driver.findElement(By.xpath("(//button[contains(@title,'Edit')][normalize-space()='Edit'])[2]"));
editbtn.click();
WebElement editfirstname = driver.findElement(By.xpath("//input[@id='546ad300']"));
editfirstname.clear();
editfirstname.sendKeys("bhagaath");
WebElement editlastname = driver.findElement(By.xpath("//input[@id='6e54da89']"));
editlastname.clear();
editlastname.sendKeys("tester");
// Clicking submit button after editing the details
WebElement sbtbutton = driver.findElement(By.xpath("//button[@title='Complete this assignment']"));
sbtbutton.click();
System.out.println("Individual Lead is edited successfully");
}
// Clicking on Convert lead
@Test (dependsOnMethods ="editlead")
public void convertlead() throws Exception
{
	driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
WebElement actions = driver.findElement(By.xpath("(//button[contains(@title,'Actions')][normalize-space()='Actions'])[2]"));
actions.click();
WebElement cnvtlead = driver.findElement(By.xpath("//span[contains(text(),'Convert lead')]"));
cnvtlead.click();
// Entering details in Convert lead fields
WebElement opportname = driver.findElement(By.xpath("(//input[@id='8dcd183b'])[1]"));
opportname.sendKeys("rules@123");
WebElement ammount = driver.findElement(By.xpath("(//input[@id='1dfe6fd2'])[1]"));
ammount.sendKeys("400");
WebElement datepicker = driver.findElement(By.xpath("(//input[@id='c0445fa3'])[1]"));
datepicker.click();
datepicker.sendKeys("1/20/2022");
// Clicking submit button in Convert lead fields
WebElement sbtbuttonclick = driver.findElement(By.xpath("//button[@title='Complete this assignment']"));
sbtbuttonclick.click();
System.out.println("Lead Conversion Successfull");
}

@AfterTest
public void finish() {
	driver.quit();
	System.out.println("Test execution is Done");
	}
}

	
	
	
	
	
	
	
	
	
	
	
	
