package TestCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import PageObjects.Loginpageobject;
import PageObjects.UpdateFieldsObject;

public class UpdateFields extends BaseBrowser  {
	
	
	UpdateFieldsObject upObject = new UpdateFieldsObject();
	Properties properties = new Properties();
	  
	
	@Test
	(priority=1)
	public void LandinDashboardPage() throws InterruptedException, IOException
	{
		//check the Login works fine
		
		  PageFactory.initElements(driver,Loginpageobject.class);
		  FileInputStream fileInputStream = new FileInputStream("config.properties");
	      properties.load(fileInputStream);
		  Loginpageobject.EnterText(driver, properties.getProperty("username"));
		  Loginpageobject.EnterPassword(driver,properties.getProperty("password") );
		  Loginpageobject.ClickSubmit(driver);
			try {
			    String texta = upObject.getValueText(driver, "Dashboard");
			    if (texta.equals("My Forms")) {
			    	System.out.println("pass-o");
			    } else {
			        System.out.println("Fail-o");
			    }
			} catch (Exception e) {
			    System.out.println("Something went wrong !!");
			}
		  
		
	}

	
	
	@Test
	(priority=2)
	public void AddTextField() throws InterruptedException, IOException
	{
		//check the user can able to add the text field
		
		  PageFactory.initElements(driver,UpdateFields.class);
		  upObject.getListNameandClick(driver);
		  upObject.clickNextandFinish(driver, "Next");
		  upObject.DragnDrop(driver, "name");
		  upObject.DragnDrop(driver, "email");
		  upObject.DragnDrop(driver, "number");
		// upObject.EnterValue(driver, "name", "firstname");
		// upObject.clickhere(driver, "updateButton");
		  try 
		  { 
			   String texta =upObject.getValueText(driver, "popup");
			   System.out.println(texta+"add txt field");
			    if (texta.equals(properties.getProperty("successaddfield"))) {
			    	System.out.println("pass-o");
			    } else {
			        System.out.println("Fail-o");
			    }
			} catch (Exception e) {
			    System.out.println("Something went wrong !!");
			}
		}
	
	
	@Test
	(priority=3)
	public void AddText() throws InterruptedException, IOException
	{
		//check the user can able to add the text field name
		
		  PageFactory.initElements(driver,UpdateFields.class);
		  //upObject.enterLable(driver, "textfield");
		  upObject.EnterValue(driver, "name", "Name");
		  upObject.clickhere(driver, "updateButton");
		  try 
		  { 
			   String texta =upObject.getValueText(driver, "popup");
			   System.out.println(texta);
			    if (texta.equals(properties.getProperty("successaddfield"))) {
			    	System.out.println("pass-o");
			    } else {
			        System.out.println("Fail-o");
			    }
			} catch (Exception e) {
			    System.out.println("Something went wrong !!");
			}
		}
	
	
	
	
	
	@Test
	(priority=4)
	public void AddEmailField() throws InterruptedException, IOException
	{
		//check the user can able to add the Email field name
		
		  PageFactory.initElements(driver,UpdateFields.class);
		  upObject.enterLable(driver, "emailfield");
		  upObject.EnterValue(driver, "email", "E Address");
		  upObject.clickhere(driver, "updateButton");
		  try 
		  { 
			   String texta =upObject.getValueText(driver, "popup");
			   System.out.println(texta);
			    if (texta.equals(properties.getProperty("successaddfield"))) {
			    	System.out.println("pass-o");
			    } else {
			        System.out.println("Fail-o");
			    }
			} catch (Exception e) {
			    System.out.println("Something went wrong !!");
			}
		}
	
	
	@Test
	(priority=5)
	public void AddNumberField() throws InterruptedException, IOException
	{
		//check the user can able to add the Number field name
		
		  PageFactory.initElements(driver,UpdateFields.class);
		  upObject.enterLable(driver, "number");
		  upObject.EnterValue(driver, "num", "Your Number");
		  upObject.clickhere(driver, "updateButton");
		  try 
		  { 
			   String texta =upObject.getValueText(driver, "popup");
			   System.out.println(texta);
			    if (texta.equals(properties.getProperty("successaddfield"))) {
			    	System.out.println("pass-o");
			    } else {
			        System.out.println("Fail-o");
			    }
			} catch (Exception e) {
			    System.out.println("Something went wrong !!");
			}
		}

	
	
	@Test
	(priority=6)
	public void publishButton() throws InterruptedException, IOException
	{
		//check the user can able to active the fields.
		
		  PageFactory.initElements(driver,UpdateFields.class);
		  upObject.clickhere(driver, "publish");
		  try 
		  { 
			   String texta =upObject.getValueText(driver, "popup");
			   System.out.println(texta);
			    if (texta.equals(properties.getProperty("successaddfield"))) {
			    	System.out.println("pass-o");
			    } else {
			        System.out.println("Fail-o");
			    }
			} catch (Exception e) {
			    System.out.println("Something went wrong !!");
			}
		}

}
