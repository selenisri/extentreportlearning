package TestCases;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.openqa.selenium.TakesScreenshot;
import PageObjects.AddUserPage;
import PageObjects.Loginpageobject;

public class LoginCases extends BaseBrowser {
	
	@Test
	(priority=7)
	public   void aLogin() 
	{
		
	   PageFactory.initElements(driver,Loginpageobject.class);
	   Loginpageobject.EnterText(driver, "teddy@mailinator.com");
	   Loginpageobject.EnterPassword(driver, "Password@123");
	   Loginpageobject.ClickSubmit(driver);
	   try
	   {
	   String text= Loginpageobject.getEmail(driver);
	   if(text.contains("teddy@mailinator.com"))
	   {
		   System.out.println("Pass");
	   }
	   }
	   catch (Exception e) {
		
		   System.out.println("Something went wrong !");
		  
	}
	     
}

	@Test
	(priority=1)
	public   void InavalidEmailandPassword() throws InterruptedException 
	{
		
		//This cases will check invalid Email and password validation
		
	   PageFactory.initElements(driver,Loginpageobject.class);
	   Loginpageobject.EnterText(driver, "Email@gmailx.com");
	   Loginpageobject.EnterPassword(driver, "Password");
	   Loginpageobject.ClickSubmit(driver);
	   try
	   {
	   String getError = Loginpageobject.getEmailError(driver);
	   if(getError.contains("Hussainme"))
	   {
		   System.out.println("Pass");
	   }
	   else
	   {   
		   File ss = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		   File destination = new File("screenshots/screenshot.png");
           FileUtils.copyFile(ss, destination);
           System.out.println("Failed");
	   }
	   }
	   catch(Exception e)
	   {
		   System.out.println("Something went wrong");
	   }
	   
	   
}
	@Test
	(priority=2)
	public  void EmptyPasswordValidation()
	{
		  //This case will check the Error Message Displayed in the Page if Password Fied is Empty
		
		   PageFactory.initElements(driver,Loginpageobject.class);
		   Loginpageobject getObject = new Loginpageobject();
		   getObject.clearFields(driver,"email");
		   Loginpageobject.EnterText(driver, "sriramraoxd@gmail.com");
		   getObject.clearFields(driver,"Password");
		   Loginpageobject.EnterPassword(driver, "");
		   Loginpageobject.ClickSubmit(driver);
		   try
		   {
		   String getError = Loginpageobject.getPasswordError(driver);
		   if(getError.contains("Password is required"))
		   {
			   System.out.println("Pass");
		   }
		   else
		   {
			   System.out.println("Fail");
		   }
		   }
		   catch(Exception e)
		   {
			   System.out.println("Something went wrong xxx");
		   }
		
	}
	
	
	@Test
	(priority=3)
	public  void InvalidEmailFormat()
	{
		  //This case will check the Error Message Displayed in the Page if Email  Fied is in invalid format
		
		   PageFactory.initElements(driver,Loginpageobject.class);
		   Loginpageobject getObject = new Loginpageobject();
		   getObject.clearFields(driver,"email");
		   Loginpageobject.EnterText(driver, "sriramraoxdgmailcom");
		   getObject.clearFields(driver,"Password");
		   Loginpageobject.EnterPassword(driver, "Hello@123");
		   Loginpageobject.ClickSubmit(driver);
		   try
		   {
		   String getError = Loginpageobject.getEmailError(driver);
		   if(getError.contains("Please enter a valid email address"))
		   {
			   System.out.println("Pass");
		   }
		   else
		   {
			   System.out.println("Fail");
		   }
		   }
		   catch(Exception e)
		   {
			   System.out.println("Something went wrong yyy");
		   }
		
	}
	
	@Test
	(priority=4)
	public  void EmptyEmailEmptyPassword()
	{
		  //This case will check the Error Message Displayed in the Page if Email is Empty and Passwod is Empty
		
		   PageFactory.initElements(driver,Loginpageobject.class);
		   Loginpageobject getObject = new Loginpageobject();
		   getObject.clearFields(driver,"email");
		   getObject.clearFields(driver,"Password");
		   Loginpageobject.ClickSubmit(driver);
		   try
		   {
		   String getError = Loginpageobject.getEmailError(driver);
		   String getErrortwo = Loginpageobject.getPasswordError(driver);
		   if(getError.contains("Email is required")&&getErrortwo.contains("Password is required"))
		   {
			   System.out.println("Pass");
		   }
		   else
		   {
			   System.out.println("Fail");
		   }
		   }
		   catch(Exception e)
		   {
			   System.out.println("Something went wrong");
		   }
		
	}
	
	
	
	
	
	
	
	
	
//	@Test
//	(priority=8)
//	public   void bLogin() throws InterruptedException 
//	{
//		
//	   PageFactory.initElements(driver,Loginpageobject.class);
//	   driver.get("https://beta.zippyform.io/profile/");
//	   //driver.manage().window().maximize();
//	   String hum=Loginpageobject.getLastRowDate(driver);
//	   System.out.println(hum);
//	   
//}

	
	
	

}
