package TestCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import PageObjects.CreateFormObject;
import PageObjects.Loginpageobject;
import PageObjects.RegistrationObject;

public class CreateFormCases extends BaseBrowser {
	
	
	CreateFormObject Createform = new CreateFormObject();
	@Test
	(priority=1)
	public void LandinDashboardPage() throws InterruptedException, IOException
	{
		//check the Login works fine
		
		  PageFactory.initElements(driver,Loginpageobject.class);
		  Properties properties = new Properties();
		  FileInputStream fileInputStream = new FileInputStream("config.properties");
          properties.load(fileInputStream);
		  Loginpageobject.EnterText(driver, properties.getProperty("username"));
		  Loginpageobject.EnterPassword(driver,properties.getProperty("password") );
		  Loginpageobject.ClickSubmit(driver);
			try {
			    String texta = Createform.getValueText(driver, "Dashboard");
			    System.out.print(texta);
			    if (texta.equals("My Forms")) {
			    } else {
			        System.out.println("Fail-o");
			    }
			} catch (Exception e) {
			    System.out.println("Something went wrong !!");
			}
		  
		
	}
	
	@Test
	(priority=2)
	public void CreatFormPopup() throws InterruptedException, IOException
	{
		//check the Create Form Popup works fine
		
		PageFactory.initElements(driver, CreateFormObject.class);
		Createform.clickhere(driver, "ClikCreateForm");
		try {
		    String texta = Createform.getValueText(driver, "formlable");
		    System.out.print(texta);
		    if (texta.equals("Create a new form")) {
		    	System.out.println("Pass-o");
		    } else {
		        System.out.println("Fail-o");
		    }
		} catch (Exception e) {
		    System.out.println("Something went wrong !!");
		}
	  
		
			
		
	}
	
	
	@Test
	(priority=3)
	public void CreatFormLandingPage() throws InterruptedException, IOException
	{
		//check the Create Form Landing Page
		
		PageFactory.initElements(driver, CreateFormObject.class);
		Createform.clickhere(driver, "ClickCreate");
		try {
		    String texta = Createform.getValueText(driver, "untitledform");
		    System.out.print(texta);
		    if (texta.equals("Untitled Form")) {
		    	System.out.println("Pass");
		    } else {
		        System.out.println("Fail-o");
		    }
		} catch (Exception e) {
		    System.out.println("Something went wrong !!");
		}
	 }
	

	
	@Test
	(priority=4)
	public void InvalidNameform() throws InterruptedException, IOException
	{
		//check with empty name field and click update
		
		PageFactory.initElements(driver, CreateFormObject.class);
		Createform.clickNextandFinish(driver, "Next");
		Createform.clickhere(driver, "pentool");
		Createform.EnterValue(driver, "fname", "");
		Createform.clickhere(driver, "updateform");
		try {
		    String texta = Createform.getValueText(driver, "getToast");
		    System.out.println(texta);
		   // Thread.sleep(9000);
		    if (texta.equals("Not updated")) {
		    	System.out.println("Pass");
		    } else {
		        System.out.println("Fail-o");
		    }
		} catch (Exception e) {
		    System.out.println("Something went wrong !!");
		}
		
		Createform.clickhere(driver, "closeToast");
		
	 }
	@Test
	(priority=6)
	public void ValidNamingform() throws InterruptedException, IOException
	{
		//check with valid name
		
		PageFactory.initElements(driver, CreateFormObject.class);
		Createform.clickhere(driver, "pentool");
		Createform.EnterValue(driver, "fname","kilo");
		Createform.clickhere(driver, "updateform");
		try {
		    String texta = Createform.getValueText(driver, "getToast");
		    System.out.println(texta);
		    if (texta.equals("Form Name Updated Successfully")) {
		    	System.out.println("Pass");
		    } else {
		        System.out.println("Fail-o");
		    }
		} catch (Exception e) {
		    System.out.println("Something went wrong !!");
		}
		
		
	 }
	
	
	@Test
	(priority=7
	)
	public void checkNameinList() throws InterruptedException, IOException
	{
		//check the name is in list
		
		PageFactory.initElements(driver, CreateFormObject.class);
		Createform.clickhere(driver, "moveBack");
		Thread.sleep(5000);
		try {
		    String texta = Createform.getListName(driver);
		    System.out.println(texta);
		    if (texta.equals("Formxyz")) {
		    	System.out.println("Pass");
		    } else {
		        System.out.println("Fail-o");
		    }
		} catch (Exception e) {
		    System.out.println(e);
		}
		
	 }
	
}
