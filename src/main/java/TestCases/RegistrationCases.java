package TestCases;

import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import PageObjects.Loginpageobject;
import PageObjects.RegistrationObject;

public class RegistrationCases extends BaseBrowser {

	@Test
	(priority=1)
	public void LandinRegistrationPage() throws InterruptedException
	{
		//Check the User Landed in the Registration Page
		
		PageFactory.initElements(driver,RegistrationObject.class);
		RegistrationObject Reg = new RegistrationObject();
		Reg.clickhere(driver ,"Register");
		try
		{
			String text=Reg.getValueText(driver, "getRegisterText");
			if(text.contains("Register"))
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
				System.out.println("Something went wrong !!!");
			}
		}
		
	
	
	@Test
	(priority=2)
	public void checkMandatoryValidation() throws InterruptedException
	{
		//Check the User gets the manadatory validation for all the fields
		
		PageFactory.initElements(driver, RegistrationObject.class);
		RegistrationObject RegisterPage = new RegistrationObject();
		RegisterPage.clickhere(driver, "clickSubmit");
		try {
	   String texta= RegisterPage.getValueText(driver, "emailerror");
	   String textb= RegisterPage.getValueText(driver, "passworderror");
	   String textc= RegisterPage.getValueText(driver, "nameerror");
	    if(texta.equals("Email is required") && textb.equals("Password is required") && textc.equals("Name is required"))
	    {
	    	System.out.println("Pass");
	    }else
	    {
	    	System.out.println("Fail");
	    }
		}catch(Exception e)
	    {
	    	System.out.println("Something went wrong !!");
	    }
	    }
	
	
	@Test
	(priority=3)
	public void checkValidEmail() throws InterruptedException
	{
		//Check the User gets the Valid Email validation 
		
		PageFactory.initElements(driver, RegistrationObject.class);
		RegistrationObject RegisterPage = new RegistrationObject();
		RegisterPage.EnterValue(driver, "email" , "raman");
		RegisterPage.clickhere(driver, "clickSubmit");
		try {
		    String texta = RegisterPage.getValueText(driver, "emailerror");
		    if (texta.equals("Please enter a valid email address")) {
		        System.out.println("Pass");
		    } else {
		        System.out.println("Fail");
		    }
		} catch (Exception e) {
		    System.out.println("Something went wrong !!");
		}
	}
	
	@Test
	(priority=4)
	public void checkPasswordMandatory() throws InterruptedException
	{
		//Check the User gets the Password Mandatory Validation
		
		PageFactory.initElements(driver, RegistrationObject.class);
		RegistrationObject RegisterPage = new RegistrationObject();
		RegisterPage.clickhere(driver, "clickSubmit");
		try {
		    String texta = RegisterPage.getValueText(driver, "passworderror");
		    if (texta.equals("Password is required")) {
		        System.out.println("Pass");
		    } else {
		        System.out.println("Fail");
		    }
		} catch (Exception e) {
		    System.out.println("Something went wrong !!");
		}
	}
	
	@Test
	(priority=5)
	public void checkCharPasswordValidation() throws InterruptedException
	{
		//Check the User gets the Password character Validation
		
		PageFactory.initElements(driver, RegistrationObject.class);
		RegistrationObject RegisterPage = new RegistrationObject();
		RegisterPage.EnterValue(driver, "password", "p");
		RegisterPage.clickhere(driver, "clickSubmit");
		try {
		    String texta = RegisterPage.getValueText(driver, "passworderror");
		    if (texta.equals("Please enter at least 8 characters")) {
		        System.out.println("Pass");
		    } else {
		        System.out.println("Fail");
		    }
		} catch (Exception e) {
		    System.out.println("Something went wrong !!");
		}
	}
	
