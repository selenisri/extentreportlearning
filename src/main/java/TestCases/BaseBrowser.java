package TestCases;

import org.testng.annotations.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.AddUserPage;
import PageObjects.Loginpageobject;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseBrowser  {
	protected WebDriver  driver ;
	
	
	@BeforeClass
	public  void browserConfigChrome() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://beta.zippyform.io/login/");
		driver.manage().window().maximize();
		
	}
	
	
	

    @AfterClass
	public  void tearDown() {
		// TODO Auto-generated method stub
		
		driver.quit();
		
	}
	
	
	
	   
	
	
}
