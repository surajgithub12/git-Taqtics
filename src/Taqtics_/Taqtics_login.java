package Taqtics_;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

public class Taqtics_login {

	private WebDriver driver;

	@BeforeMethod
	public void InitializeBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Selenium\\chromedriver-win32(1000)\\chromedriver-win32\\chromedriver.exe"); // Provide Chromedriver
																									// path
		driver = new ChromeDriver();
	}

	
	  @Test(priority=1) public void testSuccessfulLogin() throws
	  InterruptedException { driver.get("https://landmark.taqtics.co");
	  driver.findElement(By.xpath("//input[@id='email']")).sendKeys(
	  "intern@taqtics.co");
	  driver.findElement(By.xpath("//input[@type='password']")).sendKeys(
	  "TestIntern@123");
	  driver.findElement(By.xpath("//button[@type='submit']")).click();
	  
	  Thread.sleep(2000); String currentUrl = driver.getCurrentUrl(); String
	  expectedUrl = "https://landmark.taqtics.co/dashboard";
	  Assert.assertEquals(currentUrl, expectedUrl);
	  
	  }
	  
	  @Test(priority=2) public void testInvalidcredentials() throws
	  InterruptedException {
	  
	  driver.get("https://landmark.taqtics.co");
	  driver.findElement(By.xpath("//input[@id='email']")).sendKeys(
	  "intern@taqti.co"); //Invalid email id
	  driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Test123")
	  ; //Invalid Password
	  driver.findElement(By.xpath("//button[@type='submit']")).click();
	  
	  Thread.sleep(2000);
	  
	  WebElement notFoundPopup = driver.findElement(By.
	  xpath("//div[@class='ant-message-custom-content ant-message-error']"));
	  Assert.assertTrue(notFoundPopup.isDisplayed(),
	  "The 'Not Found' pop-up message is not displayed."); }
	  
	  
	  
	  @Test(priority=3) public void testInvalidPassword() throws
	  InterruptedException {
	  
	  driver.get("https://landmark.taqtics.co");
	  driver.findElement(By.xpath("//input[@id='email']")).sendKeys(
	  "intern@taqtics.co");
	  driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Test123")
	  ; //Invalid Password
	  driver.findElement(By.xpath("//button[@type='submit']")).click();
	  
	  Thread.sleep(2000);
	  
	  WebElement InvalidcredentialsPopup = driver.findElement(By.
	  xpath("//div[@class='ant-message-custom-content ant-message-error']"));
	  Assert.assertTrue(InvalidcredentialsPopup.isDisplayed(),
	  "The 'Invalid credentials!' pop-up message is not displayed.");
	  
	  }
	  
	  @Test(priority=4) public void testInvalidEmail() throws InterruptedException
	  {
	  
	  driver.get("https://landmark.taqtics.co");
	  driver.findElement(By.xpath("//input[@id='email']")).sendKeys(
	  "intern@taqts.co");//Invalid Email
	  driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Test123")
	  ; driver.findElement(By.xpath("//button[@type='submit']")).click();
	  
	  Thread.sleep(2000);
	  
	  WebElement notFoundPopup = driver.findElement(By.
	  xpath("//div[@class='ant-message-custom-content ant-message-error']"));
	  Assert.assertTrue(notFoundPopup.isDisplayed(),
	  "The 'Not Found' pop-up message is not displayed.");
	  
	  }
	  
	 
	@Test(priority = 5)
	public void testEmptyE() throws InterruptedException {

		driver.get("https://landmark.taqtics.co");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(""); // Empty Email field
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("TestIntern@123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		Thread.sleep(2000);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement errorMessage = driver.findElement(By.xpath("//div[@class='ant-form-item-explain-error']"));
		Assert.assertTrue(errorMessage.isDisplayed(), "The 'Please input your email!' error message is not displayed.");

		String expectedErrorMessage = "Please input your email!";
		String actualErrorMessage = errorMessage.getText();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage,"The error message does not match the expected message.");

	}

	@Test(priority = 6)
	public void testEmptyP() throws InterruptedException {

		driver.get("https://landmark.taqtics.co");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("intern@taqtics.co"); // Empty Email field
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(""); // Empty password field
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement errorMessage = driver.findElement(By.xpath("//div[@id='password_help']"));
		Assert.assertTrue(errorMessage.isDisplayed(),"The 'Please input your password!' error message is not displayed.");

		String expectedErrorMessage = "Please input your Password!";
		String actualErrorMessage = errorMessage.getText();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage,
				"The error message does not match the expected message.");
	}


 @AfterMethod
 public void tearDown() {
 driver.quit();
 }
}