	@Test
	(priority=7)
	public void checkMaxCharPasswordValidation() throws InterruptedException
	{
		//Check the User gets the Password Max character Validation
		
		PageFactory.initElements(driver, RegistrationObject.class);
		RegistrationObject RegisterPage = new RegistrationObject();
		RegisterPage.EnterValue(driver, "password", "asdfghjklpoiuytrewqas");
		RegisterPage.clickhere(driver, "clickSubmit");
		try {
		    String texta = RegisterPage.getValueText(driver, "passworderror");
		    if (texta.equals("Password not more than 20 characters")) {
		        System.out.println("Pass");
		    } else {
		        System.out.println("Fail");
		    }
		} catch (Exception e) {
		    System.out.println("Something went wrong !!");
		}
	}
	
	@Test
	(priority=6)
	public void checkPasswordValidations() throws InterruptedException
	{
		//Check the User gets the Password Validation
		
		PageFactory.initElements(driver, RegistrationObject.class);
		RegistrationObject RegisterPage = new RegistrationObject();
		RegisterPage.EnterValue(driver, "password", "asdfghik");
		RegisterPage.clickhere(driver, "clickSubmit");
		try {
		    String texta = RegisterPage.getValueText(driver, "passworderror");
		    if (texta.equals("Password must contain at least one lowercase alphabet, one uppercase letter, one number, and one special character.")) {
		        System.out.println("Pass");
		    } else {
		        System.out.println("Fail");
		    }
		} catch (Exception e) {
		    System.out.println("Something went wrong !!");
		}
		
		
	}
	
	@Test
	(priority=8)
	public void checkEmailUniqueValidation() throws InterruptedException
	{
		//Check the User gets Email Unique validation working fine
		
		PageFactory.initElements(driver, RegistrationObject.class);
		RegistrationObject RegisterPage = new RegistrationObject();
		RegisterPage.EnterValue(driver, "name", "sssss");
		RegisterPage.EnterValue(driver, "email", "sriram@zaigoinfotech.com");
		RegisterPage.EnterValue(driver, "password", "Hello@123");
		RegisterPage.clickhere(driver, "clickSubmit");
		try {
		    String texta = RegisterPage.getValueText(driver, "emailerror");
		    if (texta.equals("user with this email already exists.")) {
		        System.out.println("Pass");
		    } else {
		        System.out.println("Fail");
		    }
		} catch (Exception e) {
		    System.out.println("Something went wrong !!");
		}
	}
	
	
	@Test
	(priority=9)
	public void checkGotoLoginLink() throws InterruptedException
	{
		//Need to check Login Page.
		
		PageFactory.initElements(driver, RegistrationObject.class);
		RegistrationObject RegisterPage = new RegistrationObject();
		RegisterPage.clickhere(driver, "RegClick");
		try {
		    String texta = RegisterPage.getValueText(driver, "lpage");
		    if (texta.equals("Login")) {
		        System.out.println("Pass");
		    } else {
		        System.out.println("Fail");
		    }
		} catch (Exception e) {
		    System.out.println("Something went wrong !!");
		}
	}
	
	
	
	@Test
	(priority=10)
	public void checkSuccessForm() throws InterruptedException
	{
		//Check the User Logged in Successfully
		
		PageFactory.initElements(driver, RegistrationObject.class);
		RegistrationObject RegisterPage = new RegistrationObject();
		RegisterPage.clickhere(driver ,"Register");
		RegisterPage.EnterValue(driver, "name", "sssss");
		RegisterPage.EnterValue(driver, "email", "sriram1807@zaigoinfotech.com");
		RegisterPage.EnterValue(driver, "password", "Hello@123");
		RegisterPage.clickhere(driver, "clickSubmit");
		try {
		    String texta = RegisterPage.getValueText(driver, "Dashboard");
		    if (texta.equals("My Forms")) {
		        System.out.println("Pass");
		    } else {
		        System.out.println("Fail-o");
		    }
		} catch (Exception e) {
		    System.out.println("Something went wrong !!");
		}
	}
}

