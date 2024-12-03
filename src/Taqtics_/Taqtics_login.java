package Taqtics_;

	
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;
	import org.testng.Assert;

	public class Taqtics_login {

	    private WebDriver driver;

	    @BeforeMethod
	    public void InitializeBrowser() {
	        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver"); 
	        driver = new ChromeDriver();
	    }

	    @Test(priority=1)
	    public void testSuccessfulLogin() {
	        driver.get("https://landmark.taqtics.co");
	        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("intern@taqtics.co");
	        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("TestIntern@123"); 
	        driver.findElement(By.xpath("//button[@type='submit']")).click(); 

	        // Assertion to check successful login (e.g., check for a specific element on the dashboard)
	        Assert.assertTrue(driver.getTitle().contains("Dashboard")); 
	    }

	    @Test(priority=2)
	    public void testInvalidcredentials() {
	        
	        driver.get("https://landmark.taqtics.co");
	        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("intern@taqti.co");  //Invalid email id
	        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Test123");  //Invalid Password
	        driver.findElement(By.xpath("//button[@type='submit']")).click();
	        Assert.assertTrue(driver.getPageSource().contains("Not Found")); 
	    }
	    
	    
	    @Test(priority=3)
        public void testInvalidPassword() {
	        
	        driver.get("https://landmark.taqtics.co");
	        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("intern@taqtics.co");
	        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Test123");  //Invalid Password
	        driver.findElement(By.xpath("//button[@type='submit']")).click();
	        Assert.assertTrue(driver.getPageSource().contains("Invalid Credentials")); 
	    }

	    @Test(priority=4)
        public void testInvalidEmail() {
	        
	        driver.get("https://landmark.taqtics.co");
	        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("intern@taqts.co");//Invalid Email
	        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Test123");  
	        driver.findElement(By.xpath("//button[@type='submit']")).click();
	        Assert.assertTrue(driver.getPageSource().contains("Not Found")); 
	    }
	    
	    @Test(priority=5)
        public void testEmptyE() {
	        
	        driver.get("https://landmark.taqtics.co");
	        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(""); //Empty Email field
	        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("TestIntern@123"); 
	       // driver.findElement(By.xpath("//button[@type='submit']")).click();
	        Assert.assertTrue(driver.getTitle().contains("Please input your email")); // error message
	    }
	    
	    @Test(priority=6)
        public void testEmptyP() {
	        
	        driver.get("https://landmark.taqtics.co");
	        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("intern@taqtics.co"); //Empty Email field
	        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(""); //Empty password field
	       // driver.findElement(By.xpath("//button[@type='submit']")).click();
	        Assert.assertTrue(driver.getTitle().contains("Please input your Password")); // error message
	    }
	    

	    @AfterMethod
	    public void tearDown() {
	        driver.quit();
	    }
	}


		
		 




