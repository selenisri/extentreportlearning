package TestCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import PageObjects.DeletePageObject;
import PageObjects.FormObject;
import PageObjects.Loginpageobject;
import PageObjects.UpdateFieldsObject;

public class DeleteForm extends BaseBrowser{
	
	DeletePageObject DelObject = new DeletePageObject();
	UpdateFieldsObject upObject = new UpdateFieldsObject();

	Properties properties = new Properties();

	
	
	
	
	@Test
	(priority=1)
	public void Login() throws InterruptedException, IOException
	{
		//check the user can able to Copy the URL and Paste it in the New Tab
		
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
	public void RemoveFields() throws InterruptedException, IOException
	{
		//remove all the three fields
		

		PageFactory.initElements(driver,DeletePageObject.class);
		DelObject.getListNameandClick(driver);
        DelObject.clickNextandFinish(driver, "Next");
		int getcount =DelObject.ClickDeleteButton(driver, "name");
		System.out.println(getcount);
		try {
		    if (getcount==3) {
		    	System.out.println("pass-o");
		    } else {
		        System.out.println("Fail-o");
		    }
		} catch (Exception e) {
		    System.out.println("Something went wrong !!");
		}
	  
		DelObject.MovebackandWait(driver);
	
	}
	
	
	@Test
	(priority=3)
	public void DeleteForm() throws InterruptedException, IOException
	{
		//DeleteForm
		
		  PageFactory.initElements(driver,DeletePageObject.class);
		  DelObject.ClickActionButton(driver);
		  DelObject.ClickDeleteMenu(driver);
		  DelObject.ConfirmYes(driver);
		  try {
			    String texta = DelObject.getText(driver);
			    if (texta.equals("Form Deleted Successfully")) {
			    	System.out.println("pass-o");
			    } else {
			        System.out.println("Fail-o");
			    }
			} catch (Exception e) {
			    System.out.println("Something went wrong !!");
			}
		  
		
	}
	
	

}
